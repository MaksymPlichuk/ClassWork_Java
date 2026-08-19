package org.example;

import org.example.TaxService.TaxService;

public class Main {
    public static void main(String[] args) {
        ShipDock shipDock = new ShipDock(2,15,false,20);
        System.out.printf("Average wait time for passengers: %.2f",shipDock.getAverageWaitTime());

        int maxPeopleOnStop = 15;
        int optimalInterval = shipDock.findOptimalInterval(maxPeopleOnStop);
        System.out.printf("\nFor queue %d on stop optimal time for ships will be: %d",maxPeopleOnStop,optimalInterval);

        System.out.println("\nTask 2");
        Dict dict = new Dict();
        dict.startDictionary();

        System.out.println("\nTask 3");
        TaxService service = new TaxService();
        service.start();
    }
}