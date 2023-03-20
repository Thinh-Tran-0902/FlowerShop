package com.example.flowershop;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.flowershop.Database.DataBaseFlowerShop;
import com.example.flowershop.models.FlowerQuantity;

import java.util.ArrayList;
import java.util.List;

public class Bill extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill);
        Button btnCOntinueShopping = findViewById(R.id.btnContinueShopping);

        Intent i = getIntent();
        List<FlowerQuantity> cartList = (List<FlowerQuantity>) i.getSerializableExtra("cart");

        TextView billdate = findViewById(R.id.bill_date);
        billdate.setText(java.time.LocalDateTime.now().toString());

        TextView detail = findViewById(R.id.hoa_1);
        String tmp = "";
        int total = 0;
        for (FlowerQuantity item: cartList) {
            tmp += item.getFlower().getName() + " - quantity: " + item.getQuantity() + "\n";
            total += item.getFlower().getPrice() * item.getQuantity();
        }
        detail.setText(tmp);

        SQLiteDatabase myDatabase = openOrCreateDatabase
                (DataBaseFlowerShop.DATABASE_NAME, MODE_PRIVATE, null);
        myDatabase.execSQL("delete from " + DataBaseFlowerShop.TABLE_Cart);

        TextView totalmoney = findViewById(R.id.bill_total);
        totalmoney.setText(total + "");

        btnCOntinueShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //trở về trang home page
                Intent intent = new Intent(Bill.this, ShopPageActivity.class);
                startActivity(intent);
            }
        });
    }



    // Menu -------------------------------------------------------
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
