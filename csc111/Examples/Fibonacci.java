
public class Fibonacci {
    public static void main(String[] args) {
        long n = 10;
        
        for(int i = 0; i < 1000; i++) {
            System.out.println(i + 1 + ": " + fibonacci(i));
        }
    }

    public static long fibonacci(long n) {
        long prev = 1;
        long current = 1;
        for(int i = 3; i <= n; i++) {
            long next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }

    // get the nth fibonacci number starting at current
    // if n = 1 that would be current
    // if n = 2 then it is previosu + current
    public static long fibRecGood(long n, long previous, long current) {
        if(n == 1) {
            return current;
        } else {
            return fibRecGood(n - 1, current, previous + current);
        }
    }
}
    



