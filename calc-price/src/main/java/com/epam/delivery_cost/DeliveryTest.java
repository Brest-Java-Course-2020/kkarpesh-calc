package com.epam.delivery_cost;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DeliveryTest {
    public static void main(String[] args) {
        Delivery delivery = new Delivery();
        DeliveryService deliveryService = new DeliveryService();



        try {
            System.out.println("Reading prices from files...");
            File pricePerKg = new File("pricePerKg");
            File pricePerKm = new File("pricePerKm");

            delivery.setPricePerKg(deliveryService.readFromFile(pricePerKg));
            delivery.setPricePerKm(deliveryService.readFromFile(pricePerKm));

            System.out.println("Please, enter distance: ");
            delivery.setDeliveryDistance(deliveryService.readFromCommandLine());

            System.out.println("Please, enter weight: ");
            delivery.setCargoWeight(deliveryService.readFromCommandLine());

            System.out.println("Total delivery cost: " + deliveryService.calculatePriceForDelivery(delivery)+ "$");

        } catch (FileNotFoundException ex){
            System.out.println("File not found");
        }



    }

}
