package com.android.iiet;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
public class Login extends Activity{
	Button b1,b2;
	TextView t1,t2;
	EditText enro,pass;
	String username,password;
	ProgressDialog dialog;
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		b1 = (Button)findViewById(R.id.log);
		b2 = (Button)findViewById(R.id.guestuser);
		t1 = (TextView)findViewById(R.id.signup);
		t2 = (TextView)findViewById(R.id.forgot_password);
		enro=(EditText) findViewById(R.id.enrol);
		pass=(EditText) findViewById(R.id.pass);
		dialog=new ProgressDialog(Login.this);
		dialog.setTitle("Login");
		dialog.setMessage("Please wait...");		
		dialog.setIndeterminate(false);
		setTitle("Login");
		ActionBar a=getActionBar();
		ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		a.setBackgroundDrawable(c);
		Parse.initialize(this, "poYMZJJD1ZIcnUL8UgBH9nCvniTwEUVU0OCTUUIc", "tLhKuGGzvOTRnxc8DhT9zG1g7gscMVULjQvrRHm0");
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Login.this,Guest_User.class));
			}
		});
		b1.setOnClickListener(new OnClickListener() {
			
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
					username=enro.getText().toString();
					password=pass.getText().toString();
				ParseUser.logInInBackground(username, password, new LogInCallback() {
					
					@Override
					public void done(ParseUser user, ParseException e) {
						// TODO Auto-generated method stub
						dialog.dismiss();
						if (user != null) {
							// If user exist and authenticated, send user to Home.class
							Intent intent = new Intent(Login.this,Home.class);
							startActivity(intent);
							Toast.makeText(getApplicationContext(),"Successfully Logged in",Toast.LENGTH_LONG).show();
							finish();
							} else {
							Toast.makeText(
							getApplicationContext(),"No such user exist, please signup",Toast.LENGTH_LONG).show();
							
							}
					}
				});
		        }
			}
			
		});
		t1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(Login.this,Signup.class);
				startActivity(i);
			}
		});
		t2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Login.this,Forgot_Password.class);
				startActivity(i);
			}
		});
}
	@Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("No", null).show();
    }

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish();
	} 
	
	}