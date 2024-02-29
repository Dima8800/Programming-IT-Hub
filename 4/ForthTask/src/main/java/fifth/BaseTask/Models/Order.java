package fifth.BaseTask.Models;

public class Order {
    String id;
    int SumFoodItem;
    public Order(String id, int FoodItemTime){
        this.id = id;
        this.SumFoodItem = FoodItemTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSumFoodItem() {
        return SumFoodItem;
    }

    public void setSumFoodItem(int sumFoodItem) {
        SumFoodItem = sumFoodItem;
    }

    @Override
    public String toString() {
        return id + " " + SumFoodItem;
    }
}
