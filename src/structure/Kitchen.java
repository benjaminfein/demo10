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

    public static void currentlyWorkingCooker(ArrayList<String> food, ArrayList<String> dishesMaxCanCook) {
        for (int i = 0; i < food.size(); i++) {
            String dish = food.get(i).substring(2);
            if (dishesMaxCanCook.contains(dish)) {
                System.out.println("Start cooking " + dish + ". This dish is cooking by Max");
            } else {
                System.out.println("Start cooking " + dish + ". This dish is cooking by Pedro");
            }
        }
    }

    public static void preparingOrders(Kitchen kitchen, Bar bar, int numberOfTable, ArrayList<String> dishesMaxCanCook) {
        ArrayList<String> food = kitchen.getFood();
        ArrayList<String> drinks = bar.getDrinks();
        if (food.size() != 0) {
            for (int i = 0; i < food.size(); i++) {
                currentlyWorkingCooker(food, dishesMaxCanCook);
            }
            System.out.println("The waiter brings " + food.toString().substring(1, food.toString().length() - 1)
                    + " to the table " + numberOfTable);
        }
        if (drinks.size() != 0) {
            for (String drink : drinks) {
                System.out.println("Start making " + drink + ". " + bar.getBartender().getName() +
                        " is your bartender today.");
            }
            System.out.println("The waiter brings " + drinks.toString().substring(1, drinks.toString().length() - 1)
                    + " to the table " + numberOfTable);
        }
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
