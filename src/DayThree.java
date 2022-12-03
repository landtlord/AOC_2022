import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayThree {
    public static void main(String[] args) {
        List<String> input = Inputreader.readInput("day3.txt");

        List<Character> priority = input.stream().map(DayThree::calculate).toList();
        List<Character> priority2 = calculate2(input);

        int solution = priority.stream().mapToInt(DayThree::intValue).sum();
        int solution2 = priority2.stream().mapToInt(DayThree::intValue).sum();

        System.out.println(solution);
        System.out.println(solution2);

    }

    private static Character calculate(String s) {
        String firstCompartment = s.substring(0, s.length() / 2);
        String secondCompartment = s.substring(s.length() / 2) ;

        for (char character : firstCompartment.chars().mapToObj(x -> (char) x).toList()) {
            if (secondCompartment.indexOf(character) > -1) return character;
        }
        return null;
    }

    private static List<Character> calculate2(List<String> stringList) {
        List<Character> results = new ArrayList<>();


        for (int i = 0; i < stringList.size(); i = i + 3) {
            results.add(getCommonChar(stringList.get(i),stringList.get(i+1), stringList.get(i+2)));
        }
        return results;
    }

    private static Character getCommonChar(String s, String s1, String s2) {
        for (char character : s.chars().mapToObj(x -> (char) x).toList()) {
            if (s1.indexOf(character) > -1) {
                if (s2.indexOf(character) > -1) return character;
            };
        }
        return null;
    }

    private static int intValue(Character character) {
        int result = (int) character;
        if (result > 95) {
            return result - 96;
        }
        return result - 38;
    }


}
