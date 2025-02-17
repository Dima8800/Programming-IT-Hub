package ItHub.example;

abstract class Unit {
    abstract int getStrength();

    void addUnit(Unit unit) {
        throw new UnsupportedOperationException("");
    }
}
