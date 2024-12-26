package com.example.pizzajava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder> {

    private List<Pizza> pizzaList;
    private OnPizzaClickListener listener;

    public interface OnPizzaClickListener {
        void onPizzaClick(Pizza pizza);
    }

    public PizzaAdapter(List<Pizza> pizzaList, OnPizzaClickListener listener) {
        this.pizzaList = pizzaList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_item, parent, false);
        return new PizzaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder holder, int position) {
        Pizza pizza = pizzaList.get(position);
        holder.bind(pizza, listener);
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    static class PizzaViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView priceTextView;
        private Button addButton;

        public PizzaViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.pizza_name);
            priceTextView = itemView.findViewById(R.id.pizza_price);
            addButton = itemView.findViewById(R.id.add_button);
        }

        public void bind(Pizza pizza, OnPizzaClickListener listener) {
            nameTextView.setText(pizza.getName());
            priceTextView.setText(String.valueOf(pizza.getPrice()) + " руб.");
            addButton.setOnClickListener(v -> listener.onPizzaClick(pizza));
        }
    }
}
