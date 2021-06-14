package foods;

// Gjort denne abstrakt da jeg ikke ønsker å la noen lage direkte MenuItems
public abstract class MenuItem {
    // Declaring variables
    protected int     id;
    protected String  name;
    protected double  price;
    //constructor
    public MenuItem(int ID, String name, double price){
        this.id     = ID;
        this.name   = name;
        this.price  = price;
    }
    //usikker om g/s-ere kommer til å bli brukt
    //Setters
    public void setID(int newID){this.id = newID;}
    public void setName(String newName){this.name = newName;}
    public void setPrice(double newPrice){this.price = newPrice;}
    //Getters
    public int getID(){return id;}
    public String getName(){return name;}
    public double getPrice(){return price;}

    public String printItem(){
        return (id + ".\t" + name + ".\t" +
                "\u001B[32m" + price + "kr" + "\u001B[0m");
    }

    public abstract double getSPrice();

    public abstract double getXLPrice();
}


