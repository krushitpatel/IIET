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
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;



import com.android.iiet.image.adapter.CustomListAdapter;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class Subject_MainActivity extends Activity{
	ListView ll1;
	 List<ParseObject> ob;
	 CustomListAdapter subjectadapter;
	    ProgressDialog mProgressDialog;
	    private List<GetSet> subjectname = null;
	   String year,branch;
	   ConnectionDetector cd;
		Boolean isInternetPresent = false;
	 
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.listview_item);
	  ll1=(ListView)findViewById(R.id.listView);
	  Parse.initialize(this,"poYMZJJD1ZIcnUL8UgBH9nCvniTwEUVU0OCTUUIc", "tLhKuGGzvOTRnxc8DhT9zG1g7gscMVULjQvrRHm0");
	  ActionBar a=getActionBar();
	  ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
	  a.setBackgroundDrawable(c);
	  a.setDisplayHomeAsUpEnabled(true);
	  setTitle("Subject List");
	  Intent i=getIntent();
	  year=i.getStringExtra("name");
	  branch=i.getStringExtra("name2");
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
	 
	 private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
	        
	  @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	            mProgressDialog = new ProgressDialog(Subject_MainActivity.this);
	            mProgressDialog.setTitle("Fetching Subject Name !!");
	            mProgressDialog.setMessage("Loading...");
	            mProgressDialog.setIndeterminate(false);
	            mProgressDialog.show();
	        }
	        @Override
	        protected Void doInBackground(Void... params) {
	        	subjectname = new ArrayList<GetSet>();
	        try{
	          ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Subject");
	    
	          query.whereEqualTo("Year", year);
	          query.whereEqualTo("Branch_code", branch);
	          query.orderByDescending("createdAt");
	          ob = query.find();
	          
	          for (ParseObject country : ob) {
	        	 GetSet data_items=new GetSet();
	        	data_items.setSub_name(country.getString("Sub_Name"));
	        	data_items.setSyllabus(country.getString("Syllabus"));
	        	subjectname.add(data_items);
	          
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
	        	subjectadapter = new CustomListAdapter(Subject_MainActivity.this,subjectname);
	          ll1.setAdapter(subjectadapter);
	            mProgressDialog.dismiss();
	            ll1.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						Intent i=new Intent(Subject_MainActivity.this,Syllabus.class);
						i.putExtra("Syllabus", ob.get(position).getString("Syllabus"));
						startActivity(i);
					}
				});
	          }
}
}
