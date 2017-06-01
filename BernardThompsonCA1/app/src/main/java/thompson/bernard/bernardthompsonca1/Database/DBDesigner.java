package thompson.bernard.bernardthompsonca1.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBDesigner extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myFlights.db";
    private static final int 	DATABASE_VERSION = 3;
    private static final String DATABASE_CREATE_TABLE_MYFLIGHTS = "create table myFlights "
            + "(id integer primary key autoincrement,"
            + "price text not null,"
            + "booking_name text not null,"
            + "time text not null,"
            + "num_pax text not null)";

    public DBDesigner(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_TABLE_MYFLIGHTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBDesigner.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS myFlights");
        onCreate(db);
    }
}