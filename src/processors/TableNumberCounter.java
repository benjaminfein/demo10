package processors;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class TableNumberCounter {
    public static int tableNumberCount() {
        String tableFilePath = Paths.get("src/resources/table").toString();
        File tableFile = new File(tableFilePath);
        try(FileReader tableFileReader = new FileReader(tableFilePath)) {
            Scanner scanner = new Scanner(tableFileReader);
            int number = Integer.parseInt(scanner.nextLine());
            number++;
            try(FileWriter writer = new FileWriter(tableFile, false))
            {
                writer.write(String.valueOf(number));
                writer.flush();
                return number;
            }
            catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
