package thompson.bernard.bernardthompsonca1.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import thompson.bernard.bernardthompsonca1.Activities.FlightStatus;
import thompson.bernard.bernardthompsonca1.R;

/**
 * Created by bonjo1983 on 20/02/2017.
 */

public class FlightsAdapter extends ArrayAdapter<FlightStatus> {

    Context context;
    int resource;
    ArrayList<FlightStatus> flights = null;

    public FlightsAdapter(Context context, int resource, ArrayList<FlightStatus> flights) {
        super(context, resource, flights);

        this.context = context;
        this.resource = resource;
        this.flights = flights;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FlightStatus flight = flights.get(position);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.row_view, parent, false);
        }

        TextView flightNoTV = (TextView)convertView.findViewById(R.id.tvArrivalFlightNo);
        TextView destinationTV =(TextView)convertView.findViewById(R.id.tvArrivalDestination);
        TextView timeTV = (TextView)convertView.findViewById(R.id.tvArrivalTime);
        TextView statusTV = (TextView)convertView.findViewById(R.id.tvArrivalStatus);
        ImageView airlineImg = (ImageView)convertView.findViewById(R.id.arrivalImageView);

        flightNoTV.setText(flight.flightNo);
        destinationTV.setText(flight.destination);
        timeTV.setText(flight.time);
        statusTV.setText(flight.status);
        airlineImg.setImageResource(flight.airlineImg);

        return convertView;
    }
}
