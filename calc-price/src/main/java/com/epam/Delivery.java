package com.epam.delivery_cost;

import java.util.Objects;

public class Delivery {
    private double pricePerKm;
    private double pricePerKg;

    private double deliveryDistance;
    private double cargoWeight;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Double.compare(delivery.pricePerKm, pricePerKm) == 0 &&
                Double.compare(delivery.pricePerKg, pricePerKg) == 0 &&
                Double.compare(delivery.deliveryDistance, deliveryDistance) == 0 &&
                Double.compare(delivery.cargoWeight, cargoWeight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pricePerKm, pricePerKg, deliveryDistance, cargoWeight);
    }



}
