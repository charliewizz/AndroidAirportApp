package thompson.bernard.bernardthompsonca1.Database;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import thompson.bernard.bernardthompsonca1.models.MyFlights;
import thompson.bernard.bernardthompsonca1.Base;

public class DBManager {

    private SQLiteDatabase database;
    private DBDesigner dbHelper;

    public DBManager(Context context) {
        dbHelper = new DBDesigner(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    public void add(MyFlights d) {
        ContentValues values = new ContentValues();
        values.put("booking_name", d.bookedName);
        values.put("num_pax", d.pax);
        values.put("time", d.time);
        values.put("price", d.priceSelected);

        database.insert("myflights", null, values);
    }

    public List<MyFlights> getAll() {
        List<MyFlights> myflights = new ArrayList<MyFlights>();
        Cursor cursor = database.rawQuery("SELECT * FROM myflights", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            MyFlights d = toFlight(cursor);
            myflights.add(d);
            cursor.moveToNext();
        }
        cursor.close();
        return myflights;
    }

    private MyFlights toFlight(Cursor cursor) {
        MyFlights pojo = new MyFlights();
        pojo.id = cursor.getInt(0);
        pojo.priceSelected = cursor.getString(1);
        pojo.bookedName = cursor.getString(2);
        pojo.time = cursor.getString(3);
        pojo.pax = cursor.getString(4);
        return pojo;
    }


    public void reset() {
        database.delete("myflights", null, null);
    }
}
