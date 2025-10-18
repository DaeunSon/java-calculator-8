package calculator.parser;

public class DefaultNumberParser implements NumberParser {

    @Override
    public int[] parseNumbers(String input) {
        String[] strNumbers = input.split(",|;");

        int[] numbers = new int[strNumbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
            if (numbers[i] < 0) {
                throw new IllegalArgumentException("유효하지 않은 입력 : 음수는 허용되지 않습니다.");
            }
        }
        return numbers;
    }
}
