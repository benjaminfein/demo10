package processors;

import structure.Bar;
import structure.Kitchen;
import structure.OrderTable;

import java.util.Scanner;

import static service.DrinkChoose.drinksChoose;
import static service.DrinkMenuDisplay.drinkMenuDisplay;
import static service.FoodChoose.foodChoose;
import static service.FoodMenuDisplay.foodMenuDisplay;

public class UserChooseHandler {
    public static void userChooseHandler(int userChoice, OrderTable orderTable, Bar bar, Kitchen kitchen) {
        if (userChoice == 1) {
            drinkMenuDisplay(bar.getListOfDrinks(), bar);
            drinksChoose(orderTable.getOrders(), bar.getDrinks(), bar.getListOfDrinks());
        } else if (userChoice == 2) {
            foodMenuDisplay(kitchen.getListOfDishes(), kitchen);
            foodChoose(orderTable.getOrders(), kitchen.getFood(), kitchen.getListOfDishes());
        }
        Scanner endOrResumeScanner = new Scanner(System.in);
        int endOrResume = endOrResumeScanner.nextInt();
        while (endOrResume != 1 && endOrResume != 2) {
            System.out.println("Please type '1' if your order is fine or '2' if you want to order anything else");
            endOrResume = endOrResumeScanner.nextInt();
        }
        if (endOrResume == 1) {
            System.out.println("Ok, we're starting to prepare your order. Thank you!");
        }
        while (endOrResume == 2) {
            Scanner foodOrDrinkScanner = new Scanner(System.in);
            System.out.println("What do you want? Choose '1' if you want Drink or '2' if you want Food.");
            int foodOrDrink = foodOrDrinkScanner.nextInt();
            while (foodOrDrink != 1 && foodOrDrink != 2) {
                System.out.println("Please type '1' if you want Drink or '2' if you want Food.");
                foodOrDrink = foodOrDrinkScanner.nextInt();
            }
            if (foodOrDrink == 1) {
                drinkMenuDisplay(bar.getListOfDrinks(), bar);
                drinksChoose(orderTable.getOrders(), bar.getDrinks(), bar.getListOfDrinks());
            } else if (foodOrDrink == 2) {
                foodMenuDisplay(kitchen.getListOfDishes(), kitchen);
                foodChoose(orderTable.getOrders(), kitchen.getFood(), kitchen.getListOfDishes());
            }
            endOrResume = endOrResumeScanner.nextInt();
        }
    }
}
