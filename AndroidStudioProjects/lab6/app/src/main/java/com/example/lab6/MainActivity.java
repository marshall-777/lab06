package com.example.lab6;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Country> image_details = getListData();
        final ListView listView = findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object obj = listView.getItemAtPosition(position);
                Country country = (Country) obj;
                Toast.makeText(MainActivity.this, "Selected: " + country.getCountryName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<Country> getListData() {
        List<Country> list = new ArrayList<>();
        list.add(new Country("Vietnam", "vn", 98000000));
        list.add(new Country("United States", "us", 320000000));
        list.add(new Country("Russia", "ru", 142000000));
        return list;
    }
}
