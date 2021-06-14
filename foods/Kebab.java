package foods;

public class Kebab extends MenuItem{
    public Kebab(int ID, double price, String name) {
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
