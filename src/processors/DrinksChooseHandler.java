package processors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class DrinksChooseHandler {
    public static void drinksChooseHandler(HashSet<String> orders, ArrayList<String> drinks, ArrayList<String> listOfDrinks) {
        Scanner drinkScanner = new Scanner(System.in);
        System.out.println("Please choose something and write number of your choose: ");
        int drinkChoice = drinkScanner.nextInt();
        while (drinkChoice <= 0 || drinkChoice>= 8) {
            System.out.println("Please, write number from '1' to " + drinks.size() + " to choose the number in the Menu");
        }
        if (drinkChoice > 0 && drinkChoice < 8) {
            Scanner numberOfDrinksScanner = new Scanner(System.in);
            String chosenDrink = listOfDrinks.get(drinkChoice - 1);
            System.out.println("So, you choose " + chosenDrink + ". How much of drinks do you want?");
            int numberOfDrinks = numberOfDrinksScanner.nextInt();
            String readyOrder = numberOfDrinks + " " + chosenDrink;
            orders.add(readyOrder);
            drinks.add(readyOrder);
            String sumUp = "Sum up. You want " + orders.toString().substring(1, orders.toString().length() - 1)
                    + ". That's all[1], or you would like to choose anything else[2]?";
            System.out.println(sumUp);
        }
    }
}
