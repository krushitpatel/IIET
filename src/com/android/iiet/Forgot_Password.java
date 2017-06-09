package com.android.iiet;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Forgot_Password extends Activity implements OnClickListener{
	EditText et;
	Button btn;
	ProgressDialog dialog;
	String sEmail;
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgot_password);
		ActionBar a=getActionBar();
		ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		a.setBackgroundDrawable(c);
		a.setDisplayHomeAsUpEnabled(true);
		et=(EditText) findViewById(R.id.email);
		btn=(Button) findViewById(R.id.send);
		dialog = new ProgressDialog(Forgot_Password.this);
		dialog.setIndeterminate(false);
		btn.setOnClickListener(this);
		
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
		 cd = new ConnectionDetector(getApplicationContext());
			isInternetPresent = cd.isConnectingToInternet();
			if (!isInternetPresent) {
	          // Internet Connection is not present
			
				Toast.makeText(getApplicationContext(), "Internet connection fail", Toast.LENGTH_LONG).show();
				
	        
	          // stop executing code by return
	        
	      }else{
		dialog.show();
		String email=et.getText().toString();
		ParseUser.requestPasswordResetInBackground(email, new RequestPasswordResetCallback() {
			
			@Override
			public void done(ParseException e) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				if (e == null) {
					Toast.makeText(getApplicationContext(), "Email has been successfully sent", Toast.LENGTH_SHORT).show();
				      // An email was successfully sent with reset instructions.
				    } else {
				    	Toast.makeText(getApplicationContext(), "Something went wrong !", Toast.LENGTH_SHORT).show();
				      // Something went wrong. Look at the ParseException to see what's up.
				    }
			}
		});
	      }
	}



}
