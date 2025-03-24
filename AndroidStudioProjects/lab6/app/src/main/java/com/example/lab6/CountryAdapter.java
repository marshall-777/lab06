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
    private List<Country> listData;
    private Context context;

    public CountryAdapter(Context context, List<Country> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = listData.get(position);
        holder.countryNameView.setText(country.getCountryName());
        holder.populationView.setText("Population: " + country.getPopulation());

        int imageId = context.getResources().getIdentifier(country.getFlagName(), "mipmap", context.getPackageName());
        holder.flagView.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView flagView;
        TextView countryNameView, populationView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flagView = itemView.findViewById(R.id.imageView_flag);
            countryNameView = itemView.findViewById(R.id.textView_countryName);
            populationView = itemView.findViewById(R.id.textView_population);
        }
    }
}
