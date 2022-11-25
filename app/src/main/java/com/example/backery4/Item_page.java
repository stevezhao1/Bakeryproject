package com.example.backery4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class Item_page extends AppCompatActivity implements ProductAdapter.HomeCallBack {

    public static ArrayList<ProductModel> arrayList = new ArrayList<>();
    public static int cart_count = 0;
    ProductAdapter productAdapter;
    RecyclerView productRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);

        addProduct();
        productAdapter = new ProductAdapter(arrayList, this, this);
        productRecyclerView = findViewById(R.id.product_recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);

//                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productRecyclerView.setLayoutManager(gridLayoutManager);
        productRecyclerView.setAdapter(productAdapter);

    }
    private void addProduct() {

        ProductModel productModel = new ProductModel("bagel", "10", "20", R.drawable.bagel,0.35);
        arrayList.add(productModel);

        ProductModel productModel1 = new ProductModel("bread", "8", "10", R.drawable.bread,0.35);
        arrayList.add(productModel1);

        ProductModel productModel2 = new ProductModel("cookie", "9", "40", R.drawable.cookie,0.35);
        arrayList.add(productModel2);

        ProductModel productModel3 = new ProductModel("doughnut", "11", "20", R.drawable.doughnut,0.35);
        arrayList.add(productModel3);

        ProductModel productModel4 = new ProductModel("muffin", "10", "10", R.drawable.muffin,0.35);
        arrayList.add(productModel4);

        ProductModel productModel5 = new ProductModel("pie", "10", "20", R.drawable.pie,0.35);
        arrayList.add(productModel5);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.cart_action);
        menuItem.setIcon(Converter.convertLayoutToImage(Item_page.this, cart_count, R.drawable.ic_shopping_cart_white_24dp));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.cart_action:
                if (cart_count < 1) {
                    Toast.makeText(this, "there is no item in cart", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(this, ShoppingCartActivity.class));
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }


    @Override
    protected void onStart() {
        super.onStart();
        invalidateOptionsMenu();
    }

    @Override
    public void updateCartCount(Context context) {
        invalidateOptionsMenu();
    }
}