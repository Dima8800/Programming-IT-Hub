package ItHub.example;

import java.util.function.Consumer;

public class DecoratorOne implements IComponent {
    private IComponent component;

    public DecoratorOne(IComponent component) {
        this.component = component;
    }

    @Override
    public void operation() {
        Consumer<String> printComma = s -> System.out.print(s);
        printComma.accept(", ");
        component.operation();
    }
}
