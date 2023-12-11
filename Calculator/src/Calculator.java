import static Exception.CalculatorException.*;

public class Calculator {

    private final String MINUS = "-";
    private final String COLUMN = ":";
    private final String COMMA = ",";
    private final String BLANK = " ";
    private final String START_SEPARATOR = "//";
    private final String END_SEPARATOR = "\n";
    public Calculator() {
    }

    public int add(String expression) {

        String correctExpression = unifyRegex(expression);
        validExpression(expression);

        int answer = 0;
        String[] numbers = correctExpression.split(BLANK);

        for(String number : numbers) {
            answer += Integer.parseInt(number);
        }

        return answer;
    }

    private void validExpression(String expression) {
        if(expression.contains(MINUS)) {
            throw new RuntimeException(MINUS_EXCEPTION.getMessage());
        }
    }

    private String unifyRegex(String expression) {
        String unifiedExpression = expression;
        if(expression.contains(START_SEPARATOR) && expression.contains(END_SEPARATOR)) {
            String customRegex = expression.split(START_SEPARATOR)[1].split(END_SEPARATOR)[0];
            unifiedExpression = expression.split(END_SEPARATOR)[1];
            unifiedExpression = unifiedExpression.replaceAll(customRegex, BLANK);
        }

        unifiedExpression = unifiedExpression.replaceAll(COLUMN, BLANK);
        unifiedExpression = unifiedExpression.replaceAll(COMMA, BLANK);

        return unifiedExpression;

    }




}
