package com.android.iiet;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class GtuRankFragment extends Fragment{
	WebView webview;
	String url="http://gtuinfo.in/Login/Registration.aspx";
	public GtuRankFragment(){}
	ProgressDialog dialog;
	ConnectionDetector cd;
	Boolean isInternetPresent = false;
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		// TODO Auto-generated method stub
	View rootview =inflater.inflate(R.layout.gturank, container, false);
	
	 cd = new ConnectionDetector(getActivity());
		isInternetPresent = cd.isConnectingToInternet();
		if (!isInternetPresent) {
       // Internet Connection is not present
		
			Toast.makeText(getActivity(), "Internet connection fail", Toast.LENGTH_LONG).show();
			
     
       // stop executing code by return
     
   }else{
	  if (url != null) {
          webview = (WebView) rootview.findViewById(R.id.webview);

         webview.getSettings().setJavaScriptEnabled(true);

        webview.loadUrl(url);
         webview.setWebViewClient(new WebViewClient(){

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				return true;
			}
        	 
         });
     }
		
	}
		return rootview;
	}
}
