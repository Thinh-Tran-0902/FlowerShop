package com.example.flowershop;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.Database.DataBaseFlowerShop;
import com.example.flowershop.adapter.FlowerAdapter;
import com.example.flowershop.models.Flower;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    private RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        //data recyclerView
        rcv = findViewById(R.id.rcv_listHoa);
        List<Flower> listhoa = new ArrayList<>();

        /*listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa 1", 10000, "White",
                "Những bông hoa trắng muốt thơm ngào ngạt khiến vua chúa thời xưa cũng phải hạ mình" +
                        " ra thưởng thức. Cánh hoa nhỏ dài và rất nhiều cánh nở bung hút mắt"));
        *//*listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa 1", 10000, "White",
                "Những bông hoa trắng muốt thơm ngào ngạt khiến vua chúa thời xưa cũng phải hạ mình" +
                        " ra thưởng thức. Cánh hoa nhỏ dài và rất nhiều cánh nở bung hút mắt"));
        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa 1", 10000, "White",
                "Những bông hoa trắng muốt thơm ngào ngạt khiến vua chúa thời xưa cũng phải hạ mình" +
                        " ra thưởng thức. Cánh hoa nhỏ dài và rất nhiều cánh nở bung hút mắt"));
        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa 1", 10000, "White",
                "Những bông hoa trắng muốt thơm ngào ngạt khiến vua chúa thời xưa cũng phải hạ mình" +
                        " ra thưởng thức. Cánh hoa nhỏ dài và rất nhiều cánh nở bung hút mắt"));
        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa 1", 10000, "White",
                "Những bông hoa trắng muốt thơm ngào ngạt khiến vua chúa thời xưa cũng phải hạ mình" +
                        " ra thưởng thức. Cánh hoa nhỏ dài và rất nhiều cánh nở bung hút mắt"));*/

        //tạo.mở CSDL SQLite
        SQLiteDatabase myDatabase = openOrCreateDatabase
                (DataBaseFlowerShop.DATABASE_NAME, MODE_PRIVATE, null);

        // add 1 demo flower
//        ContentValues value = new ContentValues();
//        value.put(DataBaseFlowerShop.TABLE_Flower_col_id, 1);      //lưu theo key, lưu ý key phải trùng vs tên att trong table ta cần lưu
//        value.put(DataBaseFlowerShop.TABLE_Flower_col_adminId, 1);
//        value.put(DataBaseFlowerShop.TABLE_Flower_col_categoryID, 1);
//        value.put(DataBaseFlowerShop.TABLE_Flower_col_name, "Kha");
//        value.put(DataBaseFlowerShop.TABLE_Flower_col_avatar, 1);
//        value.put(DataBaseFlowerShop.TABLE_Flower_col_price, 99000);
//        value.put(DataBaseFlowerShop.TABLE_Flower_col_color, "Pink");
//        value.put(DataBaseFlowerShop.TABLE_Flower_col_description, "Kha Kha Kha KhaKha Kha Kha KhaKha Kha Kha Kha");
//
//        //hàm insert sẽ đưa value từ obj value ở trên vào Db, return -1 là nó fail, ko thì return index record đc ghi
//        if(myDatabase.insert(DataBaseFlowerShop.TABLE_Flower, null, value) == -1){
//            Toast.makeText(AdminActivity.this, "insert fail", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(AdminActivity.this, "insert success", Toast.LENGTH_SHORT).show();
//        }

        Cursor cursor = myDatabase.query(DataBaseFlowerShop.TABLE_Flower, null, null, null, null, null, null);
        cursor.moveToFirst(); //di chuyển nó đến bãn record  đầu tiên
        while (cursor.isAfterLast() == false){      //check xem nó trỏ đến bảng ghi cuối cùng chưa
            Flower f = new Flower();
            f.setId(Integer.parseInt(cursor.getString(0)));
            f.setAdminId(Integer.parseInt(cursor.getString(1)));
            f.setCategoryId(Integer.parseInt(cursor.getString(2)));
            f.setName(cursor.getString(3));
            f.setImg(R.drawable.flower);
            f.setPrice(Integer.parseInt(cursor.getString(5)));
            f.setColor(cursor.getString(6));
            f.setDescription(cursor.getString(7));
            // cursor.getString(0): index thoe thứ tự cột,
            // nếu ko nhớ index: String malop = cursor.getString(cursor.getColumnIndex("malop"))
            listhoa.add(f);
            cursor.moveToNext();
        }
        cursor.close();

        Button btnSearch = findViewById(R.id.btnsearcha);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText search = findViewById(R.id.edSearch);
                Intent intent = new Intent(AdminActivity.this, AdminActivity.class);
                intent.putExtra("search", search.getText());
                List<Flower> listsearch = new ArrayList<>();
                for (Flower item: listhoa) {
                    if(item.getName().contains(search.getText())){
                        listsearch.add(item);
                    }
                }
                // get data to show in RecyclerView
                FlowerAdapter flowerAdapter = new FlowerAdapter(listsearch, AdminActivity.this, 2);
                rcv.setAdapter(flowerAdapter);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(AdminActivity.this, 3);
                rcv.setLayoutManager(gridLayoutManager);
            }
        });

        // get data to show in RecyclerView
        FlowerAdapter flowerAdapter = new FlowerAdapter(listhoa, this, 1);
        rcv.setAdapter(flowerAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rcv.setLayoutManager(gridLayoutManager);
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