package foods;

public class DivMat extends MenuItem{
    public DivMat(int ID, double price, String name) {
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
