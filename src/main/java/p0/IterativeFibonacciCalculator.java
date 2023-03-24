package p0;

public class IterativeFibonacciCalculator implements FibonacciCalculator {

    public IterativeFibonacciCalculator() {
        super();
    }

    @Override
    public int get(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Parameter n must be positive");
        }

        int a = 1;
        int b = 1;

        for (int i = 2; i < n; i++) {
            int tmp = a;
            a = b;
            b = tmp + b;
        }

        return b;
    }
}
