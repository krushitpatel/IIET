package com.android.iiet;




import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.android.iiet.image.adapter.GridViewAdapter;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class TimeTableData extends Activity{
	Bitmap bitmap;
OutputStream output;
	GridView gridview;
List<ParseObject> ob;
ProgressDialog mProgressDialog;
GridViewAdapter adapter;
ParseFile image;
TimeTableGetSet map;
String str,str1;
ConnectionDetector cd;
		Boolean isInternetPresent = false;
private List<TimeTableGetSet> phonearraylist = null;
 
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
// Get the view from gridview_main.xml
setContentView(R.layout.timetable);
Intent i=getIntent();
str=i.getStringExtra("name");
str1=i.getStringExtra("name2");
ActionBar a=getActionBar();
ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
a.setBackgroundDrawable(c);
a.setDisplayHomeAsUpEnabled(true);
setTitle("TimeTable");
// Execute RemoteDataTask AsyncTask
Parse.initialize(this, "poYMZJJD1ZIcnUL8UgBH9nCvniTwEUVU0OCTUUIc", "tLhKuGGzvOTRnxc8DhT9zG1g7gscMVULjQvrRHm0");
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
mProgressDialog = new ProgressDialog(TimeTableData.this);
// Set progressdialog title
mProgressDialog.setTitle("Parse.com GridView Tutorial");
// Set progressdialog message
mProgressDialog.setMessage("Loading...");
mProgressDialog.setIndeterminate(false);
// Show progressdialog
mProgressDialog.show();
}
 
protected Void doInBackground(Void... params) {
// Create the array
phonearraylist = new ArrayList<TimeTableGetSet>();
try {
// Locate the class table named "SamsungPhones" in Parse.com
ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
"iiet");
// Locate the column named "position" in Parse.com and order list
// by ascending
query.whereEqualTo("Year", str);
query.whereEqualTo("Branch", str1);
System.out.println(str+""+str1);
query.orderByAscending("createdAt");
ob = query.find();
for (ParseObject country : ob) {
image = (ParseFile) country.get("app");
map = new TimeTableGetSet();
map.setPhotos(image.getUrl());
phonearraylist.add(map);
}
} catch (ParseException e) {
Log.e("Error", e.getMessage());
e.printStackTrace();
}
return null;

}
 
@Override
protected void onPostExecute(Void result) {
// Locate the gridview in gridview_main.xml
gridview = (GridView) findViewById(R.id.grid);

// Pass the results into ListViewAdapter.java

adapter = new GridViewAdapter(TimeTableData.this,
		phonearraylist);
// Binds the Adapter to the ListView
gridview.setAdapter(adapter);
// Binds the Adapter to the ListView
//gridview.setAdapter(adapter);

// Close the progressdialog
mProgressDialog.dismiss();
}
}
}
