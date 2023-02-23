package com.example.flowershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flowershop.adapter.FlowerAdapter;
import com.example.flowershop.models.Flower;

import java.util.ArrayList;
import java.util.List;

public class ShopPageActivity extends AppCompatActivity {
    private RecyclerView rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_page);

        //data recyclerView
        rcv = findViewById(R.id.rcv_listHoa);
        List<Flower> listhoa = new ArrayList<>();
        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa", 10000, "White"));
        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa", 10000, "White"));
        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa", 10000, "White"));
        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa", 10000, "White"));
        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa", 10000, "White"));

        // get data to show in RecyclerView
        FlowerAdapter flowerAdapter = new FlowerAdapter(listhoa);
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

        notificationManager.notify(1, builder.build());
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
            case R.id.logoutmenu:
                Intent in = new Intent(ShopPageActivity.this, MainActivity.class);
                startActivity(in);
                return true;
            case R.id.cartmenu:
                Intent in2 = new Intent(ShopPageActivity.this, AddToCart.class);
                startActivity(in2);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // Menu -------------------------------------------------------

}