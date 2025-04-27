package com.example.dishapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewActivity extends AppCompatActivity {

    ListView dishListView;
    Button returnBtn;
    Button openDishBtn;
    String[] dishes = {
            "Spaghetti", "Sushi", "Pizza", "Matoke", "Salad", "Steak", "Curry", "Soup", "Donards", "Capati"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            dishListView = findViewById(R.id.dishListView);
            returnBtn = findViewById(R.id.button);
            openDishBtn = findViewById(R.id.openDishBtn);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_list_item_1, dishes
            );

            dishListView.setAdapter(adapter);

            returnBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ListViewActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            openDishBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ListViewActivity.this, DishActivity.class);
                    startActivity(intent);
                }
            });

            return insets;
        });
    }
}