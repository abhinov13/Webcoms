package com.example.mywebtoonsfinder;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.w3c.dom.Text;

public class imageSliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater currentInflater;

    public imageSliderAdapter(Context context)
    {
        this.context = context;
    }

    public int [] slideImages = {
            R.drawable.omniscent_reader2,
            R.drawable.beetle_hands,
            R.drawable.a_boy_and_his_ghost,
    };

    public String [] title = {
            "Omniscent Reader",
            "Beetle Hands",
            "A boy and his Ghost",
    };

    public String [] description = {
            "An apocalyptic fantasy fiction webnovel, written by a Korean author duo writing under the pen name Sing Shong",
            "All he could see from Kenma was torn flesh, hot blood, and a single, shuddering hand...and an unknown force seems to be gripping onto his friend as if life depended on it. This silent presence...what could it be?",
            "An 80's tale, James’s best friend is a dead girl named Zooey. When Death comes to collect her soul, how far will James go to keep their friendship alive? ",
    };
    @Override
    public int getCount() {
        return slideImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        currentInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = currentInflater.inflate(R.layout.imageslider,container,false);

        ImageView sliderImage = (ImageView) view.findViewById(R.id.image_1);
        TextView title_ = view.findViewById(R.id.imageViewPagerTitle);
        TextView desc = view.findViewById(R.id.imageViewPagerDescription);

        desc.setText(description[position]);
        title_.setText(title[position]);
        sliderImage.setImageResource(slideImages[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }


}
