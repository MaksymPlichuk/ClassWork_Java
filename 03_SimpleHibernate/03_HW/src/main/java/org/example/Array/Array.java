package org.example.Array;

import lombok.Data;

@Data
public class Array implements IMath, ISort {
    private int[] array;

    public Array(int[] array) {
        this.array = array;
    }

    @Override
    public int max() {
        int max = array[0];
        for (int item : array) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    @Override
    public int min() {
        int min = array[0];
        for (int item : array) {
            if (item < min) {
                min = item;
            }
        }
        return min;
    }

    @Override
    public float avg() {
        int sum = 0;
        for (int item : array) {
            sum += item;
        }
        return (float) sum / array.length;
    }

    @Override
    public void desc() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void asc() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
