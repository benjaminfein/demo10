package processors;

import structure.Bar;
import structure.Kitchen;

import java.util.ArrayList;

import static service.CurrentlyWorkingCooker.currentlyWorkingCooker;

public class PreparingOrders {
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
}
