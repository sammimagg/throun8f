package main;

public class CityTag {

    public static City getCityTag(String city){

        if(city.compareTo("Akureyri") == 0) return City.AEY;
        else if(city.compareTo("akureyri") ==0) return City.AEY;
        else if(city.compareTo("Egilsstaðir") ==0) return City.EGS;
        else if(city.compareTo("egilsstaðir") ==0) return City.EGS;
        else if(city.compareTo("Egilsstadir") ==0) return City.EGS;
        else if(city.compareTo("egilsstadir") ==0) return City.EGS;
        else if(city.compareTo("Ísafjörður") ==0) return City.IFJ;
        else if(city.compareTo("isafjördur") ==0) return City.IFJ;
        else if(city.compareTo("Isafjordur") ==0) return City.IFJ;
        else if(city.compareTo("isafjordur") ==0) return City.IFJ;
        else if(city.compareTo("Reykjavík") ==0) return City.REK;
        else if(city.compareTo("reykjavík") ==0) return City.REK;
        else if(city.compareTo("Reykjavik") ==0) return City.REK;
        else if(city.compareTo("reykjavik") ==0) return City.REK;

        return City.NaN;
    }
}
