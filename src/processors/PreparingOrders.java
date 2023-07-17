package processors;

import java.util.ArrayList;
import java.util.Objects;

public class PreparingOrders {
    public static void preparingOrders(ArrayList<String> food, ArrayList<String> drinks, int numberOfTable) {
        for (int i = 0; i < food.size(); i++) {
            String dish = food.get(i);
            System.out.println("Start cooking " + dish);
            if (Objects.equals(dish, "Mashed potatoes")
                    || Objects.equals(dish, "Summertime salad")
                    || Objects.equals(dish, "Meatballs")) {
                System.out.println("This dish is cooking by First cook");
            } else if (Objects.equals(dish, "Sushi rolls")
                    || Objects.equals(dish, "Cesar salad")) {
                System.out.println("This dish is cooking by Second cook");
            } else if (Objects.equals(dish, "Seafood salad")
                    || Objects.equals(dish, "Borsch")) {
                System.out.println("This dish is cooking by Third cook");
            }
        }
        System.out.println("The waiter brings " + food.toString().substring(1, food.toString().length() - 1)
                + " to the table " + numberOfTable);
        for (int i = 0; i < drinks.size(); i++) {
            String drink = drinks.get(i);
            System.out.println("Start making " + drink);
            if (i >= 0 && i < 3) {
                System.out.println("The bartender takes your order from the fridge");
            } else if (i >= 3 && i < 5) {
                System.out.println("The bartender is making your hot drink");
            } else {
                System.out.println("The bartender is making your cocktail");
            }
        }
        System.out.println("The waiter brings " + drinks.toString().substring(1, drinks.toString().length() - 1)
                + " to the table " + numberOfTable);
    }
}
