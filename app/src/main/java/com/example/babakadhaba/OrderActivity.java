package com.example.babakadhaba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.babakadhaba.Adapters.OrdersAdapter;
import com.example.babakadhaba.Models.OrdersModel;
import com.example.babakadhaba.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list = helper.getOrders();
        /*list.add(new OrdersModel(R.drawable.veg,"Veg Thali","180","bkd2922"));
        list.add(new OrdersModel(R.drawable.gulab_jamun_4pc,"Gulab Jamun","60","bkd2923"));
        list.add(new OrdersModel(R.drawable.paratha,"Paratha","60","bkd2924"));*/

        OrdersAdapter adapter = new OrdersAdapter(list,this);
        binding.orderRecyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerview.setLayoutManager(layoutManager);





    }
}