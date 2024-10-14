// Класс Salmon
public class Salmon extends Fish implements IMigrate {

    private String migrationSeason;         // Сезон миграции
    private double migrationDistance;       // Расстояние миграции (км)

    // Параметризованный конструктор для инициализации полей
    public Salmon(double size, double swimSpeed, String habitat, double energy, String migrationSeason, double migrationDistance) {
        super(size, swimSpeed, habitat, energy); // Вызов конструктора родительского класса Fish
        this.migrationSeason = migrationSeason;
        this.migrationDistance = migrationDistance;
    }

    // Метод для получения текущей скорости плавания
    public double getSwimSpeed() {
        return swimSpeed;
    }

    // Метод для получения текущего уровня энергии
    public double getEnergy() {
        return energy;
    }

    // Метод для получения текущего места обитания
    public String getHabitat() {
        return habitat;
    }

    // Реализация метода потребления энергии
    @Override
    public void consumeEnergy() {
        if (swimSpeed == 10) {
            energy -= 4; // Высокая трата энергии при максимальной скорости
        } else if (swimSpeed > 2) {
            energy -= 2; // Средняя трата энергии
        } else {
            energy -= 1; // Низкая трата энергии при минимальной скорости
        }
        System.out.println("Лосось потратил энергию. Текущая энергия: " + energy);
    }

    // Метод восстановления энергии через питание
    public void feed() {
        if (energy < 15) {
            energy += 3; // Восстановление энергии
            System.out.println("Лосось поел и восстановил энергию. Текущая энергия: " + energy);
        } else {
            System.out.println("Лосось достаточно сыт и не нуждается в еде.");
        }
    }

    // Реализация метода плавания
    @Override
    public void swim() {
        if (energy > 10) {
            swimSpeed += 2; // Скорость увеличивается при высоком значении энергии
            if (swimSpeed >= 10) {
                swimSpeed = 10; // Максимальная скорость для акулы
                System.out.println("Лосось плывет на максимальной скорости: " + swimSpeed + " км/ч.");
            } else {
                System.out.println("Лосось увеличил скорость. Текущая скорость: " + swimSpeed + " км/ч.");
            }
        } else if (energy > 5) {
            swimSpeed -= 1; // Скорость уменьшается при среднем значении энергии
            System.out.println("Лосось уменьшил скорость. Текущая скорость: " + swimSpeed + " км/ч.");
        } else {
            swimSpeed = 2; // Переход на минимальную скорость при низкой энергии
            System.out.println("Лосось плывет на минимальной скорости: " + swimSpeed + " км/ч.");
        }
        consumeEnergy(); // Энергия уменьшается после плавания
    }

    // Реализация метода миграции: успех зависит от уровня энергии.
    public void migrate(String newHabitat) {
        if (energy >= 10) {
            if ("freshwater".equals(habitat) && "saltwater".equals(newHabitat)) {
                habitat = newHabitat; // Лосось мигрирует в океан
                System.out.println("Лосось мигрировал в океан.");
            } else if ("saltwater".equals(habitat) && "freshwater".equals(newHabitat)) {
                habitat = newHabitat; // Лосось мигрирует обратно в реку
                System.out.println("Лосось мигрировал обратно в реку.");
            } else {
                System.out.println("Лосось уже находится в нужной среде.");
                return; // Если лосось уже находится в целевом месте, миграция не нужна
            }
            swim(); // Плавание в процессе миграции
        } else {
            System.out.println("Недостаточно энергии для миграции.");
        }
    }
}
