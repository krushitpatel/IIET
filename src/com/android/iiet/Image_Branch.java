package com.android.iiet;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Image_Branch extends Activity implements OnClickListener {
	Button com,ec,eee,mec,auto,civil;
	String s1,s2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image__branch);
		setTitle("Branch");
		ActionBar a=getActionBar();
		a.setDisplayHomeAsUpEnabled(true);
		ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		a.setBackgroundDrawable(c);
		com=(Button) findViewById(R.id.comp1);
		ec=(Button) findViewById(R.id.ec1);
		eee=(Button) findViewById(R.id.eee1);
		mec=(Button) findViewById(R.id.mech1);
		auto=(Button) findViewById(R.id.auto1);
		civil=(Button) findViewById(R.id.civil1);
		Intent i1=getIntent();
		s1=i1.getStringExtra("name");
		com.setOnClickListener(this);
		ec.setOnClickListener(this);
		eee.setOnClickListener(this);
		mec.setOnClickListener(this);
		auto.setOnClickListener(this);
		civil.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		s2=((Button)v).getText().toString();
		Intent i=new Intent(Image_Branch.this,TimeTableData.class);
		i.putExtra("name2", s2);
		i.putExtra("name", s1);
		startActivity(i);
		
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

