package com.android.iiet;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AlertFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View rootview=inflater.inflate(R.layout.fragment_home, container,false);
		Intent i=new Intent(getActivity(),PushNotification.class);
		startActivity(i);
		return rootview;
	}
}
