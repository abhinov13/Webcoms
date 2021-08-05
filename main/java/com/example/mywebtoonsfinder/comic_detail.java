package com.example.mywebtoonsfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class comic_detail extends AppCompatActivity {
    String titleSent;
    String targetLink;
    public String[] possibleTitles = {
        "Omniscent Reader",
        "Beetle Hands",
        "A boy and his Ghost"
    };
    public String[] links = {
            "https://www.webtoons.com/en/fantasy/omniscient-reader/list?title_no=2154",
            "https://www.webtoons.com/en/horror/beetle-hands/list?title_no=2247",
            "https://www.webtoons.com/en/challenge/a-boy-and-his-ghost/list?title_no=348123"
    };
    public String[] desc =
    {
            "Back then, Dokja had no idea. He had no idea his favorite web novel 'Three Ways to Survive the Apocalypse' was going to come to life, and that he would become the only person to know how the world was going to end. He also had no idea he would end up becoming the protagonist of this novel-turned-reality. Now, Dokja will go on a journey to change the course of the story and save humankind once and for all.",
            "All he could see from Kenma was torn flesh, hot blood, and a single, shuddering hand...and an unknown force seems to be gripping onto his friend as if life depended on it. This silent presence...what could it be?",
            "James’s best friend is a dead girl named Zooey. When Death comes to collect her soul, how far will James go to keep their friendship alive? An epic 80’s tale that covers five years in the life of A Boy and His Ghost. From Author/Illustrator Rubin Pingk. Updates at least monthly. (Sometimes more.)"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);

        Intent i = getIntent();
        titleSent = i.getStringExtra(MainActivity.TAG);

        ImageView titleImg = findViewById(R.id.titleImage);
        TextView titleName = findViewById(R.id.curTitle);
        TextView titleDesc = findViewById(R.id.title_description);
        titleName.setText(titleSent);

        if(titleSent.equals(possibleTitles[0]))
        {
            targetLink = links[0];
            titleImg.setImageResource(R.drawable.omniscent_reader2);
            titleDesc.setText(desc[0]);
        }
        else if(titleSent.equals(possibleTitles[1]))
        {
            targetLink = links[1];
            titleImg.setImageResource(R.drawable.beetle_hands);
            titleDesc.setText(desc[1]);

        }
        else
        {
            targetLink = links[2];
            titleImg.setImageResource(R.drawable.a_boy_and_his_ghost);
            titleDesc.setText(desc[2]);
        }
    }
    public void goToSite(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(targetLink));
        startActivity(i);
    }

}