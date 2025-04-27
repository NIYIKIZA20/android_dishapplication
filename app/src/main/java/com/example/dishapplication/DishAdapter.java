package com.example.dishapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder> {

    private List<Dish> dishList;

    public DishAdapter(List<Dish> dishList) {
        this.dishList = dishList;
    }

    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dish_item, parent, false);
        return new DishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {
        Dish dish = dishList.get(position);
        holder.textViewDishName.setText(dish.getName());
        holder.textViewDishType.setText("Type: " + dish.getType());
        holder.textViewIsVegetarian.setText("Vegetarian: " + dish.isVegetarian());
    }

    @Override
    public int getItemCount() {
        return dishList.size();
    }

    public static class DishViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDishName, textViewDishType, textViewIsVegetarian;

        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDishName = itemView.findViewById(R.id.textViewDishName);
            textViewDishType = itemView.findViewById(R.id.textViewDishType);
            textViewIsVegetarian = itemView.findViewById(R.id.textViewIsVegetarian);
        }
    }
}
