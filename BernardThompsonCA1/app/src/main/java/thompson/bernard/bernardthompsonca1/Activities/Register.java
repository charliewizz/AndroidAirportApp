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
import android.widget.Toast;

import thompson.bernard.bernardthompsonca1.R;



public class Register extends AppCompatActivity {

    private ImageButton bookflights;
    private ImageButton arrivals;
    private ImageButton home;
    private ImageButton departures;
    private ImageButton information;


    private EditText etRegUser;
    private EditText etRegPass;
    public static final String MyPref = "UserInfo";

    private SharedPreferences sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
                Intent bookFlights = new Intent(Register.this, BookFlights.class);
                startActivity(bookFlights);
            }
        });

        arrivals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arrivals = new Intent(Register.this, Arrivals.class);
                startActivity(arrivals);
            }
        });

        departures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent departures = new Intent(Register.this, Departures.class);
                startActivity(departures);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Register.this, MainActivity.class);
                startActivity(home);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arrivals = new Intent(Register.this, Information.class);
                startActivity(arrivals);
            }
        });

        etRegUser = (EditText) findViewById(R.id.regUsername);
        etRegPass = (EditText) findViewById(R.id.regPassword);

        sharedPref = getSharedPreferences(MyPref, Context.MODE_PRIVATE);
    }

    public void registerBtn(View v){

        if(etRegUser.length() <=0 || etRegPass.length() <=0)
            Toast.makeText(this, "Your must enter and username and password", Toast.LENGTH_SHORT).show();
        else {

            SharedPreferences.Editor editor = sharedPref.edit();

            editor.putString("username", etRegUser.getText().toString());
            editor.putString("password", etRegPass.getText().toString());
            editor.commit();

            Toast.makeText(this, "Details Saved", Toast.LENGTH_SHORT).show();

            Intent displayLogin = new Intent(Register.this, Login.class);
            startActivity(displayLogin);
        }

    }
}