package com.example.flowershop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
}