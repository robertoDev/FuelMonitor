package it.rgsoft.fm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.sax.EndElementListener;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActy extends Activity implements View.OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);


/*
// NOME
		TextView label1 = new TextView(this);
		label1.setText("Nome:");
		EditText edit1 = new EditText(this);
// COGNOME
		TextView label2 = new TextView(this);
		label2.setText("Cognome:");
		EditText edit2 = new EditText(this);
// SESSO
		TextView label3 = new TextView(this);
		label3.setText("Sesso:");
		RadioButton radio1 = new RadioButton(this);
		radio1.setText("M");
		RadioButton radio2 = new RadioButton(this);
		radio2.setText("F");

		RadioGroup radioGroup1 = new RadioGroup(this);
		radioGroup1.setOrientation(LinearLayout.HORIZONTAL);
		radioGroup1.setGravity(Gravity.CENTER);
		radioGroup1.addView(radio1);
		radioGroup1.addView(radio2);


// SALVA
		Button button1 = new Button(this);
		button1.setText("Salva");
// ANNULLA
		Button button2 = new Button(this);
		button2.setText("Annulla");





// PRIMA RIGA
		TableRow row1 = new TableRow(this);
		row1.setGravity(Gravity.CENTER);
		row1.addView(label1);
		edit1.setGravity(Gravity.FILL);
		row1.addView(edit1);
// SECONDA RIGA
		TableRow row2 = new TableRow(this);
		row2.setGravity(Gravity.CENTER);
		row2.addView(label2);
		row2.addView(edit2);
// TERZA RIGA
		TableRow row3 = new TableRow(this);
		row3.setGravity(Gravity.CENTER);
		row3.addView(label3);
		row3.addView(radioGroup1);

// TABELLA DI 3 RIGHE
		TableLayout tableLayout = new TableLayout(this);
		tableLayout.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
		tableLayout.addView(row1);
		tableLayout.addView(row2);
		tableLayout.addView(row3);
		tableLayout.setColumnShrinkable(0, true);
		tableLayout.setColumnStretchable(1, true);

// BOTTONI
		LinearLayout linearLayout1 = new LinearLayout(this);
		linearLayout1.setGravity(Gravity.CENTER);
		linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout1.addView(button1);
		linearLayout1.addView(button2);

// PRINCIPALE
		LinearLayout linearLayout2 = new LinearLayout(this);
		linearLayout2.setGravity(Gravity.CENTER);
		linearLayout2.setOrientation(LinearLayout.VERTICAL);
		linearLayout2.setPadding(5, 5, 5, 5);
		linearLayout2.addView(tableLayout);
		linearLayout2.addView(linearLayout1);

// VISUALIZZA
		setContentView(linearLayout2);
*/

// tramite layout xml:
        setContentView(R.layout.main);

        // registro i listener per i bottoni
        findViewById(R.id.buttonExit).setOnClickListener(this);
        findViewById(R.id.buttonNew ).setOnClickListener(this);
        findViewById(R.id.buttonStat).setOnClickListener(this);
    }

    // gestore di click per tutti i pulsanti
    public void onClick(View v) {
        int vId=v.getId();
        switch (vId){
            case R.id.buttonExit:
                exit();
                break;
            case R.id.buttonNew:
                newRecord();
                break;
        }
    }


    private void exit(){
        message("Bye bye");
        finish();
    }

    private void newRecord(){
        message("add new record");
        startActivity(new Intent(this, RecordActy.class));
    }

    private void message(String txt){
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
    }
  }
