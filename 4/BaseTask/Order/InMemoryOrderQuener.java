package fifth.BaseTask.Order;

import fifth.BaseTask.Models.Order;

public class InMemoryOrderQuener implements OrderQueuer{
    private MyQuene<Order> orderQueue;

    public InMemoryOrderQuener(MyQuene<Order> orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void addOrder(Order ord) {
        orderQueue.putInBack(ord);
    }


    @Override
    public Order serverOrder() {
        return orderQueue.takeOffHead();
    }

    @Override
    public int getTotalTimeToCook() {
        return orderQueue.getTotalTimeToCook();
    }
}
