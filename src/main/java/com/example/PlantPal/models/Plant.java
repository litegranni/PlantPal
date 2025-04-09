package com.example.PlantPal.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // T.ex. "Monstera"
    private String type; // T.ex. "Tropisk grönväxt"
    private String category; // T.ex. "Tropisk", "Suckulent", "Blommande"
    private String location; // T.ex. "Vardagsrum"
    private int wateringIntervalDays; // T.ex. 7 (vattnas var 7:e dag)

    private LocalDate lastWateredDate; // T.ex. 2025-03-28

    // Konstruktorer
    public Plant() {
    }

    public Plant(String name, String type, String category, String location, int wateringIntervalDays, LocalDate lastWateredDate) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.location = location;
        this.wateringIntervalDays = wateringIntervalDays;
        this.lastWateredDate = lastWateredDate;
    }

    // Getters och setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getWateringIntervalDays() {
        return wateringIntervalDays;
    }

    public void setWateringIntervalDays(int wateringIntervalDays) {
        this.wateringIntervalDays = wateringIntervalDays;
    }

    public LocalDate getLastWateredDate() {
        return lastWateredDate;
    }

    public void setLastWateredDate(LocalDate lastWateredDate) {
        this.lastWateredDate = lastWateredDate;
    }
}
