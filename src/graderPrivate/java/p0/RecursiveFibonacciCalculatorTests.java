package p0;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.assertCallEquals;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;

@TestForSubmission
public class RecursiveFibonacciCalculatorTests {

    private static final FibonacciCalculator FIBONACCI_CALCULATOR = new RecursiveFibonacciCalculator();

    @ParameterizedTest
    @CsvFileSource(resources = "/fibonacci.csv")
    public void testFibonacci(int n, int expected) {
        assertCallEquals(expected, () -> FIBONACCI_CALCULATOR.get(n), contextBuilder().add("n", n).build(),
            result -> "Returned number did not match the expected Fibonacci number");
    }

    @Test
    public void testStrictlyRecursive() {

    }
}
