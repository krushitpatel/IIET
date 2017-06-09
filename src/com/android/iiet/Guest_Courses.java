package com.android.iiet;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.ListView;
import com.android.iiet.image.adapter.*;
public class Guest_Courses extends Activity {
	ListView lv;
	String[] data={"Automobile Engineering","Civil Engineering","Computer Engineering","Electrical Engineering","Electronics and Communication","Mechanical Engineering"};
	String[] data1={"60 seats","60 seats","60 seats","60 seats","60 seats","120 seats"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guest_courses);
		ActionBar a=getActionBar();
		a.setDisplayHomeAsUpEnabled(true);
		ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		a.setBackgroundDrawable(c);
		setTitle("Courses");
		lv=(ListView) findViewById(R.id.listView1);
		Guest_CustomListAdapter gc=new Guest_CustomListAdapter(this,data,data1);
		lv.setAdapter(gc);
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
