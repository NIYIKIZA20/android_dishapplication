package com.example.dishapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
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

        // Initialize dishList with real dish names
        dishList = new ArrayList<>();

        String[] dishNames = {
                "Pizza", "Burger", "Soup", "Salad", "Pasta",
                "Sushi", "Steak", "Tacos", "Sandwich", "Curry",
                "Noodles", "Fried Rice", "Dumplings", "Lasagna", "Biryani",
                "Chow Mein", "Hotdog", "Wrap", "Grilled Cheese", "Quiche"
        };

        for (int i = 0; i < dishNames.length; i++) {
            dishList.add(new Dish(dishNames[i], i % 3, i % 2 == 1));
        }

        // Then: Set adapter
        dishAdapter = new DishAdapter(dishList);
        recyclerView.setAdapter(dishAdapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

}
