package com.example.flowershop.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.Detail_Flower_Activity;
import com.example.flowershop.R;
import com.example.flowershop.models.Cart;
import com.example.flowershop.models.Flower;
import com.example.flowershop.models.FlowerQuantity;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{
    private List<FlowerQuantity> cartList;
    private Context context;

    public CartAdapter(List<FlowerQuantity> cartList, Context context) {
        this.cartList = cartList;
        this.context = context;
    }
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitemcart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        FlowerQuantity cart = cartList.get(position);
        if(cart == null) return;

//        holder.imgHoaCart.setImageResource(cart.getImg());
//        holder.cartname.setText(cart.getName());
//        holder.cartprice.setText("Price:" + Integer.toString(cart.getPrice())+ " vnd");
        holder.imgHoaCart.setImageResource(cart.getFlower().getImg());
        holder.cartname.setText(cart.getFlower().getName());
        holder.cartprice.setText("Price:" + Integer.toString(cart.getFlower().getPrice())+ " vnd");
        holder.QuantityText.setText("Quantity: ");
        holder.cartEditQuantity.setText(Integer.toString(cart.getQuantity()));

    }

    @Override
    public int getItemCount() {
        if(cartList != null) return cartList.size();
        return 0;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgHoaCart;
        private TextView cartname;
        private TextView cartprice;

        private TextView QuantityText;

        private EditText cartEditQuantity;


        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHoaCart = itemView.findViewById(R.id.img_hoa_cart);
            cartname = itemView.findViewById(R.id.tv_nameHoa_cart);
            cartprice = itemView.findViewById(R.id.tv_priceHoa_cart);

            QuantityText= itemView.findViewById(R.id.tv_QuantityText);
            cartEditQuantity = itemView.findViewById(R.id.quantity_edit_text);


        }
    }

    void release(){ context = null; }
}
