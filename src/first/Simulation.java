/**
*
* @author Gizem Şangür / gizem.sangur@ogr.sakarya.edu.tr
* @since 22.04.2025
* <p>
* Değerlerin güncellenmesi
* </p>
*/
package first;

import java.util.List;
import java.util.Iterator;
import java.time.temporal.ChronoUnit;

public class Simulation {
    private List<SpaceShip> spaceships;
    private List<People> people;
    private List<Planet> planet;
	private int maxHour;

    public Simulation(List<SpaceShip> ships, List<People> people, List<Planet> planet) {
        this.spaceships = ships;
        this.people = people;
        this.planet = planet;
    }

    public void updateSpaceshipsStatus() {
        Iterator<SpaceShip> shipIterator = spaceships.iterator();
        
        while (shipIterator.hasNext()) {
            SpaceShip ship = shipIterator.next();
            boolean allRestZero = true; 

            for (People person : people) {
                if (person.getSpaceshipName().equals(ship.getShipName()) && person.getRestOfHours() > 0) {
                    allRestZero = false; 
                    break;  
                }
            }

            if (allRestZero) {
                ship.setStatus("İmha");
            }
        }
    }

    public void setPopulation() {
        for (Planet planet : planet) {
            planet.setPopulation(0);
        }

        for (People person : people) {
            for (SpaceShip ship : spaceships) {
                if (person.getSpaceshipName().equals(ship.getShipName())) {
                    for (Planet planet : planet) {
                        String status = ship.getStatus();
                        if (status != null) {
                            if (ship.getOutPlanet().equals(planet.getPlanetName()) && status.equals("Bekliyor") && person.getRestOfHours() > 0) {
                                planet.setPopulation(planet.getPopulation() + 1);
                            } else if (ship.getinPlanet().equals(planet.getPlanetName()) && status.equals("Ulaştı") && ship.getTimeBetween() == 0 && person.getRestOfHours() > 0) {
                                planet.setPopulation(planet.getPopulation() + 1);
                            }
                        }
                    }
                }
            }
        }
    }

    public int getMaxTimeBetweenShip() {
        if (spaceships == null || spaceships.isEmpty() || planet == null || planet.isEmpty()) {
            return 0;
        }

        this.maxHour = 0;

        for (SpaceShip ship : spaceships) {
            for (Planet pl : planet) {
                if (ship.getOutPlanet().equals(pl.getPlanetName())) {
                    long planetDateInDays = ChronoUnit.DAYS.between(pl.getDateAtPlanet(), ship.getDepDate());
                    int calculatedTime = (int) ((planetDateInDays * pl.getDayHours()) + ship.getTimeBetween());

                    if (calculatedTime > this.maxHour) {
                        this.maxHour = calculatedTime;
                    }
                }
            }
        }
        return this.maxHour;
    }
    
    public void clearScreen() {
    	try {
    		if(System.getProperty("os.name").contains("Windows")) {
    			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    		}else {
    			System.out.print("\033[H\033[2J");
    			System.out.flush();
    		}
    	}catch(Exception e){
    		System.out.println("Ekran temizleme hatası");
    	}

    }

}
