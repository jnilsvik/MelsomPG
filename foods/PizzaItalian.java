package foods;

public class PizzaItalian extends MenuItem{
    double sPrice;
    String ingredients;

    public PizzaItalian(int ID, double price, double sPrice, String name, String ingredients) {
        super(ID, name, price);
        this.sPrice = sPrice;
        this.ingredients = ingredients;
    }
    @Override
    public String printItem() {
        return (id + ".\t" + name + ".\t" +
                "\u001B[32m" + "Medium: " + price + "kr\t" +
                "\u001B[33m" + "Stor: " + sPrice + "kr\t" + "\u001B[0m");
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
