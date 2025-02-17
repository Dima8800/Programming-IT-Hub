package ITHub.task;

public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        // Создание наблюдателей
        ConcreteObserver observer1 = new ConcreteObserver("Первый наблюдатель");
        ConcreteObserver observer2 = new ConcreteObserver("второй наблюдатель");

        // Подписка наблюдателей на издателя
        subject.attach(observer1);
        subject.attach(observer2);

        // Изменение состояния издателя
        subject.setState("Состояние изменено на '1'");
        subject.setState("Состояние изменено на '2'");

        // Отписка одного из наблюдателей
        subject.detach(observer1);

        // Изменение состояния снова
        subject.setState("Состояние изменено на '3'");
    }
}