package com.example.laboras2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;

@SuppressWarnings("FieldCanBeLocal")

public class MainActivity extends AppCompatActivity {

    private Spinner spCounterOption;
    private EditText edEnteredText;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        this.spCounterOption = findViewById( R.id.spCounterOption );
        this.edEnteredText = findViewById( R.id.etEnteredText );
        this.tvResult = findViewById( R.id.tvResult );

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.selection_options, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        this.spCounterOption.setAdapter( adapter );
    }

    @SuppressLint("SetTextI18n")
    public void onBtnOpenUrlClick(View view) {
        Toast.makeText( this, this.spCounterOption.getSelectedItem().toString(), Toast.LENGTH_SHORT ).show();

        String spSelectedOption = this.spCounterOption.getSelectedItem().toString();
        String charString = getString( R.string.selection_chars );
        if (spSelectedOption.equalsIgnoreCase( charString )) {
            String enteredUserText = this.edEnteredText.getText().toString();
            int charsCount = TextCounter.getCharsCount( enteredUserText );
            this.tvResult.setText( String.valueOf( charsCount ) );
        }
        String textString = getString( R.string.selection_words );
        if (spSelectedOption.equalsIgnoreCase( textString )){
            String text = edEnteredText.getText().toString();
            text = text.replace( "\n", " ");
            String [] textArray = text.split("[., ]+");
            tvResult.setText( " " + textArray.length);
        }
        else {
            Toast.makeText( this, "Not implemented", Toast.LENGTH_SHORT ).show();
        }
    }
}