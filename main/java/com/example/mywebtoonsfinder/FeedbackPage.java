package com.example.mywebtoonsfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import java.util.concurrent.TimeUnit;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class FeedbackPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner fav_theme;
    private String selectedTheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_page);

        fav_theme = findViewById(R.id.pickTheme);
        ArrayAdapter<CharSequence> spinner_Theme_Adapter = ArrayAdapter.createFromResource(this,R.array.Themes, android.R.layout.simple_spinner_item);
        spinner_Theme_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fav_theme.setAdapter(spinner_Theme_Adapter);
        fav_theme.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedTheme = adapterView.getItemAtPosition(i).toString();
        ( (TextView)adapterView.getChildAt(0)).setTextColor(Color.WHITE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void submitForm(View view)
    {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.feedbackCover),"Thank you for the feedback", BaseTransientBottomBar.LENGTH_SHORT);
        snackbar.show();
    }

}