import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int count = 0;
        while (number != 42) {
           int sum =  sumDigits(number);
            if (isPrime(sum)) {
                count++;
            }
            number = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Count of coffee-request - " + count);
    }

    private static int sumDigits(int number){
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private static boolean isPrime(int number){
        boolean isPrime = true;
        for (int i = 2; (i < mySqrt(number) + 1) && isPrime; i++) {
            if ((number % i) == 0) {
                isPrime = false;
            }
        }
        return  isPrime;
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