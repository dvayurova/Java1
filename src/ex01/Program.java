import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number <= 1) {
            System.err.println("IllegalArgument ");
            System.exit(-1);
        }
        boolean isPrime = true;
        int i = 2;
        for (; (i < Math.sqrt(number) + 1) && isPrime; i++) {
            if ((number % i) == 0) {
                isPrime = false;
            }
        }
        scanner.close();
        System.out.println(isPrime + " " + (i -2));
    }
}