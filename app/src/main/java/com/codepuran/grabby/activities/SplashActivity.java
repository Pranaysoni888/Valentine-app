package com.codepuran.grabby.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.codepuran.grabby.Constants;
import com.codepuran.grabby.R;

public class SplashActivity extends AppCompatActivity {

    private TextView txtAppLogo,txtDevIndia;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txtAppLogo = (TextView) findViewById(R.id.txt_app_title);
        txtDevIndia = (TextView) findViewById(R.id.txt_developed_in_india);

        Typeface bullettoKillaRegularFont = Typeface.createFromAsset(getAssets(),"fonts/bulletto_killa_regular.ttf");
        Typeface harleyScriptRegularFont = Typeface.createFromAsset(getAssets(),"fonts/harley_script_regular.ttf");
        txtAppLogo.setTypeface(bullettoKillaRegularFont);
        txtDevIndia.setTypeface(harleyScriptRegularFont);

        new  Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        }, Constants.SPLASH_TIME_OUT);
    }
}
