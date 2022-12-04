import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {
    public static void main(String[] args) {
        List<String> input = Inputreader.readInput("day4.txt");

        List<Boolean> overlap = input.stream()
                .map(Day4::isOverlapping)
                .toList();

        List<Boolean> overlapSection = input.stream()
                .map(Day4::isOverlappingSingleSection)
                .toList();

        long solution = overlap.stream()
                .filter(x -> x)
                .count();

        long solution2 = overlapSection.stream()
                .filter(x -> x)
                .count();

        System.out.println(solution);
        System.out.println(solution2);

    }

    private static boolean isOverlapping(String input) {
        String firstRange = input.substring(0, input.indexOf(","));
        String secondRange = input.substring(input.indexOf(",") + 1);

        int firstStart = Integer.parseInt(firstRange.substring(0, firstRange.indexOf("-")));
        int firstEnd = Integer.parseInt(firstRange.substring(firstRange.indexOf("-") + 1));
        int secondStart = Integer.parseInt(secondRange.substring(0, secondRange.indexOf("-")));
        int secondEnd = Integer.parseInt(secondRange.substring(secondRange.indexOf("-") + 1));

        if ((firstStart <= secondStart) && (firstEnd >= secondEnd)) return true;
        return ((secondStart <= firstStart) && (secondEnd >= firstEnd));
    }

    private static boolean isOverlappingSingleSection(String input) {
        String firstRange = input.substring(0, input.indexOf(","));
        String secondRange = input.substring(input.indexOf(",") + 1);

        int firstStart = Integer.parseInt(firstRange.substring(0, firstRange.indexOf("-")));
        int firstEnd = Integer.parseInt(firstRange.substring(firstRange.indexOf("-") + 1));
        int secondStart = Integer.parseInt(secondRange.substring(0, secondRange.indexOf("-")));
        int secondEnd = Integer.parseInt(secondRange.substring(secondRange.indexOf("-") + 1));

        if ((firstStart <= secondStart) && (secondStart <= firstEnd)) return true;
        if ((firstStart <= secondEnd) && (secondEnd <= firstEnd)) return true;
        if ((secondStart <= firstStart) && (firstStart <= secondEnd)) return true;
        return ((secondStart <= firstEnd) && (firstEnd <= secondEnd));
    }
}
