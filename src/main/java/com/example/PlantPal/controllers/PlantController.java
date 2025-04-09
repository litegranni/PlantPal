package com.example.PlantPal.controllers;

import com.example.PlantPal.models.Plant;
import com.example.PlantPal.models.PlantWaterLog;
import com.example.PlantPal.repositories.PlantRepository;
import com.example.PlantPal.services.DynamoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {

    private final PlantRepository plantRepository;

    @Autowired
    private DynamoDBService dynamoDBService;

    public PlantController(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @GetMapping("/watering-due")
    public List<Plant> getPlantsThatNeedWateringSoon() {
        LocalDate todayPlusTwo = LocalDate.now().plusDays(2);
        return plantRepository.findByLastWateredDateBefore(todayPlusTwo.minusDays(7));
    }

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @GetMapping("/category/{category}")
    public List<Plant> getPlantsByCategory(@PathVariable String category) {
        return plantRepository.findByCategoryIgnoreCase(category);
    }

    @GetMapping("/search")
    public List<Plant> searchPlantsByName(@RequestParam String name) {
        System.out.println("🔍 Söker efter växt med namn som innehåller: " + name);
        return plantRepository.findByNameContainingIgnoreCase(name);
    }

    @PostMapping("/logs/water")
    public ResponseEntity<String> logWatering(@RequestBody PlantWaterLog log) {
        dynamoDBService.saveWaterLog(log);
        return ResponseEntity.ok("💧 Vattningslogg sparad för " + log.getPlantName());
    }
    @GetMapping("/logs")
    public List<PlantWaterLog> getWaterLogs() {
        return dynamoDBService.getAllLogs();
    }
    @GetMapping("/")
    public String home() {
        return "🌱 PlantPal backend är igång!";
    }

}
