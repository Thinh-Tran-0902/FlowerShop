package com.example.flowershop.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.Detail_Flower_Activity;
import com.example.flowershop.Detail_Flower_Admin;
import com.example.flowershop.R;
import com.example.flowershop.models.Flower;

import java.util.List;

public class FlowerAdapter extends  RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>{
    private List<Flower> listHoa;
    private Context context;
    private int roleId;

    public FlowerAdapter(List<Flower> listHoa, Context context, int roleId) {
        this.listHoa = listHoa;
        this.context = context;
        this.roleId = roleId;
    }

    @NonNull
    @Override
    public FlowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rcv_list_hoa, parent, false);
        return new FlowerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerViewHolder holder, int position) {
        Flower flower = listHoa.get(position);
        if(flower == null) return;

        holder.imgHoa.setImageResource(flower.getImg());
        holder.tvname.setText(flower.getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, roleId==1? Detail_Flower_Admin.class : Detail_Flower_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("FLOWER", flower);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listHoa != null) return listHoa.size();
        return 0;
    }

    public class FlowerViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgHoa;
        private TextView tvname;
        private CardView cardView;
        public FlowerViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHoa = itemView.findViewById(R.id.img_hoa);
            tvname = itemView.findViewById(R.id.tv_nameHoa);
            cardView = itemView.findViewById(R.id.cardviewHoa);
        }
    }

    void release(){ context = null; }
}
