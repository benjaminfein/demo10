package structure;

import java.util.ArrayList;
import java.util.HashSet;

public class Bar extends OrderTable{
    private ArrayList<String> drinks;
    private ArrayList<String> listOfDrinks;
    private Bartender bartender;

    public Bar(HashSet<String> orders, ArrayList<String> drinks, ArrayList<String> listOfDrinks, Bartender bartender) {
        super(orders);
        this.drinks = drinks;
        this.listOfDrinks = listOfDrinks;
        this.bartender = bartender;
    }

    public ArrayList<String> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<String> drinks) {
        this.drinks = drinks;
    }

    public ArrayList<String> getListOfDrinks() {
        return listOfDrinks;
    }

    public void setListOfDrinks(ArrayList<String> listOfDrinks) {
        this.listOfDrinks = listOfDrinks;
    }

    public Bartender getBartender() {
        return bartender;
    }

    public void setBartender(Bartender bartender) {
        this.bartender = bartender;
    }
}
