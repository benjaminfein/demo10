package structure;

import java.util.ArrayList;
import java.util.HashSet;

public class Kitchen extends OrderTable{
    private Cooker cooker;
    private ArrayList<String> food;
    private ArrayList<String> listOfDishes;

    public Kitchen(HashSet<String> orders, Cooker cooker, ArrayList<String> food, ArrayList<String> listOfFood) {
        super(orders);
        this.cooker = cooker;
        this.food = food;
        this.listOfDishes = listOfFood;
    }

    public Cooker getCooker() {
        return cooker;
    }

    public void setCooker(Cooker cooker) {
        this.cooker = cooker;
    }

    public ArrayList<String> getFood() {
        return food;
    }

    public void setFood(ArrayList<String> food) {
        this.food = food;
    }

    public ArrayList<String> getListOfDishes() {
        return listOfDishes;
    }

    public void setListOfDishes(ArrayList<String> listOfDishes) {
        this.listOfDishes = listOfDishes;
    }
}
