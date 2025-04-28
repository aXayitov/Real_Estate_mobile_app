package com.example.real_estate.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.real_estate.Adapter.ListItemsAdapter;
import com.example.real_estate.Domain.PropertyDomain;
import com.example.real_estate.R;
import com.example.real_estate.databinding.ActivityMainBinding;
import com.example.real_estate.databinding.ActivityProfileBinding;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initLast();
        initBottomMenu();
    }

    private void initBottomMenu() {
        binding.bottomMenu.setOnItemSelectedListener(i -> {
            if(i==R.id.profile) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            };
        });
    }

    private void initLast() {
        ArrayList<PropertyDomain> items = new ArrayList<>();

        items.add(new PropertyDomain(
                "Apartment",
                "Modern City Apartment",
                "123 Main St, New York",
                "pic_1",
                350000,
                2,
                1,
                1200,
                true,
                4.5,
                "Beautiful modern apartment in the heart of the city with great views."
        ));

        // 2-uy
        items.add(new PropertyDomain(
                "House",
                "Cozy Suburban House",
                "456 Oak Ave, Boston",
                "pic_2",
                450000,
                3,
                2,
                1800,
                true,
                4.7,
                "Lovely family home with spacious backyard and garage."
        ));

        // 3-uy
        items.add(new PropertyDomain(
                "Villa",
                "Luxury Beach Villa",
                "789 Beach Blvd, Miami",
                "pic_3",
                1200000,
                5,
                4,
                3200,
                true,
                4.9,
                "Stunning beachfront property with private pool and ocean views."
        ));

        // 4-uy
        items.add(new PropertyDomain(
                "Condo",
                "Downtown Luxury Condo",
                "101 Skyline Dr, Chicago",
                "pic_4",
                650000,
                2,
                2,
                1500,
                false,
                4.3,
                "High-end condo with premium amenities and concierge service."
        ));

        // 5-uy
        items.add(new PropertyDomain(
                "Townhouse",
                "Charming Townhouse",
                "202 Elm St, Seattle",
                "pic_5",
                380000,
                3,
                2,
                1600,
                false,
                4.2,
                "Quiet neighborhood townhouse with modern interior."
        ));
        binding.viewList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.viewList.setAdapter(new ListItemsAdapter(items));
    }
}