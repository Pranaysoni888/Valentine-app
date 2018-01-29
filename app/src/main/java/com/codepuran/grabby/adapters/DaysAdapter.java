package com.codepuran.grabby.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.codepuran.grabby.R;

import java.util.ArrayList;

/**
 * Created by parth on 1/29/2018.
 */

public class DaysAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<String> daysList;

    public DaysAdapter(Context context, ArrayList<String> daysList) {
        this.context = context;
        this.daysList = daysList;
    }

    @Override
    public int getCount() {
        return daysList.size();
    }

    @Override
    public Object getItem(int position) {
        return daysList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*DaysViewHolder daysViewHolder;

        if(daysViewHolder == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            daysViewHolder = new DaysViewHolder();

        }
        else
        {

        }*/
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.days_layout,parent,false);

        TextView txtDayName = (TextView) convertView.findViewById(R.id.txt_day_name);
        txtDayName.setText(daysList.get(position));

        return convertView;
    }


    private class DaysViewHolder
    {

    }
}
