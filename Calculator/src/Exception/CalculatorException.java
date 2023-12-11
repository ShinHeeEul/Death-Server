package Exception;

public enum CalculatorException {
    MINUS_EXCEPTION("음수는 처리할 수 없습니다.");
    String message;

    CalculatorException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
