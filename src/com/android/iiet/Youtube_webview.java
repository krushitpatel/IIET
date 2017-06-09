package com.android.iiet;

import java.util.List;


import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;       
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;

import android.webkit.WebView;
import android.widget.Toast;

public class Youtube_webview extends Activity{
	WebView w; 
	String str,str1,str2;
	ProgressDialog dialog;
	  ConnectionDetector cd;
			Boolean isInternetPresent = false;
	 List<ParseObject> ob;
	 String video;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.youtube_webview);
		w=(WebView) findViewById(R.id.webview);
	ActionBar a=getActionBar();
		ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		a.setBackgroundDrawable(c);
		a.setDisplayHomeAsUpEnabled(true);
		setTitle("Tutorial videos");
		Parse.initialize(this, "poYMZJJD1ZIcnUL8UgBH9nCvniTwEUVU0OCTUUIc", "tLhKuGGzvOTRnxc8DhT9zG1g7gscMVULjQvrRHm0");
		Intent i=getIntent();
		str=i.getStringExtra("key");
		str1=i.getStringExtra("data");
		str2=i.getStringExtra("content");
		 cd = new ConnectionDetector(getApplicationContext());
			isInternetPresent = cd.isConnectingToInternet();
			if (!isInternetPresent){
	          // Internet Connection is not present
			
				Toast.makeText(getApplicationContext(), "Internet connection fail", Toast.LENGTH_LONG).show();
				
	        
	          // stop executing code by return
	        
	      }else{
		new RemoteDataTask().execute();
	      }
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
          onBackPressed();
        
        }
  return true;
    }
	private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        
		  @Override
		        protected void onPreExecute() {
		            super.onPreExecute();
		            dialog = new ProgressDialog(Youtube_webview.this);
		            dialog.setTitle("Fetching Faculty Name !!");
		            dialog.setMessage("Loading...");
		            dialog.setIndeterminate(false);
		            dialog.show();
		        }
		        @Override
		        protected Void doInBackground(Void... params) {
		        
		        try{
		          ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Videos");
		          query.whereEqualTo("Branch", str);
		          query.whereEqualTo("Subject",str1);
		          query.whereEqualTo("Tutorial", str2);
		          query.orderByDescending("createdAt");
		          ob = query.find();
		          
		          for (ParseObject country : ob) {
		        	
		        video=country.getString("Id");   
		        	
		        	System.out.println(video);
		           }
		        }
		        catch (ParseException e) {
		            Log.e("Error", e.getMessage());
		            e.printStackTrace();
		        } 
		           
		          
		            return null;
		        }
		        @SuppressLint("SetJavaScriptEnabled")
				@Override
		        protected void onPostExecute(Void result) {
		        	
		        	  if (video != null) {
			                w = (WebView) findViewById(R.id.webview);

			               w.getSettings().setJavaScriptEnabled(true);
			              
			               //webview.setWebViewClient(new webClient());
			               w.getSettings().setAppCacheEnabled(true);
			               w.getSettings().setLoadWithOverviewMode(true);
			               w.loadUrl(video); 
			        }
		            dialog.dismiss();
		          }
	}
}
