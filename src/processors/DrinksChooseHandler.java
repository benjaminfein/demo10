package processors;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class DrinksChooseHandler {
    public static void drinksChooseHandler(HashSet<String> orders, ArrayList<String> drinks) {
        Scanner drinkScanner = new Scanner(System.in);
        System.out.println("Please choose something and write number of your choose: ");
        int drinkChoose = drinkScanner.nextInt();
        if (drinkChoose > 0 && drinkChoose < 8) {
            String drinksMenuFilePath = Paths.get("src/resources/drinksMenu").toString();
            try(FileReader drinksMenuFileReader = new FileReader(drinksMenuFilePath)) {
                ArrayList<String> listOfDrinks = new ArrayList<>();
                Scanner scanner = new Scanner(drinksMenuFileReader);
                while (scanner.hasNextLine()) {
                    String nameOfDrink = scanner.nextLine();
                    if (!nameOfDrink.startsWith("*")){
                        listOfDrinks.add(nameOfDrink.substring(2));
                    }
                }
                Scanner numberOfDrinksScanner = new Scanner(System.in);
                String chosenDrink = listOfDrinks.get(drinkChoose - 1);
                System.out.println("So, you choose " + chosenDrink
                        + ". How much of drinks do you want?");
                int numberOfDrinks = numberOfDrinksScanner.nextInt();
                String readyOrder = numberOfDrinks + " " + chosenDrink;
                orders.add(readyOrder);
                drinks.add(readyOrder);
                String sumUp = "Sum up. You want " + orders.toString().substring(1, orders.toString().length() - 1)
                        + ". That's all[1], or you would like to choose anything else[2]?";
                System.out.println(sumUp);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
