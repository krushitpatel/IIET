package com.android.iiet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;

public class Pdf extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		AssetManager assetManager = getAssets();
		   
        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), "application_form.pdf");	      
        try
        {
            in = assetManager.open("application_form.pdf");
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "test1");
            folder.mkdir();
            
            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e)
        {
            Log.e("tag", e.getMessage());
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(
                Uri.parse("file://" + getFilesDir() + "/application_form.pdf"),
                "application/pdf");
       
        startActivity(intent);
}

    private void copyFile(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, read);
        }
    }
	}

