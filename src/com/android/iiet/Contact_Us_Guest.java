package com.android.iiet;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Contact_Us_Guest extends Activity {
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_contact_us);
		setTitle("Contact Us");
		ActionBar a=getActionBar();
		  ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		  a.setBackgroundDrawable(c);
		  a.setDisplayHomeAsUpEnabled(true);
		  btn=(Button) findViewById(R.id.button1);
		  btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			startActivity(new Intent(Contact_Us_Guest.this,Google_Map.class));	
			}
		});
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
