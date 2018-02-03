package com.codepuran.grabby.activities;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.codepuran.grabby.Constants;
import com.codepuran.grabby.R;
import com.codepuran.grabby.Request;
import com.codepuran.grabby.adapters.PostsAdapter;
import com.codepuran.grabby.dto.TextDaysDTO;
import com.codepuran.grabby.listeners.ResponseListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PostsActivity extends AppCompatActivity implements ResponseListener{

    private ListView listViewTextPosts;
    private int selectedDay;
    private Toolbar toolbar;
    private ArrayList<String> daysList;
    private ProgressDialog progressDialog;
    private Gson gson;
    ArrayList<TextDaysDTO> textDaysDTOs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        selectedDay = getIntent().getIntExtra(Constants.INTENT_DAYS,0);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait");

        gson = new GsonBuilder().create();


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
            textView.setText(daysList.get(selectedDay));
            Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/bulletto_killa_regular.ttf");
            textView.setTypeface(typeface);
        }

        listViewTextPosts = (ListView) findViewById(R.id.listview_text_posts);

        if(progressDialog != null) {
            progressDialog.show();
            Request.makeStringRequest(Constants.MAIN_URL + String.valueOf(selectedDay + 1), this);
        }

    }

    @Override
    public void notifySuccess(String response, String url) {

        if(response != null)
        {
            Type collectionType = new TypeToken<ArrayList<TextDaysDTO>>() {}.getType();
            textDaysDTOs = gson.fromJson(response,collectionType);
            PostsAdapter postsAdapter = new PostsAdapter(this,textDaysDTOs);
            listViewTextPosts.setAdapter(postsAdapter);

            if(progressDialog != null && progressDialog.isShowing())
            {
                progressDialog.dismiss();
            }
        }

    }

    @Override
    public void notifyError(VolleyError error, String url) {

        Toast.makeText(this,error.toString(),Toast.LENGTH_LONG).show();

    }
}
