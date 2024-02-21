package fifth.BaseTask.Order;

public interface MyQuene<T> {
    public void putInBack(T item);
    public T takeOffHead();
    public int getTotalTimeToCook();
}
