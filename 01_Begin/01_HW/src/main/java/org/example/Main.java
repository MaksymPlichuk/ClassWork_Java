package org.example;


import java.util.Random;
import java.util.Scanner;

public class Main {

    static void DrawLine(int format, int size, char symb) {
        System.out.println();
        if (format == 1) {
            for (int i = 0; i < size; i++) {
                System.out.print(symb);
            }
            System.out.println();
        }
        if (format == 2) {
            for (int i = 0; i < size; i++) {
                System.out.println(symb);
            }
        }
    }

    static void SortArray(int type, int[] arr) {

        for (int item : arr) {
            System.out.printf("\t%d", item);
        }
        System.out.println("\nAfter:");

        if (type == 1) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] < arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }if (type == 2) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        for (int item : arr) {
            System.out.printf("\t%d", item);
        }
    }

    public static void main(String[] args) {

//        Вивести на екран надпис "Your time is limited, so don't waste it living someone else's life" Steve Jobs в різних рядках. Приклад виводу:
//        "Your time is limited,
//          so don't waste it
//              living someone else's life"
//                      Steve Jobs
        System.out.println("Task 1");
        System.out.println("\"Your time is limited,");
        System.out.println(" so don't waste it");
        System.out.println("\tliving someone else's life\"");
        System.out.println("\t\t\tSteve Jobs");

//        Завдання 2:
//        Користувач вводить з клавіатури два числа. Перше число - це значення, друге число - відсоток, який необхідно підрахувати. Наприклад, ми ввели з клавіатури 50 і 10. Потрібно вивести на екран 10 відсотків від 50. Результат 5.
        System.out.println("Task 2");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter percent: ");
        double percent = scanner.nextInt();
        double res = (num1 * percent / 100);
        System.out.printf("%.2f percents of %d = %.2f", percent, num1, res);

//        Завдання 3:
//        Користувач вводить з клавіатури 3 числа. Необхідно створити число, що містить ці числа. Наприклад, якщо з клавіатури введено 7, 3, 8, тоді потрібно сформувати число 738.
        System.out.println("\nTask 3");
        System.out.print("Enter num1: ");
        int n1 = scanner.nextInt();
        System.out.print("Enter num2: ");
        int n2 = scanner.nextInt();
        System.out.print("Enter num3: ");
        int n3 = scanner.nextInt();
        System.out.printf("Число: %d%d%d", n1, n2, n3);

//        Завдання 4:
//        Користувач вводить шестизначне число. Необхідно змінити в цьому числі перше і шосте число, а також друге і п'яте число. Наприклад, 723895 повинно перетворитися на 593827
//        Якщо користувач ввів не шестизначне число потрібно вивести повідомлення про помилку.

        System.out.println("\nTask 4");
        while (true) {
            System.out.print("Enter 6-digit number: ");
            int sixdigit = scanner.nextInt();
            String sixdigStr = String.valueOf(sixdigit);
            if (sixdigStr.length() != 6) {
                System.out.println("It's not a 6 digit number!");
            } else {
                char[] digits = sixdigStr.toCharArray();
                char temp1 = digits[0];
                digits[0] = digits[5];
                digits[5] = temp1;
                char temp2 = digits[1];
                digits[1] = digits[4];
                digits[4] = temp2;

                String strRes = new String(digits);
                System.out.printf("New number: %s", strRes);
                break;
            }

        }
        System.out.println("\nTask 5");
//        Завдання 5:
//        Користувач вводить з клавіатури номер місяця(1-12). В залежності від отриманого номера програма
//        виводить на екран надпис : Winter (якщо введене значення 1,2 або 12), Spring (якщо введене значення від
//                3 до 5), Summer (якщо введене значення від 6 до 8), Autumn (якщо введене значення від 9 до 11).
//                Якщо користувач ввів значення не в діапазоні від 1 до 12 потрібно вивести повідомлення про помилку.
        System.out.print("Enter month number: ");
        int month = scanner.nextInt();
        if (month == 1 | month == 2 | month == 12) {
            System.out.println("Winter");
        } else if (month == 3 | month == 4 | month == 5) {
            System.out.println("Spring");
        } else if (month == 6 | month == 7 | month == 8) {
            System.out.println("Summer");
        } else if (month == 9 | month == 10 | month == 11) {
            System.out.println("Autumn");
        } else {
            System.out.println("Wrong month number");
        }
//                Завдання 6:
//        Користувач вводить з клавіатури кількість метрів. В залежності від вибору користувача програма
//        переводить метри в милі, дюйми чи ярди

        System.out.println("Task 6");
        System.out.print("Enter number of meters: ");
        int meters = scanner.nextInt();
        double convertedRes;
        while (true) {
            System.out.print("[ 1 ] - convert to miles\n[ 2 ] - convert to inches\n[ 3 ] - convert to yards\n Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                convertedRes = meters / 1609.344;
                System.out.printf("Result: %.6f", convertedRes);
                break;
            } else if (choice == 2) {
                convertedRes = meters * 39.3701;
                System.out.printf("Result: %.6f", convertedRes);
                break;
            } else if (choice == 3) {
                convertedRes = meters / 0.9144;
                System.out.printf("Result: %.6f", convertedRes);
                break;
            } else {
                System.out.println("Wrong Choice!");
            }
        }

//        Завдання 7:
//        Користувач вводить з клавіатури два числа. Потрібно вивести всі непарні числа в вказаному
//        діапазоні. Якщо границі вказані не вірно потрібно провести нормалізацію границь. Наприклад,
//                якщо ввели 20 і 11, потрібна нормалізація, після якої початок стане рівним 11, а кінець 20.
        System.out.println("\nTask 7");
        System.out.print("Enter range start: ");
        int start = scanner.nextInt();
        System.out.print("\nEnter range end: ");
        int end = scanner.nextInt();

        if (start > end) {
            int temp = end;
            end = start;
            start = temp;
        }
        System.out.printf("Uneven numbers from %d to %d: ", start, end);
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                System.out.printf("%d\t", i);
            }
        }

