package ITHub.task;

public class Stack {
    private int[] items;
    private int sp;

    public Stack() {
        items = new int[10];
        sp = -1;
    }

    public void push(int in) {
        if (sp + 1 >= items.length) {
            // Увеличиваем размер массива, если необходимо
            int[] newItems = new int[items.length * 2];
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
        }
        items[++sp] = in;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items[sp--];
    }

    public boolean isEmpty() {
        return (sp == -1);
    }

    public int size() {
        return (sp + 1);
    }

    // Метод для получения элемента по индексу
    public int getItem(int index) {
        return items[index];
    }

    public StackIter createIterator() {
        return new StackIter(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Stack)) return false;

        Stack other = (Stack) obj;

        if (this.size() != other.size()) return false;

        StackIter itl = this.createIterator();
        StackIter itr = other.createIterator();

        itl.first();
        itr.first();

        while (!itl.isDone() && !itr.isDone()) {
            if (itl.currentItem() != itr.currentItem()) {
                return false; // Если элементы не равны, стеки не равны
            }
            itl.next();
            itr.next();
        }

        return itl.isDone() && itr.isDone(); // Проверяем, достигли ли конца обоих стеков
    }
}