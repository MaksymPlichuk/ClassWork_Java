package org.example;


public class Main {
    public static void main(String[] args) {
        System.out.println("---------Task 1-----------");

        Array<Integer> array = new Array<>(Integer.class);

        array.FillArrayManually();
        array.ShowArray();
        array.FillArrayWithNumbers();
        array.ShowArray();
        array.FindMin();
        array.FindMax();
        array.FindAvg();
        array.BinarySearch();
        array.ReplaceValue();

        Matrix matrix = new Matrix(2,3);
        matrix.ShowMatrix();
        //matrix.FillManually();
        matrix.FillWithRandom();
        matrix.MinMaxAvg();

        Matrix matrix2 = new Matrix(3,2);
        matrix2.FillWithRandom();
        matrix2.MultiplyMatrices(matrix);

        Matrix matrix3 = new Matrix(3,3);
        matrix3.FillWithRandom();

        Matrix matrix4 = new Matrix(3,3);
        matrix4.FillWithRandom();

        matrix3.AddMatrices(matrix4);
        matrix3.SubtractMatrices(matrix4);

        System.out.println("----------Division M3 3x3 and M4 3x3----------");
        matrix3.ShowMatrix();
        matrix4.DivideMatrices(matrix3);


    }
}