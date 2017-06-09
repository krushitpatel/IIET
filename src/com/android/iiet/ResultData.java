package com.android.iiet;


import java.util.ArrayList;
import java.util.List;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import com.android.iiet.image.adapter.*;
public class ResultData extends Activity {
	ListView listview;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    xyz adapter;
    String item,year,branch;
    private List<gsmethod> main_menu_list = null;
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultdata);
		 listview=(ListView) findViewById(R.id.listView1);
		 Parse.initialize(this,"poYMZJJD1ZIcnUL8UgBH9nCvniTwEUVU0OCTUUIc", "tLhKuGGzvOTRnxc8DhT9zG1g7gscMVULjQvrRHm0");
		 ActionBar a=getActionBar();
			a.setDisplayHomeAsUpEnabled(true);
			ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
			a.setBackgroundDrawable(c);
			setTitle("Result");
			Intent i=getIntent();
			  year=i.getStringExtra("name");
			  branch=i.getStringExtra("name2");
		 new RemoteDataTask().execute();
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
			mProgressDialog = new ProgressDialog(ResultData.this);
			mProgressDialog.setMessage("Loading");
			mProgressDialog.setIndeterminate(false);
			mProgressDialog.setCancelable(false);
			mProgressDialog.show();
			}

			@Override
			protected Void doInBackground(Void... params) {

			main_menu_list = new ArrayList<gsmethod>();
			
			try {
				
				ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("result");
				query.orderByAscending("roll_no");
				query.whereEqualTo("Year", year);
				query.whereEqualTo("Branch_code", branch);
				ob = query.find();
				for (ParseObject country : ob)  {
					
					gsmethod menu_items = new gsmethod();
					menu_items.setRoll_no(Integer.parseInt(country.get("roll_no").toString()));
					menu_items.setMaths1(country.getString("maths1"));

					menu_items.setPhysics(country.getString("physics"));

					menu_items.setMos(country.getString("mos"));

					menu_items.setEg( country.getString("eg"));

					main_menu_list.add(menu_items);
				}
			} catch (ParseException e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
				}
			return null;
		}

			@Override
			protected void onPostExecute(Void result) {

				adapter = new xyz(ResultData.this,main_menu_list);
				listview.setAdapter(adapter);
		        mProgressDialog.dismiss();
			}
	}

}

