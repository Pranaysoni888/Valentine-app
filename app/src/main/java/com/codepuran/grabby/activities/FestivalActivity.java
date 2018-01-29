package com.codepuran.grabby.activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.codepuran.grabby.Constants;
import com.codepuran.grabby.R;
import com.codepuran.grabby.adapters.DaysAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class FestivalActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listViewDays;
    private DaysAdapter daysAdapter;
    private ArrayList<String> daysList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        listViewDays = (ListView) findViewById(R.id.listview_days);
        daysList = new ArrayList<>();
        daysList.add("Rose Day");
        daysList.add("Propose Day");
        daysList.add("Chocolate Day");
        daysList.add("Teddy Day");
        daysList.add("Promise Day");
        daysList.add("Hug Day");
        daysList.add("Kiss Day");
        daysList.add("Valentine’s Day");

        setSupportActionBar(toolbar);
        if(toolbar != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            TextView textView = (TextView) toolbar.findViewById(R.id.txt_toolbar_header);
            textView.setText(getIntent().getStringExtra(Constants.INTENT_FESTIVAL));
            Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/bulletto_killa_regular.ttf");
            textView.setTypeface(typeface);
        }

        daysAdapter = new DaysAdapter(this, daysList);
        listViewDays.setAdapter(daysAdapter);
    }
}
