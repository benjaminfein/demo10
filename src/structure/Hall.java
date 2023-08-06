package structure;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Hall {
    private final int capacityOfTables = 20;

    public int getCapacityOfTables() {
        return capacityOfTables;
    }

    public static void drinksChoose(HashSet<String> orders, ArrayList<String> drinks, ArrayList<String> listOfDrinks) {
        Scanner drinkScanner = new Scanner(System.in);
        System.out.println("Please choose something and write number of your choose: ");
        int drinkChoice = 0;
        while (!Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7})
                .contains(drinkScanner.hasNextInt() ? drinkChoice = drinkScanner.nextInt() : drinkScanner.next())){
            System.out.println("Error, input int-value!");
            System.out.println("Please, write number from '1' to '" + listOfDrinks.size() + "' to choose the number in the Menu");
        }
        if (drinkChoice > 0 && drinkChoice < 8) {
            Scanner numberOfDrinksScanner = new Scanner(System.in);
            String chosenDrink = listOfDrinks.get(drinkChoice - 1);
            System.out.println("So, you choose " + chosenDrink + ". How much of drinks do you want?");
            int numberOfDrinks = 0;
            while (!Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
                    .contains(numberOfDrinksScanner.hasNextInt() ? numberOfDrinks = numberOfDrinksScanner.nextInt() : numberOfDrinksScanner.next())){
                System.out.println("Error, input int-value!");
                System.out.println("We can bring you less or equals 10");
            }
            String readyOrder = numberOfDrinks + " " + chosenDrink;
            orders.add(readyOrder);
            drinks.add(readyOrder);
            String sumUp = "Sum up. You want " + orders.toString().substring(1, orders.toString().length() - 1)
                    + ". That's all[1], or you would like to choose anything else[2]?";
            System.out.println(sumUp);
        }
    }

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

    public static void foodChoose(HashSet<String> orders, ArrayList<String> food, ArrayList<String> listOfDishes) {
        Scanner foodScanner = new Scanner(System.in);
        System.out.println("Please choose something and write number of your choose: ");
        int foodChoice = 0;
        while (!Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
                .contains(foodScanner.hasNextInt() ? foodChoice = foodScanner.nextInt() : foodScanner.next())){
            System.out.println("Error, input int-value!");
            System.out.println("Please, write number from '1' to '" + listOfDishes.size() + "' to choose the number in the Menu");
        }
        if (foodChoice > 0 && foodChoice < 11) {
            Scanner numberOfDishesScanner = new Scanner(System.in);
            String chosenDish = listOfDishes.get(foodChoice - 1);
            System.out.println("So, you choose " + chosenDish + ". How much of dishes do you want?");
            int numberOfDishes = 0;
            while (!Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
                    .contains(numberOfDishesScanner.hasNextInt() ? numberOfDishes = numberOfDishesScanner.nextInt() : numberOfDishesScanner.next())){
                System.out.println("Error, input int-value!");
                System.out.println("We can bring you less or equals 10");
            }
            String readyOrder = numberOfDishes + " " + chosenDish;
            orders.add(readyOrder);
            food.add(readyOrder);
            String sumUp = "Sum up. You want " + orders.toString().substring(1, orders.toString().length() - 1)
                    + ". That's all[1], or you would like to choose anything else[2]?";
            System.out.println(sumUp);
        }
    }

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

    public static int tableNumberCount() {

        //Метод выводит номер столика, и цифру 0, если все столики заняты

        String tableFilePath = Paths.get("src/resources/table").toString();
        File tableFile = new File(tableFilePath);
        Hall hall = new Hall();

        try(FileReader tableFileReader = new FileReader(tableFilePath)) {
            Scanner scanner = new Scanner(tableFileReader);
            int number = Integer.parseInt(scanner.nextLine());
            number++;
            if (number <= hall.getCapacityOfTables()){
                try(FileWriter writer = new FileWriter(tableFile, false))
                {
                    writer.write(String.valueOf(number));
                    writer.flush();
                    return number;
                }
                catch(IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                return 0;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static void userChooseHandler(int userChoice, OrderTable orderTable, Bar bar, Kitchen kitchen) {
        if (userChoice == 1) {
            drinkMenuDisplay(bar.getListOfDrinks(), bar);
            drinksChoose(orderTable.getOrders(), bar.getDrinks(), bar.getListOfDrinks());
        } else if (userChoice == 2) {
            foodMenuDisplay(kitchen.getListOfDishes(), kitchen);
            foodChoose(orderTable.getOrders(), kitchen.getFood(), kitchen.getListOfDishes());
        }
        Scanner endOrResumeScanner = new Scanner(System.in);
        int endOrResume = 0;
        while (!Arrays.asList(new Integer[]{1, 2})
                .contains(endOrResumeScanner.hasNextInt() ? endOrResume = endOrResumeScanner.nextInt() : endOrResumeScanner.next())){
            System.out.println("Error, input int-value!");
            System.out.println("Please type '1' if your order is fine or '2' if you want to order anything else");
        }
        if (endOrResume == 1) {
            System.out.println("Ok, we're starting to prepare your order. Thank you!");
        }
        while (endOrResume == 2) {
            Scanner foodOrDrinkScanner = new Scanner(System.in);
            System.out.println("What do you want? Choose '1' if you want Drink or '2' if you want Food.");
            int foodOrDrink = 0;
            while (!Arrays.asList(new Integer[]{1, 2})
                    .contains(foodOrDrinkScanner.hasNextInt() ? foodOrDrink = foodOrDrinkScanner.nextInt() : foodOrDrinkScanner.next())){
                System.out.println("Error, input int-value!");
                System.out.println("Please type '1' if you want Drink or '2' if you want Food.");
            }
            if (foodOrDrink == 1) {
                drinkMenuDisplay(bar.getListOfDrinks(), bar);
                drinksChoose(orderTable.getOrders(), bar.getDrinks(), bar.getListOfDrinks());
            } else if (foodOrDrink == 2) {
                foodMenuDisplay(kitchen.getListOfDishes(), kitchen);
                foodChoose(orderTable.getOrders(), kitchen.getFood(), kitchen.getListOfDishes());
            }
            endOrResume = endOrResumeScanner.nextInt();
        }
    }
}
