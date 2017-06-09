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
import android.widget.Toast;

public class Civil_Youtube_List extends Activity implements OnClickListener{
	Button cp;
	String str,str1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.civil_youtube_list);
		ActionBar a=getActionBar();
		  ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		  a.setBackgroundDrawable(c);
		  a.setDisplayHomeAsUpEnabled(true);
		  setTitle("Subjects");	
		  cp=(Button) findViewById(R.id.cp);
		  cp.setOnClickListener(this);
		  Intent i=getIntent();
		  str=i.getStringExtra("key");
		
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
		str1=((Button)v).getText().toString();
		Intent i=new Intent(Civil_Youtube_List.this,Youtube_Subject.class);
		i.putExtra("key", str);
		i.putExtra("data", str1);
		startActivity(i);
	}
}
