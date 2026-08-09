package org.example;

import org.example.Animal.Crocodile;
import org.example.Animal.Kangaroo;
import org.example.Animal.Tiger;
import org.example.Device.*;
import org.example.Human.Builder;
import org.example.Human.Pilot;
import org.example.Human.Sailor;
import org.example.Array.Array;
import org.example.Instrument.Cello;
import org.example.Instrument.Trombone;
import org.example.Instrument.Ukulele;
import org.example.Instrument.Violin;
import org.example.Money.Money;
import org.example.Money.Product;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("----------Task 1------------");

        Sailor sailor = new Sailor(1,25,"Ivan",3580);
        System.out.println(sailor);

        Builder builder = new Builder(2,45,"Mukola",20);
        System.out.println(builder);

        Pilot pilot = new Pilot(3,45,"Thomas","Corporal");
        System.out.println(pilot);

        System.out.println("----------Task 2------------");
        Tiger tiger = new Tiger("Tigr",50,5,3);
        tiger.Sound();
        System.out.println(tiger);

        Crocodile crocodile = new Crocodile("Bob",200,7,78);
        crocodile.Sound();
        System.out.println(crocodile);

        Kangaroo kangoo = new Kangaroo("Austin",150,10,15);
        kangoo.Sound();
        System.out.println(kangoo);

        System.out.println("----------Task 3------------");
        Product product = new Product("Donut",5,"Tasty ummm",new Money(5));
        System.out.println(product);
        product.ReducePrice(2);
        System.out.println("Price after change:\n"+product);

        System.out.println("----------Task 4------------");
        Device device = new Device("dddd","ddd","ddd");
        Auto auto = new Auto("FordMustang legendary auto","GT","FordMustang",250000);
        auto.Sound();
        auto.Desc();
        auto.Show();

        Kettle kettle = new Kettle("black kettle nice","samsung","XY-57", 40);
        kettle.Sound();
        kettle.Desc();
        kettle.Show();

        Microwave microwave = new Microwave("black Microwave nice","samsung","XYQ-59", 10);
        microwave.Sound();
        microwave.Desc();
        microwave.Show();

        SteamShip steamShip = new SteamShip("routing through Atlantic","light-cruiser","potyomkin", 250);
        steamShip.Sound();
        steamShip.Desc();
        steamShip.Show();

        System.out.println("\n----------Task 5------------");
        Violin violin = new Violin("Violing","blablalbalblab",30,"The modern violin emerged in early 16th-century northern Italy, evolving from earlier bowed instruments like the rebec",8);
        violin.Show();
        violin.Sound();
        violin.Desc();
        violin.History();

        System.out.println("--------------------");
        Trombone trombone = new Trombone(
                "Trombone",
                "A brass instrument with a long sliding tube used to change pitch.",
                15,
                "Developed in the mid-15th century, it was originally called the sackbut before evolving into the modern trombone.",
                85
        );
        trombone.Show();
        trombone.Sound();
        trombone.Desc();
        trombone.History();

        System.out.println("--------------------");
        Cello cello = new Cello(
                "Cello",
                "A large bowed string instrument with a deep, rich, and warm tone.",
                45,
                "Developed in the 16th century alongside the violin family, it became a core part of the orchestra by the Baroque era.",
                4
        );
        cello.Show();
        cello.Sound();
        cello.Desc();
        cello.History();

        System.out.println("--------------------");
        Ukulele ukulele = new Ukulele(
                "Ukulele",
                "A small four-stringed instrument resembling a miniature guitar.",
                5,
                "Introduced to Hawaii by Portuguese immigrants in the late 19th century, where it gained rapid royal popularity.",
                "Portugal / Hawaii"
        );
        ukulele.Show();
        ukulele.Sound();
        ukulele.Desc();
        ukulele.History();


        System.out.println("\n----------Task 6-7------------");
        int[] arr = new int[10];
        Random random = new Random();
        for (int i=0; i<arr.length; i++){
                    //max-min+1 +min (від [0-21) --> після -10: [-10 - 11))
            arr[i] = random.nextInt(20+10+1) + -10;
            System.out.printf("%d\t".formatted(arr[i]));
        }
        Array array = new Array(arr);
        System.out.printf("\nMin: %d".formatted(array.min()));
        System.out.printf("\nMax: %d".formatted(array.max()));
        System.out.printf("\nAvg: %.3f\n".formatted(array.avg()));

        array.asc();
        System.out.println(array);

        array.desc();
        System.out.println(array);

    }
}