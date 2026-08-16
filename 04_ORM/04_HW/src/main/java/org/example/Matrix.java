package org.example;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Matrix {

    private int[][] matrix;
    private Scanner scanner = new Scanner(System.in);
    //private Class<T> type;
    int rows;
    int cols;

    public Matrix(int rows, int cols) {
        this.matrix = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public void ShowMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void ShowCalculatedMatrix(Matrix m) {
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                System.out.print(m.matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void FillWithRandom() {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10 + 10 + 1) - 10;
            }
        }
        System.out.println("\nRandomly filled matrix");
        ShowMatrix();
    }

    public void FillManually() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("Enter element at position [%d,%d]: ", i, j);
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("\nManually filled matrix");
        ShowMatrix();
    }

    public void AddMatrices(Matrix m) {
        boolean res = CheckDimensions(m.rows, m.cols);
        if (!res) {
            return;
        }

        Matrix newMatrix = new Matrix(m.rows, m.cols);
        //int[][] newMatrix = new int[m.rows][m.cols];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix.matrix[i][j] = this.matrix[i][j] + m.matrix[i][j];
            }
        }
        System.out.println("Matrices sum");
        ShowCalculatedMatrix(newMatrix);
    }

    public void SubtractMatrices(Matrix m) {
        boolean res = CheckDimensions(m.rows, m.cols);
        if (!res) {
            return;
        }
        Matrix newMatrix = new Matrix(m.rows, m.cols);
        //int[][] newMatrix = new int[m.rows][m.cols];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix.matrix[i][j] = this.matrix[i][j] - m.matrix[i][j];
            }
        }
        System.out.println("Matrices subtraction");
        ShowCalculatedMatrix(newMatrix);
    }

    public void MultiplyMatrices(Matrix m) {
        if (!(this.cols == m.rows)) {
            System.out.print("Cant multiply matrices! Because of wrong sizes");
            return;
        }
        //int[][] newMatrix = new int[this.rows][m.cols];
        Matrix newMatrix = new Matrix(this.rows, m.cols);

        for (int i = 0; i < newMatrix.rows; i++) {
            for (int j = 0; j < newMatrix.cols; j++) {

                newMatrix.matrix[i][j] = 0;
                for (int k = 0; k < this.cols; k++) {
                    newMatrix.matrix[i][j] += this.matrix[i][k] * m.matrix[k][j];
                }

            }
        }
        System.out.println("Multiplied Matrices");
        ShowCalculatedMatrix(newMatrix);
    }

    private Matrix MatrixTransposition(Matrix m) { //temp ф-ція для ділення
        Matrix newMatrix = new Matrix(m.cols, m.rows);

        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                newMatrix.matrix[j][i] = m.matrix[i][j];
            }
        }
        System.out.println("Transposed Matrix");
        ShowCalculatedMatrix(newMatrix);
        return newMatrix;
    }

    public void DivideMatrices(Matrix m) {

        Matrix divisionMatrix = MatrixTransposition(m);
        if (!(this.cols == divisionMatrix.rows)) {
            System.out.print("Cant divide matrices! Because of wrong sizes");
            return;
        }
        //int[][] newMatrix = new int[this.rows][m.cols];
        Matrix newMatrix = new Matrix(this.rows, m.cols);

        for (int i = 0; i < newMatrix.rows; i++) {
            for (int j = 0; j < newMatrix.cols; j++) {

                newMatrix.matrix[i][j] = 0;
                for (int k = 0; k < this.cols; k++) {
                    newMatrix.matrix[i][j] += this.matrix[i][k] / divisionMatrix.matrix[k][j];
                }

            }
        }
        System.out.println("Divided Matrices");
        ShowCalculatedMatrix(newMatrix);
    }

    public void MinMaxAvg() {
        if (this.matrix.length == 0) {
            System.out.println("Matrix is Empty");
        }
        int min = this.matrix[0][0];
        int max = this.matrix[0][0];

        int sum = 0;
        int count = this.rows * this.cols;

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < cols; j++) {

                sum += this.matrix[i][j];

                if (this.matrix[i][j] > max) {
                    max = this.matrix[i][j];
                }
                if (this.matrix[i][j] < min) {
                    min = this.matrix[i][j];
                }
            }
        }

        System.out.println("Max: " + max);
        System.out.println("Max: " + min);
        System.out.println("Average: " + (sum / count));
    }

    private boolean CheckDimensions(int r, int c) {
        if (this.rows != r || this.cols != c) {
            System.out.println("Matrices not equal!");
            return false;
        } else return true;
    }


//    private T parseInput(String input) {
//        if (type.equals(Integer.class)) return (T) Integer.valueOf(input);
//        if (type.equals(Float.class)) return (T) Float.valueOf(input);
//        if (type.equals(Double.class)) return (T) Double.valueOf(input);
//        throw new IllegalArgumentException("Wrong type");
//    }
}
