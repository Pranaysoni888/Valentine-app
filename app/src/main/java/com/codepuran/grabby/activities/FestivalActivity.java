package com.codepuran.grabby.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.codepuran.grabby.Constants;
import com.codepuran.grabby.GrabbyUtils;
import com.codepuran.grabby.R;
import com.codepuran.grabby.adapters.DaysAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Arrays;

public class FestivalActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Toolbar toolbar;
    private ListView listViewDays;
    private DaysAdapter daysAdapter;
    private ArrayList<String> daysList;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        listViewDays = (ListView) findViewById(R.id.listview_days);
        mAdView = (AdView) findViewById(R.id.adView);
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
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            TextView textView = (TextView) toolbar.findViewById(R.id.txt_toolbar_header);
            textView.setText(getIntent().getStringExtra(Constants.INTENT_FESTIVAL));
            Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/bulletto_killa_regular.ttf");
            textView.setTypeface(typeface);
        }

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        daysAdapter = new DaysAdapter(this, daysList);
        listViewDays.setAdapter(daysAdapter);

        listViewDays.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(FestivalActivity.this,PostsActivity.class);
        intent.putExtra(Constants.INTENT_DAYS,position);

        if(GrabbyUtils.isNetworkConnected(this)) {
            startActivity(intent);
        }
        else {
            Toast.makeText(this,getString(R.string.no_internet_connection),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
