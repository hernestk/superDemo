public class Factorial {
    public static void main(String[] args) {

    }

    public static long factorial(long n) {
        if(n == 1) {
            // base case
            return n;
        } else {
            return n * factorial(n - 1);

            // small problem
            // long f = factorial(n - 1);

            // long result = f * n;
        }
    }

    public static long factorialIter(long n) {
        long product = 1;

        for(long i = 0; i <= n; i++) {
            product *= i;
        }
        return product;
    }
}
