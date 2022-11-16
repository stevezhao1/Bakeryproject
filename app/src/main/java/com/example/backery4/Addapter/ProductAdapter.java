package com.example.backery4.Addapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.backery4.R;
import com.example.backery4.model.ProductImage;
import com.example.backery4.model.ProductModel;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    public static ArrayList<ProductModel> productsArray;
    public static ArrayList<ProductImage> cartModels = new ArrayList<ProductImage>();
    public static ProductImage cartModel;
    private  CallBackUs mCallBackus;
    private HomeCallBack homeCallBack;
    public ProductAdapter(ArrayList<ProductModel> productsArray, Context context, HomeCallBack mCallBackus) {
        this.productsArray = productsArray;
        this.context = context;
        this.homeCallBack = mCallBackus;
    }
    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder viewHolder, int i) {

    }
    @Override
    public int getItemCount() {
        return 0;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public interface CallBackUs {
        void addCartItemView();
    }
    // this interface creates for call the invalidateoptionmenu() for refresh the menu item

    public interface HomeCallBack {
        void updateCartCount(Context context);
    }
}



