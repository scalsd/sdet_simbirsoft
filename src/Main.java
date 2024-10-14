public class Main {
    public static void main(String[] args) {

        Shark shark = new Shark(6.5, 17, "saltwater", 15, 164, 6);

        System.out.println("Начальная скорость акулы: " + shark.getSwimSpeed() + " км/ч");
        System.out.println("Начальный уровень энергии акулы: " + shark.getEnergy());
        System.out.println("Начальный уровень агрессии акулы: " + shark.getAggressionLevel());

        System.out.println("\n=== Плавание акулы ===");
        shark.swim();

        System.out.println("\n=== Охота акулы ===");
        shark.hunt();

        System.out.println("\n=== Охота акулы ===");
        shark.hunt();

        System.out.println("_________________________________________");

        Salmon salmon = new Salmon(0.5, 4, "freshwater", 8, "autumn", 2000);

        System.out.println("Начальная скорость лосося: " + salmon.getSwimSpeed() + " км/ч");
        System.out.println("Начальный уровень энергии лосося: " + salmon.getEnergy());
        System.out.println("Место обитания лосося: " + salmon.getHabitat());

        System.out.println("\n=== Миграция лосося ===");
        salmon.migrate("saltwater");

        System.out.println("\n=== Питание лосося ===");
        salmon.feed();

        System.out.println("\n=== Миграция лосося ===");
        salmon.migrate("saltwater");
    }
}
