package com.example.backery4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Stores extends AppCompatActivity {
    private TextView bagelView;
    private TextView breadView;
    private TextView cookieView;
    private TextView doughnutView;
    private TextView muffinView;
    private TextView pieView;
    private Button purchaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);
        bagelView = findViewById(R.id.bagelShown);
        breadView = findViewById(R.id.breadShown);
        cookieView = findViewById(R.id.cookieShown);
        doughnutView = findViewById(R.id.doughnutShown);
        muffinView = findViewById(R.id.muffinShown);
        pieView = findViewById(R.id.pieShown);
        purchaseButton = findViewById(R.id.purchase_button);
        Intent intent = getIntent();
        ProductModel bagel = (ProductModel) intent.getSerializableExtra("bagel");
        ProductModel bread = (ProductModel) intent.getSerializableExtra("bread");
        ProductModel cookie = (ProductModel) intent.getSerializableExtra("cookie");
        ProductModel doughnut = (ProductModel) intent.getSerializableExtra("doughnut");
        ProductModel muffin = (ProductModel) intent.getSerializableExtra("muffin");
        ProductModel pie = (ProductModel) intent.getSerializableExtra("pie");

        if(bagel != null ){
            bagelView.setText(bagel.getProductName() + " discount : $" + bagel.getDiscount());
        }
        if(bread != null){
            breadView.setText(bread.getProductName() + " discount : $" + bread.getDiscount());
        }
        if(cookie != null){
            cookieView.setText(cookie.getProductName() + " discount : $" + cookie.getDiscount());
        }
        if(doughnut != null){
            doughnutView.setText(doughnut.getProductName() + " discount : $" + doughnut.getDiscount());
        }
        if(muffin != null){
            muffinView.setText(muffin.getProductName() + " discount : $" + muffin.getDiscount());
        }
        if(pie != null){
            pieView.setText(pie.getProductName() + " discount : $" + pie.getDiscount());
        }
        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Stores.this, Item_page.class);
                startActivity(intent);

            }
        });

    }
}