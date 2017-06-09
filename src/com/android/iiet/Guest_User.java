package com.android.iiet;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Guest_User extends Activity implements OnClickListener {
	ImageView i1,i2,i3,i4,i5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guest__user);
		 	i1=(ImageView)findViewById(R.id.img1);
	        i2=(ImageView)findViewById(R.id.img2);
	        i3=(ImageView)findViewById(R.id.img3);
	        i4=(ImageView)findViewById(R.id.img4);
	        i5=(ImageView)findViewById(R.id.img5);
	        i1.setOnClickListener(this);
	        i2.setOnClickListener(this);
	        i3.setOnClickListener(this);
	        i4.setOnClickListener(this);
	        i5.setOnClickListener(this);
	    
	      
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
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.img1:
			startActivity(new Intent(getApplicationContext(),Contact_Us_Guest.class));
			break;
		case R.id.img2:
			startActivity(new Intent(getApplicationContext(),AboutUs_guest.class));
			break;
		case R.id.img3:
			startActivity(new Intent(getApplicationContext(),PhotoGallery_Guest.class));
			break;
		case R.id.img4:
			startActivity(new Intent(getApplicationContext(),Pdf.class));
			break;
		case R.id.img5:
			startActivity(new Intent(getApplicationContext(),Guest_Courses.class));
			break;
		default:
			break;
		}
	}
	
}
