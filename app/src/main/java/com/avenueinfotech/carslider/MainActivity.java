package com.avenueinfotech.carslider;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.avenueinfotech.carslider.adapter.TabsAdapter;

public class MainActivity extends AppCompatActivity {

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //TABS
        mViewPager = (ViewPager) findViewById(R.id.vp_tabs);
        mViewPager.setAdapter( new TabsAdapter( getSupportFragmentManager(), this));

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor( getResources().getColor( R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor( R.color.colorFAB));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mSlidingTabLayout.setViewPager( mViewPager);


    }


}
