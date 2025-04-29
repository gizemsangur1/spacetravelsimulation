# Space Travel Simulation

## Overview
This Java console application simulates the interplanetary travel of people aboard spaceships. It reads input data from text files (`Kisiler.txt`, `Araclar.txt`, `Gezegenler.txt`), models time and planetary time zones, and dynamically updates the console display to reflect population counts, ship statuses, and arrival schedules.

## Features
- **Data-Driven**: Loads people, spaceship, and planet details from external files.
- **Time Simulation**: Advances in one-hour iterations, synchronizing each planet’s local time.
- **Dynamic Console Display**: Clears and refreshes output each hour to show:
  - Current date and time on each planet
  - Population per planet (excluding ship populations in transit)
  - Spaceship statuses (in transit, arrived, or destroyed)
- **Lifecycle Handling**:
  - Tracks each person’s remaining lifespan; persons die when their time reaches zero and are removed from populations.
  - Destroys ships if all onboard perish, marking them as **IMHA** and omitting arrival times.
- **End Condition**: Simulation ends when all ships reach their destinations.

## Project Structure
```
|   |                       
│   ├── Gezegenler.txt     
│   ├── Kisiler.txt        
│   └── Araclar.txt        
├── src/                    
│   ├── first/             
│   │   ├── Time.java       
│   │   ├── People.java     
│   │   ├── SpaceShip.java 
│   │   ├── Planet.java    
│   │   ├── Main.java		
|   |   ├── Simulation.java
│   │   └── ReadFromFile.java 
└── dist/                   
    └── myApp.jar
```

## Prerequisites
- Java Development Kit (JDK) 17 or higher
- Eclipse IDE (recommended for project import and build)

## Installation & Setup
1. **Clone the repository**
   ```bash
   git clone https://github.com/gizemsangur1/spacetravelsimulation.git
   cd space-travel-simulation
   ```
2. **Import into Eclipse**
   - File → Import... → Existing Projects into Workspace → Select this folder
3. **Build the project**
   - Ensure the `data/` folder is on the classpath or at the root of your working directory.
   - Run `mvn package` or use Eclipse’s **Export → Runnable JAR File** feature to generate `myApp.jar` in `dist/`.

## Usage
From the command line:
```bash
java -jar dist/myApp.jar
```
The console will clear and update each simulated hour until all spaceships have arrived.

### Input File Formats
- **Kisiler.txt**: `name#age#remainingLifeHours#shipName`
- **Araclar.txt**: `shipName#departurePlanet#arrivalPlanet#departureDate(dd.MM.yyyy)#travelTimeHours`
- **Gezegenler.txt**: `planetName#hoursPerDay#currentDate(dd.MM.yyyy)`

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your improvements.


