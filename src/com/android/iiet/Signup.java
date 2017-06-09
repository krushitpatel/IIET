
package com.android.iiet;

import com.parse.ParseException;


import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
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

public class Signup extends Activity implements OnClickListener {
	Button b1;
	EditText branch,password,name,enrollment,year,email;
	String usernametext,passwordtext,enrollmenttext,yeartext,branchtext,email_id;
	ProgressDialog dialog;
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		b1=(Button) findViewById(R.id.submit);
		name=(EditText) findViewById(R.id.name);
		enrollment=(EditText) findViewById(R.id.enrollment);
		year=(EditText) findViewById(R.id.year);
		branch=(EditText) findViewById(R.id.branch);
		password=(EditText) findViewById(R.id.password);
		email=(EditText) findViewById(R.id.email);
		b1.setOnClickListener(this);
		setTitle("Signup");
		ActionBar a=getActionBar();
		ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		a.setBackgroundDrawable(c);
		a.setDisplayHomeAsUpEnabled(true);
		
		dialog=new ProgressDialog(Signup.this);
		dialog.setTitle("SignUp");
		dialog.setMessage("Plaese wait...");
		dialog.setIndeterminate(false);
		// Show progressdialog
		
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
		usernametext=name.getText().toString();
		passwordtext=password.getText().toString();
		enrollmenttext=enrollment.getText().toString();
		yeartext=year.getText().toString();
		branchtext=branch.getText().toString();
		email_id=email.getText().toString();
		if (usernametext.equals("") && passwordtext.equals("") && enrollmenttext.equals("") && yeartext.equals("") && branchtext.equals("") && email_id.equals("")) 
		{
			Toast.makeText(getApplicationContext(),
			"Please complete the sign up form",
			Toast.LENGTH_SHORT).show();
		}
		else
		{
			ParseUser user=new ParseUser();
			user.put("Branch", branchtext);
			user.put("EnrollmentNo", usernametext);
			user.put("Year", yeartext);
			user.setUsername(enrollmenttext);
			user.setPassword(passwordtext);
			user.setEmail(email_id);
			//user.saveEventually();
			user.signUpInBackground(new SignUpCallback() {
				
				@Override
				public void done(ParseException e) {
					// TODO Auto-generated method stub
					if (e == null) {
						// Show a simple Toast message upon successful registration
						dialog.dismiss();
						Toast.makeText(getApplicationContext(),
								"Successfully Signed up, please log in.",
								Toast.LENGTH_SHORT).show();
						Intent i=new Intent(Signup.this,Login.class);
						startActivity(i);
					} else {
						Toast.makeText(getApplicationContext(),
								"You are already an user", Toast.LENGTH_SHORT)
								.show();
					}
				}
			});
			
		}
		
	}
	
	}
	}
	
