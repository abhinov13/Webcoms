package com.example.mywebtoonsfinder;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {
    public String currentTitleSelected;
    public static final String TAG = "MainActivity";
    private ViewPager imagePager;
    private ViewPager listPager;

    private listSliderAdapter list_adapter;
    private imageSliderAdapter image_adapter;
    private Toolbar toolbar;
    public String [] titles = {
            "Omniscent Reader",
            "Beetle Hands",
            "A boy and his Ghost",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.action_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //try {
        //    this.getSupportActionBar().hide();//line to remove default title bar at top
        //}
        //catch (NullPointerException exp){
        //    Log.e(TAG, "onCreate: Unable to remove title bar");//logging error
        //}

        imagePager = findViewById(R.id.recommendation);
        image_adapter = new imageSliderAdapter(this);
        imagePager.setAdapter(image_adapter);

        listPager = findViewById(R.id.bestList);
        list_adapter = new listSliderAdapter(this);
        listPager.setAdapter(list_adapter);
    }
    public void goToFeedback(View view)
    {
        Intent i = new Intent(this,FeedbackPage.class);
        startActivity(i);
    }
    public void setUsernameFunction(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View v = getLayoutInflater().inflate(R.layout.username_setter_alert_dialog, null);
        builder.setView(v);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                    EditText newName = v.findViewById(R.id.newUsername);
                    if(newName.getText().length() != 0)
                    setName(newName.getText().toString());
                    else
                        setName("USERNAME");

            }
        });
        AlertDialog d = builder.create();
        d.show();
    }
    public void setName(String name)
    {
        TextView username_ =findViewById(R.id.username);
        username_.setText(name);
    }

    public void actionBarImageButton(View view)
    {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.cover),"Want to proceed to website?", BaseTransientBottomBar.LENGTH_SHORT);
        snackbar.setAction("Proceed",new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse("https://www.webtoons.com/en/"));
                        startActivity(i);
                    }
                }
        );
        snackbar.show();
    }

    public void showDetail(View view)
    {
        Intent i = new Intent(this, comic_detail.class);
        TextView titleHolder = findViewById(R.id.imageViewPagerTitle);
        int pos = imagePager.getCurrentItem();
        String title = titles[pos];

        i.putExtra(TAG, title);
        startActivity(i);
    }

}
