package calculator.parser;

public class NumberParser {

    public int[] parseNumbers(String input) {
        int[] strNumbers = new int[input.length()];
        try {
            // 커스텀 구분자라면 parseNumbersWithCustomDelimiter 호출
            if (input.startsWith("//")) {
                strNumbers = parseNumbersWithCustomDelimiter(input);
            }

            // 기본 구분자라면 parseNumbersWithDefaultDelimiter 호출
            else if (!input.startsWith("//")) {
                strNumbers = parseNumbersWithDefaultDelimiter(input);
            } else { // 빈 문자열일 경우
                strNumbers[0] = 0;
            }
            return strNumbers;
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int[] parseNumbersWithCustomDelimiter(String input) {
        // parseDelimiter 메서드를 사용하여 구분자 추출
        int newLineIndex = input.indexOf("\\n");

        System.out.println("newLineIndex : " + newLineIndex);

        String delimiter = parseDelimiter(input, newLineIndex);
        System.out.println("delimiter : " + delimiter);
        String numbersPart = input.substring(newLineIndex + 2);
        System.out.println("numbersPart : " + numbersPart);
        String[] strNumbers = numbersPart.split(delimiter);

        int[] numbers = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }
        return numbers;
    }

    public int[] parseNumbersWithDefaultDelimiter(String input) {
        String[] strNumbers = input.split(",|;");

        int[] numbers = new int[strNumbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }
        return numbers;
    }


    private String parseDelimiter(String input, int newLineIndex) {
        int delimiterIndex = newLineIndex - 1;
        return String.valueOf(input.charAt(delimiterIndex));
    }
}
