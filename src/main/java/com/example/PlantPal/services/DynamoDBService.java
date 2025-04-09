package com.example.PlantPal.services;

import com.example.PlantPal.models.PlantWaterLog;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;

import java.util.ArrayList;
import java.util.List;


@Service
public class DynamoDBService {

    private DynamoDbEnhancedClient enhancedClient;
    private DynamoDbTable<PlantWaterLog> table;

    /**
     * Initierar DynamoDB-klient och kopplar till tabellen "PlantWaterLog"
     */
    @PostConstruct
    public void init() {
        DynamoDbClient client = DynamoDbClient.builder()
                .region(Region.EU_NORTH_1) // 🟢 Ändra om du valt annan region i AWS
                .build();

        enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(client)
                .build();

        table = enhancedClient.table("PlantWaterLog", TableSchema.fromBean(PlantWaterLog.class));
    }

    /**
     * Spara en vattningslogg till DynamoDB-tabellen
     */
    public void saveWaterLog(PlantWaterLog log) {
        table.putItem(log);
        System.out.println("💧 Logg sparad för: " + log.getPlantName());
    }

    /**
     * Hämta alla loggar från DynamoDB-tabellen
     */
    public List<PlantWaterLog> getAllLogs() {
        List<PlantWaterLog> logs = new ArrayList<>();
        table.scan(ScanEnhancedRequest.builder().build())
                .items()
                .forEach(logs::add);
        return logs;
    }
}
