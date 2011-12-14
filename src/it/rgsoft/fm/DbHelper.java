package it.rgsoft.fm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by IntelliJ IDEA.
 * User: homeuser
 * Date: 11/12/11
 * Time: 17.50
 * To change this template use File | Settings | File Templates.
 */
public class DbHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "FmDb";
    private static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //To change body of implemented methods use File | Settings | File Templates.
        String sql = "";
        sql += "CREATE TABLE refuels (" +
                " _id INTEGER PRIMARY KEY," +
                " rdate TEXT NOT NULL," +
                " km INT NOT NULL," +
                " quantity TEXT NOT NULL, " +
                " price TEXT NOT NULL" +
                " )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //To change body of implemented methods use File | Settings | File Templates.

    }
}
