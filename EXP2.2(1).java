import java.util.*;

public class SumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = new ArrayList<>();
        System.out.println("Enter numbers separated by space:");
        String input = scanner.nextLine();
        scanner.close();
        
        String[] inputs = input.split(" ");
        numbers.addAll(Arrays.asList(inputs));
        
        int sum = calculateSum(numbers);
        System.out.println("Sum of the list: " + sum);
    }

    public static int calculateSum(List<String> numbers) {
        int sum = 0;
        for (String num : numbers) {
            Integer intValue = Integer.parseInt(num); 
            sum += intValue; 
        }
        return sum;
    }
}
