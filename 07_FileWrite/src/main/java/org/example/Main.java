package org.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static Integer[] lineToIntList(String text) {
        String[] allElems = text.split(" ");
        //if (allElems.length == 0) { allElems = new String[] {text}; }

        List<Integer> onlyNumbers = new ArrayList<>();
        for (int i = 0; i < allElems.length; i++) {
            var elem = tryParseInt(allElems[i]);
            if (elem != null) {
                onlyNumbers.add(elem);
            }
        }
        return onlyNumbers.toArray(new Integer[onlyNumbers.size()]);
    }


    private static Integer tryParseInt(String elem) {
        try {
            return Integer.parseInt(elem);
        } catch (Exception ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Task 1");

        System.out.print("Enter file path 1: ");
        Path path1 = Paths.get(scanner.nextLine());
        System.out.print("\nEnter file path 2: ");
        Path path2 = Paths.get(scanner.nextLine());

        try {
            //без Try Java відмлвляється компілювати це :)
            List<String> text1 = Files.readAllLines(path1);
            List<String> text2 = Files.readAllLines(path2);

            int maxLines = Math.max(text1.size(), text2.size());

            for (int i = 0; i < maxLines; i++) {

                String line1 = i < text1.size() ? text1.get(i) : "End of the Text";
                String line2 = i < text2.size() ? text2.get(i) : "End of the Text";

                if (line1.equals(line2)) {
                    System.out.println(i + " Equal");
                } else {
                    System.out.printf("Differece at line %d\n", i);
                    System.out.println("\u001B[41m File 1: " + line1);
                    System.out.println("\u001B[42m File 2: " + line2);
                    System.out.println("\u001B[0m");
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Task 2");
        System.out.print("Enter File Path: ");
        Path filePath = Paths.get(scanner.nextLine());

        try {
            List<String> listText = Files.readAllLines(filePath);
            if (listText.isEmpty()) {
                return;
            }
            int maxLines = listText.getFirst().length();
            String biggestLine = listText.getFirst();

            for (int i = 0; i < listText.size(); i++) {
                if (listText.get(i).length() > maxLines) {
                    maxLines = listText.get(i).length();
                    biggestLine = listText.get(i);
                }
            }
            System.out.println("\nBiggest Line:");
            System.out.printf("{ %s } with length: %d", biggestLine, maxLines);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nTask 3");

        System.out.print("Enter File Path: ");
        Path text3 = Paths.get(scanner.nextLine());

        try {
            List<String> allLines3 = Files.readAllLines(text3);
            int totalSum = 0;

            for (int i = 0; i < allLines3.size(); i++) {
                int arrSum =0;

                Integer[] arr = lineToIntList(allLines3.get(i));
                if (arr.length==0) {
                    System.out.println("Array - "+(i+1)+ " Didn't have suitable numbers");
                    continue;
                }
                System.out.println("\nArray - "+(i+1));

                Integer max = arr[0];
                Integer min = arr[0];
                for (int j=0; j < arr.length; j++){
                    System.out.print(arr[j]+"\t");

                    if (arr[j] > max) { max = arr[j]; }
                    if (arr[j] < min) { min = arr[j]; }
                    arrSum+=arr[j];
                }
                System.out.printf("\nSum of Array: %d | Max: %d and Min: %d",arrSum,max,min);
                System.out.println();
                totalSum+=arrSum;
            }
            System.out.println("Total sum: "+totalSum);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        System.out.println("Task 4");
        System.out.print("Enter file path: ");
        Path path4 = Paths.get(scanner.nextLine());

        int[] arr = new int[5];

        for (int i=0; i<arr.length; i++){
            System.out.printf("\n[ %d ] element: ",i);
            arr[i] = scanner.nextInt();
        }

        List<Integer> evenNums = new ArrayList<>();
        List<Integer> unevenNums = new ArrayList<>();
        int[] reversedArr = new int[5];
        int j = arr.length-1;

        for (int i = 0; i<arr.length; i++){
            if (arr[i] %2 == 0) {
                evenNums.add(arr[i]);
            }
            else { unevenNums.add(arr[i]); }
            reversedArr[i] = arr[j];
            j--;
        }

        try {
            if (!Files.exists(path4)){
                Files.createFile(path4);
            }
                        //щоб при записі правильно запис
            String strArr = Arrays.toString(arr);
            String strEven = String.valueOf(evenNums);
            String strUneven = String.valueOf(unevenNums);
            String strReversed = Arrays.toString(reversedArr);


            Files.write(path4,List.of(strArr,strEven,strUneven,strReversed));
            System.out.println("Data was written");

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("Task 5");
        Corporation corp = new Corporation();
        corp.startProgram();
    }
}