package calculator.core;

public class AddCalculator implements Calculator{
    @Override
    public int calculate(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
