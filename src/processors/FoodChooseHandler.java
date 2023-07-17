package processors;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class FoodChooseHandler {
    public static void foodChooseHandler(HashSet<String> orders, ArrayList<String> food) {
        Scanner foodScanner = new Scanner(System.in);
        System.out.println("Please choose something and write number of your choose: ");
        int foodChoice = foodScanner.nextInt();
        if (foodChoice > 0 && foodChoice < 11) {
            String foodMenuFilePath = Paths.get("src/resources/foodMenu").toString();
            try(FileReader foodMenuFileReader = new FileReader(foodMenuFilePath)) {
                ArrayList<String> listOfDishes = new ArrayList<>();
                Scanner scanner = new Scanner(foodMenuFileReader);
                while (scanner.hasNextLine()) {
                    String nameOfDish = scanner.nextLine();
                    if (!nameOfDish.startsWith("*")){
                        listOfDishes.add(nameOfDish.substring(2));
                    }
                }
                Scanner numberOfDishesScanner = new Scanner(System.in);
                String chosenDish = listOfDishes.get(foodChoice - 1);
                System.out.println("So, you choose " + chosenDish
                        + ". How much of dishes do you want?");
                int numberOfDishes = numberOfDishesScanner.nextInt();
                String readyOrder = numberOfDishes + " " + chosenDish;
                orders.add(readyOrder);
                food.add(readyOrder);
                String sumUp = "Sum up. You want " + orders.toString().substring(1, orders.toString().length() - 1)
                        + ". That's all[1], or you would like to choose anything else[2]?";
                System.out.println(sumUp);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
