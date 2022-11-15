package com.example.backery4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class demographic extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private TextView salaryRange;
    private SeekBar salarySeekBar;
    private int currentSalary = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demographic);
        Button demo_button = (Button) findViewById(R.id.breadclick);
        demo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(demographic.this,BakeryProducts.class);
                startActivity(intent);
            }
        });


        Spinner spinner = findViewById(R.id.store_choice);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.stores, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        salaryRange = findViewById(R.id.income_value);
        salaryRange.setText(currencyFormat.format(0));
        salarySeekBar = findViewById(R.id.income_Bar);
        salarySeekBar.setOnSeekBarChangeListener(salarySeekBarListener);
    }
    private SeekBar.OnSeekBarChangeListener salarySeekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            currentSalary = progress * 1000;
            calculate();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void calculate() {
        salaryRange.setText(currencyFormat.format(currentSalary));
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}