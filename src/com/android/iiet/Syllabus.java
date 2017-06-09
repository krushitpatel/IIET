package com.android.iiet;

import com.parse.Parse;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Syllabus extends Activity {
	TextView tv;
	String name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.syllabus);
		setTitle("Syllabus");
		ActionBar a=getActionBar();
		  ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		  a.setBackgroundDrawable(c);
		  a.setDisplayHomeAsUpEnabled(true);
		Parse.initialize(this, "poYMZJJD1ZIcnUL8UgBH9nCvniTwEUVU0OCTUUIc","tLhKuGGzvOTRnxc8DhT9zG1g7gscMVULjQvrRHm0");
		tv=(TextView) findViewById(R.id.syllabus);
		Intent i = getIntent();
		name = i.getStringExtra("Syllabus");
		tv.setText(name);
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
