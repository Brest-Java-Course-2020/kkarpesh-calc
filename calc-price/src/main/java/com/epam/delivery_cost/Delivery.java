package com.epam.delivery_cost;

import java.util.Objects;

public class Delivery {
    private double pricePerKm;
    private double pricePerKg;

    private double deliveryDistance;
    private double cargoWeight;

    private double distanceDiscount = 1;
    private double weightDiscount = 1;

    public Delivery() {
    }

    public Delivery(double pricePerKm, double pricePerKg, double deliveryDistance, double cargoWeight) {
        this.pricePerKm = pricePerKm;
        this.pricePerKg = pricePerKg;
        this.deliveryDistance = deliveryDistance;
        this.cargoWeight = cargoWeight;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(double pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public double getDeliveryDistance() {
        return deliveryDistance;
    }

    public void setDeliveryDistance(double deliveryDistance) {
        this.deliveryDistance = deliveryDistance;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public double getDistanceDiscount() {
        return distanceDiscount;
    }

    public void setDistanceDiscount(double distanceDiscount) {
        this.distanceDiscount = distanceDiscount;
    }

    public double getWeightDiscount() {
        return weightDiscount;
    }

    public void setWeightDiscount(double weightDiscount) {
        this.weightDiscount = weightDiscount;
    }



}
