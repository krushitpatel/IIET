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

public class Youtube_Branch extends Activity implements OnClickListener {
	Button comp,civil,mech,eee,ec,auto;
	String s;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_youtube__branch);
		comp=(Button) findViewById(R.id.comp);
		civil=(Button) findViewById(R.id.civil);
		mech=(Button) findViewById(R.id.mech);
		eee=(Button) findViewById(R.id.eee);
		ec=(Button) findViewById(R.id.ec);
		auto=(Button) findViewById(R.id.auto);
		comp.setOnClickListener(this);
		civil.setOnClickListener(this);
		mech.setOnClickListener(this);
		eee.setOnClickListener(this);
		ec.setOnClickListener(this);
		auto.setOnClickListener(this);
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
		switch(v.getId()){
		case R.id.comp:
		s=((Button)v).getText().toString();
		Intent i=new Intent(Youtube_Branch.this,Computer_Youtube_List.class);
		i.putExtra("key", s);
		startActivity(i);
		break;
		case R.id.civil:
			s=((Button)v).getText().toString();
			Intent civil=new Intent(Youtube_Branch.this,Civil_Youtube_List.class);
			civil.putExtra("key", s);
			startActivity(civil);
			break;
		case R.id.mech:
			s=((Button)v).getText().toString();
			Intent mech=new Intent(Youtube_Branch.this,Mechanical_Youtube_List.class);
			mech.putExtra("key", s);
			startActivity(mech);
			break;
		case R.id.auto:
			s=((Button)v).getText().toString();
			Intent auto=new Intent(Youtube_Branch.this,Automobile_Youtube_List.class);
			auto.putExtra("key", s);
			startActivity(auto);
			break;
		case R.id.eee:
			s=((Button)v).getText().toString();
			Intent eee=new Intent(Youtube_Branch.this,Electrical_Youtube_List.class);
			eee.putExtra("key", s);
			startActivity(eee);
			break;
		case R.id.ec:
			s=((Button)v).getText().toString();
			Intent ec=new Intent(Youtube_Branch.this,Ec_Youtube_List.class);
			ec.putExtra("key", s);
			startActivity(ec);
			break;
		}
	}
}
