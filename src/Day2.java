import java.util.List;

public class Day2 {
    public static void main(String[] args) {
        List<String> input = Inputreader.readInput("day2.txt");

        List<Integer> resultsPerPlay = input.stream()
                .map(Day2::calculate)
                .toList();

        List<Integer> resultsPerPlay2 = input.stream()
                .map(Day2::calculate2)
                .toList();

        int solutionOne = resultsPerPlay.stream().mapToInt(x -> x).sum();
        int solutionTwo = resultsPerPlay2.stream().mapToInt(x -> x).sum();
        System.out.println(solutionOne);
        System.out.println(solutionTwo);
    }

    private static int calculate(String input) {
        int rockAX = 1;
        int paperBY = 2;
        int scissorCZ = 3;

        String player1 = input.substring(0, 1);
        String player2 = input.substring(2);

        int result = switch (player1) {
            case "A" -> switch (player2) {
                case "X" -> 3 + rockAX;
                case "Y" -> 6 + paperBY;
                case "Z" -> scissorCZ;
                default -> 0;
            };
            case "B" -> switch (player2) {
                case "X" -> rockAX;
                case "Y" -> 3 + paperBY;
                case "Z" -> 6 + scissorCZ;
                default -> 0;
            };
            case "C" -> switch (player2) {
                case "X" -> 6 + rockAX;
                case "Y" -> paperBY;
                case "Z" -> 3 + scissorCZ;
                default -> 0;
            };
            default -> 0;
        };
        return result;
    }

    private static int calculate2(String input) {
        int rockAX = 1;
        int paperBY = 2;
        int scissorCZ = 3;

        String player1 = input.substring(0, 1);
        String player2 = input.substring(2);

        return switch (player1) {
            case "A" -> switch (player2) {
                case "Z" -> 6 + paperBY;
                case "Y" -> 3 + rockAX;
                case "X" -> scissorCZ;
                default -> 0;
            };
            case "B" -> switch (player2) {
                case "Z" -> 6 + scissorCZ;
                case "Y" -> 3 + paperBY;
                case "X" -> rockAX;
                default -> 0;
            };
            case "C" -> switch (player2) {
                case "Z" -> 6 + rockAX;
                case "Y" -> 3 + scissorCZ;
                case "X" -> paperBY;
                default -> 0;
            };
            default -> 0;
        };
    }
}
