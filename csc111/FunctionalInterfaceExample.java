import java.beans.DefaultPersistenceDelegate;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        double[] numbers = new double[(args.length)];
        for (int i = 0; i < args.length; i++) {
            numbers[i] = Double.parseDouble(args[i]);
        }


        // double sum = combine(numbers, (a, b) -> a + b);;
        // double product = combine(numbers, (a, b) -> a * b);

        double sum = combine(numbers, FunctionalInterfaceExample::sum);;
        double product = combine(numbers, FunctionalInterfaceExample::product);

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }

    static double combine(double[] array, Op op) {
        double combined = array[0];
        for (int i = 0; i < array.length; i++) {
            combined = op.operate(combined, array[i]);
        }
        return combined;
    }

    static double sum(double[] array, Op op) {
        double combined = array[0];
        for (int i = 1; i < array.length; i++) {
            combined = combined + array[i];
        }
        return combined;
    }

    static double product(double[] array, Op op) {
        double combined = array[0];
        for (int i = 1; i < array.length; i++) {
            combined = combined * array[i];
        }
        return combined;
    }

    @FunctionalInterface
    static interface Op {
        double operate(double a, double b);
    }
}
