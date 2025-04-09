package com.example.PlantPal.models;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;
import java.time.LocalDateTime;
import java.util.UUID;

@DynamoDbBean
public class PlantWaterLog {

    private String id;
    private String plantName;
    private String note;
    private String wateredAt;

    public PlantWaterLog() {
        this.id = UUID.randomUUID().toString();
        this.wateredAt = LocalDateTime.now().toString();
    }

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPlantName() {
        return plantName;
    }
    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public String getWateredAt() {
        return wateredAt;
    }
    public void setWateredAt(String wateredAt) {
        this.wateredAt = wateredAt;
    }
}
