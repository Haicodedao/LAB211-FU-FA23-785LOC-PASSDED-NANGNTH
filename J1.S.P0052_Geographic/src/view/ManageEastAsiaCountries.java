package view;

import Mytoys_Col.Input;
import data.BoCountry;
import data.EastAsiaCountries;
import java.util.ArrayList;
import java.util.List;

public class ManageEastAsiaCountries {

    public static void main(String[] args) {
        int choice;
        CountryShelf countriesList = new CountryShelf();
        Input ip = new Input();
        BoCountry bc = new BoCountry();
        do {
            countriesList.Menu();
            choice = ip.inputNumber("Enter your choice: ");
            switch (choice) {
                case 1:
                    countriesList.createCountryInformation();
                    break;
                case 2:
                    countriesList.displayInputLast();
                    break;
                case 3:
                    countriesList.searchInfomationByName();
                    break;
                case 4:
                    countriesList.sortInformationByAscendingOrder();
                    break;
                case 5:
                    System.out.println("See you again!!!");
                    break;
            }
        } while (choice != 5);
    }

}
