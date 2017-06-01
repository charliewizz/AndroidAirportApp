package thompson.bernard.bernardthompsonca1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        };


    public void gotoBookFlights(View view){
        Intent bookFlightsIntent = new Intent(this, BookFlights.class);
        startActivity(bookFlightsIntent);
    }

    public void gotoArrivals(View view){
        Intent arrivalFlights = new Intent(this, Arrivals.class);
        startActivity(arrivalFlights);
    }

    public void gotoDepartures(View view){
        Intent departuresFlights = new Intent(this, Departures.class);
        startActivity(departuresFlights);
    }

    public void gotoInformation(View view){
        Intent info = new Intent(this, Information.class);
        startActivity(info);
    }


}
