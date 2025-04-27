package com.example.dishapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    DishAdapter dishAdapter;
    List<Dish> dishList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // First: Create and populate dishList
        dishList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            dishList.add(new Dish("Dish " + i, i % 3, i % 2 == 0)); // Randomize types and vegetarian
        }

        // Then: Set adapter
        dishAdapter = new DishAdapter(dishList);
        recyclerView.setAdapter(dishAdapter);

        // Add dividers
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

}