//        Завдання 8:
//        Показати на екрані таблицю множення в діапазоні, вказаному користувачем. Наприклад, якщо
//        користувач вказав 3 і 5, таблиця може виглядати так
//        3*1 = 3 3*2 = 6 3*3 = 9 ………… 3* 10 = 30
//        5*1 = 5 5 *2 = 10 5 *3 = 15 ………….
        System.out.println("\nTask 8");
        System.out.print("Enter range start: ");
        int mulStart = scanner.nextInt();
        System.out.print("\nEnter range end: ");
        int mulEnd = scanner.nextInt();
        if (mulStart > mulEnd) {
            int temp = mulEnd;
            mulEnd = mulStart;
            mulStart = temp;
        }
        for (int i = mulStart; i <= mulEnd; i++) {
            int counter = 1;
            while (counter <= 10) {
                System.out.printf("\t%d * %d=%d", i, counter, counter * i);
                counter++;
            }
            System.out.println();
        }


//        Завдання 9:
//        В одномірному масиві, заповненому випадковими числами, визначаємо мінімальне і
//        максимальне значення, підраховуємо кількість від’ємних значень, підраховуємо кількість
//        додатних значень, підраховуємо кількість нулів. Результат виводимо на екран.
        System.out.println("\nTask 9");
        int[] arr = new int[10];
        int negativeCount = 0;
        int positiveCount = 0;
        int numberOfNulls = 0;

        Random rand = new Random();
        int min = 5;
        int max = 100;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
            System.out.printf("%d  ", arr[i]);
        }
        int arrMin = arr[0];
        int arrMax = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arrMax) {
                arrMax = arr[i];
            }
            if (arr[i] < arrMin) {
                arrMin = arr[i];
            }
            if (arr[i] < 0) {
                negativeCount++;
            }
            if (arr[i] > 0) {
                positiveCount++;
            }
            if (arr[i] == 0) {
                numberOfNulls++;
            }
        }
        System.out.printf("\n Min {%d} Max {%d}; negatives {%d}; positives {%d}; nulls {%d}", arrMin, arrMax, negativeCount, positiveCount, numberOfNulls);

//        Завдання 10:
//        Маємо одновимірний масив, заповнений випадковими числами. На основі даних масиву
//        потрібно:
// Створити одновимірний масив, що містить лише парні числа з першого масиву
// Створити одновимірний масив, що містить лише непарні числа з першого масиву
// Створити одновимірний масив, що містить лише від’ємні числа з першого масиву
// Створити одновимірний масив, що містить лише додатні числа з першого масиву
        System.out.println("Task 10");
        int evenCount = 0;
        int unevenCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                unevenCount++;
            }
        }
        int[] evenArr = new int[evenCount];
        int[] unevenArr = new int[unevenCount];
        int[] positiveArr = new int[positiveCount];
        int[] negativeArr = new int[negativeCount];
        int evenArrIndex = 0;
        int unevenArrIndex = 0;
        int positiveArrIndex = 0;
        int negativeArrIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenArr[evenArrIndex] = arr[i];
                evenArrIndex++;
            }
            if (arr[i] % 2 != 0) {
                unevenArr[unevenArrIndex] = arr[i];
                unevenArrIndex++;
            }
            if (arr[i] > 0) {
                positiveArr[positiveArrIndex] = arr[i];
                positiveArrIndex++;
            }
            if (arr[i] < 0) {
                negativeArr[negativeArrIndex] = arr[i];
                negativeArrIndex++;
            }

        }
        System.out.printf("\neven Array: ");
        for (int index : evenArr) {
            System.out.printf("\t%d", index);
        }
        System.out.printf("\nuneven Array: ");
        for (int index : unevenArr) {
            System.out.printf("\t%d", index);
        }
        System.out.printf("\npositive Array: ");
        for (int index : positiveArr) {
            System.out.printf("\t%d", index);
        }
        System.out.printf("\nnegative Array: ");
        for (int index : negativeArr) {
            System.out.printf("\t%d", index);
        }


//        Завдання 11:
//        Написати метод, що відображає вертикальну або горизонтальну лінію із деяких символів. Метод приймає
//        в якості параметрів: довжину лінії, напрям, символ.
        System.out.println("\nTask 11");


        System.out.print("Enter line size: ");
        int lineSize = scanner.nextInt();
        System.out.print("\nEnter line symbol: ");
        char symbol = scanner.next().charAt(0);

        while (true) {
            System.out.print("\tPick format\n[ 1 ] - Horizontal;\n[ 2 ] - Vertical\n");
            int f = scanner.nextInt();
            if (f == 1 | f == 2) {
                DrawLine(f, lineSize, symbol);
                break;
            }

        }

//        Завдання 12:
//        Написати метод, що сортує масив по спаданню або зростанню в залежності від вибору
//        користувача
        System.out.println("Task 12");
        int sortChoice;
        while (true) {
            System.out.print("Enter sort choice\n[ 1 ] - descending\n[ 2 ] - ascending\n");
            sortChoice = scanner.nextInt();
            if (sortChoice == 1 || sortChoice ==2){
                break;
            }
        }
        int[] arrToSort = {1, 8, 7, 5, 4, 8, 10, 78, 0};
        SortArray(sortChoice, arrToSort);

    }
}