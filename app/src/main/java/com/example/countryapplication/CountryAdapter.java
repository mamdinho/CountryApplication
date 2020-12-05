package com.example.countryapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryAdapter extends BaseAdapter {
    ArrayList<Country> arrayList;
    Context context;
    LayoutInflater inflater;

    CountryAdapter(Context cntxt, int textViewResourceId, ArrayList<Country> countryList){
        this.context = cntxt;
        arrayList = countryList;
        inflater = LayoutInflater.from(cntxt); //inflate this inflater from calling activity layout
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.country_image_row, null);
        TextView countryText = convertView.findViewById(R.id.textView);
        ImageView image = convertView.findViewById(R.id.imageView);

        countryText.setText(arrayList.get(position).getCountryName());
        image.setImageResource(arrayList.get(position).getCountryImage());
        return convertView;
    }
}
