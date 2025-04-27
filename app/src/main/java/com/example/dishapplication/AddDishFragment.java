package com.example.dishapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;


public class AddDishFragment extends Fragment {

    EditText inputDish;
    Button btnAddDish;

    public AddDishFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_dish, container, false);
        inputDish = view.findViewById(R.id.input_dish);
        btnAddDish = view.findViewById(R.id.btn_add_dish);

        btnAddDish.setOnClickListener(v -> {
            String newDish = inputDish.getText().toString().trim();
            if (!newDish.isEmpty()) {
                DishActivity.addDish(newDish);
                requireActivity().getSupportFragmentManager().popBackStack();
                ((DishActivity) requireActivity()).reloadList();
            } else {
                Toast.makeText(getContext(), "Enter a dish name", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
