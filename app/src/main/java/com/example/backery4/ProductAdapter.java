package com.example.backery4;

import static com.example.backery4.Item_page.arrayList;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
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
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_adapter_layout, viewGroup, false);
        return new ProductAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder viewHolder, int i) {
        viewHolder.productName.setText(productsArray.get(i).productName);
        viewHolder.productPrice.setText(productsArray.get(i).price);

        viewHolder.productImage.setImageDrawable(ContextCompat.getDrawable(context, productsArray.get(i).imagePath));

        viewHolder.productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialog_item_quantity_update);
                // Set dialog title
                dialog.setTitle("Custom Dialog");
                final ImageView cartDecrement = dialog.findViewById(R.id.cart_decrement);
                ImageView cartIncrement = dialog.findViewById(R.id.cart_increment);
                ImageView closeDialog = dialog.findViewById(R.id.imageView_close_dialog_cart);
                TextView updateQtyDialog = dialog.findViewById(R.id.update_quantity_dialog);
                ImageView viewCartDialog = dialog.findViewById(R.id.view_cart_button_dialog);
                final TextView quantity = dialog.findViewById(R.id.cart_product_quantity_tv);
                quantity.setText(String.valueOf(0));
                final int[] cartCounter = {0};//{(arrayListImage.get(position).getStocks())};
                cartDecrement.setEnabled(false);
                cartDecrement.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (cartCounter[0] == 1) {
                                Toast.makeText(context, "cant add less than 0", Toast.LENGTH_SHORT).show();
                            } else {
                                cartCounter[0] -= 1;
                                quantity.setText(String.valueOf(cartCounter[0]));
                            }

                        }
                    });
                cartIncrement.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cartDecrement.setEnabled(true);
                        cartCounter[0] += 1;
                        quantity.setText(String.valueOf(cartCounter[0]));


                    }
                });
                viewCartDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        context.startActivity(new Intent(context, ShoppingCartActivity.class));
                    }
                });

                dialog.show();
                updateQtyDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, String.valueOf(cartCounter[0]) + "", Toast.LENGTH_SHORT).show();

                        // from these line of code we add items in cart
                        cartModel = new ProductImage();
                        cartModel.setProductQuantity((cartCounter[0]));
                        cartModel.setProductPrice(arrayList.get(i).getPrice());
                        cartModel.setProductImage(arrayList.get(i).getImagePath());
                        cartModel.setTotalCash(cartCounter[0] *
                                Integer.parseInt(arrayList.get(i).getPrice()));
                        Log.d("pos", String.valueOf(i));

                        cartModels.add(cartModel);

//
                        // from these lines of code we update badge count value
                        Item_page.cart_count = 0;
                        for (int i = 0; i < cartModels.size(); i++) {
                            for (int j = i + 1; j < cartModels.size(); j++) {
                                if (cartModels.get(i).getProductImage().equals(cartModels.get(j).getProductImage())) {
                                    cartModels.get(i).setProductQuantity(cartModels.get(j).getProductQuantity());
                                    cartModels.get(i).setTotalCash(cartModels.get(j).getTotalCash());
                                    //          cartModels.get(i).setImageIdSlide(cartModels.get(j).getImageIdSlide());
                                    cartModels.remove(j);
                                    j--;
                                    Log.d("remove", String.valueOf(cartModels.size()));

                                }
                            }
                        }
                        Item_page.cart_count = cartModels.size();

                        // from this interface method calling we show the updated value of cart cout in badge
                        homeCallBack.updateCartCount(context);
                        dialog.dismiss();
                    }

                });

                closeDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Item_page.cart_count = 0;
                        for (int i = 0; i < cartModels.size(); i++) {
                            for (int j = i + 1; j < cartModels.size(); j++) {
                                if (cartModels.get(i).getProductImage().equals(cartModels.get(j).getProductImage())) {
                                    cartModels.get(i).setProductQuantity(cartModels.get(j).getProductQuantity());
                                    cartModels.get(i).setTotalCash(cartModels.get(j).getTotalCash());
                                    //          cartModels.get(i).setImageIdSlide(cartModels.get(j).getImageIdSlide());
                                    cartModels.remove(j);
                                    j--;
                                    Log.d("remove", String.valueOf(cartModels.size()));

                                }
                            }
                        }


                        Item_page.cart_count = cartModels.size();
                        homeCallBack.updateCartCount(context);
                        dialog.dismiss();
                    }
                });


            }
        });

    }
    @Override
    public int getItemCount() {
        return productsArray.size();
    }


    public interface CallBackUs {
        void addCartItemView();
    }

    public interface HomeCallBack {
        void updateCartCount(Context context);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;
        TextView productPrice;

        ViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.android_gridview_image);
            productName = itemView.findViewById(R.id.android_gridview_text);
            productPrice=itemView.findViewById(R.id.android_gridview_price);
        }
    }
}



