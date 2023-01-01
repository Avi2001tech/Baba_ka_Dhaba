package com.example.babakadhaba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.example.babakadhaba.Adapters.MainAdapter;
import com.example.babakadhaba.Models.MainModel;
import com.example.babakadhaba.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.full_meal_2,"Full plate","250","A full set of meal comprising of parathas and 6 variety of veggies"));
        list.add(new MainModel(R.drawable.veg,"Veg plate","180","A pure veg food meal comprising of rice,dal and sweets"));
        list.add(new MainModel(R.drawable.non_veg_thali,"Non veg plate","290","A complete non veg bowl full of nutrients"));
        list.add(new MainModel(R.drawable.biryani,"Briyani","200","A full plate of briyani with two pieces included"));
        list.add(new MainModel(R.drawable.punjabi,"Punjabi Thali","230","Lassi along with a whole pack of food meal"));
        list.add(new MainModel(R.drawable.south,"South thali","180","Get the taste of south in a full plate"));
        list.add(new MainModel(R.drawable.eggcurry,"Egg Curry","100","One bowl of egg curry with two eggs included"));
        list.add(new MainModel(R.drawable.paneer_tikka,"Paneer tikka","80","Two grilled high chain pieces of paneer"));
        list.add(new MainModel(R.drawable.paratha,"Paratha","60","4 pcs of paratha "));
        list.add(new MainModel(R.drawable.chappati_6_pc,"Roti","30","6 pcs of hot cooked chappati"));
        list.add(new MainModel(R.drawable.gulab_jamun_4pc,"Gulab Jamun","60","4 pcs of mouth watering gulab jamun to make your day"));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}