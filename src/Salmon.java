/**
 * Класс, описывающий лосося, который может мигрировать и плавать с изменяющейся скоростью.
 * Наследует базовые свойства и методы от класса Fish и реализует интерфейс IMigrate.
 */
public class Salmon extends Fish implements IMigrate {

    /** Сезон миграции лосося. */
    private String migrationSeason;

    /** Расстояние миграции лосося в километрах. */
    private double migrationDistance;

    /**
     * Параметризованный конструктор для инициализации полей.
     *
     * @param size             Размер лосося в метрах.
     * @param swimSpeed        Скорость лосося в км/ч.
     * @param habitat          Среда обитания лосося ("freshwater" или "saltwater").
     * @param energy           Уровень энергии лосося.
     * @param migrationSeason  Сезон миграции лосося.
     * @param migrationDistance Расстояние миграции лосося в километрах.
     */
    public Salmon(double size, double swimSpeed, String habitat, double energy,
                  String migrationSeason, double migrationDistance) {
        super(size, swimSpeed, habitat, energy);
        this.migrationSeason = migrationSeason;
        this.migrationDistance = migrationDistance;
    }

    /**
     * Возвращает текущую скорость плавания лосося.
     *
     * @return Текущая скорость плавания.
     */
    public double getSwimSpeed() {
        return swimSpeed;
    }

    /**
     * Возвращает текущий уровень энергии лосося.
     *
     * @return Уровень энергии.
     */
    public double getEnergy() {
        return energy;
    }

    /**
     * Возвращает текущую среду обитания лосося.
     *
     * @return Среда обитания.
     */
    public String getHabitat() {
        return habitat;
    }

    /**
     * Метод для потребления энергии. Снижение энергии зависит от текущей скорости плавания.
     */
    @Override
    public void consumeEnergy() {
        if (swimSpeed == 10) {
            energy -= 4;
        } else if (swimSpeed > 2) {
            energy -= 2;
        } else {
            energy -= 1;
        }
        System.out.println("Лосось потратил энергию. Текущая энергия: " + energy);
    }

    /**
     * Восстанавливает энергию лосося при питании.
     */
    public void feed() {
        if (energy < 15) {
            energy += 3;
            System.out.println("Лосось поел и восстановил энергию. Текущая энергия: " + energy);
        } else {
            System.out.println("Лосось достаточно сыт и не нуждается в еде.");
        }
    }

    /**
     * Реализация метода плавания с изменением скорости в зависимости от уровня энергии.
     */
    @Override
    public void swim() {
        if (energy > 10) {
            swimSpeed += 2;
            if (swimSpeed >= 10) {
                swimSpeed = 10;
                System.out.println("Лосось плывет на максимальной скорости: " + swimSpeed + " км/ч.");
            } else {
                System.out.println("Лосось увеличил скорость. Текущая скорость: " + swimSpeed + " км/ч.");
            }
        } else if (energy > 5) {
            swimSpeed -= 1;
            System.out.println("Лосось уменьшил скорость. Текущая скорость: " + swimSpeed + " км/ч.");
        } else {
            swimSpeed = 2;
            System.out.println("Лосось плывет на минимальной скорости: " + swimSpeed + " км/ч.");
        }
        consumeEnergy();
    }

    /**
     * Реализация метода миграции. Лосось может перемещаться между пресной и соленой водой,
     * если у него достаточно энергии для миграции.
     *
     * @param newHabitat Новая среда обитания ("freshwater" или "saltwater").
     */
    public void migrate(String newHabitat) {
        if (energy >= 10) {
            if ("freshwater".equals(habitat) && "saltwater".equals(newHabitat)) {
                habitat = newHabitat;
                System.out.println("Лосось мигрировал в океан.");
            } else if ("saltwater".equals(habitat) && "freshwater".equals(newHabitat)) {
                habitat = newHabitat;
                System.out.println("Лосось мигрировал обратно в реку.");
            } else {
                System.out.println("Лосось уже находится в нужной среде.");
                return;
            }
            swim();
        } else {
            System.out.println("Недостаточно энергии для миграции.");
        }
    }
}
