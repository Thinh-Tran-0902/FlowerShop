package com.example.flowershop;

import android.content.Intent;
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

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //lấy data ở trên insert vào db


                Toast.makeText(AddNew.this, "add new flower success", Toast.LENGTH_SHORT).show();

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