package com.avenueinfotech.carslider.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.avenueinfotech.carslider.R;
import com.avenueinfotech.carslider.fragments.CarFragment;
import com.avenueinfotech.carslider.fragments.LuxuryCarFragment;
import com.avenueinfotech.carslider.fragments.OldCarFragment;
import com.avenueinfotech.carslider.fragments.PopularCarFragment;
import com.avenueinfotech.carslider.fragments.SportCarFragment;

/**
 * Created by suken on 13-01-2017.
 */

public class TabsAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles = {"Todos", "Luxo", "Sport", "Colecionador", "Popular"};
    private int[] icons = new int[]{R.drawable.car1_i, R.drawable.car2_i, R.drawable.car4_i, R.drawable.car5_i, R.drawable.car_i};
    private int heightIcon;

    public TabsAdapter(FragmentManager fm, Context c) {
        super(fm);

        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon = (int)( 24 * scale + 0.5f );
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        if(position == 0){
            frag = new CarFragment();
        }
        else  if(position == 1){
            frag = new LuxuryCarFragment();
        }
        else  if(position == 2){
            frag = new SportCarFragment();
        }else  if(position == 3){
            frag = new OldCarFragment();
        }else  if(position == 4){
            frag = new PopularCarFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);

        frag.setArguments(b);

        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable d;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            d = mContext.getDrawable(icons[position]);
        }else {
            d = mContext.getResources().getDrawable(icons[position]);
        }
        d.setBounds(0,0,heightIcon,heightIcon);

        ImageSpan is = new ImageSpan( d );

        SpannableString sp = new SpannableString(" ");
        sp.setSpan( is, 0, sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return ( sp);
    }
}
