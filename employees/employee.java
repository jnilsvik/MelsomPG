package employees;

import java.util.ArrayList;

public abstract class employee {
    private String name;
    private String position;
    private int wage;

    ArrayList<String> startTime = new ArrayList<>();
    ArrayList<String> stopTime = new ArrayList<>();
    ArrayList<Double> times = new ArrayList<>();

    public employee(String name, String position, int wage) {

    }
}
