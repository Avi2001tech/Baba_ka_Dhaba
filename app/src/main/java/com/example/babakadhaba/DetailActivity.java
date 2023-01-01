
package com.example.babakadhaba;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.babakadhaba.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DBHelper helper = new DBHelper(this);

        if(getIntent().getIntExtra("type",0)==1) {
            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            String name = getIntent().getStringExtra("name");
            String description = getIntent().getStringExtra("desc");

            binding.detailImg.setImageResource(image);
            binding.orderPrice.setText(String.format("%d", price));
            binding.detailFoodName.setText(name);
            binding.detailDesc.setText(description);


            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean isInserted = helper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );
                    if (isInserted)
                        Toast.makeText(DetailActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });
        } else{
            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
            final int image = cursor.getInt(4);
            binding.detailImg.setImageResource(image);
            binding.orderPrice.setText(String.format("%d",cursor.getInt(3)));
            binding.detailFoodName.setText(cursor.getString(6));
            binding.detailDesc.setText(cursor.getString(5));

            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertBtn.setText("Update now");
            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isUpdated =helper.updateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.orderPrice.getText().toString()),
                            image,
                            binding.detailDesc.getText().toString(),
                            binding.detailFoodName.getText().toString(),
                            1,
                            id);
                    if(isUpdated){
                        Toast.makeText(DetailActivity.this, "successfully updated", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(DetailActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }


                }
            });

        }
    }
}