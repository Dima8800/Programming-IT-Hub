package ItHub.example;

import java.util.ArrayList;
import java.util.List;

public class CompositeUnit extends Unit {
    private final List<Unit> units = new ArrayList<>();

    @Override
    int getStrength() {
        int total = 0;
        for (Unit unit : units) {
            total += unit.getStrength();
        }
        return total;
    }

    @Override
    void addUnit(Unit unit) {
        units.add(unit);
    }
}
