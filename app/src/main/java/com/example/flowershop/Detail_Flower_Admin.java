package com.example.flowershop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.flowershop.models.Flower;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.flowershop.models.Flower;

public class Detail_Flower_Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_detail_flower);
        LinearLayout linearLayout = findViewById(R.id.linear_layout);

        EditText tvNameFlower = findViewById(R.id.tv_name);
        EditText tvColorFlower = findViewById(R.id.tv_color);
        EditText tvPriceFlower = findViewById(R.id.tv_price);
        EditText tvDescriptionFlower = findViewById(R.id.tv_description);
        Button button = (Button) findViewById(R.id.buttonsave);

        Intent intent = getIntent();
        if(intent != null) {
            Bundle bundle = intent.getExtras();
            Flower flower = (Flower) bundle.get("FLOWER");
            tvNameFlower.setText(flower.getName());
            tvColorFlower.setText(flower.getColor());
            tvPriceFlower.setText(Integer.toString(flower.getPrice()));
            tvDescriptionFlower.setText(flower.getDescription());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save new to database
            }
        });
    }
}
