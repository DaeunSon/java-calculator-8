package calculator;

public class Calculator {

    public int calculate(int[] numbers) {
        int sum = 0;
        for (int i=0;i<numbers.length;i++){
            sum += numbers[i];
        }
        return sum;
    }
}
