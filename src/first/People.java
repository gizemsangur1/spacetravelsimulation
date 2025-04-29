/**
*
* @author Gizem Şangür / gizem.sangur@ogr.sakarya.edu.tr
* @since 22.04.2025
* <p>
*Kişilerin bilgileri
* </p>
*/
package first;

public class People {
	private String peopleName;
    private int age;
    private int restOfhours;
    private String spaceshipName;
    
    public People(String peopleName, int age, int restOfhours,String spaceshipName) {
        this.peopleName = peopleName;
        this.age = age;
        this.restOfhours = restOfhours;
        this.spaceshipName=spaceshipName;
    }

   
    public String getPeopleName() {
        return peopleName;
    }

    public int getAge() {
        return age;
    }

    public int getRestOfHours() {
        return restOfhours;
    }
    
    public void setRestOfHours(int i) {
		this.restOfhours=i;
		
	}
    
    public String getSpaceshipName() {
        return spaceshipName;
    }

  
    public String toString() {
        return "Kişi Adı: " + peopleName + ", Yaş: " + age + ", Kalan Saat: " + restOfhours +", uzay aracı ismi: "+ spaceshipName;
    }


	
}
