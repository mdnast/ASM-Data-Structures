public class Factorial {
    public static int factorial(int n) {
        if (n == 1) return 1; // Base case
        return n * factorial(n - 1); // Recursive case
    }

    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println("Factorial of 5: " + result);
    }
}
