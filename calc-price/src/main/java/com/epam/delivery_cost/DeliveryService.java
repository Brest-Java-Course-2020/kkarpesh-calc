package com.epam.delivery_cost;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class DeliveryService {

    private Delivery delivery;

    public DeliveryService() {
    }

    public DeliveryService(Delivery delivery) {
        this.delivery = delivery;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }


    public double readFromCommandLine() {
        Scanner input = new Scanner(System.in);
        double finalValue = 0;
        String enteredValue;
        do {
            System.out.println("For exit enter Q");
            enteredValue = input.next();
            if (isExitValue(enteredValue)) {
                System.out.println("Finish");
                System.exit(0);

            } else {
                finalValue = convertFromStringToDouble(enteredValue);
            }
        } while (!isCorrectValue(enteredValue));

        return finalValue;
    }

    public double readFromFile(File file) throws FileNotFoundException {

        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);
        String stringFromFile = "";

        while (scanner.hasNextLine()) {
            stringFromFile += scanner.nextLine();
        }

        return convertFromStringToDouble(stringFromFile);
    }

    public boolean isCorrectValue(String value) {
        boolean checkResult;
        try {
            double enteredDoubleValue = Double.parseDouble(value);
            checkResult = enteredDoubleValue > 0;
        } catch (NumberFormatException ex) {
            checkResult = false;
        }
        return checkResult;

    }

    public boolean isExitValue(String value) {
        return value.equalsIgnoreCase("Q");
    }

    public double convertFromStringToDouble(String value) throws NumberFormatException {
        double finalValue = 0;
        try {
            finalValue = Double.parseDouble(value);
        } catch (NumberFormatException ex) {
            System.out.println("Incorrect value");
        }
        return finalValue;
    }

    public BigDecimal calculatePriceForDelivery(Delivery delivery) {

        BigDecimal costBasedOnDistance = new BigDecimal(delivery.getPricePerKm() * delivery.getDeliveryDistance() * delivery.getDistanceDiscount());
        BigDecimal costBasedOnWeight = new BigDecimal(delivery.getPricePerKg() * delivery.getCargoWeight() * delivery.getWeightDiscount());
        BigDecimal totalCost = costBasedOnDistance.add(costBasedOnWeight);

        return totalCost;

    }
}
