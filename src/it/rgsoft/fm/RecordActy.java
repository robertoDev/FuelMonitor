package it.rgsoft.fm;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import javax.sql.RowSet;

/**
 * Created by IntelliJ IDEA.
 * User: homeuser
 * Date: 11/12/11
 * Time: 15.45
 * To change this template use File | Settings | File Templates.
 */
public class RecordActy extends Activity implements View.OnClickListener
{
private DbHelper dbh;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        findViewById(R.id.buttonSave).setOnClickListener(this);
        findViewById(R.id.buttonAbort).setOnClickListener(this);

        // accesso al db
        dbh=new DbHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();

        String sql=" SELECT * FROM refuels";
        Cursor rs=db.rawQuery(sql,null);
        int rows=rs.getCount();
        message("rifornimenti: "+rows);
        rs.close();

    }

    // gestore di click per tutti i pulsanti
    public void onClick(View v) {
        int vId=v.getId();
        switch (vId){
            case R.id.buttonSave:
                save();
                break;
            case R.id.buttonAbort:
                abort();
                break;
        }
    }

    private void save(){
        SQLiteDatabase db = dbh.getWritableDatabase();

        ContentValues values = new ContentValues();

        ;

        DatePicker dp= (DatePicker)findViewById(R.id.datePk1);
        String sDate="";
        sDate+=dp.getYear();
        sDate+="."+  (dp.getMonth()+1);
        sDate+="."+dp.getDayOfMonth();

        values.put("rdate", sDate);
        values.put("km", ((EditText)findViewById(R.id.txtKm)).getText().toString() );
        values.put("quantity", ((EditText)findViewById(R.id.txtQty)).getText().toString() );
        values.put("price", ((EditText)findViewById(R.id.txtPrice)).getText().toString() );
        long id = db.insert("refuels", null, values);
        message("saved "+id);
        finish();
    }


    private void abort(){
        message("aborted");
        finish();
    }

    private void message(String txt){
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
    }

}
