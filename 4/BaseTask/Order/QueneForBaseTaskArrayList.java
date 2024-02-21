package fifth.BaseTask.Order;

import fifth.BaseTask.Models.Order;

import java.util.ArrayList;

public class QueneForBaseTaskArrayList<T> implements MyQuene {
    ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void putInBack(Object item) {
        String[] strObject = item.toString().split(" ");
        Order O = new Order(strObject[0],Integer.parseInt(strObject[1]));
        orders.add(O);
    }

    @Override
    public Object takeOffHead() {
        return getObjectAndDelete();
    }
    private Order getObjectAndDelete() {
        if (orders.size() != 0) {
            Order obj = orders.get(0);
            orders.remove(0);
            return obj;
        }
        return null;
    }

    @Override
    public int getTotalTimeToCook() {
        int sum = 0;
        for (int i = 0; i < orders.size(); i++){
            sum += orders.get(i).getSumFoodItem();
        }
        return sum;
    }
}
