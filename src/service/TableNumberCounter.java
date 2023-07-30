package service;

import structure.Hall;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public interface TableNumberCounter {
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
}
