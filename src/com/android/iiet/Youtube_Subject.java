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

public class Youtube_Subject extends Activity implements OnClickListener{
	Button btn,btn1,btn2,btn3,btn4;
	String str,str1,str2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.youtube_subject);
		btn=(Button) findViewById(R.id.t1);
		btn1=(Button) findViewById(R.id.t2);
		btn2=(Button) findViewById(R.id.t3);
		btn3=(Button) findViewById(R.id.t4);
		btn4=(Button) findViewById(R.id.t5);
		btn.setOnClickListener(this);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		Intent i=getIntent();
		str=i.getStringExtra("key");
		str1=i.getStringExtra("data");
		
		 ActionBar a=getActionBar();
		 ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		 a.setBackgroundDrawable(c);
		 a.setDisplayHomeAsUpEnabled(true);
		 setTitle("Tutorial");
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
		str2=((Button)v).getText().toString();
		Intent i=new Intent(Youtube_Subject.this,Youtube_webview.class);
		i.putExtra("content", str2);
		i.putExtra("key", str);
		i.putExtra("data", str1);
		startActivity(i);
	}
	
}
