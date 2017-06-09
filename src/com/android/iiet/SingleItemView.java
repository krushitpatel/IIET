package com.android.iiet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;




import com.android.iiet.image.adapter.ImageLoader;
import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;


public class SingleItemView extends Activity implements OnClickListener {
	String s,URL;
	TouchImageView imgphoto;
	Button btn;
	int count;
	String root = Environment.getExternalStorageDirectory().toString();
	int i = 0;
	Bitmap bmp;
	ProgressDialog progressDialog;
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	 @SuppressWarnings("unused")
	private ProgressDialog pDialog;
	 public static final int progress_bar_type = 0; 
	ImageLoader imageLoader = new ImageLoader(this);
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	// Get the view from singleitemview.xml
	setContentView(R.layout.singleitemview);
	btn=(Button) findViewById(R.id.img_download);
	Parse.initialize(this, "poYMZJJD1ZIcnUL8UgBH9nCvniTwEUVU0OCTUUIc", "tLhKuGGzvOTRnxc8DhT9zG1g7gscMVULjQvrRHm0");
	ActionBar a=getActionBar();
	ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
	a.setBackgroundDrawable(c);
	a.setDisplayHomeAsUpEnabled(true);
	Intent i = getIntent();
	// Get the intent from ListViewAdapter
	s= i.getStringExtra("photo");
	URL=i.getStringExtra("key");
	// Locate the ImageView in singleitemview.xml
	imgphoto = (TouchImageView) findViewById(R.id.download);
	imageLoader.DisplayImage(s, imgphoto);
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
		ParseQuery<ParseObject> query = ParseQuery.getQuery("iiet");
	    query.findInBackground(new FindCallback<ParseObject>() {
	        @Override
	        public void done(List<ParseObject> parseObjects, com.parse.ParseException e) {
	            if (e == null) {
	                int size = parseObjects.size();
	                Log.d("query size", "size is " + size + " int i is " + i);
	                ParseFile fileObject = parseObjects.get(i).getParseFile("app");
	                for(i=0;i<parseObjects.size();i++){
	                    fileObject.getDataInBackground(new GetDataCallback() {
	                        @Override
	                        public void done(byte[] bytes, ParseException e) {
	                            if (e == null) {
	                                Log.d("Data", "We have data successfully " +i);

	                                bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
	                                 saveImagesInSdCard(bmp, i);

	                            } else {
	                                Log.d("ERROR: ", "" + e.getMessage());
	                                progressDialog.dismiss();
	                            }
	                        }
	                    });
	                    
	                }
	            } else {
	                Log.d("ERROR:", "" + e.getMessage());
	                progressDialog.dismiss();
	            }
	        }
	    });
      }
	}
	private void saveImagesInSdCard(Bitmap bmp, int i) {
		// TODO Auto-generated method stub
			    File myDir = new File(root + "/iiet_images");
			    myDir.mkdirs();
			    File file = new File(myDir, ""+i+".jpg");
			   // if (file.exists()) file.delete();
			    Log.d("IMAGE", "SAVED " +"" + i);

			    try {
			        FileOutputStream out = new FileOutputStream(file);
			        bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
			        out.flush();
			        out.close();

			    } catch (FileNotFoundException e1) {
			        e1.printStackTrace();
			    } catch (IOException e2) {
			        e2.printStackTrace();
			    }


			
	}
}

	   

	

