package com.android.iiet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
public class Splash extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		
	getActionBar().hide();
		Thread t=new Thread()
		{
			public void run()
			{
				try
				{
					sleep(1000);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					Intent i=new Intent(Splash.this,LoginCheck.class);
					startActivity(i);
				}
			}
		};
		t.start();
	}

	private void setActionBar(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	}

