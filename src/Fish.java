// Абстрактный класс, описывающий общие свойства и методы для всех рыб
public abstract class Fish {

    protected double size;      // Размер рыбы (м)
    protected double swimSpeed; // Скорость рыбы (км/ч)
    protected String habitat;   // Среда обитания рыбы ("freshwater"(пресная вода) или "saltwater"(морская вода))
    protected double energy;    // Уровень энергии рыбы

    private static int totalFish = 0; // Статическое поле, содержащее количество рыб

    // Параметризованный конструктор для инициализации полей
    public Fish(double size, double swimSpeed, String habitat, double energy) {
        this.size = size;
        this.swimSpeed = swimSpeed;
        this.habitat = habitat;
        this.energy = energy;
        totalFish++;
    }

    // Метод для получения общего количества рыб
    public static int getTotalFish() {
        return totalFish;
    }

    // Абстрактный метод для плавания
    public abstract void swim();

    // Абстрактный метод для потребления энергии
    public abstract void consumeEnergy();
}
