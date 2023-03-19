package com.example.flowershop;

import android.content.ContentValues;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.flowershop.Database.DataBaseFlowerShop;

public class AddNew extends AppCompatActivity {

    EditText name, color, price, description;

    Button btncreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        name = findViewById(R.id.tv_name);
        color = findViewById(R.id.tv_color);
        price = findViewById(R.id.tv_price);
        description = findViewById(R.id.tv_description);

        btncreate = findViewById(R.id.btncreate);

        SQLiteDatabase myDatabase = openOrCreateDatabase
                (DataBaseFlowerShop.DATABASE_NAME, MODE_PRIVATE, null);
        long count = DatabaseUtils.queryNumEntries(myDatabase, DataBaseFlowerShop.TABLE_Flower);

        btncreate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String new_name = name.getText().toString();
                String new_color = color.getText().toString();
                String new_price = price.getText().toString();
                Integer final_price = Integer.parseInt(new_price);
                String new_description = description.getText().toString();
                //lấy data ở trên insert vào db
                ContentValues value = new ContentValues();
                value.put(DataBaseFlowerShop.TABLE_Flower_col_id, count+1);      //lưu theo key, lưu ý key phải trùng vs tên att trong table ta cần lưu
                value.put(DataBaseFlowerShop.TABLE_Flower_col_adminId, 1);
                value.put(DataBaseFlowerShop.TABLE_Flower_col_categoryID, 1);
                value.put(DataBaseFlowerShop.TABLE_Flower_col_name, new_name);
                value.put(DataBaseFlowerShop.TABLE_Flower_col_avatar, 1);
                value.put(DataBaseFlowerShop.TABLE_Flower_col_price, final_price);
                value.put(DataBaseFlowerShop.TABLE_Flower_col_color, new_color);
                value.put(DataBaseFlowerShop.TABLE_Flower_col_description, new_description);

                if(myDatabase.insert(DataBaseFlowerShop.TABLE_Flower, null, value) == -1){
                    Toast.makeText(AddNew.this, "insert fail", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AddNew.this, "insert success", Toast.LENGTH_SHORT).show();
                }

                //trở về trang home page admin
                Intent intent = new Intent(AddNew.this, AdminActivity.class);
                startActivity(intent);
            }
        });
    }

    // Admin Menu -------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.adminpagemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addnew:
                Intent in = new Intent(this, AddNew.class);
                startActivity(in);
                return true;
            case R.id.logoutmenu:
                Intent in2 = new Intent(this, LoginActivity.class);
                startActivity(in2);
                return true;
            case R.id.homemenu:
                Intent in3 = new Intent(this, AdminActivity.class);
                startActivity(in3);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // Admin Menu -------------------------------------------------------

}