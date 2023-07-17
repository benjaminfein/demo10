import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

import static processors.PreparingOrders.preparingOrders;
import static processors.TableNumberCounter.tableNumberCount;
import static processors.UserChooseHandler.userChooseHandler;

public class Main {
    public static void main(String[] args) {
        Scanner enterToRestaurant = new Scanner(System.in);
        System.out.println("If you want to enter to restaurant please type 'Enter'. If you don't - type anything else.");
        String start = enterToRestaurant.nextLine();
        if (Objects.equals(start, "Enter")) {
            HashSet<String> orders = new HashSet<>();
            ArrayList<String> food = new ArrayList<>();
            ArrayList<String> drinks = new ArrayList<>();

            Scanner drinksOrFood = new Scanner(System.in);
            int numberOfTable = tableNumberCount();
            System.out.println("Ok, so number of your table is '" + numberOfTable
                    + "'." + '\n' + "So what would you like at first? Drinks[1] or Food[2]?");
            int userChoice = drinksOrFood.nextInt();
            userChooseHandler(drinksOrFood, userChoice, orders, food, drinks);

            preparingOrders(food, drinks, numberOfTable);
            System.out.println("Your order is ready. Bon appetit!");
        } else {
            System.out.println("Goodbye! Thanks a lot for your visit!");
        }
    }
}
