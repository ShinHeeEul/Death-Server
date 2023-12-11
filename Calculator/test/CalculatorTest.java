import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("빈 문자열이 들어온 경우 0이 반환되어야 한다.")
    void blank_is_null() {
        assertEquals(0, calculator.add(" "));
        assertEquals(0, calculator.add(null));
    }

    @Test
    @DisplayName("\"1,2\"인 들어온 경우 3을 반환되어야 한다.")
    void with_comma() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    @DisplayName("\"1,2:3\"인 경우 6이 반환되어야 한다.")
    void with_comma_column() {
        assertEquals(6, calculator.add("1,2:3"));
    }

    @Test
    @DisplayName("\"//d\\n1d2,3\"인 경우 6이 반환되어야 한다.")
    void with_custom() {
        assertEquals(6, calculator.add("//d\n1d2,3"));
    }

    @Test
    @DisplayName("음수가 들어간 경우 RunTimeException 에러가 발생 해야한다.")
    void with_minus() {
        assertThrows(RuntimeException.class, () -> calculator.add("-1,10"));
    }
}
