package com.example.babakadhaba.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.babakadhaba.Models.OrdersModel;
import com.example.babakadhaba.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewholder> {

    ArrayList<OrdersModel> list;
    Context context;

    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final OrdersModel model = list.get(position);
        holder.orderImg.setImageResource(model.getOrderImage());
        holder.orderNo.setText(model.getOrderNumber());
        holder.orderName.setText(model.getOrderName());
        holder.price.setText(model.getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        ImageView orderImg;
        TextView orderName,price,orderNo;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            orderImg = itemView.findViewById(R.id.order_img);
            orderName = itemView.findViewById(R.id.order_name);
            price = itemView.findViewById(R.id.order_price);
            orderNo=itemView.findViewById(R.id.order_id);
        }
    }
}
