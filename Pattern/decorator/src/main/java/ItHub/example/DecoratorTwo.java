package ItHub.example;

public class DecoratorTwo implements IComponent {
    private IComponent component;

    public DecoratorTwo(IComponent component) {
        this.component = component;
    }

    @Override
    public void operation() {
        System.out.print("HI");
        component.operation();
    }
}
