package com.example.flowershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.flowershop.models.Flower;

public class Detail_Flower_Activity extends AppCompatActivity {

    Button btnAddToCart ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_flower);
        LinearLayout linearLayout = findViewById(R.id.linear_layout);

        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add to cart trong Db
            }
        });

        TextView tvNameFlower = findViewById(R.id.tv_name);
        TextView tvColorFlower = findViewById(R.id.tv_color);
        TextView tvPriceFlower = findViewById(R.id.tv_price);
        TextView tvDescriptionFlower = findViewById(R.id.tv_description);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            Flower flower = (Flower) bundle.get("FLOWER");
            tvNameFlower.setText(flower.getName());
            tvColorFlower.setText(flower.getColor());
            tvPriceFlower.setText(Integer.toString(flower.getPrice()));
            tvDescriptionFlower.setText(flower.getDescription());
        }
    }
}