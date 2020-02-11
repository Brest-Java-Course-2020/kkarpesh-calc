package com.epam.delivery_cost;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DeliveryTest {
    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application-config.xml");
        Delivery delivery = (Delivery) applicationContext.getBean("delivery");
        DeliveryService deliveryService = (DeliveryService) applicationContext.getBean("deliveryService");



        try {
            System.out.println("Reading prices from files...");
            File pricePerKg = new File("calc-price/src/main/resources/pricePerKg");
            File pricePerKm = new File("calc-price/src/main/resources/pricePerKm");

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
