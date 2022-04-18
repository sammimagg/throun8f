package main;

public enum City {

        AEY("Akureyri"),
        EGS("Egilsstaðir"),
        IFJ("Ísafjörður"),
        REK("Reykjavík"),
        NaN("NULL");
        String name;

        City(String name)
        {
            this.name = name;
        }
        public String getName()
        {
            return name;
        }


}
