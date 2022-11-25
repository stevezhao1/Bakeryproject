package com.example.backery4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class BakeryProduct extends AppCompatActivity {

    CheckBox breadCheck;
    CheckBox bagelCheck;
    CheckBox cookieCheck;
    CheckBox muffinCheck;
    CheckBox pieCheck;
    CheckBox doughnutCheck;
    Button discountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakery_product);
        breadCheck = findViewById(R.id.breadCheck);
        bagelCheck = findViewById(R.id.bagelCheck);
        cookieCheck = findViewById(R.id.cookieCheck);
        muffinCheck = findViewById(R.id.muffinCheck);
        pieCheck = findViewById(R.id.pieCheck);
        doughnutCheck = findViewById(R.id.doughnutCheck);
        discountButton = findViewById(R.id.discount_button);
        discountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BakeryProduct.this, Stores.class);
                Bundle bundle = new Bundle();
                if(breadCheck.isChecked()){
                    ProductModel model = new ProductModel("bread", "10","10",0,0.35);
                    bundle.putSerializable("bread", model);
                }
                if(bagelCheck.isChecked()){
                    ProductModel model = new ProductModel("bagel", "10","10",0,0.35);
                    bundle.putSerializable("bagel", model);
                }
                if(cookieCheck.isChecked()){
                    ProductModel model = new ProductModel("cookie", "10","10",0,0.35);
                    bundle.putSerializable("cookie", model);
                }
                if(muffinCheck.isChecked()){
                    ProductModel model = new ProductModel("muffin", "10","10",0,0.35);
                    bundle.putSerializable("muffin", model);
                }
                if(pieCheck.isChecked()){
                    ProductModel model = new ProductModel("pie", "10","10",0,0.35);
                    bundle.putSerializable("pie", model);
                }
                if(doughnutCheck.isChecked()){
                    ProductModel model = new ProductModel("doughnut", "10","10",0,0.35);
                    bundle.putSerializable("doughnut", model);
                }
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });




    }
}