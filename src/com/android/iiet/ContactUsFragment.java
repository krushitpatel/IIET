package com.android.iiet;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class ContactUsFragment extends Fragment implements OnClickListener {
	Button btn;
	public ContactUsFragment(){}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView =inflater.inflate(R.layout.fragment_contact_us, container, false);
		btn=(Button) rootView.findViewById(R.id.button1);
		btn.setOnClickListener(this);
		
		return rootView;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(getActivity(),Google_Map.class);
		startActivity(i);
	}
}
