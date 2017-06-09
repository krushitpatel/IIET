package com.android.iiet.image.adapter;

import java.util.ArrayList;
import java.util.List;


import com.android.iiet.Notice_GetSet;

import com.android.iiet.Notice_SingleItemView;
import com.android.iiet.R;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Notice_ListAdapter extends BaseAdapter{
	Context context;
	  TextView name;
	  LayoutInflater inflater;
	     private List<Notice_GetSet> details=null;
	     private ArrayList<Notice_GetSet> arraylist;
	 
	     public Notice_ListAdapter(Context context, List<Notice_GetSet> details) {

	  	   this.context = context;
	  	   this.details=details;
	  	   inflater = LayoutInflater.from(context);
	  	    this.arraylist = new ArrayList<Notice_GetSet>();
	  	       this.arraylist.addAll(details);
	  	   
	  	  }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return details.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return details.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		   if (convertView == null) {
		          LayoutInflater mInflater = (LayoutInflater)
		                     context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		          convertView = mInflater.inflate(R.layout.listview, null);
		          name = (TextView) convertView.findViewById(R.id.list);     
		         name.setText(details.get(position).getDetails());
		  }
		  
		return convertView;
	}

}
