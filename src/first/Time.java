/**
*
* @author Gizem Şangür / gizem.sangur@ogr.sakarya.edu.tr
* @since 22.04.2025
* <p>
* Zaman hesaplamaları yapılıyor
* </p>
*/
package first;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Time {
    private List<Planet> planets;
    private List<SpaceShip> spaceships;

    public Time(List<Planet> planets, List<SpaceShip> spaceships) {
        this.planets = planets;
        this.spaceships = spaceships;
    }

    public void printSpaceShips() {
        System.out.println("Uzay Gemileri:");
        for (SpaceShip ship : spaceships) {
            System.out.println(ship);
        }
    }

    public void printPlanets() {
        System.out.println("Gezegenler:");
        for (Planet planet : planets) {
            System.out.println(planet);
        }
    }
    
    public void SetArrivalDate() {
        for (SpaceShip ship : spaceships) {
            int hours = 0; 
            
            for (Planet planet : planets) {
                if (ship.getOutPlanet().equals(planet.getPlanetName())) {
                    LocalDate planetoutDate = planet.getDateAtPlanet();
                    LocalDate planetDepDate = ship.getDepDate();
                    
                    if (planetoutDate != null && planetDepDate != null) { 
                        long daysBetween = ChronoUnit.DAYS.between(planetoutDate, planetDepDate);
                        hours = (int) daysBetween * planet.getDayHours();
                        
                    } else {
                        System.out.println("HATA: " + planet.getPlanetName() + " için çıkış veya gemi kalkış tarihi NULL!");
                    }
                }
            }

            for (Planet planet : planets) {
                if (ship.getinPlanet().equals(planet.getPlanetName())) {
                    if (planet.getDateAtPlanet() != null) {

                    	LocalDate newDate = planet.getDateAtPlanet()
                    		    .plusDays(ship.getTimeBetween() / planet.getDayHours())
                    		    .plusDays(hours / planet.getDayHours());
                    	

                        if(ship.getStatus().equals("İmha")) {
                        	ship.setArrDate(LocalDate.of(1, 1, 1));
                        }else {
                        	ship.setArrDate(newDate);	
                        }
                        
                        
                    } else {
                        System.out.println("HATA: " + planet.getPlanetName() + " için tarih NULL!");
                    }
                }
            }
        }
    }

}
