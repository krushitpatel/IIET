package com.android.iiet;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class AboutUs_guest extends Activity {
	private Toolbar mToolbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		setTitle("About Us");
		
		 ActionBar a=getActionBar();
	  	  ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
	  	  a.setBackgroundDrawable(c);
	  	  a.setDisplayHomeAsUpEnabled(true);
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
