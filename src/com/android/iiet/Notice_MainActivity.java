package com.android.iiet;

import java.util.ArrayList;
import java.util.List;

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
import android.view.View;



import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;



import com.android.iiet.image.adapter.Notice_ListAdapter;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class Notice_MainActivity extends Activity {
	// Declare Variables
	ListView listview;
	List<ParseObject> ob;
	ProgressDialog mProgressDialog;
	Notice_ListAdapter notice_adapter;
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	private List<Notice_GetSet> noticemodule = null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from listview_main.xml
		setContentView(R.layout.notice_listview_item);
		ActionBar a=getActionBar();
		ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		a.setBackgroundDrawable(c);
		a.setDisplayHomeAsUpEnabled(true);
		setTitle("Notice");
		listview = (ListView) findViewById(R.id.listview);
		Parse.initialize(this, "poYMZJJD1ZIcnUL8UgBH9nCvniTwEUVU0OCTUUIc", "tLhKuGGzvOTRnxc8DhT9zG1g7gscMVULjQvrRHm0");
		// Execute RemoteDataTask AsyncTask
		cd = new ConnectionDetector(getApplicationContext());
		isInternetPresent = cd.isConnectingToInternet();
		if (!isInternetPresent) {
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
	// RemoteDataTask AsyncTask
	private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Create a progressdialog
			mProgressDialog = new ProgressDialog(Notice_MainActivity.this);
			// Set progressdialog title
			mProgressDialog.setTitle("Fetching Notices...");
			// Set progressdialog message
			mProgressDialog.setMessage("Loading...");
			mProgressDialog.setIndeterminate(false);
			// Show progressdialog
			mProgressDialog.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			// Locate the class table named "Country" in Parse.com
			noticemodule=new ArrayList<Notice_GetSet>();
			try{
		          ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("notice");
		    
		          
		          query.orderByDescending("createdAt");
		          ob = query.find();
		          
		          for (ParseObject country : ob) {
		        	  Notice_GetSet data_items=new Notice_GetSet();
		        	data_items.setDetails(country.getString("Notice"));
		        	data_items.setNotice(country.getString("Details_Data"));
		        	noticemodule.add(data_items);
		          System.out.println(noticemodule);
		           }
		        }
		        catch (ParseException e) {
		            Log.e("Error", e.getMessage());
		            e.printStackTrace();
		        } 
		            return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// Locate the listview in listview_main.xml
		
			// Pass the results into an ArrayAdapter
			notice_adapter = new Notice_ListAdapter(Notice_MainActivity.this,noticemodule);
			// Retrieve object "name" from Parse.com database
			
			// Binds the Adapter to the ListView
			listview.setAdapter(notice_adapter);
			// Close the progressdialog
			mProgressDialog.dismiss();
			// Capture button clicks on ListView items
			listview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					Intent i=new Intent(Notice_MainActivity.this,Notice_SingleItemView.class);
					i.putExtra("Details_Data", ob.get(position).getString("Details_Data"));
					
					startActivity(i);
				}
			});
					
					
	}
}}