
# 🌿 PlantPal – En växtassistent i molnet!

PlantPal är en skalbar och hög tillgänglig backendapplikation utvecklad i Java med Spring Boot,
kopplad till både en relationsdatabas (MySQL via AWS RDS) och en NoSQL-lösning (AWS DynamoDB).
Projektet visar förståelse för objektorienterad programmering, REST-arkitektur, datahantering och molninfrastruktur.

## Innehåller
- Relationsdatabas (MySQL RDS)  
- NoSQL-lösning (DynamoDB)  
- CRUD via REST API  
- Java + Spring Boot  
- Ansluter från EC2 till RDS + DynamoDB  
- Dokumentation + kod i GitHub-repo  
- Testat med Postman och webbläsare  
- Tydlig projektstruktur  


---

## 🔧 Teknikstack
- Java 21  
- Spring Boot 3  
- MySQL (AWS RDS)  
- DynamoDB (AWS NoSQL)  
- AWS EC2 (för deployment)  
- IntelliJ IDEA Ultimate  
- Postman (för test av endpoints)

---

## Funktionalitet
-  Sök växter på namn eller filtrera på kategori  
-  Skapa nya växter  
-  Visa växter som behöver vattnas (baserat på vattningsintervall)  
-  Logga vattning (sparas i DynamoDB)  
-  Se vattningshistorik per växt  
-  Full CRUD via REST API  

---

##  Deployment och moln
PlantPal körs på en EC2-instans och är kopplad till:
-  En MySQL-databas på AWS RDS (`plantpal_db`)  
-  En DynamoDB-tabell (`PlantWaterLog`)  
-  Applikationen är tillgänglig via EC2:s publika IP

---

##  Säkerhet och åtkomst
- EC2 har öppnat port 8080  
- RDS tillåter endast anslutningar från:
  - Min nuvarande IP-adress  
  - EC2-instansens säkerhetsgrupp  
- Port 3306 är öppen endast för dessa källor  

---

## 🔬 Testning
- Testad med Postman (GET, POST, PUT, DELETE)  
- Testad i webbläsare (t.ex. `http://localhost:8080/plants`)  
- Live-test i molnet via EC2  
- Anslutning till RDS testad med `Test-NetConnection` i PowerShell  
- Anslutning till RDS verifierad i MySQL Workbench  

---

## 📂 Projektstruktur (src/main/java)
```
com.example.plantpal
├── controllers         # REST controllers
├── models              # JPA Entities och DTOs
├── repositories        # JPA Repository + DynamoDBRepository
├── services            # Logik för hantering av växter och loggning
├── configuration       # DynamoDB config
└── PlantPalApplication.java
```

---

## Screenshots & bevis
Bevisen finns i documentation-mappen!
 `documentation/`  
- RDS-instans  
- EC2-instans  
- DynamoDB-tabell  
- MySQL-anslutning  
- REST API i webbläsare och Postman  
- Terminaltest av port 3306  
- Exempel på filtrering och sökning  

---

##  Problem som löstes under utvecklingen
Jag stötte på en rad problem under utvecklingens gång, men dessa var de mest lärorika:
-  **MySQL-anslutning misslyckades pga. fel databasnamn**  
  Lösning: Skapade databasen `plantpal_db` direkt i RDS via MySQL Workbench.

- **RDS-anslutning blockerad**  
  Lösning: Öppnade port 3306 i security group för både egen IP och EC2.

  - **EC2 kunde inte kommunicera med RDS**  
  Lösning: Länka säkerhetsgrupperna mellan EC2 och RDS.

-  **Commons-logging varnar i loggar**  
   Lösning: Varning ignoreras, påverkar inte funktion.

-  **DynamoDB-tabellen syntes inte**  
   Lösning: Säkerställde att korrekt tabellnamn och AWS-region används.

-  **Applikationen fungerade lokalt men inte via EC2**  
   Lösning: Kontrollera `application.yml`, använd korrekt endpoint och port, samt att EC2 är igång.

---

## Så körs applikationen lokalt
1. Klona repo  
2. Uppdatera `application.yml` med dina egna RDS/DynamoDB-uppgifter  
3. Kör `PlantPalApplication.java`  
4. Testa via Postman eller `http://localhost:8080/plants`

