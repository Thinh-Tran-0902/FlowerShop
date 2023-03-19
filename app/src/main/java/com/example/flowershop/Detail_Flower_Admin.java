package com.example.flowershop;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flowershop.Database.DataBaseFlowerShop;
import com.example.flowershop.models.Flower;

public class Detail_Flower_Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_detail_flower);

        /*Button btnSave = findViewById(R.id.buttonsave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add to update flower đó

                //tạo.mở CSDL SQLite
                SQLiteDatabase myDatabase = openOrCreateDatabase
                        (DataBaseFlowerShop.DATABASE_NAME, MODE_PRIVATE, null);

                //....làm gì đó
                Toast.makeText(Detail_Flower_Admin.this, "update flower success", Toast.LENGTH_SHORT).show();
                //trở về trang home page
                Intent intent = new Intent(Detail_Flower_Admin.this, AdminActivity.class);
                startActivity(intent);
            }
        });*/

        LinearLayout linearLayout = findViewById(R.id.linear_layout);

        EditText tvNameFlower = findViewById(R.id.tv_name);
        EditText tvColorFlower = findViewById(R.id.tv_color);
        EditText tvPriceFlower = findViewById(R.id.tv_price);
        EditText tvDescriptionFlower = findViewById(R.id.tv_description);
        Button button = findViewById(R.id.buttonsave);

        int flowerid = 0;
        int adminid = 0;
        int categoryid = 0;
        int avatar = R.drawable.flower;

        Intent intent = getIntent();
        if(intent != null) {
            Bundle bundle = intent.getExtras();
            Flower flower = (Flower) bundle.get("FLOWER");

            flowerid = flower.getId();
            adminid = flower.getAdminId();
            categoryid = flower.getCategoryId();
            tvNameFlower.setText(flower.getName());
            avatar = R.drawable.flower;
            tvPriceFlower.setText(Integer.toString(flower.getPrice()));
            tvColorFlower.setText(flower.getColor());
            tvDescriptionFlower.setText(flower.getDescription());
        }

        int finalFlowerid = flowerid;
        int finalAdminid = adminid;
        int finalCategoryid = categoryid;
        int finalAvatar = avatar;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //tạo.mở CSDL SQLite
                SQLiteDatabase myDatabase = openOrCreateDatabase
                        (DataBaseFlowerShop.DATABASE_NAME, MODE_PRIVATE, null);

                //save new to database
                /*int siso = Integer.parseInt(editsiso.getText().toString());
                String tenlop = edttenlop.getText().toString();
                String malop = edtmalop.getText().toString();*/


                ContentValues contentValues = new ContentValues();
                contentValues.put(DataBaseFlowerShop.TABLE_Flower_col_id, finalFlowerid);      //lưu theo key, lưu ý key phải trùng vs tên att trong table ta cần lưu
                contentValues.put(DataBaseFlowerShop.TABLE_Flower_col_adminId, finalAdminid);
                contentValues.put(DataBaseFlowerShop.TABLE_Flower_col_categoryID, finalCategoryid);
                contentValues.put(DataBaseFlowerShop.TABLE_Flower_col_name, tvNameFlower.getText().toString());
                contentValues.put(DataBaseFlowerShop.TABLE_Flower_col_avatar, finalAvatar);
                contentValues.put(DataBaseFlowerShop.TABLE_Flower_col_price, tvPriceFlower.getText().toString());
                contentValues.put(DataBaseFlowerShop.TABLE_Flower_col_color, tvColorFlower.getText().toString());
                contentValues.put(DataBaseFlowerShop.TABLE_Flower_col_description, tvDescriptionFlower.getText().toString());

                //update record ở table tbllop tại record có malop = malop trong string[] và value mới tương ứng contentvalues
                if(myDatabase.update(DataBaseFlowerShop.TABLE_Flower, contentValues, "id = ?", new String[]{String.valueOf(finalFlowerid)}) > 0){
                    Toast.makeText(Detail_Flower_Admin.this, "update success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Detail_Flower_Admin.this, "update fail", Toast.LENGTH_SHORT).show();
                }
                //return main admin page
                Intent intent = new Intent(Detail_Flower_Admin.this, AdminActivity.class);
                startActivity(intent);
            }
        });
    }
}
