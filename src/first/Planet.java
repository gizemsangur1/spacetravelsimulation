/**
*
* @author Gizem Şangür / gizem.sangur@ogr.sakarya.edu.tr
* @since 22.04.2025
* <p>
* Gezegenlerin bilgileri
* </p>
*/
package first;

import java.time.LocalDate;

public class Planet {
    private String planetName;
    private int dayHours;
    private LocalDate dateAtPlanet;
    private int population;

    
    public Planet(String planetName, int dayHours, LocalDate dateAtPlanet) {
        this.planetName = planetName;
        this.dayHours = dayHours;
        this.dateAtPlanet = dateAtPlanet;
    }

   
    public String getPlanetName() {
        return planetName;
    }

    public int getDayHours() {
        return dayHours;
    }

    public LocalDate getDateAtPlanet() {
        return dateAtPlanet;
    }
    
    public void setDateAtPlanet(LocalDate newDate) {
        this.dateAtPlanet=newDate;
    }
    
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int newPopulation) {
        this.population = newPopulation;
    }


    
    public String toString() {
        return "Gezegen Adı: " + planetName + ", Gün Süresi: " + dayHours + " saat, Tarih: " + dateAtPlanet;
    }


	
}
