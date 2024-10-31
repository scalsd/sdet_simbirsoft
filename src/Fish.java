/**
 * Абстрактный класс, описывающий общие свойства и методы для всех рыб.
 */
public abstract class Fish {

    /** Размер рыбы в метрах. */
    protected double size;

    /** Скорость рыбы в км/ч. */
    protected double swimSpeed;

    /** Среда обитания рыбы: "freshwater" (пресная вода) или "saltwater" (морская вода). */
    protected String habitat;

    /** Уровень энергии рыбы. */
    protected double energy;

    /** Статическое поле, содержащее количество рыб. */
    private static int totalFish = 0;

    /**
     * Параметризованный конструктор для инициализации полей.
     *
     * @param size      Размер рыбы в метрах.
     * @param swimSpeed Скорость рыбы в км/ч.
     * @param habitat   Среда обитания ("freshwater" или "saltwater").
     * @param energy    Уровень энергии рыбы.
     */
    public Fish(double size, double swimSpeed, String habitat, double energy) {
        this.size = size;
        this.swimSpeed = swimSpeed;
        this.habitat = habitat;
        this.energy = energy;
        totalFish++;
    }

    /**
     * Возвращает общее количество рыб.
     *
     * @return Общее количество рыб.
     */
    public static int getTotalFish() {
        return totalFish;
    }

    /**
     * Абстрактный метод для плавания. Должен быть реализован в подклассах.
     */
    public abstract void swim();

    /**
     * Абстрактный метод для потребления энергии. Должен быть реализован в подклассах.
     */
    public abstract void consumeEnergy();
}
