package com.example.flowershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.flowershop.Database.DataBaseFlowerShop;
import com.example.flowershop.adapter.FlowerAdapter;
import com.example.flowershop.models.Flower;

import java.util.ArrayList;
import java.util.List;

public class ShopPageActivity extends AppCompatActivity {
    private RecyclerView rcv;
    List<Flower> listhoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_page);

        Button btnSearch = findViewById(R.id.btnsearch);

        //data recyclerView
        rcv = findViewById(R.id.rcv_listHoa);
        listhoa = new ArrayList<>();
//        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa 1", 10000, "White",
//                "Những bông hoa trắng muốt thơm ngào ngạt khiến vua chúa thời xưa cũng phải hạ mình" +
//                        " ra thưởng thức. Cánh hoa nhỏ dài và rất nhiều cánh nở bung hút mắt"));
//        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa 1", 10000, "White",
//                "Những bông hoa trắng muốt thơm ngào ngạt khiến vua chúa thời xưa cũng phải hạ mình" +
//                        " ra thưởng thức. Cánh hoa nhỏ dài và rất nhiều cánh nở bung hút mắt"));
//        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa 1", 10000, "White",
//                "Những bông hoa trắng muốt thơm ngào ngạt khiến vua chúa thời xưa cũng phải hạ mình" +
//                        " ra thưởng thức. Cánh hoa nhỏ dài và rất nhiều cánh nở bung hút mắt"));
//        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa 1", 10000, "White",
//                "Những bông hoa trắng muốt thơm ngào ngạt khiến vua chúa thời xưa cũng phải hạ mình" +
//                        " ra thưởng thức. Cánh hoa nhỏ dài và rất nhiều cánh nở bung hút mắt"));
//        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa 1", 10000, "White",
//                "Những bông hoa trắng muốt thơm ngào ngạt khiến vua chúa thời xưa cũng phải hạ mình" +
//                        " ra thưởng thức. Cánh hoa nhỏ dài và rất nhiều cánh nở bung hút mắt"));

        SQLiteDatabase myDatabase = openOrCreateDatabase
                (DataBaseFlowerShop.DATABASE_NAME, MODE_PRIVATE, null);

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

            listhoa.add(f);
            cursor.moveToNext();
        }
        cursor.close();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText search = findViewById(R.id.edSearch);
                Intent intent = new Intent(ShopPageActivity.this, ShopPageActivity.class);
                intent.putExtra("search", search.getText());
                List<Flower> listsearch = new ArrayList<>();
                for (Flower item: listhoa) {
                    if(item.getName().contains(search.getText())){
                        listsearch.add(item);
                    }
                }
                // get data to show in RecyclerView
                FlowerAdapter flowerAdapter = new FlowerAdapter(listsearch, ShopPageActivity.this, 2);
                rcv.setAdapter(flowerAdapter);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(ShopPageActivity.this, 3);
                rcv.setLayoutManager(gridLayoutManager);
            }
        });

        // get data to show in RecyclerView
        FlowerAdapter flowerAdapter = new FlowerAdapter(listhoa, this, 2);
        rcv.setAdapter(flowerAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rcv.setLayoutManager(gridLayoutManager);

        // Get username form MainActivity
        String username = null;
        if(getIntent() != null) {
           username = getIntent().getStringExtra("username");
        }

        // Create a notification channel
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("log_in_channel", "Welcome", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        // Create a notification and notification content
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "log_in_channel")
                .setSmallIcon(R.drawable.ic_cart_icon)
                .setContentTitle("Welcome to Flower Shop")
                .setContentText("Hi, " + username + " enjoy your time here.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Notification noti = builder.build();

        //notificationManager.notify(1, noti);
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