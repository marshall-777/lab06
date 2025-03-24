package com.example.lab6;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Country> countryList = getListData();
        CountryAdapter adapter = new CountryAdapter(this, countryList);
        recyclerView.setAdapter(adapter);
    }

    private List<Country> getListData() {
        List<Country> list = new ArrayList<>();
        list.add(new Country("Vietnam", "vn", 98000000));
        list.add(new Country("United States", "us", 320000000));
        list.add(new Country("Russia", "ru", 142000000));
        return list;
    }
}
