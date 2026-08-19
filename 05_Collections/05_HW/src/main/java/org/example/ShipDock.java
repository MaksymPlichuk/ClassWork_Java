package org.example;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class ShipDock {
    private int basePassengerInterval;
    private int baseShipInterval;
    private boolean shipFinalStop;
    private int maxShipCapacity;

    private final Random random = new Random();

    public ShipDock(int basePassengerInterval, int baseShipInterval, boolean shipFinalStop, int maxShipCapacity) {
        this.basePassengerInterval = basePassengerInterval;
        this.baseShipInterval = baseShipInterval;
        this.shipFinalStop = shipFinalStop;
        this.maxShipCapacity = maxShipCapacity;
    }

    private static class Passenger {
        private int arrivalTime;

        Passenger(int arrivalTime) {
            this.arrivalTime = arrivalTime;
        }
    }

    public double getAverageWaitTime() {
        return runSimulation(this.baseShipInterval)[0];
    }

    private int getAdjustedInterval(int minute, int baseInterval) {
        int hour = (minute / 60) % 24;

        if (hour >= 6 && hour < 10) return baseInterval; //ранок
        if (hour >= 17 && hour < 21) return baseInterval; //вечір
        if (hour >= 10 && hour < 17) return baseInterval * 2; //день
        return baseInterval * 4; //ніч
    }

    private double[] runSimulation(int currentShipInterval) {
        Queue<Passenger> dockQueue = new ArrayDeque<>();
        long totalWaitTime = 0;
        int servedPassengers = 0;
        int maxQueueSize = 0;

        int nextShipTime = getAdjustedInterval(0, currentShipInterval);


        for (int minute = 0; minute < 1440; minute++) {

            if (random.nextInt(getAdjustedInterval(minute, this.basePassengerInterval)) == 0) {
                dockQueue.add(new Passenger(minute));
            }

            if (minute >= nextShipTime) {
                int freeSeats = shipFinalStop ? maxShipCapacity : random.nextInt(maxShipCapacity + 1);

                while (freeSeats > 0 && !dockQueue.isEmpty()) {
                    Passenger p = dockQueue.poll();
                    totalWaitTime += (minute - p.arrivalTime);
                    servedPassengers++;
                    freeSeats--;
                }

                nextShipTime = minute + getAdjustedInterval(minute, currentShipInterval);
            }

            if (dockQueue.size() > maxQueueSize) {
                maxQueueSize = dockQueue.size();
            }
        }

        double avgWait = servedPassengers == 0 ? 0 : (double) totalWaitTime / servedPassengers;
        return new double[] { avgWait, maxQueueSize };
    }
    public int findOptimalInterval(int maxPeopleOnDock) {
        int testInterval = 1;

        while (testInterval <= 120) {
            double[] stats = runSimulation(testInterval);
            int maxQueueSize = (int) stats[1];

            if (maxQueueSize <= maxPeopleOnDock) {
                return testInterval;
            }
            testInterval++;
        }
        return -1;
    }
}
