package ItHub.example;

public class Main {
    static CompositeUnit createLegion() {
        // Римский легион содержит:
        CompositeUnit legion = new CompositeUnit();
        // 3000 тяжелых пехотинцев
        for (int i = 0; i < 3000; ++i) {
            legion.addUnit(new Infantryman());
        }
        // 1200 легких пехотинцев
        for (int i = 0; i < 1200; ++i) {
            legion.addUnit(new Archer());
        }
        return legion;
    }

    public static void main(String[] args) {
        CompositeUnit army = new CompositeUnit();
        for (int i = 0; i < 4; ++i) {
            army.addUnit(createLegion());
        }
        System.out.println("Сила легиона = " + army.getStrength());
    }
}