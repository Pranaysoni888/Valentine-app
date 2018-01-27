package com.codepuran.grabby.activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.codepuran.grabby.R;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView txtValentine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtValentine = (TextView) findViewById(R.id.txt_valentine);

        setSupportActionBar(toolbar);
        if(toolbar!=null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            TextView textView = (TextView) toolbar.findViewById(R.id.txt_toolbar_header);
            textView.setText(getString(R.string.app_name));
            Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/bulletto_killa_regular.ttf");
            textView.setTypeface(typeface);
        }

    }
}
