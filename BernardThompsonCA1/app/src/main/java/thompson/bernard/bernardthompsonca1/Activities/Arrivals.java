package thompson.bernard.bernardthompsonca1.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import thompson.bernard.bernardthompsonca1.Adapter.FlightsAdapter;
import thompson.bernard.bernardthompsonca1.R;

public class Arrivals extends AppCompatActivity {

    private ImageButton bookflights;
    private ImageButton arrivals;
    private ImageButton home;
    private ImageButton departures;
    private ImageButton information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrivals);
        Toolbar bottomToolbar = (Toolbar) findViewById(R.id.tool_bar_bottom);
        setSupportActionBar(bottomToolbar);

        bookflights = (ImageButton)findViewById(R.id.ib_book_flights);
        arrivals = (ImageButton)findViewById(R.id.ib_arrivals);
        home = (ImageButton)findViewById(R.id.ib_home);
        departures = (ImageButton)findViewById(R.id.ib_departures);
        information = (ImageButton)findViewById(R.id.ib_infomation);

        bookflights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bookFlights = new Intent(Arrivals.this, BookFlights.class);
                startActivity(bookFlights);
            }
        });

        departures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent departures = new Intent(Arrivals.this, Departures.class);
                startActivity(departures);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Arrivals.this, MainActivity.class);
                startActivity(home);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arrivals = new Intent(Arrivals.this, Information.class);
                startActivity(arrivals);
            }
        });

        ListView listView = (ListView)findViewById(R.id.arivals_list_view);

        ArrayList<FlightStatus> flight = new ArrayList<FlightStatus>();

        FlightStatus firstFlight = new FlightStatus("DT-742", "London - LTN", "10.50", "Landed", R.drawable.danish_air );
        flight.add(firstFlight);

        FlightStatus secondFlight = new FlightStatus("SA-822", "Manchester", "14.30", "Landed", R.drawable.stobart_air );
        flight.add(secondFlight);

        FlightStatus thirdFlight = new FlightStatus("FB-501", "Birmingham", "18.25", "Landed", R.drawable.flybe );
        flight.add(thirdFlight);

        FlightStatus fourthFlight = new FlightStatus("DT-758", "London - LTN", "22.15", "On Time", R.drawable.danish_air );
        flight.add(fourthFlight);

        FlightsAdapter adapter = new FlightsAdapter(getApplicationContext(), R.layout.row_view, flight);
        listView.setAdapter(adapter);

        };



}
