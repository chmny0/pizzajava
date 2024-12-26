package com.example.pizzajava;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private ArrayList<Pizza> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        cartItems = (ArrayList<Pizza>) getIntent().getSerializableExtra("cart");

        ListView cartListView = findViewById(R.id.cart_list_view);


        ArrayAdapter<Pizza> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, cartItems);

        cartListView.setAdapter(adapter);
    }
}
