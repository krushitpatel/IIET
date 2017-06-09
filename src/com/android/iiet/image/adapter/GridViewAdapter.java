package com.android.iiet.image.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.android.iiet.R;
import com.android.iiet.SingleItemView;
import com.android.iiet.TimeTableGetSet;


public class GridViewAdapter extends BaseAdapter{
	Context context;
	LayoutInflater inflater;
	ImageLoader imageLoader;
	private List<TimeTableGetSet> phonearraylist = null;
	private ArrayList<TimeTableGetSet> arraylist;
	public GridViewAdapter(Context context, List<TimeTableGetSet> phonearraylist) {
		this.context = context;
		this.phonearraylist = phonearraylist;
		inflater = LayoutInflater.from(context);
		this.arraylist = new ArrayList<TimeTableGetSet>();
		this.arraylist.addAll(phonearraylist);
		imageLoader = new ImageLoader(context);
	}
	public class ViewHolder {
		ImageView photo;
	
		}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return phonearraylist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return phonearraylist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder holder;
		if (convertView == null) {
		holder = new ViewHolder();
		convertView = inflater.inflate(R.layout.gridview_item, null);
		// Locate the ImageView in gridview_item.xml
		holder.photo = (ImageView) convertView.findViewById(R.id.photo);
		holder.photo.setScaleType(ImageView.ScaleType.CENTER_CROP);
		convertView.setLayoutParams(new GridView.LayoutParams(100, 100));
		convertView.setTag(holder);
		} else {
		holder = (ViewHolder) convertView.getTag();
		}
		// Load image into GridView
		imageLoader.DisplayImage(phonearraylist.get(position).getPhotos(),holder.photo);
		
		convertView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(context, SingleItemView.class);
				// Pass all data photo
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.putExtra("photo", phonearraylist.get(position).getPhotos());
				
				context.startActivity(intent);
			}
		});
		// Capture GridView item click
		
		return convertView;
	}
}

