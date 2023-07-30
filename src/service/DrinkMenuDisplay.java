package service;

import structure.Bar;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public interface DrinkMenuDisplay {
    public static void drinkMenuDisplay(ArrayList<String> listOfDrinks, Bar bar) {
        String drinksMenuFilePath = Paths.get("src/resources/drinksMenu").toString();
        try (FileReader drinksMenuFileReader = new FileReader(drinksMenuFilePath)) {
            Scanner scanner = new Scanner(drinksMenuFileReader);
            while (scanner.hasNextLine()) {
                String lineOfDrinkMenu = scanner.nextLine();
                System.out.println('\n' + lineOfDrinkMenu);
                if (!lineOfDrinkMenu.startsWith("*")) {
                    listOfDrinks.add(lineOfDrinkMenu.substring(2));
                }
            }
            bar.setListOfDrinks(listOfDrinks);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
