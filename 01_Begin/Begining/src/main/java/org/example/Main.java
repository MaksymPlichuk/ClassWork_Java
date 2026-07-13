package org.example; //namespace


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter arr size: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        Random rand = new Random();
        int min =18;
        int max = 80;
        for (int i=0; i<size; i++)
        {
            arr[i] = rand.nextInt(max-min+1)+min;
        }
        int count = 0;
        for (int item: arr){

            System.out.printf("%d\t", item);
            if (item>=25){
                count++;
            }
        }
        System.out.println("Nums > 25: "+count);

        //System.out.println(num);

//        System.out.print("Enter your name: ");
//        String name = scanner.nextLine();
//        System.out.println("Hello " + name);
//
//
//        System.out.println("Hello WRLD!");
//        int a = 25;
//        System.out.println(a);
//
//        boolean b = true;
//
//        char ch = 'd';
//        String str = "string";
//
//        System.out.println("b="+b);
//        System.out.println(ch+" "+str);
    }
}