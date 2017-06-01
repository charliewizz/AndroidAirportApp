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

public class Departures extends AppCompatActivity {

    private ImageButton bookflights;
    private ImageButton arrivals;
    private ImageButton home;
    private ImageButton information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departures);
        Toolbar bottomToolbar = (Toolbar) findViewById(R.id.tool_bar_bottom);
        setSupportActionBar(bottomToolbar);

        bookflights = (ImageButton)findViewById(R.id.ib_book_flights);
        arrivals = (ImageButton)findViewById(R.id.ib_arrivals);
        home = (ImageButton)findViewById(R.id.ib_home);
        information = (ImageButton)findViewById(R.id.ib_infomation);

        bookflights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bookFlights = new Intent(Departures.this, BookFlights.class);
                startActivity(bookFlights);
            }
        });

        arrivals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arrivals = new Intent(Departures.this, Arrivals.class);
                startActivity(arrivals);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Departures.this, MainActivity.class);
                startActivity(home);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(Departures.this, Information.class);
                startActivity(info);
            }
        });

        ListView listView = (ListView)findViewById(R.id.arivals_list_view);

        ArrayList<FlightStatus> flight = new ArrayList<FlightStatus>();

        FlightStatus firstFlight = new FlightStatus("DT-741", "London - LTN", "07.30", "Departed", R.drawable.danish_air );
        flight.add(firstFlight);

        FlightStatus secondFlight = new FlightStatus("SA-821", "Manchester", "11.25", "Departed", R.drawable.stobart_air );
        flight.add(secondFlight);

        FlightStatus thirdFlight = new FlightStatus("FB-499", "Birmingham", "15.15", "Departed", R.drawable.flybe );
        flight.add(thirdFlight);

        FlightStatus fourthFlight = new FlightStatus("DT-756", "London - LTN", "19:00", "On Time", R.drawable.danish_air );
        flight.add(fourthFlight);

        FlightsAdapter adapter = new FlightsAdapter(getApplicationContext(), R.layout.row_view, flight);
        listView.setAdapter(adapter);

    };

}
