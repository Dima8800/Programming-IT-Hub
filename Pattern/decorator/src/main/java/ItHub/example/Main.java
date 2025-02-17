package ItHub.example;

public class Main {
    public static void main(String[] args) {
        IComponent obj = new DecoratorTwo(new DecoratorOne(new Component()));
        obj.operation();
    }
}