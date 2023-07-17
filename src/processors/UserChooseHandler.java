package processors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import static processors.DrinksChooseHandler.drinksChooseHandler;
import static processors.FoodChooseHandler.foodChooseHandler;

public class UserChooseHandler {
    public static void userChooseHandler(Scanner drinksOrFood, int userChoice, HashSet<String> orders, ArrayList<String> food, ArrayList<String> drinks) {
        while (userChoice != 1 && userChoice != 2) {
            System.out.println("Please type '1' if you want to order drinks or '2' if you want to order food");
            userChoice = drinksOrFood.nextInt();
        }
        if (userChoice == 1) {
            MenuDisplay.menuDisplay(userChoice);
            drinksChooseHandler(orders, drinks);
        } else if (userChoice == 2) {
            MenuDisplay.menuDisplay(userChoice);
            foodChooseHandler(orders, food);
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
                MenuDisplay.menuDisplay(1);
                drinksChooseHandler(orders, drinks);
            } else if (foodOrDrink == 2) {
                MenuDisplay.menuDisplay(2);
                foodChooseHandler(orders, food);
            }
            endOrResume = endOrResumeScanner.nextInt();
        }
    }
}
