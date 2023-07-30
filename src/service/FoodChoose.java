package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public interface FoodChoose {
    public static void foodChoose(HashSet<String> orders, ArrayList<String> food, ArrayList<String> listOfDishes) {
        Scanner foodScanner = new Scanner(System.in);
        System.out.println("Please choose something and write number of your choose: ");
        int foodChoice = foodScanner.nextInt();
        while (foodChoice <= 0 || foodChoice>= 8) {
            System.out.println("Please, write number from '1' to " + food.size() + " to choose the number in the Menu");
        }
        if (foodChoice > 0 && foodChoice < 11) {
            Scanner numberOfDishesScanner = new Scanner(System.in);
            String chosenDish = listOfDishes.get(foodChoice - 1);
            System.out.println("So, you choose " + chosenDish + ". How much of dishes do you want?");
            int numberOfDishes = numberOfDishesScanner.nextInt();
            String readyOrder = numberOfDishes + " " + chosenDish;
            orders.add(readyOrder);
            food.add(readyOrder);
            String sumUp = "Sum up. You want " + orders.toString().substring(1, orders.toString().length() - 1)
                    + ". That's all[1], or you would like to choose anything else[2]?";
            System.out.println(sumUp);
        }
    }
}
