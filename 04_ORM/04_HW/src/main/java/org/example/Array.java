package org.example;

import java.util.*;

//для порівннянь T типу і Min Max
public class Array<T extends Number & Comparable<T>> {

    private ArrayList<T> list = new ArrayList<>();//щоб не було null
    private Scanner scanner = new Scanner(System.in);
    private Class<T> type;//typeof у Java

    public Array(Class<T> type) {
        this.type = type;
    }

    public void ShowArray() {
        for (var item : list) {
            System.out.printf(item + "\t");
        }
        System.out.println();
    }

    public void FillArrayManually() {
        while (true) {
            System.out.println("[ 1 ] -- fill with numbers\n[ 2 ] -- exit");
            int choice = scanner.nextInt();
            int i = 0;

            if (choice == 2) {
                return;
            } else if (choice == 1) {
                System.out.printf("\nEnter element [ %d ], type %s: ", i, type.getSimpleName());
                T elem = parseInput(scanner.next());
                list.add(elem);
                i += 1;
            }
        }
    }

    public void FillArrayWithNumbers() {
        Random random = new Random();
        if (type.equals(Integer.class) || type.equals(Double.class) || type.equals(Float.class)) {
            System.out.print("Enter size for Array: ");
            int size = scanner.nextInt();
            for (int i = 0; i < size; i++) {
                int randNum = random.nextInt(50 + 50 + 1) - 50;

                T number = parseInput(String.valueOf(randNum));
                list.add(number);
            }
        } else {
            System.out.println("Type of Array must be float double or integer");
        }
    }

    public void FindMin() {
        if (list.isEmpty()) {
            System.out.println("Array is empty!");
            return;
        }
        T min = Collections.min(list);
        System.out.println("Min: " + min);
    }

    public void FindMax() {
        if (list.isEmpty()) {
            System.out.println("Array is empty!");
            return;
        }
        T max = Collections.max(list);
        System.out.println("Max: " + max);
    }

    public void FindAvg() {
        if (list.isEmpty()) {
            System.out.println("Array is empty!");
            return;
        }
        int count = list.size();
        double sum = 0;
        for (T item : list) {
            sum += item.doubleValue(); //метод від Number
        }
        System.out.printf("Avg: %.4f", sum / count);
    }

    public void SortAsc() {
        Collections.sort(list);
        System.out.println("Sorted ascending");
    }

    public void SortDesc() {
        list.sort(Collections.reverseOrder());
        System.out.println("sorted descending");
    }

    public void BinarySearch() {
        SortAsc();
        System.out.print("Enter element for search: ");
        T elem = parseInput(scanner.next());
        int index = Collections.binarySearch(list, elem);
        if (index < 0) {
            System.out.println("Element " + elem + " not found");
            return;
        }
        System.out.println("Found " + elem + " at index " + (index - 1));
    }

    public void ReplaceValue() {
        System.out.print("Enter element to replace: ");
        T elem = parseInput(scanner.next());
        int i = 0;
        boolean found = false;
        for (var item : list) {
            if (item.equals(elem)) {
                found=true;
                break;
            }
            i++;
        }

        if (found) System.out.printf("Element found at index %d",i);
        else {
            System.out.println("Element not found");
            return;
        }
        System.out.print("\nEnter new element: ");
        T newElem = parseInput(scanner.next());
        list.remove(i);
        list.add(newElem);
        System.out.println("Successfully added");
        ShowArray();
    }

    private T parseInput(String input) {
        if (type.equals(Integer.class)) return (T) Integer.valueOf(input);
        if (type.equals(Float.class)) return (T) Float.valueOf(input);
        if (type.equals(Double.class)) return (T) Double.valueOf(input);
        throw new IllegalArgumentException("Wrong type");
    }
}
