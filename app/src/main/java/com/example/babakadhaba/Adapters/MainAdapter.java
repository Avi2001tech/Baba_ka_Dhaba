package com.example.babakadhaba.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.babakadhaba.Models.MainModel;
import com.example.babakadhaba.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder> {

    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food_sample,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final MainModel model = list.get(position);
        holder.foodImage.setImageResource(model.getImage());
        holder.foodName.setText(model.getName());
        holder.foodPrice.setText(model.getPrice());
        holder.foodDesc.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView foodName,foodPrice,foodDesc;


        public viewholder(@NonNull View itemView) {
            super(itemView);

            foodImage=itemView.findViewById(R.id.food_image);
            foodName=itemView.findViewById(R.id.food_name);
            foodPrice=itemView.findViewById(R.id.food_price);
            foodDesc=itemView.findViewById(R.id.food_desc);
        }
    }
}
