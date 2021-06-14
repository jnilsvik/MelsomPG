package foods;

public class Hamburger extends MenuItem{
    public Hamburger(int ID, double price, String name) {
        super(ID, name, price);
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
