package foods;

public class VoksenMat extends MenuItem{
    String ingredients;
    public VoksenMat(int ID, double price, String name, String ingredients) {
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
