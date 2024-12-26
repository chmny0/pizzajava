package com.example.pizzajava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuActivity extends AppCompatActivity {

    private ArrayList<Pizza> pizzaList;
    private ArrayList<Pizza> cart; // cписок для хранения пицц в корзине

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        pizzaList = new ArrayList<>(Arrays.asList(
                new Pizza("Маргарита", 500),
                new Pizza("Пепперони", 600),
                new Pizza("Гавайская", 700)
        ));

        cart = new ArrayList<>();

        ListView listView = findViewById(R.id.pizza_list_view);

        ArrayAdapter<Pizza> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, pizzaList);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {
            Pizza selectedPizza = pizzaList.get(position);
            addToCart(selectedPizza);
        });

        Button cartButton = findViewById(R.id.cart_button);
        cartButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, CartActivity.class);
            intent.putExtra("cart", cart);
            startActivity(intent);
        });
    }

    private void addToCart(Pizza pizza) {
        cart.add(pizza);
    }
}
