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

public class Guest_CustomListAdapter extends BaseAdapter{
	

	
		 Context context;
		  TextView t1,t2;
		  String[] data,data1;
		  LayoutInflater inflater;
		     
		 
		       
		  
		  public Guest_CustomListAdapter(Context context,String[] data,String[] data1) {

		   this.context = context;
		   this.data=data;
		   this.data1=data1;
		   inflater = LayoutInflater.from(context);
		   
		  }
		  @Override
		  public int getCount() {
		   // TODO Auto-generated method stub
		   return data.length;
		  }

		  @Override
		  public Object getItem(int position) {
		   // TODO Auto-generated method stub
		   return null;
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
		          convertView = mInflater.inflate(R.layout.guest_courses_custom, null);
		          t1 = (TextView) convertView.findViewById(R.id.textView1);  
		          t2 = (TextView) convertView.findViewById(R.id.textView2);
		          t1.setText(data[position]);
		          t2.setText(data1[position]);
		  }
		   return convertView;
		   }
	}


