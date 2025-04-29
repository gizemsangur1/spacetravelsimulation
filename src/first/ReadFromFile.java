/**
*
* @author Gizem Şangür / gizem.sangur@ogr.sakarya.edu.tr
* @since 22.04.2025
* <p>
* Dosyadan okuma
* </p>
*/
package first;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFromFile {


	private static final DateTimeFormatter FLEXIBLE_DATE_FORMATTER = new DateTimeFormatterBuilder()
		    .appendValue(ChronoField.DAY_OF_MONTH, 1, 2, java.time.format.SignStyle.NOT_NEGATIVE)
		    .appendLiteral('.')
		    .appendValue(ChronoField.MONTH_OF_YEAR, 1, 2, java.time.format.SignStyle.NOT_NEGATIVE)
		    .appendLiteral('.')
		    .appendValue(ChronoField.YEAR, 4)
		    .toFormatter()
		    .withResolverStyle(ResolverStyle.LENIENT);


    public static List<Planet> readPlanetsFromFile(String filePath) {
        List<Planet> planetList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");

                if (parts.length == 3) {
                    String name = parts[0];
                    int hours = Integer.parseInt(parts[1]);
                    LocalDate date = LocalDate.parse(parts[2], FLEXIBLE_DATE_FORMATTER);

                    planetList.add(new Planet(name, hours, date));
                }
            }
        } catch (IOException e) {
            System.err.println("Dosya okunurken hata oluştu: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.err.println("Tarih formatı hatalı! Beklenen format: GÜN.AY.YIL (örn: 5.6.2025 ya da 05.06.2025). Hata: " + e.getMessage());
        }

        return planetList;
    }

    public static List<People> readPeopleFromFile(String filePath) {
        List<People> peopleList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");

                if (parts.length == 4) {
                    String peopleName = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    int restOfhours = Integer.parseInt(parts[2]);
                    String spaceshipName = parts[3];

                    peopleList.add(new People(peopleName, age, restOfhours, spaceshipName));
                }
            }
        } catch (IOException e) {
            System.err.println("Dosya okunurken hata oluştu: " + e.getMessage());
        }

        return peopleList;
    }

    public static List<SpaceShip> readSpaceShipFromFile(String filePath) {
        List<SpaceShip> shipList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");

                if (parts.length == 5) {
                    String shipName = parts[0];
                    String outPlanet = parts[1];
                    String inPlanet = parts[2];
                    LocalDate depDate = LocalDate.parse(parts[3], FLEXIBLE_DATE_FORMATTER);
                    int spaceshipCode = Integer.parseInt(parts[4]);

                    shipList.add(new SpaceShip(shipName, outPlanet, inPlanet, depDate, spaceshipCode));
                }
            }
        } catch (IOException e) {
            System.err.println("Dosya okunurken hata oluştu: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.err.println("Tarih formatı hatalı! Beklenen format: GÜN.AY.YIL (örn: 5.6.2025 ya da 05.06.2025). Hata: " + e.getMessage());
        }

        return shipList;
    }
}
