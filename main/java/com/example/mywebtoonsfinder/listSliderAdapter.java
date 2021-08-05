package com.example.mywebtoonsfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


public class listSliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater currentInflater;

    public listSliderAdapter(Context context)
    {
        this.context = context;
    }

    public int [][] logo = {
            {
                    R.drawable.suitor_armor,
                    R.drawable.god_of_highschool,
                    R.drawable.castle_swimmer,
                    R.drawable.your_throne,
                    R.drawable.omniscent_reader
            },

            {
                    R.drawable.not_even_bones,
                    R.drawable.killstagram,
                    R.drawable.its_mine,
                    R.drawable.shiloh,
                    R.drawable.hardcore_leveling_warrior
            },

            {
                    R.drawable.god_of_highschool,
                    R.drawable.microhunter,
                    R.drawable.elceed,
                    R.drawable.hardcore_leveling_warrior,
                    R.drawable.blood_ink
            },

            {
                    R.drawable.in_the_bleak_midwinter,
                    R.drawable.eggnoid,
                    R.drawable.room_of_swords,
                    R.drawable.rebirth,
                    R.drawable.falling_in_the_blue
            }

    };

    public String [][] name = {
            {
                    "Suitor Armor",
                    "The God of High School",
                    "Castle Swimmer",
                    "Your Throne",
                    "Omniscent Reader"
            },

            {
                    "Not Even Bones",
                    "#Killstagram",
                    "It's Mine",
                    "Shiloh",
                    "Hardcore-Leveling Warrior"
            },

            {
                    "The God of High School",
                    "microHUNTER",
                    "Elceed",
                    "Hardcore-Leveling Warrior",
                    "Blood-Ink"
            },

            {
                    "In the Bleak Midwinter",
                    "Eggnoid",
                    "Room of Swords",
                    "Rebirth",
                    "Falling in the Blue"
            }
    };
    public String [] genre = {
            "Top Series",
            "Top Thriller",
            "Top Action",
            "Top Sci-Fi"
    };

    @Override
    public int getCount() {
        return logo.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        currentInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = currentInflater.inflate(R.layout.listslider,container,false);

        TextView genre_ = (TextView) view.findViewById(R.id.listSliderGenre);

        ImageView sliderImage1 = (ImageView) view.findViewById(R.id.FirstImg);
        ImageView sliderImage2 = (ImageView) view.findViewById(R.id.SecondImg);
        ImageView sliderImage3 = (ImageView) view.findViewById(R.id.ThirdImg);
        ImageView sliderImage4 = (ImageView) view.findViewById(R.id.FourthImg);
        ImageView sliderImage5 = (ImageView) view.findViewById(R.id.FifthImg);


        TextView name1 = view.findViewById(R.id.FirstName);
        TextView name2 = view.findViewById(R.id.SecondName);
        TextView name3 = view.findViewById(R.id.ThirdName);
        TextView name4 = view.findViewById(R.id.FourthName);
        TextView name5 = view.findViewById(R.id.FifthName);

        name1.setText(name[position][0]);
        name2.setText(name[position][1]);
        name3.setText(name[position][2]);
        name4.setText(name[position][3]);
        name5.setText(name[position][4]);

        sliderImage1.setImageResource(logo[position][0]);
        sliderImage2.setImageResource(logo[position][1]);
        sliderImage3.setImageResource(logo[position][2]);
        sliderImage4.setImageResource(logo[position][3]);
        sliderImage5.setImageResource(logo[position][4]);

        genre_.setText(genre[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}

