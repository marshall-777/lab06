package com.example.lab6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private List<Country> countryList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Country country);
    }

    public CountryAdapter(List<Country> countryList, OnItemClickListener listener) {
        this.countryList = countryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_country, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.countryNameView.setText(country.getCountryName());
        holder.populationView.setText("Population: " + country.getPopulation());

        // Получаем ID ресурса флага
        Context context = holder.itemView.getContext();
        int flagResId = context.getResources().getIdentifier(country.getFlagName(), "mipmap", context.getPackageName());
        if (flagResId != 0) {
            holder.flagView.setImageResource(flagResId);
        }

        holder.itemView.setOnClickListener(v -> listener.onItemClick(country));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView flagView;
        TextView countryNameView, populationView;

        ViewHolder(View itemView) {
            super(itemView);
            flagView = itemView.findViewById(R.id.imageView_flag);
            countryNameView = itemView.findViewById(R.id.textView_countryName);
            populationView = itemView.findViewById(R.id.textView_population);
        }
    }
}
