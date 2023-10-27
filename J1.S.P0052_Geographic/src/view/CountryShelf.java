package view;

import Mytoys_Col.Input;
import data.BoCountry;
import data.EastAsiaCountries;
import java.util.ArrayList;
import java.util.List;

public class CountryShelf {

//    List<EastAsiaCountries> countryList = new ArrayList<>();
    BoCountry bc = new BoCountry();
    Input ip = new Input();

    public void Menu() {
        System.out.println("                          Menu                          ");
        System.out.println("========================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just data");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");

    }

    // country : ko đc trùng tên , ko đc trùng mã , 
    // ko đc vượt quá 11 nước 
    public void createCountryInformation() {
        String code;
        String name;
        float total;
        String terrain;
        code = ip.inputStr("Enter code of country: ").toUpperCase();
        if (bc.checkIDDup(code)) {
            System.out.println("Code existed");
            return;
        }
        do {
            name = ip.inputStr("Enter name of country: ");
            if (bc.checkNameDup(name)) {
                System.out.println("Name exist");
            }
        } while (bc.checkNameDup(name));
        total = ip.inputFloat("Enter total Area: ");
        terrain = ip.inputStr("Enter terrain of country: ");

        try {
            EastAsiaCountries ealcountry = new EastAsiaCountries(code, name, total, terrain);
                bc.addCountryInformation(ealcountry);
                System.out.println("Add successfully!!!");
            }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        }

    

    public void displayInputLast() {
        try {
            EastAsiaCountries ouputLast = bc.getRecentlyEnteredInformation();
            System.out.printf("%-15s %-15s %-15s %-15s\n", "ID", "Name", "Total", "Terrain");
            ouputLast.display();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchInfomationByName() {
        try {
            String nameCountry = ip.inputStr("Enter the name you want to search for: ").toUpperCase();
            EastAsiaCountries[] countryList = bc.searchInformationByName(nameCountry);
            System.out.printf("%-15s %-15s %-15s %-15s\n", "ID", "Name", "Total", "Terrain");
            for (EastAsiaCountries search : countryList) {
                search.display();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sortInformationByAscendingOrder() {
        try {
            EastAsiaCountries[] result = bc.sortInformationByAscendingOrder();
            System.out.printf("%-15s %-15s %-15s %-15s\n", "ID", "Name", "Total", "Terrain");
            for (int i = 0; i < result.length; i++) {
                result[i].display();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
