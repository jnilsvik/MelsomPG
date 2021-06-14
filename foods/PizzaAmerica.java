package foods;

public class PizzaAmerica extends MenuItem{
    double  sPrice;
    double  xlPrice;

    public PizzaAmerica(int ID,  double price, double sPrice, double xlPrice, String name) {
        super(ID, name, price);
        this.sPrice     = sPrice;
        this.xlPrice    = xlPrice;
    }
    public double getSPrice(){return sPrice;}
    public double getXLPrice(){return xlPrice;}

    @Override
    public String printItem() {
        return (id + ".\t" + name + ".\t" +
                "\u001B[32m" + "Medium: " + price + "kr\t" +
                "\u001B[33m" + "Stor: "+ sPrice + "kr\t" +
                "\u001B[31m" + "XL: " + xlPrice + "kr\t" + "\u001B[0m");
    }



}

