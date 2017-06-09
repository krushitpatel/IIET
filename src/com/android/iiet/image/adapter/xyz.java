package com.android.iiet.image.adapter;

import java.util.ArrayList;
	import java.util.List;
	import	com.android.iiet.*; 
	import android.content.Context;
	import android.content.Intent;
	import android.view.LayoutInflater;
	import android.view.View;
	import android.view.ViewGroup;
	import android.view.View.OnClickListener;
	import android.widget.BaseAdapter;
	import android.widget.ImageView;
	import android.widget.TextView;

	

	public class xyz extends BaseAdapter {
		Context context;
		TextView t1,t2,t3,t4,t5;
		
		LayoutInflater inflater;
	    private List<gsmethod> menu_list=null;
	    private ArrayList<gsmethod> arraylist;
	    public xyz(Context context, List<gsmethod> menu_list) {

			this.context = context;
			this.menu_list=menu_list;
			inflater = LayoutInflater.from(context);
			 this.arraylist = new ArrayList<gsmethod>();
		     this.arraylist.addAll(menu_list);
		  
		     }	
	    
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return menu_list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return menu_list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position,View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater)
	                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			     convertView = mInflater.inflate(R.layout.result_next, null);
			}
			t1=(TextView) convertView.findViewById(R.id.textView1);
			t2=(TextView) convertView.findViewById(R.id.textView2);
			t3=(TextView) convertView.findViewById(R.id.textView3);
			t4=(TextView) convertView.findViewById(R.id.textView4);
			t5=(TextView) convertView.findViewById(R.id.textView5);

			t1.setText(String.valueOf(menu_list.get(position).getRoll_no()));
			t2.setText(menu_list.get(position).getMaths1());
			t3.setText(menu_list.get(position).getPhysics());
			t4.setText(menu_list.get(position).getMos());
			t5.setText(menu_list.get(position).getEg());

	     return convertView;
	}
		
	
	

}
