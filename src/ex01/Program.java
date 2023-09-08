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
        for (; (i < mySqrt(number) + 1) && isPrime; i++) {
            if ((number % i) == 0) {
                isPrime = false;
            }
        }
        System.out.print(isPrime + " " + (i - 2));
    }

    public static double mySqrt(double x) {
        double result = x / 2;
        double tmp;
        boolean stop = false;
        while (!stop) {
            tmp = result;
            result = (result + x / result) / 2;
            stop = isResultFound(result, tmp);
        }
        return result;
    }

    public static boolean isResultFound(double a, double b) {
        double difference = (a - b) < 0 ? -1 * (a - b) : (a - b);
        return difference <= 0.00001;
    }
}