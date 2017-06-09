package com.android.iiet.image.adapter;


import android.annotation.SuppressLint;
import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.TextView;


import com.android.iiet.R;

public class YoutubeCustomListAdapter extends BaseAdapter{
	private final Activity context;
	  private final String[] values;
	  TextView name;
	  LayoutInflater inflater;
	 
	       
	  
	  public YoutubeCustomListAdapter(Activity context, String[] values) {
		 
	   this.context = context;
	   this.values=values;
	  }
	 

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return values.length;
	}



	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}


	@SuppressLint({ "ViewHolder", "InflateParams" })
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		inflater=context.getLayoutInflater();
		View v=inflater.inflate(R.layout.youtube_text, null,true);
		name=(TextView) v.findViewById(R.id.text);
		name.setText(values[position]);
		return v;
	}
}
