import java.util.Scanner;

public class Program {

    private static final int MAX_CODE_VALUE = 65535;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] result = input.toCharArray();
        int[] charFrequency = new int[MAX_CODE_VALUE];

        for (int i = 0; i < result.length; i++) {
            charFrequency[result[i]]++;
        }
        char[] allChars = new char[result.length];
        int[] frequencyArray = new int[allChars.length];
        int uniqueLettersCount = getNonZero(charFrequency, allChars, frequencyArray);
        bubbleSortDescending(frequencyArray, allChars, uniqueLettersCount);

        int numberOfResults = uniqueLettersCount > 10 ? 10 : uniqueLettersCount;
        drawChart(frequencyArray, allChars, numberOfResults);
        scanner.close();
    }

    public static int getNonZero(int[] charFrequency, char[] allChars, int[] frequencyArray) {
        int j = 0;
        for (int i = 0; i < MAX_CODE_VALUE; i++) {
            if (charFrequency[i] != 0) {
                frequencyArray[j] = charFrequency[i];
                allChars[j] = (char) i;
                j++;
            }
        }
        return j;
    }

    public static void bubbleSortDescending(int[] arr, char[] allChars, int uniqueLettersCount) {
        char[] resChars = new char[uniqueLettersCount];
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    char tempSymbol = allChars[j];
                    allChars[j] = allChars[j + 1];
                    allChars[j + 1] = tempSymbol;
                }
            }
        }
    }

    public static void drawChart(int[] frequencies, char[] chars, int numberOfResults) {
        int[] temp = new int[10];
        temp[0] = 10;
        if (frequencies[0] != 0) {
            for (int i = 1; i < numberOfResults; i++) {
                temp[i] = frequencies[i] * 10 / frequencies[0];
            }
            for (int i = 11; i > 0; i--) {
                for (int j = 0; j < 10 && frequencies[j] != 0; j++) {
                    if (temp[j] == i - 1) {
                        System.out.print(frequencies[j] + "\t");
                    } else if (temp[j] >= i) {
                        System.out.print("#\t");
                    } else {
                        System.out.print("\t");
                    }
                }
                System.out.println();
            }
            for (int i = 0; i < numberOfResults; i++) {
                System.out.print((char) chars[i] + "\t");
            }
        }
        System.out.println();
    }
}


