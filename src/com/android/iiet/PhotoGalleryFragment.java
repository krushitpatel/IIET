package com.android.iiet;

import com.android.iiet.image.adapter.CustomPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PhotoGalleryFragment extends Fragment {
	ViewPager mViewPager;
	CirclePageIndicator mIndicator;
	 
	public PhotoGalleryFragment(){}
	
	@SuppressWarnings("unused")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootview =inflater.inflate(R.layout.fragment_photo_gallery, container, false);
		CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(getActivity());
		int[] mResources = {R.drawable.colg,R.drawable.images,R.drawable.img1,R.drawable.img3,R.drawable.img4,R.drawable.img2};
		mViewPager = (ViewPager) rootview.findViewById(R.id.pager);
		mViewPager.setAdapter(mCustomPagerAdapter);
		mIndicator = (CirclePageIndicator) rootview.findViewById(R.id.indicator);
		mIndicator.setSnap(false);
		mIndicator.setViewPager(mViewPager);
		return rootview;
	}
	

	
}
