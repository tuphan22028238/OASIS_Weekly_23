public class Fibonacci {
    /**
     * Give back the nth fibonacci number.
     * @param n require to calculate n fibonacci number
     * @return the nth fibonacci number
     */
    public static long fibonacci(long n) {
        long f0 = 0;
        long f1 = 1;
        long fn = 1;
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return f0;
        }
        if (n == 1) {
            return f1;
        }

        for (long i = 2; i <= n; i++) {
            if (Long.MAX_VALUE - f1 < f0) {
                return Long.MAX_VALUE;
            }
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }

    /**
     * Check whether the given number is prime number.
     * @param n given number
     * @return the given number is prime or not
     */
    public static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }
        if (n < 2 || n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        for (int i = 2; i <= Math.round(Math.sqrt(n)); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        for (long i = -1; i < 10; i++)
            System.out.println(fibonacci(i));
        double executed_time = (System.nanoTime() - start)/1000000.0; //ms
        System.out.println("Execution time: " + executed_time);
    }
}
