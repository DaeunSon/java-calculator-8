package calculator.parser;

public class CustomNumberParser implements NumberParser {
    @Override
    public int[] parseNumbers(String input) {
        // parseDelimiter 메서드를 사용하여 구분자 추출
        int newLineIndex = input.indexOf("\\n");

        if (newLineIndex == -1) {
            throw new IllegalArgumentException("유효하지 않은 입력 : 입력에 개행 문자가 없습니다.");
        }
        String delimiter = parseDelimiter(input, newLineIndex);
        String numbersPart = input.substring(newLineIndex + 2);
        String[] strNumbers = numbersPart.split(delimiter);

        int[] numbers = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
            if (numbers[i] < 0) {
                throw new IllegalArgumentException("유효하지 않은 입력 : 음수는 허용되지 않습니다.");
            }
        }
        return numbers;
    }

    private String parseDelimiter(String input, int newLineIndex) {
        int delimiterIndex = newLineIndex - 1;
        return String.valueOf(input.charAt(delimiterIndex));
    }
}
