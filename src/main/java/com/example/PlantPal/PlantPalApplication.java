package com.example.PlantPal;

import com.example.PlantPal.models.Plant;
import com.example.PlantPal.repositories.PlantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class PlantPalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantPalApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(PlantRepository plantRepository) {
		return args -> {

			if (plantRepository.count() == 0) {
				plantRepository.saveAll(List.of(
						new Plant("Monstera", "Tropisk grönväxt", "Tropisk", "Vardagsrum", 7, LocalDate.now().minusDays(3)),
						new Plant("Gullranka", "Luftrenande klätterväxt", "Luftrenande", "Köksfönster", 5, LocalDate.now().minusDays(2)),
						new Plant("Svärmorstunga", "Tålig suckulent", "Suckulent", "Hall", 14, LocalDate.now().minusDays(10)),
						new Plant("Fredskalla", "Blommande grönväxt", "Blommande", "Sovrum", 4, LocalDate.now().minusDays(1)),
						new Plant("Elefantöra", "Bladväxt", "Tropisk", "Vardagsrum", 6, LocalDate.now().minusDays(4)),
						new Plant("Paradisträd", "Suckulent", "Suckulent", "Söderfönster", 10, LocalDate.now().minusDays(5)),
						new Plant("Zamiakalla", "Låg ljusväxt", "Låg ljusväxt", "Badrum", 12, LocalDate.now().minusDays(9)),
						new Plant("Ampellilja", "Luftrenande", "Luftrenande", "Bokhylla", 5, LocalDate.now().minusDays(3)),
						new Plant("Kaktus", "Ökenväxt", "Ökenväxt", "Fönsterbräda", 20, LocalDate.now().minusDays(15)),
						new Plant("Guldpalm", "Palmväxt", "Palmväxt", "Hörn i vardagsrum", 8, LocalDate.now().minusDays(7)),
						new Plant("Aloe Vera", "Medicinsk suckulent", "Suckulent", "Fönster", 14, LocalDate.now().minusDays(13)),
						new Plant("Fiolfikus", "Större bladväxt", "Tropisk", "Sovrum", 7, LocalDate.now().minusDays(6)),
						new Plant("Dr Westerlund", "Pelargonväxt", "Blommande", "Kök", 4, LocalDate.now().minusDays(2))
				));
			}

			List<Plant> plants = plantRepository.findAll();

			if (plants.isEmpty()) {
				System.out.println("❌ Inga växter hittades i databasen.");
			} else {
				System.out.println("🌿 Lista på alla växter i databasen:");
				for (Plant plant : plants) {
					System.out.println("→ " + plant.getName()
							+ " | Typ: " + plant.getType()
							+ " | Kategori: " + plant.getCategory()
							+ " | Plats: " + plant.getLocation()
							+ " | Vattningsintervall: " + plant.getWateringIntervalDays() + " dagar"
							+ " | Senast vattnad: " + plant.getLastWateredDate());
				}
			}
		};
	}
}
