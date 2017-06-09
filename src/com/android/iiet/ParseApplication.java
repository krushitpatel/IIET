package com.android.iiet;
import com.parse.Parse;
import com.parse.ParseACL;

import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;

import android.app.Application;


public class ParseApplication extends Application {
	
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate() {
	super.onCreate();
	 
	// Add your initialization code here
	Parse.initialize(this, "poYMZJJD1ZIcnUL8UgBH9nCvniTwEUVU0OCTUUIc", "tLhKuGGzvOTRnxc8DhT9zG1g7gscMVULjQvrRHm0");
	 
	//ParseUser.enableAutomaticUser();
	ParseACL defaultACL = new ParseACL();
	 
	// If you would like all objects to be private by default, remove this line.
	defaultACL.setPublicReadAccess(true);
	 
	ParseACL.setDefaultACL(defaultACL, true);
	
	 
	// inform the Parse Cloud that it is ready for notifications
	PushService.setDefaultPushCallback(this, PushNotification.class);
	ParseInstallation.getCurrentInstallation().saveInBackground();
	}
	 
}
