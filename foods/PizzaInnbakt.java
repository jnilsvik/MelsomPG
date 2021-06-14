package foods;

public class PizzaInnbakt extends MenuItem{
    String ingredients;
    public PizzaInnbakt(int ID, double price, String name, String ingredients) {
        super(ID, name, price);
        this.ingredients = ingredients;
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
