package p0;

import org.sourcegrade.jagr.api.rubric.Criterion;
import org.sourcegrade.jagr.api.rubric.Grader;
import org.sourcegrade.jagr.api.rubric.JUnitTestRef;
import org.sourcegrade.jagr.api.rubric.Rubric;
import org.sourcegrade.jagr.api.rubric.RubricProvider;
import org.sourcegrade.jagr.api.testing.TestCycle;

public class P0_RubricProvider_Private implements RubricProvider {

    private static final Criterion FIBONACCI_ITERATIVE_CRITERION = Criterion.builder()
        .shortDescription("Die Fibonacci-Zahlen werden in [[[IterativeFibonacciCalculator]]] korrekt berechnet.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() ->
                IterativeFibonacciCalculatorTests.class.getDeclaredMethod("testFibonacci", int.class, int.class)))
            .pointsFailedMin()
            .pointsPassedMax()
            .build())
        .build();
    private static final Criterion FIBONACCI_LOOPS_ONLY = Criterion.builder()
        .shortDescription("Methode [[[get(int)]]] in [[[IterativeFibonacciCalculator]]] ist rein iterativ implementiert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> IterativeFibonacciCalculatorTests.class.getDeclaredMethod("testStrictlyIterative", TestCycle.class)))
            .pointsFailedMin()
            .pointsPassedMax()
            .build())
        .minPoints(-1)
        .maxPoints(0)
        .build();
    private static final Criterion FIBONACCI_ITERATIVE = Criterion.builder()
        .shortDescription("Fibonacci-Zahlen - iterativ")
        .addChildCriteria(FIBONACCI_ITERATIVE_CRITERION, FIBONACCI_LOOPS_ONLY)
        .minPoints(0)
        .maxPoints(1)
        .build();

    private static final Criterion FIBONACCI_RECURSIVE_CRITERION = Criterion.builder()
        .shortDescription("Die Fibonacci-Zahlen werden in [[[RecursiveFibonacciCalculator]]] korrekt berechnet.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> RecursiveFibonacciCalculatorTests.class.getDeclaredMethod(
                "testFibonacci", int.class, int.class)))
            .pointsFailedMin()
            .pointsPassedMax()
            .build())
        .build();
    private static final Criterion FIBONACCI_RECURSION_ONLY = Criterion.builder()
        .shortDescription("Methode [[[get(int)]]] in [[[RecursiveFibonacciCalculator]]] ist rein rekursiv implementiert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> RecursiveFibonacciCalculatorTests.class.getDeclaredMethod(
                "testStrictlyRecursive")))
            .pointsFailedMin()
            .pointsPassedMax()
            .build())
        .minPoints(-1)
        .maxPoints(0)
        .build();
    private static final Criterion FIBONACCI_RECURSIVE = Criterion.builder()
        .shortDescription("Fibonacci-Zahlen - rekursiv")
        .addChildCriteria(FIBONACCI_RECURSIVE_CRITERION, FIBONACCI_RECURSION_ONLY)
        .minPoints(0)
        .maxPoints(1)
        .build();

    public static final Rubric RUBRIC = Rubric.builder()
        .title("P0")
        .addChildCriteria(FIBONACCI_ITERATIVE, FIBONACCI_RECURSIVE)
        .build();

    @Override
    public Rubric getRubric() {
        return RUBRIC;
    }
}
