package com.android.iiet;







import org.json.JSONObject;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class PushNotification extends Activity{
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.push);
		ActionBar a=getActionBar();
		ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		a.setBackgroundDrawable(c);
		a.setDisplayHomeAsUpEnabled(true);
		tv=(TextView) findViewById(R.id.push);
		try{
		 Bundle b = getIntent().getExtras(); 
	        JSONObject jsonObject = new JSONObject(b.getString("com.parse.Data"));
	        Toast.makeText(getApplicationContext(), "" + jsonObject.getString("alert"), Toast.LENGTH_LONG).show();
	        String data=jsonObject.getString("alert");
	        tv.setText(data);
		}catch(Exception e){
			e.printStackTrace();
		}
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
