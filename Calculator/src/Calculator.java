import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Exception.CalculatorException.*;

public class Calculator {


    public Calculator() {
    }

    public int add(String expression) {
        if (isNull(expression)) {
            return 0;
        }
        String[] numbers = split(expression);

        return sum(toInt(numbers));
    }

    private String[] split(String expression) {
        Matcher m = Pattern.compile(Literal.CUSTOM_REGEX).matcher(expression);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return expression.split(Literal.COMMA + Literal.OR + Literal.COLUMN);
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private int[] toInt(String[] numbers) {
        int[] values = new int[numbers.length];

        for (int i = 0; i < values.length; i++) {
            values[i] += toPositive(numbers[i]);
        }

        return values;
    }

    private boolean isNull(String expression) {
        return expression == null || expression.equals(Literal.BLANK);
    }

    private int toPositive(String number) {
        int value = Integer.parseInt(number);
        if (value < 0) {
            throw new RuntimeException(MINUS_EXCEPTION.getMessage());
        }
        return value;
    }


}
