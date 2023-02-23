package com.example.flowershop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flowershop.R;
import com.example.flowershop.models.Flower;

import java.util.List;

public class FlowerAdapter extends  RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>{
    private List<Flower> listHoa;

    public FlowerAdapter(List<Flower> listHoa) {
        this.listHoa = listHoa;
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
    }

    @Override
    public int getItemCount() {
        if(listHoa != null) return listHoa.size();
        return 0;
    }

    public class FlowerViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgHoa;
        private TextView tvname;
        public FlowerViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHoa = itemView.findViewById(R.id.img_hoa);
            tvname = itemView.findViewById(R.id.tv_nameHoa);
        }
    }
}
