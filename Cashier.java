import foods.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Cashier {
    private int orderID;
    private int orderItemID;
    private double total;
    private ArrayList<MenuItem> menuList = new ArrayList<>();
    private ArrayList<MenuItem> orderList = new ArrayList<>();
    Scanner menuInput = new Scanner(System.in);
    //bygger kassa
    public Cashier() {
        orderID = 0;
        orderItemID = 0;
        total = 0;
        menuLoader();
        terminalMenu();
    }
    //Laster inn meny - basically bare array loading
    private void menuLoader(){
        //Amerikanske pizzaer //todo -> bruke en int og int++ for å ID?
        menuList.add(new PizzaAmerica(1,  160,210,400,"Løk, pepperoni, champignon"));
        menuList.add(new PizzaAmerica(2,  160,210,400,"Skinke, champignon"));
        menuList.add(new PizzaAmerica(3,  160,210,400,"Løk, biff, champignon"));
        menuList.add(new PizzaAmerica(4,  160,210,400,"Ananas, champignon, tomat, paprika, mais, løk"));
        menuList.add(new PizzaAmerica(5,  160,210,400,"Biff, ananas, løk, paprika"));
        menuList.add(new PizzaAmerica(6,  160,210,400,"Pepperoni, ananas, paprika"));

        menuList.add(new PizzaAmerica(7,  170,220,410,"Bacon, biff, champignon, purre"));
        menuList.add(new PizzaAmerica(8,  170,220,410,"Løk skinke, mais, champignon"));
        menuList.add(new PizzaAmerica(9,  170,220,410,"Pepperoni, salami, paprika"));
        menuList.add(new PizzaAmerica(10, 170,220,410,"Løk, biff, malt bacon, paprika"));
        menuList.add(new PizzaAmerica(11, 170,220,410,"Løk biff, hakket oliven, grovmalt pepper"));
        menuList.add(new PizzaAmerica(12, 170,220,410,"Reker, musling, løk, champignon"));

        menuList.add(new PizzaAmerica(13, 190,230,420,"Løk, biff, skinke, pepperoni"));
        menuList.add(new PizzaAmerica(14, 190,230,420,"Løk, skinke, salami, kjøttboller, paprika"));
        menuList.add(new PizzaAmerica(15, 190,230,420,"Løk, biff, pepperoni, campignon"));
        menuList.add(new PizzaAmerica(16, 190,230,420,"Skinke, bacon, pepperoni, ananas, paprika"));
        menuList.add(new PizzaAmerica(17, 190,230,420,"Kylling, løk, champignon"));
        menuList.add(new PizzaAmerica(18, 190,230,420,"Kylling, løk, champignon"));
        menuList.add(new PizzaAmerica(19, 190,230,420,"Tacokrydret kjøtt, løk, champignon"));

        menuList.add(new PizzaAmerica(20, 190,260,450,"Kylling, taco,løk, paprika, jalapenos"));
        menuList.add(new PizzaAmerica(21, 190,260,450,"Løk, biff, skinke, pepperoni, bacon, champignon"));
        menuList.add(new PizzaAmerica(22, 190,260,450,"Kjøttdeig, løk, skinke, pepperoni, ananas, paprika"));
        menuList.add(new PizzaAmerica(23, 190,260,450,"Kylling, biff, pepperoni, løk, paprika"));
        menuList.add(new PizzaAmerica(24, 190,260,450,"Biff, skinke, pepperoni, bacon, salami, kjøttdeig"));

        menuList.add(new PizzaAmerica(25, 190,260,450,"Custom - sett sammen 5 ingridienser"));
        menuList.add(new PizzaAmerica(26, 190,190,190,"Glutenfri")); //todo -> kan kun fåes i liten størrelse

        menuList.add(new PizzaAmerica(27, 190,260,450,"Kebabpizza, kebabkjøtt, løk, mais, salat og dressing"));
        menuList.add(new PizzaAmerica(28, 190,260,450,"Kebabkjøtt og pommes frites"));

        //Italienske
        menuList.add(new PizzaItalian(29, 140,210, "Margarita",     "Tomatsaus, ost"));
        menuList.add(new PizzaItalian(30, 150,210, "Vesuvio",       "Tomatsaus, ost, skinke"));
        menuList.add(new PizzaItalian(31, 150,210, "Sicillian",     "Tomatsaus, ost, skinke, løk, champignon"));
        menuList.add(new PizzaItalian(32, 150,230, "Hawaii",        "Tomatsaus, ost, pepperoni, skinke, ananas, paprika"));
        menuList.add(new PizzaItalian(33, 150,230, "La Luna",       "Tomatsaus, ost, løk, biff, skinke, champpignon"));
        menuList.add(new PizzaItalian(34, 150,230, "Venezia",       "Tomatsaus, ost, skinke, tunfisk"));
        menuList.add(new PizzaItalian(35, 150,230, "Caramba",       "Tomatsaus, ost, skinke, reker,løk, champignon, jalapenos"));
        menuList.add(new PizzaItalian(36, 160,230, "Bella",         "Tomatsaus, ost, løk, biff skinke, pepperoni"));
        menuList.add(new PizzaItalian(37, 160,230, "Kebab pizza",   "Tomatsaus, ost, krydret kebabkjøtt,løk, salat, dressing"));
        menuList.add(new PizzaItalian(38, 160,240, "Bella Casa",    "Tomatsaus, ost, paramaskinke, salami, pepperoni"));
        menuList.add(new PizzaItalian(39, 160,240, "Melsom Spesial","Tomatsaus, ost, parmaskinke, rokkolo"));
        menuList.add(new PizzaItalian(40, 140,210, "Vegetarina",    "Tomatsaus, ost, løk, tomat, champignon, oliven, mais, paprika"));
        menuList.add(new PizzaItalian(41, 160,220, "Gresk pizza",   "Tomatsaus, ost, marinert kyllingbryst, løk, champignon"));

        //Innbakt Italiensk
        menuList.add(new PizzaInnbakt(42, 120,"Calzone",                  "Tomatsaus, ost, skinke"));
        menuList.add(new PizzaInnbakt(43, 130,"Romana",                   "Tomatsaus, ost, løk, biff, champignon"));
        menuList.add(new PizzaInnbakt(44, 130,"Alacasa (halvinnbakt)",    "Ost, bearnaisesaus, løk, biff, tomat, champignon"));
        menuList.add(new PizzaInnbakt(45, 140,"U.F.O (dobbel deig)",      "Løk, biff, skinke, champignon, hvit saus"));
        menuList.add(new PizzaInnbakt(46, 140,"Taco",                     "Tacokryddret kjøttdeig, løk, mais, paprika, jalapenos"));

        menuList.add(new Kebab(47,110,"Kebab i pita"));
        menuList.add(new Kebab(48,110,"Kebabrull"));
        menuList.add(new Kebab(49,140,"Rullekebab stor"));
        menuList.add(new Kebab(50,140,"Rullekebab med pommes frites og kebabkjøtt"));
        menuList.add(new Kebab(51,140,"Kebab tallerken"));

        //foods.Hamburger
        menuList.add(new Hamburger(52,90, "Løvstekt hamburger ned salat og dressing"));
        menuList.add(new Hamburger(53,90, "100g kyllingsburger"));
        menuList.add(new Hamburger(54,90, "100g hamburger m/salat og dressing"));
        menuList.add(new Hamburger(55,115,"160g hamburger m/salat og dressing"));
        menuList.add(new Hamburger(56,135,"250g hamburger m/salat og dressing"));
        menuList.add(new Hamburger(57,200,"320g hamburger m/salat og dressing"));
        menuList.add(new Hamburger(58,230,"500g hamburger m/salat og dressing"));

        //foods.Hamburger tallerken
        //? Kanksje sette gram som egen verdi? -KONFLIKTER MED LØVSTEK
        menuList.add(new Hamburger(59,130,"Løvstektallerken"));
        menuList.add(new Hamburger(60,120,"100g hamburgertallerken"));
        menuList.add(new Hamburger(61,135,"160g hamburgertallerken"));
        menuList.add(new Hamburger(62,145,"200g hamburgertallerken"));
        menuList.add(new Hamburger(63,155,"250g hamburgertallerken"));
        menuList.add(new Hamburger(64,230,"320g hamburgertallerken"));
        menuList.add(new Hamburger(65,250,"500g hamburgertallerken"));

        //Voksenretter
        menuList.add(new VoksenMat(66,140,"ShiTawok tallerken", "m/Marinert kyllingbryst, gresk salat, pitabrød, og pommes frites"));
        menuList.add(new VoksenMat(67,130,"Fiskefillet",        "m/pommes frites, salat og dressing"));
        menuList.add(new VoksenMat(68,130,"Kylling nuggets (9)","m/pommes frites, salat og dressing"));
        menuList.add(new VoksenMat(69,130,"1/2 grillet kylling","m/pommes frites, salat og dressing"));
        menuList.add(new VoksenMat(70,140,"Biffsnadder",        "m/pitabrød"));
        menuList.add(new VoksenMat(71,200,"Svinefillet Oscar",  "m/sharonsaus, reker, pommes frites, salat, dressing og pitabrød"));

        //Barneretter
        menuList.add(new DivMat(72,95, "Pizza med skinke og ost"));
        menuList.add(new DivMat(73,80, "Pølse med pommes frites"));
        menuList.add(new DivMat(74,90, "Kyling nuggets (5)"));
        menuList.add(new DivMat(75,100,"Hambrugettalerken"));
        menuList.add(new DivMat(76,50, "Pommes frites (liten)"));
        menuList.add(new DivMat(77,60, "Pommes frites (stor)"));

        //Salat
        menuList.add(new DivMat(78,96,"Gresk salat"));
        menuList.add(new DivMat(79,96,"Rekesalat"));
        menuList.add(new DivMat(80,96,"Kyllingsalat"));
        menuList.add(new DivMat(81,96,"Grønn salat"));

        // Drikke
        menuList.add(new DivMat(82,15,"Kaffe"));
        menuList.add(new DivMat(83,37,"0,5l Mineral"));
        menuList.add(new DivMat(84,50,"1,5l Mineral"));
        menuList.add(new DivMat(85,40,"Slush"));
    }
    //Viser meny i terminal
    private void printMenu(){
        //for-loop for printe alle detaljene i hvert enkelt element i listen
        int nr=0;
        for(MenuItem i: menuList){
            nr++; //todo -> finn en måte printe dette på rett fra array?
            if(nr== 1) System.out.println("\u001B[41m"+"\u001B[30m"+"### Amerikask Pizza ###"+"\u001B[0m");
            if(nr==29) System.out.println("\u001B[41m"+"\u001B[30m"+"### Italiensk Pizza ###"+"\u001B[0m");
            if(nr==42) System.out.println("\u001B[41m"+"\u001B[30m"+"### Innbakt Pizza ###"+"\u001B[0m");
            if(nr==47) System.out.println("\u001B[41m"+"\u001B[30m"+"### Kebab ###"+"\u001B[0m");
            if(nr==52) System.out.println("\u001B[41m"+"\u001B[30m"+"### Hamburger ###"+"\u001B[0m");
            if(nr==59) System.out.println("\u001B[41m"+"\u001B[30m"+"### Hamburger Tallerken ###"+"\u001B[0m");
            if(nr==66) System.out.println("\u001B[41m"+"\u001B[30m"+"### Voksen Retter ###"+"\u001B[0m");
            if(nr==72) System.out.println("\u001B[41m"+"\u001B[30m"+"### Barneretter ###"+"\u001B[0m");
            if(nr==78) System.out.println("\u001B[41m"+"\u001B[30m"+"### Salat ###"+"\u001B[0m");
            if(nr==82) System.out.println("\u001B[41m"+"\u001B[30m"+"### Drikke ###"+"\u001B[0m");

            System.out.println(i.printItem()); //todo -> kan bruke if for å dele opp teksten litt i kategorier
        }
        System.out.println("-----");
    }
    //viser velkomst
    private void printWelcome(){
        System.out.println(
                "############################################\n" +
                "### Velkommen til Melsom pizza og grill! ###\n" +
                "############################################");
    }
    //viser "hade"
    private void printFarewell(){
        System.out.println(
                "############################################\n" +
                "###                    Hade!             ###\n" +
                "############################################");
    }
    //viser alternativer - vurdrer å fjerne
    private void printOptions(){
        System.out.println("---");
        System.out.println("Hva vil du gjøre?");
        System.out.println("---");
        System.out.println("Tast [M], etterfulgt av [Enter], for meny");
        System.out.println("Tast [B], etterfulgt av [Enter], for ny bestilling");
        System.out.println("Tast [L], etterfulgt av [Enter], for å legge til flere varer");
        System.out.println("Tast [P], etterfulgt av [Enter], for å betale");
        System.out.println("Tast [X], etterfulgt av [Enter], for å avslutte");
        System.out.println("---");
        System.out.println("Valg: ");
    }
    //responderer til svar
    private void terminalMenu(){
        printWelcome();
        boolean running = true;
        while (running){
            printOptions();
            String mInput = menuInput.nextLine().toUpperCase();

            switch (mInput){
                case "M" -> printMenu();
                case "B" -> newOrder();
                case "L" -> newOrder();
                case "P" -> payOrder();
                case "X" -> {
                    printFarewell();
                    running = false;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }
    //betaler ordre
    private void payOrder(){
        System.out.println("---");
            for (MenuItem i : orderList) {

                System.out.println(i.getID() + " " + i.getName() + " " + i.getPrice());
                total += i.getPrice();
            }
            System.out.println("Total: " + total);
            discount();

            System.out.println("Pay or run?");
            menuInput.nextLine();
    }
    //Generer ny ordre
    private void newOrder(){
        orderID++;
        orderItemID = 0;
        total = 0;
        orderList.removeAll(orderList);
        addItemToOrder();
    }
    //Legger til vare i ordre
    private void addItemToOrder(){
        orderItemID++;
        boolean finished;
        boolean sizeChoice;

        System.out.println("Hva ønsker du å bestille?");
        int nr = menuInput.nextInt() - 1; //her!
        System.out.println("Du har valgt nr." + (nr + 1) + " \"" + menuList.get(nr).getName() + "\"");
        System.out.println("---");

        if (nr < 28) {
            sizeChoice = true;
            while (sizeChoice) {
                System.out.println("Hvilke størrelse ønsker du?");
                System.out.println("Trykk [M] for medium, [S] for stor, eller [X] for ekstra stor"); //inkluder en kanseleringsfunksjon?
                System.out.println("Valg: ");
                String size = menuInput.next().toUpperCase();

                switch (size) {
                    case "M" -> {
                        orderList.add(new OrderItem(orderItemID, menuList.get(nr).getName(), menuList.get(nr).getPrice(), 1));
                        sizeChoice = false;
                    }
                    case "S" -> {
                        orderList.add(new OrderItem(orderItemID, menuList.get(nr).getName(), menuList.get(nr).getSPrice(), 1));
                        sizeChoice = false;
                    }
                    case "X" -> {
                        orderList.add(new OrderItem(orderItemID, menuList.get(nr).getName(), menuList.get(nr).getXLPrice(), 1));
                        sizeChoice = false;
                    }
                    default -> System.out.println("Ikke godkjent, vennlings bruk [M] for medium, [S] for stor, eller [X] for ekstra stor");
                }
            }
            moreOrExtras(nr);
        }
        else if (nr > 28 && nr < 41) {
            sizeChoice = true;
            while (sizeChoice) {
                System.out.println("Hvilke størrelse ønsker du?");
                System.out.println("Trykk [M] for medium, eller [S] for stor");
                String size = menuInput.nextLine();

                switch (size.toUpperCase()) {
                    case "M" -> {
                        orderList.add(new OrderItem(orderItemID, menuList.get(nr).getName(), menuList.get(nr).getPrice(), 1));
                        sizeChoice = false;
                    }
                    case "S" -> {
                        orderList.add(new OrderItem(orderItemID, menuList.get(nr).getName(), menuList.get(nr).getSPrice(), 1));
                        sizeChoice = false;
                    }
                    default -> System.out.println("Ikke godkjent, vennlings bruk [M] for medium eller [S] for stor");
                }
            }
            moreOrExtras(nr);
        }
        else if (nr > 41) {
            System.out.print("," + menuList.get(nr).getPrice() + "kr");
            orderList.add(new OrderItem(orderItemID, menuList.get(nr).getName(), menuList.get(nr).getPrice(), 1));
        }


    }
    //forespør om en vil ha ekstra
    private void moreOrExtras(int nr) {
        String vilHa;
        if (nr <= 27 || (nr >= 51 && nr <= 57)) {
            System.out.println("Vil du ha noe tilbehør? [J] for ja eller [N] for nei");
            vilHa = menuInput.next();

            switch (vilHa.toUpperCase()) {
                case "J" -> menuEkstra(nr);
                default -> System.out.println("Ok, then");
            }
        }
    }
    //legger til ekstra i ordre
    private void menuEkstra(int nr){
        String ekstra;
        int mengde = 1;

        if(nr<=27){
            System.out.println("---");
            System.out.println("[H]vitløsdressing(15,-), [T]omatsaus(15,-) [K]rydder(15,-), [R]emulade(15,-)");
            System.out.println("eller ekstra [O]st (20,-), k[J]øtt (20,-), eller [G]rønnsaker (15,-)?");
            System.out.println("---");
            System.out.println("Valg: ");
            ekstra = menuInput.next().toUpperCase();
            if(!(ekstra.equals("O") || ekstra.equals("J"))){
                System.out.println("Hvor mange?");
                mengde = menuInput.nextInt();
            }
            for(int i=0;i<mengde;i++) { //kan fjerne når jeg vet hvordan jeg skal regne dette
                switch (ekstra){
                    case "H","T","K","R","G" ->orderList.add(new OrderItem(orderItemID,"Tilbehør", 15, mengde));
                    case "O","J" -> orderList.add(new OrderItem(orderItemID,"Tilbehør", 20, mengde));
                }
            }
        } //for pizza
        if(nr >= 51 && nr <= 57){
            System.out.println("Ekstra [O]st (20,-) eller k[J]øtt (20,-)");
            ekstra = menuInput.next();
            switch (ekstra){
                case "J" -> orderList.add(new OrderItem(orderItemID,"Ekstra Kjøtt", 20, mengde));
                case "O" -> orderList.add(new OrderItem(orderItemID,"Ekstra ost", 20, mengde));
            }

        } //for burger
    }

    private void discount(){
        System.out.println("Apply discount? Input percentage discount");
        System.out.println("eg. input 30 = 30% discount");
        int discount = menuInput.nextInt();
        System.out.println("Appplying " + discount + "% discount");
        this.total *= (1-discount/100);
    }

}
