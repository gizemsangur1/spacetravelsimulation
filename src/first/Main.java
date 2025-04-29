
/**
*
* @author Gizem Şangür / gizem.sangur@ogr.sakarya.edu.tr
* @since 22.04.2025
* <p>
* Programın çalıştığı sınıf
* </p>
*/
package first;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the program...");
        int maxHour;

        String planetfilePath = "Gezegenler.txt";
        String peoplefilePath = "Kisiler.txt";
        String spaceshipfilePath = "Araclar.txt";
        List<Planet> planets = ReadFromFile.readPlanetsFromFile(planetfilePath); 
        List<People> people = ReadFromFile.readPeopleFromFile(peoplefilePath); 
        List<SpaceShip> ships = ReadFromFile.readSpaceShipFromFile(spaceshipfilePath);
        
        Time time = new Time(planets, ships);
       
        
      
        time.SetArrivalDate();
        Simulation simulation=new Simulation(ships,people,planets);
        maxHour=simulation.getMaxTimeBetweenShip();
        System.out.println(maxHour);
       
        int i = 0;
        boolean simulationShouldEnd = false; 

        while (true) {
            simulation.clearScreen();
            simulation.updateSpaceshipsStatus();

            for (People person : people) {
                if (person.getRestOfHours() > 0) {
                    person.setRestOfHours(person.getRestOfHours() - 1);
                }
            }

            System.out.println("Gezegenler:");
            for (Planet planet : planets) {
                System.out.print("         ---"+planet.getPlanetName()+"---    ");
                if (i % planet.getDayHours() == 0 && i > 0) {
                    planet.setDateAtPlanet(planet.getDateAtPlanet().plusDays(1));
                }
            }
            System.out.println();
            System.out.print("Tarih:");
            for (Planet planet : planets) {
                System.out.print(  "  "+planet.getDateAtPlanet()+"         ");
            }
            System.out.println();
            System.out.print("Nüfus:");
            for (Planet planet : planets) {
                System.out.print(  "        "+planet.getPopulation()+"         ");
            }
            System.out.println();

            System.out.println("Uzay Araçları:");
            System.out.println("Araç Adı  Durum  Çıkış  Varış  Hedefe Kalan Saat  Hedefe Varacağı Tarih");

            boolean allShipsCompleted = true;

            for (SpaceShip ship : ships) {
                for (Planet planet : planets) {
                    if (ship.getOutPlanet().equals(planet.getPlanetName())) {
                        if (ship.getDepDate().isEqual(planet.getDateAtPlanet()) && ship.getTimeBetween() > 0) {
                            simulation.setPopulation();
                            ship.setStatus("Yolda");
                        }
                    }
                    if (ship.getStatus().equals("Yolda") && ship.getTimeBetween() == 0) {
                        simulation.setPopulation();
                        ship.setStatus("Ulaştı");
                    }
                    if (ship.getinPlanet().equals(planet.getPlanetName())) {
                        simulation.setPopulation();
                        if (ship.getArrDate().atStartOfDay().isEqual(planet.getDateAtPlanet().atStartOfDay()) && ship.getTimeBetween() == 0) {
                            ship.setStatus("Ulaştı");
                        }
                    }
                }
                if (ship.getStatus().equals("İmha")) {
                    ship.setTimeBetween(-1);
                }
                if (ship.getStatus().equals("Yolda")) {
                    ship.setTimeBetween(Math.max(0, ship.getTimeBetween() - 1));
                }

                if (ship.getStatus().equals("Bekliyor") || ship.getStatus().equals("Yolda")) {
                    allShipsCompleted = false;
                }

                System.out.println(ship);
            }

            if (simulationShouldEnd) {
                break; 
            }

            if (allShipsCompleted) {
                simulationShouldEnd = true; 
            }

            i++;
          
        }

     
        System.out.println("Süren saat:"+(i-1));
      
      
    }
   
}
