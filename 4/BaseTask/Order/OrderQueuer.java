package fifth.BaseTask.Order;

import fifth.BaseTask.Models.Order;

public interface OrderQueuer {
    public void addOrder(Order ord);
    public Order serverOrder();
    public int getTotalTimeToCook();
}
