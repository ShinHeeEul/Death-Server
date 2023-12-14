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
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void blank_is_null() {
        assertEquals(0, calculator.add(" "));
        assertEquals(0, calculator.add(null));
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void one_number() {
        assertEquals(1, calculator.add("1"));
    }

    @Test
    @DisplayName("숫자들이 쉼표 구분자로 들어올 경우 숫자 배열이 반환되어야 한다.")
    void split_with_comma() {
        assertArrayEquals(new String[]{"1"}, "1".split(","));
        assertArrayEquals(new String[]{"1", "2"}, "1,2".split(","));
    }

    @Test
    @DisplayName("숫자 두개를 쉼표 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    void with_comma() {
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    @DisplayName("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    void with_comma_column() {
        assertEquals(6, calculator.add("1,2:3"));
    }


    @Test
    @DisplayName("\"//\"와 \"\n\" 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    void with_custom() {
        assertEquals(6, calculator.add("//;\n1;2;3"));
    }

    @Test
    @DisplayName("문자열 계산기에 음수를 전달하는 경우 RunTimeException 예외를 throw한다.")
    void with_minus() {
        assertThrows(RuntimeException.class, () -> calculator.add("-1,2,3"));
    }
}
