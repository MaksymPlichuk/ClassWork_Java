package org.example;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Predicate<Integer> isLeapYear = year -> (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        //2 приймає 1 повертає
        BiFunction<LocalDate, LocalDate, Long> daysBetween = (d1, d2) -> ChronoUnit.DAYS.between(d1, d2);

        Function<LocalDate, DayOfWeek> dayOfTheWeek = d -> d.getDayOfWeek();

        System.out.println("----Task 1-----");

        LocalDate date1 = LocalDate.of(1969, 7, 20);
        LocalDate date2 = LocalDate.of(2026, 7, 12);

        System.out.println(isLeapYear.test(2000));
        System.out.println("Days between: " + daysBetween.apply(date1, date2));
        System.out.println(date1 + " is " + dayOfTheWeek.apply(date1));

        System.out.println("----Task 2-----");

        BiFunction<Fraction, Fraction, Fraction> sumFractions = (f1, f2) ->
                new Fraction(f1.numerator * f2.denominator + f2.numerator * f1.denominator, f2.denominator * f1.denominator);

        BiFunction<Fraction, Fraction, Fraction> subtractFractions = (f1, f2) ->
                new Fraction(f1.numerator * f2.denominator - f2.numerator * f1.denominator, f2.denominator * f1.denominator);

        BiFunction<Fraction, Fraction, Fraction> multiplyFractions = (f1, f2) ->
                new Fraction(f1.numerator * f2.numerator, f2.denominator * f1.denominator);

        BiFunction<Fraction, Fraction, Fraction> divideFractions = (f1, f2) ->
                new Fraction(f1.numerator * f2.denominator, f2.denominator * f1.denominator);

        Fraction f1 = new Fraction(3, 2);
        Fraction f2 = new Fraction(2, 3);

        System.out.println(f1 + " + " + f2 + " = " + sumFractions.apply(f1, f2));
        System.out.println(f1 + " - " + f2 + " = " + subtractFractions.apply(f1, f2));
        System.out.println(f1 + " * " + f2 + " = " + multiplyFractions.apply(f1, f2));
        System.out.println(f1 + " - " + f2 + " = " + divideFractions.apply(f1, f2));

        System.out.println("----Task 3-----");

        interface TemplateFunction<T extends Comparable<T>> {
            T apply(T[] arr);
        }

        TemplateFunction<Integer> findMax = arr -> {
            Integer max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i].compareTo(max) > 0) {
                    max = arr[i];
                }
            }
            return max;
        };
        TemplateFunction<Integer> findMin = arr -> {
            Integer min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i].compareTo(min) < 0) {
                    min = arr[i];
                }
            }
            return min;
        };

        Random random = new Random();
        Integer arr[] = {0, 0, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            int val = random.nextInt(10 + 10 + 1) - 10;
            arr[i] = Integer.valueOf(val);
            i++;
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i + " \t"));
        System.out.println("\nMax: " + findMax.apply(arr));
        System.out.println("Min: " + findMin.apply(arr));

        System.out.println("----Task 4-----");

        BiFunction<int[], Integer, Boolean> isArrSumEqual = (a, num) -> Arrays.stream(a).sum() == num;

        interface ThreeArgs<A, B, C, R> {
            R apply(A arr, B n1, C n2);
        }

        ThreeArgs<int[], Integer, Integer, Boolean> isNumInRange = (a, n1, n2) -> {
            Integer res = Arrays.stream(a).sum();
            if (res <= n2 && res >= n1) {
                return true;
            }
            return false;
        };

        Function<int[], Boolean> isSumPositive = a -> Arrays.stream(a).sum() > 0;
        Function<int[], Boolean> isSumNevgative = a -> Arrays.stream(a).sum() < 0;


        int[] arr2 = {0, 0, 0, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = random.nextInt(10 + 10 + 1) - 10;
            System.out.print(arr2[i] + "\t");
            i++;
        }

        int arr2Sum = 0;
        for (int item : arr2) {
            System.out.print(item + "\t");
            arr2Sum+=item;
        }
        System.out.println("\nSumm of array = "+arr2Sum);

        Integer n1 = 2;
        Integer n2 = 9;


        System.out.println("\nIs sum == " + n1 + " " + isArrSumEqual.apply(arr2, n1));
        System.out.println("Is sum in rage " + n1 + " to " + n2 + " " + isNumInRange.apply(arr2, n1, n2));
        System.out.println("Is sum > 0 " + isSumPositive.apply(arr2));
        System.out.println("Is sum < 0 " + isSumNevgative.apply(arr2));

    }
}