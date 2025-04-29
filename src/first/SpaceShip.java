
/**
*
* @author Gizem Şangür / gizem.sangur@ogr.sakarya.edu.tr
* @since 22.04.2025
* <p>
* Uzay aracı bilgileri
* </p>
*/
package first;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SpaceShip {
	private String shipName;
    private String outPlanet;
    private String inPlanet;
    private String status="Bekliyor";
    private LocalDate depDate;
    private LocalDate arrDate;
    private int timeBetween;
    private String previousStatus="Bekliyor";
    
    public SpaceShip(String shipName, String outPlanet, String inPlanet,LocalDate depDate,int timeBetween) {
        this.shipName = shipName;
        this.outPlanet = outPlanet;
        this.inPlanet = inPlanet;
        this.depDate=depDate;
        this.timeBetween=timeBetween;
    }

   
    public String getShipName() {
        return shipName;
    }

    public String getOutPlanet() {
        return outPlanet;
    }

    public String getinPlanet() {
        return inPlanet;
    }
    
    public String getPreviousStatus() {
        return previousStatus;
    }

   
    
    public LocalDate getDepDate() {
        return depDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    
    public void setStatus(String newStatus) {
        if (!this.status.equals(newStatus)) { 
            this.previousStatus = this.status; 
            this.status = newStatus;
        }
    }
    
    public int getTimeBetween() {
        return timeBetween;
    }
    
    public void setTimeBetween(int i) {
        this.timeBetween=i;
    }
    
	public void setArrDate(LocalDate newDate) {
		this.arrDate = newDate;
		
	}
    
    
    public LocalDate getArrDate() {
        return arrDate;
    }
    
    


    
    public String toString() {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return   shipName +"         "+status+"    " + outPlanet+"      "  + inPlanet+"      " + (timeBetween == -1 ? "---" : timeBetween)+"                "  +(status.equals("İmha") ? "---" : arrDate.format(formatter) );
    }


	
}
