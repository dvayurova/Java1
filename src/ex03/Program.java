import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String weekInput = scanner.nextLine();
        int week = 1;
        long gradeForResult = 0;
        while (!weekInput.equals("42") && week <= 18) {
            if (!weekInput.equals("Week " + week)) {
                printError();
            }
            gradeForResult = gradeForResult * 10 + getMinGrade(scanner);
            weekInput = scanner.nextLine();
            week++;
        }
        printResult(week, gradeForResult);
        scanner.close();
    }

    private static void printError() {
            System.err.println("IllegalArgument");
            System.exit(-1);
    }

    private static int getMinGrade(Scanner scanner) {
        int min = scanner.nextInt();
        int grade;
        for (int i = 0; i < 4 && scanner.hasNextInt(); i++) {
            grade = scanner.nextInt();
            if (grade < min) {
                min = grade;
            }
        }
        scanner.nextLine();
        return min;
    }

    private static void printResult(int week, long gradeForResult) {
        long reverseGrades = reverseNumber(gradeForResult);
        for (int i = 1; i < week; i++) {
            System.out.print("Week " + i + " ");
            long minGrade = reverseGrades % 10;
            for (int j = 0; j < minGrade; j++) {
                System.out.print("=");
            }
            System.out.println(">");
            reverseGrades /= 10;
        }
    }

    private static long reverseNumber(long number) {
        long result = 0;
        while (number != 0) {
            result = result * 10 + (number % 10);
            number /= 10;
        }
        return result;
    }

}