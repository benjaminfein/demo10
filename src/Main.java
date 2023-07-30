import structure.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

import static processors.PreparingOrders.preparingOrders;
import static processors.UserChooseHandler.userChooseHandler;
import static service.TableNumberCounter.tableNumberCount;

public class Main {
    public static void main(String[] args) {
        Scanner enterToRestaurant = new Scanner(System.in);
        System.out.println("If you want to enter to restaurant please type 'Enter'. If you don't - type anything else.");
        String start = enterToRestaurant.nextLine();
        if (Objects.equals(start, "Enter")) {
            HashSet<String> orders = new HashSet<>();
            ArrayList<String> food = new ArrayList<>();
            ArrayList<String> drinks = new ArrayList<>();
            ArrayList<String> listOfDrinks = new ArrayList<>();
            ArrayList<String> listOfDishes = new ArrayList<>();

            OrderTable orderTable = new OrderTable(orders);
            Bartender bartender = new Bartender();
            Bar bar = new Bar(orders, drinks, listOfDrinks, bartender);
            ArrayList<String> dishesMaxCanCook = new ArrayList<>();
            dishesMaxCanCook.add("Mashed potatoes");
            dishesMaxCanCook.add("Summertime salad");
            dishesMaxCanCook.add("Meatballs");
            dishesMaxCanCook.add("Borsch");
            ArrayList<String> dishesPedroCanCook = new ArrayList<>();
            dishesPedroCanCook.add("Sushi rolls");
            dishesPedroCanCook.add("Cesar salad");
            dishesPedroCanCook.add("Seafood salad");
            Cooker max = new Cooker("Max", dishesMaxCanCook);
            Cooker pedro = new Cooker("Pedro", dishesPedroCanCook);
            Kitchen kitchen = new Kitchen(orders, max, food, listOfDishes);
            Scanner drinksOrFood = new Scanner(System.in);
            int numberOfTable = tableNumberCount();
            if (numberOfTable == 0) {
                System.out.println("You can go to the veranda. If you want to go to the veranda type 1, " +
                        "if you want to leave type 2");
                Scanner scanner = new Scanner(System.in);
                int secondUserChoice = scanner.nextInt();
                while (secondUserChoice != 1 && secondUserChoice != 2) {
                    System.out.println("Please type 1 if you want to go to the veranda or 2 if you want to leave.");
                    secondUserChoice = drinksOrFood.nextInt();
                }
                if (secondUserChoice == 1) {
                    System.out.println("Ok, so you would like to seat on the veranda. " +
                            "We will add a bottle of water to your order"
                            + "." + '\n' + "So what would you like at first? Drinks[1] or Food[2]?");
                    int userChoice = drinksOrFood.nextInt();
                    while (userChoice != 1 && userChoice != 2) {
                        System.out.println("Please type '1' if you want to order drinks or '2' if you want to order food");
                        userChoice = drinksOrFood.nextInt();
                    }
                    userChooseHandler(userChoice, orderTable, bar, kitchen);
                    orders.add(listOfDishes.get(2));
                    preparingOrders(kitchen, bar, numberOfTable, dishesMaxCanCook);
                    System.out.println("Your order is ready. Bon appetit!");
                } else {
                    System.out.println("Goodbye! We apologize for this case, next time it will be place to seat. " +
                            "Thanks a lot for your visit!");
                }
            } else {
                System.out.println("Ok, so number of your table is '" + numberOfTable
                        + "'." + '\n' + "So what would you like at first? Drinks[1] or Food[2]?");
                int userChoice = drinksOrFood.nextInt();
                while (userChoice != 1 && userChoice != 2) {
                    System.out.println("Please type '1' if you want to order drinks or '2' if you want to order food");
                    userChoice = drinksOrFood.nextInt();
                }
                userChooseHandler(userChoice, orderTable, bar, kitchen);
                preparingOrders(kitchen, bar, numberOfTable, dishesMaxCanCook);
                System.out.println("Your order is ready. Bon appetit!");
            }
        } else {
            System.out.println("Goodbye! Thanks a lot for your visit!");
        }
    }
}
