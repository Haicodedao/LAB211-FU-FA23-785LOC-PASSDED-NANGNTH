    
package data;


public class EastAsiaCountries extends Country{
    private String countryTerrain;

    public EastAsiaCountries() {
        super();
    }
    
    public EastAsiaCountries(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    

    @Override
    public void display() {
        System.out.printf("%-15s %-15s %-15.1f %-15s \n", countryCode, countryName , totalArea, countryTerrain);
    }
    
    
    
}
