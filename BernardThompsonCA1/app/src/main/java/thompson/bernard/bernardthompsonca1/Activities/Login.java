package thompson.bernard.bernardthompsonca1.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import thompson.bernard.bernardthompsonca1.R;

public class Login extends AppCompatActivity {

    private ImageButton bookflights;
    private ImageButton arrivals;
    private ImageButton home;
    private ImageButton departures;
    private ImageButton information;


    private EditText etUser, etPassword;


    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etUser = (EditText) findViewById(R.id.loginUsername);
        etPassword = (EditText) findViewById(R.id.loginPassword);
        sharedPref = getSharedPreferences(Register.MyPref, Context.MODE_PRIVATE);

        bookflights = (ImageButton)findViewById(R.id.ib_book_flights);
        arrivals = (ImageButton)findViewById(R.id.ib_arrivals);
        home = (ImageButton)findViewById(R.id.ib_home);
        departures = (ImageButton)findViewById(R.id.ib_departures);
        information = (ImageButton)findViewById(R.id.ib_infomation);

        bookflights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bookFlights = new Intent(Login.this, BookFlights.class);
                startActivity(bookFlights);
            }
        });

        arrivals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arrivals = new Intent(Login.this, Arrivals.class);
                startActivity(arrivals);
            }
        });

        departures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent departures = new Intent(Login.this, Departures.class);
                startActivity(departures);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Login.this, MainActivity.class);
                startActivity(home);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arrivals = new Intent(Login.this, Information.class);
                startActivity(arrivals);
            }
        });
    }


    public void loginNow(View v) {

        String user = sharedPref.getString("username", "");
        String password = sharedPref.getString("password", "");

        if (etUser.length() <= 0 || etPassword.length() <= 0)

            Toast.makeText(this, "You must enter an email and password", Toast.LENGTH_SHORT).show();

        else if (!etUser.toString().matches(user) || !etPassword.toString().matches(password))

            Toast.makeText(this, "Unable to validate your username and password", Toast.LENGTH_SHORT).show();

        else if (etUser.toString().equals(user)||etPassword.toString().equals(password)){

            Intent displayFlights = new Intent(Login.this, BookFlights.class);
            startActivity(displayFlights);
            this.finish();
        }


    }

    public void RegNow(View v){

            Intent login = new Intent(this, Register.class);
            startActivity(login);

    }

}
