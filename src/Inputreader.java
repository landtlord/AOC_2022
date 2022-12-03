import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inputreader {
    public static List<String> readInput(String inputFileName) {
        List<String> input = new ArrayList<>();
        try {
            File inputFile = new File("C:\\Users\\andyl\\IdeaProjects\\advent of code\\resources\\" + inputFileName);
            Scanner inputReader = new Scanner(inputFile);
            while (inputReader.hasNext()){
                input.add(inputReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }
}