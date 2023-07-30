package service;

import structure.Kitchen;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public interface FoodMenuDisplay {
    public static void foodMenuDisplay(ArrayList<String> listOfDishes, Kitchen kitchen) {
        String foodMenuFilePath = Paths.get("src/resources/foodMenu").toString();
        try (FileReader foodMenuFileReader = new FileReader(foodMenuFilePath)) {
            Scanner scanner = new Scanner(foodMenuFileReader);
            while (scanner.hasNextLine()) {
                String lineOfFoodMenu = scanner.nextLine();
                System.out.println('\n' + lineOfFoodMenu);
                if (!lineOfFoodMenu.startsWith("*")) {
                    listOfDishes.add(lineOfFoodMenu.substring(2));
                }
            }
            kitchen.setListOfDishes(listOfDishes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
