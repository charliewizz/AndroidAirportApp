package thompson.bernard.bernardthompsonca1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Information extends AppCompatActivity {

    private ImageButton bookflights;
    private ImageButton arrivals;
    private ImageButton home;
    private ImageButton departures;
    private ImageButton information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bookflights = (ImageButton)findViewById(R.id.ib_book_flights);
        arrivals = (ImageButton)findViewById(R.id.ib_arrivals);
        home = (ImageButton)findViewById(R.id.ib_home);
        departures = (ImageButton)findViewById(R.id.ib_departures);
        information = (ImageButton)findViewById(R.id.ib_infomation);

        bookflights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bookFlights = new Intent(Information.this, BookFlights.class);
                startActivity(bookFlights);
            }
        });

        arrivals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arrivals = new Intent(Information.this, Arrivals.class);
                startActivity(arrivals);
            }
        });

        departures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent departures = new Intent(Information.this, Departures.class);
                startActivity(departures);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Information.this, MainActivity.class);
                startActivity(home);
            }
        });

    }


}
