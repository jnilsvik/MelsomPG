package foods;

public class OrderItem extends MenuItem{
    int amount;

    public OrderItem(int ID, String name, double price, int amount) {
        super(ID, name, price);
        this.amount = amount;
    }

    @Override
    public double getSPrice() {
        return 0;
    }

    @Override
    public double getXLPrice() {
        return 0;
    }
}
