package ITHub.task;

public class StackIter {
    private final Stack stk;
    private int index;

    public StackIter(Stack s) {
        stk = s;
        index = 0; // Начинаем с первого элемента
    }

    public void first() {
        index = 0; // Устанавливаем индекс на первый элемент
    }

    public void next() {
        index++; // Переход к следующему элементу
    }

    public boolean isDone() {
        return index >= stk.size(); // Проверка, достигнут ли конец стека
    }

    public int currentItem() {
        if (index < stk.size()) { // Проверяем, что индекс в пределах размера стека
            return stk.getItem(index); // Возвращаем текущий элемент стека
        } else {
            throw new IllegalStateException("Iterator out of bounds");
        }
    }
}