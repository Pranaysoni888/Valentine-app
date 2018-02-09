package com.codepuran.grabby.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepuran.grabby.R;
import com.codepuran.grabby.dto.TextDaysDTO;

import java.util.ArrayList;

/**
 * Created by parth on 2/3/2018.
 */

public class PostsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<TextDaysDTO> textDaysDTOs;

    public PostsAdapter(Context context, ArrayList<TextDaysDTO> textDaysDTOs) {
        this.context = context;
        this.textDaysDTOs = textDaysDTOs;
    }

    @Override
    public int getCount() {
        return textDaysDTOs.size();
    }

    @Override
    public Object getItem(int position) {
        return textDaysDTOs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.posts_layout,parent,false);

        TextView txtDayName = (TextView) convertView.findViewById(R.id.txt_day_name);
        ImageView imageViewShare = (ImageView) convertView.findViewById(R.id.imgview_share);
        txtDayName.setText(textDaysDTOs.get(position).getStatus());

        imageViewShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, textDaysDTOs.get(position).getStatus());
                context.startActivity(Intent.createChooser(sharingIntent, context.getResources().getString(R.string.share_using)));
            }
        });

        return convertView;
    }
}
