package thompson.bernard.bernardthompsonca1.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import thompson.bernard.bernardthompsonca1.Base;
import thompson.bernard.bernardthompsonca1.R;
import thompson.bernard.bernardthompsonca1.models.MyFlights;

/**
 * Created by bonjo1983 on 26/02/2017.
 */



public class Report extends Base {

    ListView listView;

    private ImageButton arrivals;
    private ImageButton home;
    private ImageButton departures;
    private ImageButton information;
    private ImageButton bookFlights;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_flights);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.report_list_view);
        ReportAdapter adapter = new ReportAdapter(this, app.dbManager.getAll());
        listView.setAdapter(adapter);

        arrivals = (ImageButton) findViewById(R.id.ib_arrivals);
        home = (ImageButton) findViewById(R.id.ib_home);
        departures = (ImageButton) findViewById(R.id.ib_departures);
        information = (ImageButton) findViewById(R.id.ib_infomation);
        bookFlights = (ImageButton) findViewById(R.id.ib_book_flights);

        bookFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bookFlights = new Intent(Report.this, BookFlights.class);
                startActivity(bookFlights);
            }
        });


        departures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent departures = new Intent(Report.this, BookFlights.class);
                startActivity(departures);
            }
        });

        arrivals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arrivals = new Intent(Report.this, Arrivals.class);
                startActivity(arrivals);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Report.this, MainActivity.class);
                startActivity(home);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent information = new Intent(Report.this, Information.class);
                startActivity(information);
            }
        });
    }
}

class ReportAdapter extends ArrayAdapter<MyFlights> {

    private Context context;
    public List<MyFlights> rFlights;

    public ReportAdapter(Context context, List<MyFlights> rFlight) {
        super(context, R.layout.report_flight_row, rFlight);
        this.context = context;
        this.rFlights = rFlight;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        MyFlights report = rFlights.get(position);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.report_flight_row, parent, false);
        }


        TextView bkPrice = (TextView) convertView.findViewById(R.id.bk_price);
        TextView bkTimeDes = (TextView) convertView.findViewById(R.id.bk_time_des);
        TextView bkName = (TextView) convertView.findViewById(R.id.bk_name);
        TextView bkPax = (TextView) convertView.findViewById(R.id.bk_pax);


        bkTimeDes.setText(report.time);
        bkPrice.setText(report.priceSelected);
        bkName.setText(report.bookedName);
        bkPax.setText(report.pax);

        return convertView;
    }

    @Override
    public int getCount()
    {
        return rFlights.size();
    }
}


