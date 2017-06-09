package com.android.iiet;




import com.parse.Parse;
import com.parse.ParseAnonymousUtils;

import com.parse.ParseUser;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;



public class LoginCheck extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		Parse.initialize(this, "poYMZJJD1ZIcnUL8UgBH9nCvniTwEUVU0OCTUUIc", "tLhKuGGzvOTRnxc8DhT9zG1g7gscMVULjQvrRHm0");
		
	
			ParseUser currentUser=ParseUser.getCurrentUser();
			if(currentUser !=null){
				Intent i=new Intent(LoginCheck.this,Home.class);
				startActivity(i);
				finish();
			}
			else{
				Intent i=new Intent(LoginCheck.this,Login.class);
				startActivity(i);
				finish();
			}
		
		}
	}
