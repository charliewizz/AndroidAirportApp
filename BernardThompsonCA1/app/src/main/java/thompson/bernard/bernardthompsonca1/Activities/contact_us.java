package thompson.bernard.bernardthompsonca1.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

import thompson.bernard.bernardthompsonca1.R;

public class contact_us extends AppCompatActivity {

    private ImageButton bookflights;
    private ImageButton arrivals;
    private ImageButton home;
    private ImageButton information;
    private ImageButton departures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Toolbar bottomToolbar = (Toolbar) findViewById(R.id.tool_bar_bottom);
        setSupportActionBar(bottomToolbar);

        String url = "http://www.waterfordairport.ie/index.php?option=com_content&view=article&id=15&Itemid=128";

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
                Intent bookFlights = new Intent(contact_us.this, BookFlights.class);
                startActivity(bookFlights);
            }
        });

        arrivals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arrivals = new Intent(contact_us.this, Arrivals.class);
                startActivity(arrivals);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(contact_us.this, MainActivity.class);
                startActivity(home);
            }
        });

        departures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent departures = new Intent(contact_us.this, Departures.class);
                startActivity(departures);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent info = new Intent(contact_us.this, Information.class);
                startActivity(info);
            }
        });



    }

}
