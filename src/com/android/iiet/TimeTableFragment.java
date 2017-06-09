package com.android.iiet;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class TimeTableFragment extends Fragment implements OnClickListener{
	Button first,second,third,forth;
	String s;
	public TimeTableFragment(){}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootview =inflater.inflate(R.layout.fragment_timetable, container, false);
		
		first=(Button) rootview.findViewById(R.id.first);
		second=(Button) rootview.findViewById(R.id.second);
		third=(Button) rootview.findViewById(R.id.third);
		forth=(Button) rootview.findViewById(R.id.fourth);
		first.setOnClickListener(this);
		second.setOnClickListener(this);
		third.setOnClickListener(this);
		forth.setOnClickListener(this);
		return rootview;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		s=((Button)v).getText().toString();
		Intent i=new Intent(getActivity(),Image_Branch.class);
		i.putExtra("name", s);
		startActivity(i);
	}
}
