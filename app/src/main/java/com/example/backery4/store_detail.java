package com.example.backery4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class store_detail extends AppCompatActivity {


Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        Button store1 = (Button) findViewById(R.id.store1);
        Button store2 = (Button) findViewById(R.id.store2);
        Button store3 = (Button) findViewById(R.id.store3);


        store1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(store_detail.this,Item_page.class));
            }
        });
        store2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(store_detail.this,Item_page.class));
            }
        });
        store3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(store_detail.this,Item_page.class));
            }
        });


    }
}