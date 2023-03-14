package com.example.flowershop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa 1", 10000, "White",
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
                        " ra thưởng thức. Cánh hoa nhỏ dài và rất nhiều cánh nở bung hút mắt"));
        listhoa.add(new Flower(1, 1, 1, R.drawable.flower, "Hoa 1", 10000, "White",
                "Những bông hoa trắng muốt thơm ngào ngạt khiến vua chúa thời xưa cũng phải hạ mình" +
                        " ra thưởng thức. Cánh hoa nhỏ dài và rất nhiều cánh nở bung hút mắt"));

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