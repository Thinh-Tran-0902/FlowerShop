package com.example.flowershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.flowershop.models.Flower;

public class Detail_Flower_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_flower);
        LinearLayout linearLayout = findViewById(R.id.linear_layout);

        TextView tvNameFlower = findViewById(R.id.tv_name);
        TextView tvColorFlower = findViewById(R.id.tv_color);
        TextView tvPriceFlower = findViewById(R.id.tv_price);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            Flower flower = (Flower) bundle.get("FLOWER");
            tvNameFlower.setText(flower.getName());
            tvColorFlower.setText(flower.getColor());
            tvPriceFlower.setText(Integer.toString(flower.getPrice()));


        }
    }
}