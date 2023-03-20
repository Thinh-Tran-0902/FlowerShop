package com.example.flowershop;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import com.example.flowershop.Database.DataBaseFlowerShop;
import com.example.flowershop.adapter.CartAdapter;

import com.example.flowershop.models.Cart;
import com.example.flowershop.models.Flower;
import com.example.flowershop.models.FlowerQuantity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView rcv_cart;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        rcv_cart = findViewById(R.id.ListViewCatalog);
        List<FlowerQuantity> cartList = new ArrayList<>();
//        cartList.add(new Cart(1, "Hoa 1", 10000, 9, R.drawable.flower));
//        cartList.add(new Cart(1, "Hoa 2", 50000, 9, R.drawable.flower));
//        cartList.add(new Cart(1, "Hoa 3", 55000, 9, R.drawable.flower));
//        cartList.add(new Cart(1, "Hoa 4", 18000, 9, R.drawable.flower));
//        cartList.add(new Cart(1, "Hoa 5", 95632, 9, R.drawable.flower));
        SQLiteDatabase myDatabase = openOrCreateDatabase
                (DataBaseFlowerShop.DATABASE_NAME, MODE_PRIVATE, null);

        Cursor cursor = myDatabase.query(DataBaseFlowerShop.TABLE_Cart, null, null, null, null, null, null);
        cursor.moveToFirst(); //di chuyển nó đến bãn record  đầu tiên
        while (cursor.isAfterLast() == false){      //check xem nó trỏ đến bảng ghi cuối cùng chưa
            FlowerQuantity f = new FlowerQuantity();
            String idquantity = cursor.getString(1);
            String[] value = idquantity.split(" ");
            f.setFlower(getFlowerByID(myDatabase, value[0]));
            f.setQuantity(Integer.parseInt(value[1]));
            // cursor.getString(0): index thoe thứ tự cột,
            cartList.add(f);
            cursor.moveToNext();
        }
        cursor.close();

        List<FlowerQuantity> listRs = new ArrayList<>();
        //lọc lấy những flower moi loại tồn tại trong cart
        for (FlowerQuantity item: cartList) {
            if(checkExist(item, listRs) == null){
                FlowerQuantity ele = (FlowerQuantity) item.clone();
                ele.setQuantity(0);
                listRs.add(ele);
            }
        }
//        //gọp quantity của hao giống nhau lại
        FlowerQuantity tmp = null;
        for (FlowerQuantity item: cartList) {
            int index = getIndexFromList(item.getFlower().getId(), listRs);
            listRs.get(index).setQuantity(listRs.get(index).getQuantity() + item.getQuantity());
        }


        // get data to show in RecyclerView
        CartAdapter cartAdapter = new CartAdapter(listRs, this);
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
                intent.putExtra("cart", (Serializable) listRs);
                startActivity(intent);
            }
        });
    }

    private int getIndexFromList(int id, List<FlowerQuantity> listRs) {
        for(int i = 0; i < listRs.size(); i++){
            if(listRs.get(i).getFlower().getId() == id){
                return i;
            }
        }
        return -1;
    }

    private FlowerQuantity checkExist(FlowerQuantity item, List<FlowerQuantity> listRs) {
        for (FlowerQuantity iteml: listRs) {
            if(iteml.getFlower().getId() == item.getFlower().getId()){
                return iteml;
            }
        }
        return null;
    }

    private Flower getFlowerByID(SQLiteDatabase myDatabase, String id) {
        Flower f = null;
        Cursor cursor = myDatabase.query(DataBaseFlowerShop.TABLE_Flower, null, DataBaseFlowerShop.TABLE_Flower_col_id + " = ?", new String[]{id}, null, null, null);
        cursor.moveToFirst(); //di chuyển nó đến bãn record  đầu tiên
        while (cursor.isAfterLast() == false){      //check xem nó trỏ đến bảng ghi cuối cùng chưa
            f = new Flower();
            f.setId(Integer.parseInt(cursor.getString(0)));
            f.setAdminId(Integer.parseInt(cursor.getString(1)));
            f.setCategoryId(Integer.parseInt(cursor.getString(2)));
            f.setName(cursor.getString(3));
            f.setImg(R.drawable.flower);
            f.setPrice(Integer.parseInt(cursor.getString(5)));
            f.setColor(cursor.getString(6));
            f.setDescription(cursor.getString(7));
            // cursor.getString(0): index thoe thứ tự cột,
            cursor.moveToNext();
        }
        cursor.close();
        return f;
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
