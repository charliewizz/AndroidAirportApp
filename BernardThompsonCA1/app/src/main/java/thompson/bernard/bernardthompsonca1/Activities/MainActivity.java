package thompson.bernard.bernardthompsonca1.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import thompson.bernard.bernardthompsonca1.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton facebook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        facebook = (ImageButton)findViewById(R.id.facebook);


        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facebookIntent = openFacebook(MainActivity.this);
                startActivity(facebookIntent);
            }
        });

        }

    public static Intent openFacebook(Context context){
        try{
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://page/109807425752211"));
        } catch (Exception e) {
            e.printStackTrace();

            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/WaterfordAirport/?ref=page_internal&fref=nf"));
        }
    }

    public void gotoBookFlights(View view){
        Intent bookFlightsIntent = new Intent(this, Login.class);
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
