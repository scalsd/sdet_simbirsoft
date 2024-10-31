/**
 * Класс, описывающий акулу, которая может охотиться и плавать с изменяющейся скоростью.
 * Наследует базовые свойства и методы от класса Fish и реализует интерфейс IHunt.
 */
public class Shark extends Fish implements IHunt {

    /** Коэффициент силы укуса акулы. */
    private int quotientBiteForce;

    /** Уровень агрессии акулы (от 1 до 10). */
    private int aggressionLevel;

    /**
     * Параметризованный конструктор для инициализации полей.
     *
     * @param size              Размер акулы в метрах.
     * @param swimSpeed         Скорость акулы в км/ч.
     * @param habitat           Среда обитания акулы ("saltwater").
     * @param energy            Уровень энергии акулы.
     * @param quotientBiteForce Коэффициент силы укуса акулы.
     * @param aggressionLevel   Уровень агрессии акулы.
     */
    public Shark(double size, double swimSpeed, String habitat, double energy,
                 int quotientBiteForce, int aggressionLevel) {
        super(size, swimSpeed, habitat, energy);
        this.quotientBiteForce = quotientBiteForce;
        this.aggressionLevel = aggressionLevel;
    }

    /**
     * Возвращает текущую скорость плавания акулы.
     *
     * @return Текущая скорость плавания.
     */
    public double getSwimSpeed() {
        return swimSpeed;
    }

    /**
     * Возвращает текущий уровень энергии акулы.
     *
     * @return Уровень энергии.
     */
    public double getEnergy() {
        return energy;
    }

    /**
     * Возвращает текущий уровень агрессии акулы.
     *
     * @return Уровень агрессии.
     */
    public int getAggressionLevel() {
        return aggressionLevel;
    }

    /**
     * Метод для потребления энергии. Снижение энергии зависит от текущей скорости плавания.
     */
    @Override
    public void consumeEnergy() {
        if (swimSpeed == 25) {
            energy -= 3;
        } else if (swimSpeed > 5) {
            energy -= 2;
        } else {
            energy -= 1;
        }
        System.out.println("Акула потратила энергию. Текущая энергия: " + energy);
    }

    /**
     * Восстанавливает энергию акулы.
     */
    private void recoveryEnergy() {
        energy += 8;
        System.out.println("Акула восстановила энергию. Текущая энергия: " + energy);
    }

    /**
     * Увеличивает уровень агрессии акулы.
     */
    private void increaseAggression() {
        if (aggressionLevel < 10) {
            aggressionLevel += 2;
            System.out.println("Агрессивность акулы возросла. Текущий уровень: " + aggressionLevel);
        }
    }

    /**
     * Уменьшает уровень агрессии акулы.
     */
    private void decreaseAggression() {
        if (aggressionLevel > 1) {
            aggressionLevel -= 2;
            System.out.println("Агрессивность акулы снизилась. Текущий уровень: " + aggressionLevel);
        }
    }

    /**
     * Корректирует уровень агрессии в зависимости от уровня энергии.
     */
    private void adjustAggression() {
        if (energy < 8 && aggressionLevel < 10) {
            aggressionLevel++;
            System.out.println("Низкая энергия! Агрессивность акулы возросла. Текущий уровень: " + aggressionLevel);
        } else if (energy > 12 && aggressionLevel > 1) {
            aggressionLevel--;
            System.out.println("Высокая энергия! Агрессивность акулы снизилась. Текущий уровень: " + aggressionLevel);
        }
    }

    /**
     * Реализация метода плавания с изменением скорости в зависимости от уровня энергии.
     */
    @Override
    public void swim() {
        if (energy > 10) {
            swimSpeed += 2;
            if (swimSpeed >= 20) {
                swimSpeed = 20;
                System.out.println("Акула плывет на максимальной скорости: " + swimSpeed + " км/ч.");
            } else {
                System.out.println("Акула увеличила скорость. Текущая скорость: " + swimSpeed + " км/ч.");
            }
        } else if (energy > 5) {
            swimSpeed -= 1;
            System.out.println("Акула уменьшила скорость. Текущая скорость: " + swimSpeed + " км/ч.");
        } else {
            swimSpeed = 5;
            System.out.println("Акула плывет на минимальной скорости: " + swimSpeed + " км/ч.");
        }
        consumeEnergy();
    }

    /**
     * Реализация метода охоты. Успех зависит от уровня агрессии и скорости.
     */
    @Override
    public void hunt() {
        if (aggressionLevel > 7 && swimSpeed >= 15) {
            System.out.println("Успешная охота!");
            recoveryEnergy();
            decreaseAggression();
        } else {
            System.out.println("Неудачная охота!");
            increaseAggression();
            consumeEnergy();
        }
    }
}
