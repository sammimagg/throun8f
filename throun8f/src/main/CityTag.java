package main;

public class CityTag {

    public static String getCityTag(String city){

        if(city.compareTo("Akureyri") == 0) return "AEY";
        else if(city.compareTo("akureyri") ==0) return "AEY";
        else if(city.compareTo("Egilsstaðir") ==0) return "EGS";
        else if(city.compareTo("egilsstaðir") ==0) return "EGS";
        else if(city.compareTo("Egilsstadir") ==0) return "EGS";
        else if(city.compareTo("egilsstadir") ==0) return "EGS";
        else if(city.compareTo("Ísafjörður") ==0) return "IFJ";
        else if(city.compareTo("isafjördur") ==0) return "IFJ";
        else if(city.compareTo("Isafjordur") ==0) return "IFJ";
        else if(city.compareTo("isafjordur") ==0) return "IFJ";
        else if(city.compareTo("Reykjavík") ==0) return "REK";
        else if(city.compareTo("reykjavík") ==0) return "REK";
        else if(city.compareTo("Reykjavik") ==0) return "REK";
        else if(city.compareTo("reykjavik") ==0) return "REK";

        return "NoN";
    }
}
