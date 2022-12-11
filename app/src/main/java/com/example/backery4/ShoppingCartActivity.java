package com.example.backery4;

import static com.example.backery4.ProductAdapter.cartModels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShoppingCartActivity extends AppCompatActivity {
    public static TextView grandTotal;
    public static int grandTotalplus;


    // create a temp list and add cartitem list
    public static ArrayList<ProductImage> temparraylist;
    RecyclerView cartRecyclerView;
    CartAdapter cartAdapter;
    LinearLayout proceedToBook;
    Context context;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        Button check_store = (Button) findViewById(R.id.availableStore);

//        check_store.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(ShoppingCartActivity.this,Grocerry_store.class));
//            }
//        });


        context = this;
        temparraylist = new ArrayList<>();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        proceedToBook = findViewById(R.id.proceed_to_book);
        grandTotal = findViewById(R.id.grand_total_cart);
/*        setSupportActionBar(mToolbar);*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Cart");


//        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back_arrow));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // these lines of code for show the same  cart for future refrence
                grandTotalplus = 0;
                for (int i = 0; i < temparraylist.size(); i++) {

                }
                cartModels.addAll(temparraylist);
                Item_page.cart_count = (temparraylist.size());
//                addItemInCart.clear();
                finish();
            }
        });
        Item_page.cart_count = 0;

        //addInCart();

        Log.d("sizecart_1", String.valueOf(temparraylist.size()));
        Log.d("sizecart_2", String.valueOf(cartModels.size()));

        // from these lines of code we remove the duplicacy of cart and set last added quantity in cart
        // for replace same item
        for (int i = 0; i < cartModels.size(); i++) {
            for (int j = i + 1; j < cartModels.size(); j++) {
                if (cartModels.get(i).getProductImage().equals(cartModels.get(j).getProductImage())) {
                    cartModels.get(i).setProductQuantity(cartModels.get(j).getProductQuantity());
                    cartModels.get(i).setTotalCash(cartModels.get(j).getTotalCash());
                    cartModels.remove(j);
                    j--;
                    Log.d("remove", String.valueOf(cartModels.size()));

                }
            }

        }
        temparraylist.addAll(cartModels);
        cartModels.clear();
        Log.d("sizecart_11", String.valueOf(temparraylist.size()));
        Log.d("sizecart_22", String.valueOf(cartModels.size()));
        // this code is for get total cash
        for (int i = 0; i < temparraylist.size(); i++) {
            grandTotalplus = grandTotalplus + temparraylist.get(i).getTotalCash();
        }
        grandTotal.setText(" $ " + String.valueOf(grandTotalplus));
        cartRecyclerView = findViewById(R.id.recycler_view_cart);
        cartAdapter = new CartAdapter(temparraylist, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        cartRecyclerView.setLayoutManager(mLayoutManager);
        cartRecyclerView.setAdapter(cartAdapter);


        proceedToBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShoppingCartActivity.this, "order placed", Toast.LENGTH_SHORT).show();
                //bookMyOrder();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        grandTotalplus = 0;
        for (int i = 0; i < temparraylist.size(); i++) {
            Item_page.cart_count = (temparraylist.size());

        }
        cartModels.addAll(temparraylist);
        //cartModels.clear();
    }


}
