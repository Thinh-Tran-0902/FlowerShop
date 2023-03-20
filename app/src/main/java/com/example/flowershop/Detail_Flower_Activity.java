package com.example.flowershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flowershop.Database.DataBaseFlowerShop;
import com.example.flowershop.models.CartDb;
import com.example.flowershop.models.Flower;
import com.example.flowershop.models.FlowerQuantity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Detail_Flower_Activity extends AppCompatActivity {

    Button btnAddToCart ;
    Flower flower;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_flower);
        LinearLayout linearLayout = findViewById(R.id.linear_layout);

        btnAddToCart = findViewById(R.id.btnAddToCart);

        TextView tvNameFlower = findViewById(R.id.tv_name);
        TextView tvColorFlower = findViewById(R.id.tv_color);
        TextView tvPriceFlower = findViewById(R.id.tv_price);
        TextView tvDescriptionFlower = findViewById(R.id.tv_description);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            flower = (Flower) bundle.get("FLOWER");
            tvNameFlower.setText(flower.getName());
            tvColorFlower.setText(flower.getColor());
            tvPriceFlower.setText(Integer.toString(flower.getPrice()));
            tvDescriptionFlower.setText(flower.getDescription());
        }

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    EditText edquantity = findViewById(R.id.tv_number);
                    int quantity = Integer.parseInt(edquantity.getText().toString());
                    if(quantity > 0) {

                        //add to cart trong Db
                        SQLiteDatabase myDatabase = openOrCreateDatabase
                                (DataBaseFlowerShop.DATABASE_NAME, MODE_PRIVATE, null);

//                List<CartDb> listCart = getAllCart(myDatabase);
//                if(listCart != null){
//                    boolean check = false;
//                    for (CartDb item: listCart) {
//                        //check xem hoa co exist chua
//                            //chu7a thi them moi
//
//                        String[] value = item.getFloweridquantity().split(" ");
//                        if(value[0] == (flower.getId() + "")){
//                            check = true;
//                            //roi thi cap nhat lai list va update cart lai sqlite
//                            int newquantity = Integer.parseInt(value[1]) + quantity;
//                            String newfloweridquantity = value[0] + " " + newquantity;
//
//                            ContentValues valueupdate = new ContentValues();
//                            valueupdate.put(DataBaseFlowerShop.TABLE_Cart_col_floweridquantity, newfloweridquantity);
//                            if(myDatabase.update(DataBaseFlowerShop.TABLE_Cart, valueupdate,  DataBaseFlowerShop.TABLE_Cart_col_cartid+ " = ?", new String[] {item.getId()}) != -1){
//                                Toast.makeText(Detail_Flower_Activity.this, "update to cart success", Toast.LENGTH_SHORT).show();
//                            }else{
//                                Toast.makeText(Detail_Flower_Activity.this, "update to cart fail", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//                    if(check == false){ //have list cart but don't have flower this -> add to cart
//                        ContentValues content = new ContentValues();
//
//                        Random generator = new Random();
//                        content.put(DataBaseFlowerShop.TABLE_Cart_col_cartid, generator.nextInt() + "");
//
//                        String value = flower.getId() + " " + quantity;
//                        content.put(DataBaseFlowerShop.TABLE_Cart_col_floweridquantity, value);
//
//                        if(myDatabase.insert(DataBaseFlowerShop.TABLE_Cart, null, content) == -1){
//                            Toast.makeText(Detail_Flower_Activity.this, "add to cart fail", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Toast.makeText(Detail_Flower_Activity.this, "add to cart success", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }else{
                        ContentValues content = new ContentValues();

                        Random generator = new Random();
                        content.put(DataBaseFlowerShop.TABLE_Cart_col_cartid, generator.nextInt() + "");

                        String value = flower.getId() + " " + quantity;
                        content.put(DataBaseFlowerShop.TABLE_Cart_col_floweridquantity, value);

                        if (myDatabase.insert(DataBaseFlowerShop.TABLE_Cart, null, content) == -1) {
                            Toast.makeText(Detail_Flower_Activity.this, "add to cart fail", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Detail_Flower_Activity.this, "add to cart success", Toast.LENGTH_SHORT).show();
                        }
//                }

                        //trở về trang home page
                        Intent intent = new Intent(Detail_Flower_Activity.this, ShopPageActivity.class);
                        startActivity(intent);
                    }
                }catch (Exception ex){
                    Toast.makeText(Detail_Flower_Activity.this, "error format", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private boolean checkFlowerCart(SQLiteDatabase myDatabase, int id) {
        boolean check = false;
        Cursor cursor = myDatabase.query(DataBaseFlowerShop.TABLE_Cart, null, DataBaseFlowerShop.TABLE_Cart_col_floweridquantity + " = ?", new String[]{id+ ""}, null, null, null);
        cursor.moveToFirst(); //di chuyển nó đến bãn record  đầu tiên
        while (cursor.isAfterLast() == false){
            check = true;
        }
        cursor.close();
        return check;
    }

    private List<CartDb> getAllCart(SQLiteDatabase myDatabase) {
        List<CartDb> listCArt = new ArrayList<>();
        Cursor cursor = myDatabase.query(DataBaseFlowerShop.TABLE_Cart, null, null, null, null, null, null);
        cursor.moveToFirst(); //di chuyển nó đến bãn record  đầu tiên
        while (cursor.isAfterLast() == false){
            CartDb cartDb = new CartDb();
            cartDb.setId(cursor.getString(0));
            cartDb.setFloweridquantity(cursor.getString(1));
            listCArt.add(cartDb);
        }
        cursor.close();
        return listCArt;
    }

    // Menu -------------------------------------------------------
    @Override
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
                Intent in2 = new Intent(this, LoginActivity.class);
                startActivity(in2);
                return true;
            case R.id.cartmenu:
                Intent in3 = new Intent(this, CartActivity.class);
                startActivity(in3);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // Menu -------------------------------------------------------
}