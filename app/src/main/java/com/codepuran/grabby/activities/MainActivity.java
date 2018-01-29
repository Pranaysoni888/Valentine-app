package com.codepuran.grabby.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codepuran.grabby.Constants;
import com.codepuran.grabby.R;
import com.codepuran.grabby.Request;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView txtValentine;
    private RelativeLayout layoutValentines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtValentine = (TextView) findViewById(R.id.txt_valentine);
        layoutValentines = (RelativeLayout) findViewById(R.id.layout_valentines);

        setSupportActionBar(toolbar);
        if(toolbar!=null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            TextView textView = (TextView) toolbar.findViewById(R.id.txt_toolbar_header);
            textView.setText(getString(R.string.app_name));
            Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/bulletto_killa_regular.ttf");
            textView.setTypeface(typeface);
        }

        layoutValentines.setOnClickListener(this);
        txtValentine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.layout_valentines || v.getId() == R.id.txt_valentine)
        {
            startActivity(new Intent(this,FestivalActivity.class).putExtra(Constants.INTENT_FESTIVAL,"Valentine's Day"));
        }
    }
}
