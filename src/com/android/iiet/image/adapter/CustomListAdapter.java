package com.android.iiet.image.adapter;

import java.util.ArrayList;
import java.util.List;

import com.android.iiet.GetSet;
import com.android.iiet.R;

import android.annotation.SuppressLint;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter{
	 Context context;
	  TextView name;
	  LayoutInflater inflater;
	     private List<GetSet> subjectname=null;
	     private ArrayList<GetSet> arraylist;
	 
	       
	  
	  public CustomListAdapter(Context context, List<GetSet> subjectname) {

	   this.context = context;
	   this.subjectname=subjectname;
	   inflater = LayoutInflater.from(context);
	    this.arraylist = new ArrayList<GetSet>();
	       this.arraylist.addAll(subjectname);
	   
	  }
	  @Override
	  public int getCount() {
	   // TODO Auto-generated method stub
	   return subjectname.size();
	  }

	  @Override
	  public Object getItem(int position) {
	   // TODO Auto-generated method stub
	   return subjectname.get(position);
	  }

	  @Override
	  public long getItemId(int position) {
	   // TODO Auto-generated method stub
	   return position;
	  }
	  


	  @SuppressLint("InflateParams")
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	   // TODO Auto-generated method stub
	  
	   if (convertView == null) {
	          LayoutInflater mInflater = (LayoutInflater)
	                     context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	          convertView = mInflater.inflate(R.layout.listview, null);
	          name = (TextView) convertView.findViewById(R.id.list);     
	         name.setText(subjectname.get(position).getSub_name());
	         
	       
	  }
	   return convertView;
	   }
}
