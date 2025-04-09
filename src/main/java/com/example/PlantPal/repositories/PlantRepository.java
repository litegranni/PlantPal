package com.example.PlantPal.repositories;

import com.example.PlantPal.models.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    // tar in alla standardmetoder som findAll(), save(), deleteById(), osv!

    List<Plant> findByLastWateredDateBefore(LocalDate date);

    List<Plant> findByCategoryIgnoreCase(String category);

    List<Plant> findByNameContainingIgnoreCase(String name);


}

