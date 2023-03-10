package com.example.flowershop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.adapter.CartAdapter;

import com.example.flowershop.models.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView rcv_cart;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        rcv_cart = findViewById(R.id.ListViewCatalog);
        List<Cart> cartList = new ArrayList<>();
        cartList.add(new Cart(1, "Hoa 1", 10000, 9, R.drawable.flower));
        cartList.add(new Cart(1, "Hoa 2", 50000, 9, R.drawable.flower));
        cartList.add(new Cart(1, "Hoa 3", 55000, 9, R.drawable.flower));
        cartList.add(new Cart(1, "Hoa 4", 18000, 9, R.drawable.flower));
        cartList.add(new Cart(1, "Hoa 5", 95632, 9, R.drawable.flower));

        // get data to show in RecyclerView
        CartAdapter cartAdapter = new CartAdapter(cartList, this);
        rcv_cart.setAdapter(cartAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rcv_cart.setLayoutManager(gridLayoutManager);

        // Get username form MainActivity
        String username = null;
        if (getIntent() != null) {
            username = getIntent().getStringExtra("username");
        }

        Button btnBill = findViewById(R.id.btnBill);
        btnBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, Bill.class);
                startActivity(intent);
            }
        });
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.homepagemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.homemenu:
                Intent in = new Intent(this, ShopPageActivity.class);
                startActivity(in);
                return true;
            case R.id.logoutmenu:
                Intent in2 = new Intent(this, MainActivity.class);
                startActivity(in2);
                return true;
            case R.id.cartmenu:
                Intent in3 = new Intent(this, CartActivity.class);
                startActivity(in3);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
