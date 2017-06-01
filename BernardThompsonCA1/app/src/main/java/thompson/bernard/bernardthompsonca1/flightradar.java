package thompson.bernard.bernardthompsonca1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

import thompson.bernard.bernardthompsonca1.Activities.Arrivals;
import thompson.bernard.bernardthompsonca1.Activities.BookFlights;
import thompson.bernard.bernardthompsonca1.Activities.Departures;
import thompson.bernard.bernardthompsonca1.Activities.Information;
import thompson.bernard.bernardthompsonca1.Activities.MainActivity;
import thompson.bernard.bernardthompsonca1.Activities.contact_us;

public class flightradar extends AppCompatActivity {

    private ImageButton bookflights;
    private ImageButton arrivals;
    private ImageButton home;
    private ImageButton information;
    private ImageButton departures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flightradar);
        Toolbar bottomToolbar = (Toolbar) findViewById(R.id.tool_bar_bottom);
        setSupportActionBar(bottomToolbar);

        String url = "https://www.flightradar24.com/52.26,-7.11/8";

        WebView webview = (WebView)findViewById(R.id.webView);
        webview.loadUrl(url);

        bookflights = (ImageButton)findViewById(R.id.ib_book_flights);
        arrivals = (ImageButton)findViewById(R.id.ib_arrivals);
        home = (ImageButton)findViewById(R.id.ib_home);
        information = (ImageButton)findViewById(R.id.ib_infomation);
        departures = (ImageButton)findViewById(R.id.ib_departures);

        bookflights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bookFlights = new Intent(flightradar.this, BookFlights.class);
                startActivity(bookFlights);
            }
        });

        arrivals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arrivals = new Intent(flightradar.this, Arrivals.class);
                startActivity(arrivals);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(flightradar.this, MainActivity.class);
                startActivity(home);
            }
        });

        departures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent departures = new Intent(flightradar.this, Departures.class);
                startActivity(departures);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(flightradar.this, Information.class);
                startActivity(info);
            }
        });

    }

}
