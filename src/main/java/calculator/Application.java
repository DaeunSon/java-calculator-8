package calculator;

import calculator.core.AddCalculator;
import calculator.core.Calculator;
import calculator.io.ConsoleInput;
import calculator.io.ConsoleOutput;
import calculator.io.InputPort;
import calculator.io.OutputPort;
import calculator.parser.CustomNumberParser;
import calculator.parser.DefaultNumberParser;
import calculator.parser.NumberParser;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputPort input = new ConsoleInput();
        OutputPort output = new ConsoleOutput();
        NumberParser parser;
        Calculator calculator = new AddCalculator();

        output.printLine("덧셈할 문자열을 입력해 주세요.");
        String line = input.readLine();

        if (line != null && line.startsWith("//")) {
            parser = new CustomNumberParser();
        } else {
            parser = new DefaultNumberParser();
        }

        int[] numbers = parser.parseNumbers(line);
        int result = calculator.calculate(numbers);
        output.printLine("결과 : " + result);
    }
}
