import java.util.*;

public class Day1 {
    public static void main(String[] args) {
        List<String> input =Inputreader.readInput("day1.txt");

        List<Integer> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < input.size() - 2 ; i++) {
            String inputString = input.get(i);

            count = count + Integer.parseInt(inputString);

            if (input.get(i+1).isBlank()){
                result.add(count);
                count = 0;
                i++;
            }
        }

        int[] resultArray = result.stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(x->x)
                .toArray();

        System.out.println(resultArray[0]);
        int x = resultArray[0] + resultArray[1] + resultArray[2];
        System.out.println(x);
    }
}
