package thompson.bernard.bernardthompsonca1.models;

/**
 * Created by bonjo1983 on 26/02/2017.
 */


public class MyFlights {

    public int id;
    public String bookedName;
    public String priceSelected;
    public String time;
    public String pax;

    public MyFlights(String priceSelected, String bookedName, String time, String pax) {

        this.bookedName = bookedName;
        this.priceSelected = priceSelected;
        this.time = time;
        this.pax = pax;
    }

    public MyFlights ()
    {
        this.bookedName = "";
        this.priceSelected = "";
        this.time = "";
        this.pax = "";
    }

    public String toString()
    {
        return id + ", " + bookedName + ", " + priceSelected + ", " + time + ", " + pax;
    }
}


