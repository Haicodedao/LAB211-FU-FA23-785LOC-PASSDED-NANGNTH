package data;

import Mytoys_Col.Input;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BoCountry {

    private List<EastAsiaCountries> lec = new ArrayList<>();
    private EastAsiaCountries recentlyAddedCountry;

    public void addCountryInformation(EastAsiaCountries country) throws Exception {
        if (lec.size() < 11) {
            lec.add(country);
            recentlyAddedCountry = country;
        } else {
            throw new Exception("List full");
        }
    }

    public EastAsiaCountries getRecentlyEnteredInformation() { // LẤY CÁI THÔNG TIN CUỐI CÙNG ĐƯỢC NHẬP
        return recentlyAddedCountry;
    }

    public EastAsiaCountries[] searchInformationByName(String name) throws Exception {
        if (lec.isEmpty()) {
            throw new Exception("List empty");
        }

        ArrayList<EastAsiaCountries> searchResults = new ArrayList<>();
        for (EastAsiaCountries country : lec) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                searchResults.add(country);
            }
        }

        return searchResults.toArray(new EastAsiaCountries[0]);
    }

    public EastAsiaCountries[] sortInformationByAscendingOrder() throws Exception {
        if (lec.isEmpty()) {
            throw new Exception("No country information available");
        }

        Collections.sort(lec, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o1.getCountryName().compareTo(o2.getCountryName());
            }
        });

        return lec.toArray(new EastAsiaCountries[0]);
    }

    public boolean checkIDDup(String code) {
        for (EastAsiaCountries country : lec) {
            if (country.getCountryCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }


    public boolean checkNameDup(String name) {
        for (EastAsiaCountries country : lec) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}