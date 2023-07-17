package processors;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class MenuDisplay {
    public static void menuDisplay(int userChoice) {
        if (userChoice == 1) {
            String drinksMenuFilePath = Paths.get("src/resources/drinksMenu").toString();
            try(FileReader drinksMenuFileReader = new FileReader(drinksMenuFilePath)) {
                Scanner scanner = new Scanner(drinksMenuFileReader);
                while (scanner.hasNextLine()) {
                    System.out.println('\n' + scanner.nextLine());
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (userChoice == 2) {
            String foodMenuFilePath = Paths.get("src/resources/foodMenu").toString();
            try(FileReader foodMenuFileReader = new FileReader(foodMenuFilePath)) {
                Scanner scanner = new Scanner(foodMenuFileReader);
                while (scanner.hasNextLine()) {
                    System.out.println('\n' + scanner.nextLine());
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Wrong choose! Please type '1' or '2'.");
        }
    }
}
