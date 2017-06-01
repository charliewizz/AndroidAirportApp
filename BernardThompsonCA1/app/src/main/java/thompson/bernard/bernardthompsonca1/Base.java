package thompson.bernard.bernardthompsonca1;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import thompson.bernard.bernardthompsonca1.BookFlights;
import thompson.bernard.bernardthompsonca1.R;

/**
 * Created by bonjo1983 on 24/02/2017.
 */

public class Base extends AppCompatActivity {

    public void timesToast(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_london_t1:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Flight - London, Time - 07.30", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rd_london_t2:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Flight - London, Time - 19.30", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rd_manchester_t:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Flight - Manchester, Time -  11.30", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rd_birmingham_t:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Flight - Birmingham, Time - 15.15", Toast.LENGTH_SHORT).show();
                break;


        }
    }
}
