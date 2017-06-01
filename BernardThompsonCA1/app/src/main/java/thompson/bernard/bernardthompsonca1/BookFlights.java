package thompson.bernard.bernardthompsonca1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.checked;

public class BookFlights extends Base {

    private Button bookNow;
    private RadioGroup timedes;
    private RadioButton btnDestTime;
    private EditText bookingName;
    private EditText noOfPax;
    private TextView totalPrice;
    private NumberPicker pricePicker;

    String selection;
    private ImageButton arrivals;
    private ImageButton home;
    private ImageButton departures;
    private ImageButton information;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_flights);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        arrivals = (ImageButton)findViewById(R.id.ib_arrivals);
        home = (ImageButton)findViewById(R.id.ib_home);
        departures = (ImageButton)findViewById(R.id.ib_departures);
        information = (ImageButton)findViewById(R.id.ib_infomation);


        departures.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent departures = new Intent(BookFlights.this, BookFlights.class);
                    startActivity(departures);
                }
        });

        arrivals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent arrivals = new Intent(BookFlights.this, Arrivals.class);
                    startActivity(arrivals);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(BookFlights.this, MainActivity.class);
                startActivity(home);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent information = new Intent(BookFlights.this, Information.class);
                startActivity(information);
            }
        });

        bookNow = (Button) findViewById(R.id.b_book_now);

        timedes = (RadioGroup) findViewById(R.id.rg_dest_times) ;
        timedes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb = (RadioButton) group.findViewById(checkedId);

                switch (rb.getId()) {
                    case R.id.rd_london_t1:
                        selection = "London - 07.30";

                        break;


                    case R.id.rd_london_t2:
                        selection = "London - 19:00";

                        break;


                    case R.id.rd_manchester_t:
                        selection = "Manchester - 11:30";

                        break;

                    case R.id.rd_birmingham_t:
                        selection = "Birmingham - 15.15";
                        break;

                }

            }
        });

        btnDestTime = (RadioButton) findViewById(R.id.rd_london_t1);
        bookingName = (EditText) findViewById(R.id.ed_booked_name);
        noOfPax = (EditText) findViewById(R.id.ed_no_pax);

        totalPrice = (TextView) findViewById(R.id.tv_totalPrice);
        totalPrice.setText("€0");

        /**
         * Tried to set the numberPicker to steps of 50 to select a price

         int start = 70;
         String[] price = new String[3];
         for (int i =0; i<3; i++){
         price[i] = start + "";
         start = start + 50;
         }
         pricePicker.setDisplayedValues(price);
         */
        pricePicker = (NumberPicker) findViewById(R.id.pricePicker);
        pricePicker.setMaxValue(170);
        pricePicker.setMinValue(70);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_book_flights) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    public void bookNowPressed(View view) {

        int priceSelected = pricePicker.getValue();

        if (priceSelected == 0) {
            String text = totalPrice.getText().toString();
            if (!text.equals(""))
                priceSelected = Integer.parseInt(text);
        }
        if (priceSelected > 0) {

            String totalPriceString = "€" + pricePicker.getValue();
            totalPrice.setText(totalPriceString);
        }



        Log.v("Flight Price", pricePicker.getValue() + " Time and Destination " +  selection );
        Toast.makeText(getApplicationContext(), "Flight Booked", Toast.LENGTH_SHORT).show();
    }




}



