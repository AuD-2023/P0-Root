package p0;

public class RecursiveFibonacciCalculator implements FibonacciCalculator {

    public RecursiveFibonacciCalculator() {
        super();
    }

    @Override
    public int get(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Parameter n must be positive");
        }

        return calculateFibonacci(n);
    }

    private static int calculateFibonacci(int n) {
        return n == 1 || n == 2 ? 1 : calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }
}
