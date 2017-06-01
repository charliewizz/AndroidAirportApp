package thompson.bernard.bernardthompsonca1.main;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import thompson.bernard.bernardthompsonca1.Database.DBManager;
import thompson.bernard.bernardthompsonca1.models.MyFlights;

import static thompson.bernard.bernardthompsonca1.Base.rFlights;

/**
 * Created by bonjo1983 on 18/03/2017.
 */


public class AirportApp extends Application {

    public final int maxFlightPrice = 1000;
    public int totalPrice = 0;

    public DBManager dbManager;

    public boolean new_flight(MyFlights flight){
        boolean flightselected =  totalPrice > maxFlightPrice;
        if(!flightselected)
        {
            dbManager.add(flight);
        }
        else
        {
            Toast.makeText(this, "Please select Price, Max Price allowed €1000", Toast.LENGTH_SHORT).show();
        }
        return flightselected;
    }


    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.v("Splash","Airport App Started");
        dbManager = new DBManager(this);
        Log.v("Donate", "Database Created");

    }



}
