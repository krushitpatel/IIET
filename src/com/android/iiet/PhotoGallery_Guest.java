package com.android.iiet;

import com.android.iiet.image.adapter.CustomPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import android.view.MenuItem;

public class PhotoGallery_Guest extends Activity {
	ViewPager mViewPager;
	CirclePageIndicator mIndicator;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_photo_gallery);
		setTitle("PhotoGallery");
		ActionBar a=getActionBar();
		a.setDisplayHomeAsUpEnabled(true);
		ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		a.setBackgroundDrawable(c);
		CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(this);
		int[] mResources = {R.drawable.colg,R.drawable.images,R.drawable.img1,R.drawable.img3,R.drawable.img4,R.drawable.img2};
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mCustomPagerAdapter);
		mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
		mIndicator.setSnap(false);
		mIndicator.setViewPager(mViewPager);
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
          onBackPressed();
        
        }
  return true;
    }
	
}
