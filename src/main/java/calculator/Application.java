package calculator;

import calculator.parser.NumberParser;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator();
        int result;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            String input = Console.readLine();
            System.out.println("입력받은 문자열 : " + input);

            if (input.isEmpty()) {
                result = 0;
            }

            else {
                int[] numbers = new int[input.length()];

                NumberParser parser = new NumberParser();
                numbers = parser.parseNumbers(input);

                for (int i = 0; i < numbers.length; i++) {
                    System.out.println("파싱된 숫자 : " + numbers[i]);
                }

                result = calculator.calculate(numbers);

            }
            System.out.println("계산 결과 : " + result);
        }

        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
