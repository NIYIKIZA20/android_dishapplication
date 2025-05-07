package com.example.dishapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle;

public class DishActivity extends AppCompatActivity {

    ListView dishListView;
    ArrayAdapter<String> adapter;
    private ActionBarDrawerToggle toggle;


    // Shared dish list
    static ArrayList<String> dishes = new ArrayList<>(Arrays.asList(
            "Spaghetti", "Sushi", "Pizza"
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish);

        dishListView = findViewById(R.id.dish_list_view);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishes);
        dishListView.setAdapter(adapter);

        Button openRecyclerButton = findViewById(R.id.button_open_recycler);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        // Handle Navigation Menu Items
        navView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_add_dish) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new AddDishFragment())
                        .addToBackStack(null)
                        .commit();
            } else if (id == R.id.nav_view_dishes) {
                getSupportFragmentManager().popBackStack();
                reloadList();
            } else if (id == R.id.nav_recycler) {
                //  Open RecyclerViewActivity
                Intent intent = new Intent(DishActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }

            drawer.closeDrawer(GravityCompat.START);
            return true;
        });


        openRecyclerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DishActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void reloadList() {
        adapter.notifyDataSetChanged();
    }

    public static void addDish(String newDish) {
        dishes.add(newDish);
    }
}
