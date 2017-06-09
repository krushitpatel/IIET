package com.android.iiet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class ImageDownload extends Activity{
	String root = Environment.getExternalStorageDirectory().toString();
	int i = 0;
	Bitmap bmp;
	ProgressDialog progressDialog;
	Button btn;
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Parse.initialize(this, "poYMZJJD1ZIcnUL8UgBH9nCvniTwEUVU0OCTUUIc", "tLhKuGGzvOTRnxc8DhT9zG1g7gscMVULjQvrRHm0");
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
	                while (i < size) {
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
	                    i++;
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
			    int j=i+1;
			    File file = new File(myDir, ""+j+".pdf");
			   // if (file.exists()) file.delete();
			    Log.d("IMAGE", "SAVED " +"" + j);

			    try {
			        FileOutputStream out = new FileOutputStream(file);
			       // bmp.compress(Bitmap.CompressFormat.WEBP, 90, out);
			        out.flush();
			        out.close();

			    } catch (FileNotFoundException e1) {
			        e1.printStackTrace();
			    } catch (IOException e2) {
			        e2.printStackTrace();
			    }


			
	}
}

