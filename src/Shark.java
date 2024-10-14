// Класс Shark
public class Shark extends Fish implements IHunt {

    private int quotientBiteForce;      // Коэффициент силы укуса акулы
    private int aggressionLevel;        // Уровень агрессии акулы (от 1 до 10)

    // Параметризованный конструктор для инициализации полей
    public Shark(double size, double swimSpeed, String habitat, double energy, int quotientBiteForce, int aggressionLevel) {
        super(size, swimSpeed, habitat, energy); // Вызов конструктора родительского класса Fish
        this.quotientBiteForce = quotientBiteForce;
        this.aggressionLevel = aggressionLevel;
    }

    // Метод для получения текущей скорости плавания
    public double getSwimSpeed() {
        return swimSpeed;
    }

    // Метод для получения текущего уровня энергии
    public double getEnergy() {
        return energy;
    }

    // Метод для получения текущего уровня агрессии
    public int getAggressionLevel() {
        return aggressionLevel;
    }

    // Реализация метода потребления энергии
    @Override
    public void consumeEnergy() {
        if (swimSpeed == 25) {
            energy -= 3; // Высокая трата энергии при максимальной скорости
        } else if (swimSpeed > 5) {
            energy -= 2; // Средняя трата энергии
        } else {
            energy -= 1; // Низкая трата энергии при минимальной скорости
        }
        System.out.println("Акула потратила энергию. Текущая энергия: " + energy);
    }

    // Метод для восстановления энергии
    private void recoveryEnergy() {
        energy += 8;
        System.out.println("Акула восстановила энергию. Текущая энергия: " + energy);
    }

    // Метод для увеличения уровня агрессии акулы
    private void increaseAggression() {
        if (aggressionLevel < 10) { // Уровень агрессии не может быть больше 10
            aggressionLevel += 2;
            System.out.println("Агрессивность акулы возросла. Текущий уровень: " + aggressionLevel);
        }
    }

    // Метод для уменьшения уровня агрессии акулы
    private void decreaseAggression() {
        if (aggressionLevel > 1) { // Уровень агрессии не может быть меньше 1
            aggressionLevel -= 2;
            System.out.println("Агрессивность акулы снизилась. Текущий уровень: " + aggressionLevel);
        }
    }

    // Метод для корректировки агрессии в зависимости от уровня энергии
    private void adjustAggression() {
        if (energy < 8 && aggressionLevel < 10) {
            aggressionLevel++;
            System.out.println("Низкая энергия! Агрессивность акулы возросла. Текущий уровень: " + aggressionLevel);
        } else if (energy > 12 && aggressionLevel > 1) {
            aggressionLevel--;
            System.out.println("Высокая энергия! Агрессивность акулы снизилась. Текущий уровень: " + aggressionLevel);
        }
    }

    // Реализация метода плавания
    @Override
    public void swim() {
        if (energy > 10) {
            swimSpeed += 2; // Скорость увеличивается при высоком значении энергии
            if (swimSpeed >= 20) {
                swimSpeed = 20; // Максимальная скорость для акулы
                System.out.println("Акула плывет на максимальной скорости: " + swimSpeed + " км/ч.");
            } else {
                System.out.println("Акула увеличила скорость. Текущая скорость: " + swimSpeed + " км/ч.");
            }
        } else if (energy > 5) {
            swimSpeed -= 1; // Скорость уменьшается при среднем значении энергии
            System.out.println("Акула уменьшила скорость. Текущая скорость: " + swimSpeed + " км/ч.");
        } else {
            swimSpeed = 5; // Переход на минимальную скорость при низкой энергии
            System.out.println("Акула плывет на минимальной скорости: " + swimSpeed + " км/ч.");
        }
        consumeEnergy(); // Энергия уменьшается после плавания
    }

    // Реализация метода охоты: успех зависит от уровня агрессии и скорости
    @Override
    public void hunt() {
        if (aggressionLevel > 7 && swimSpeed >= 15) {
            System.out.println("Успешная охота!");
            recoveryEnergy(); // Энергия восстанавливается после успешной охоты
            decreaseAggression(); // Уровень агрессии снижается после успешной охоты
        } else {
            System.out.println("Неудачная охота!");
            increaseAggression(); // Уровень агрессии увеличивается после неудачной охоты
            consumeEnergy(); // Энергия тратится на неудачную охоту
        }
    }
}
