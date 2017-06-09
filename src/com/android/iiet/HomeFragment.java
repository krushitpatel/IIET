package com.android.iiet;




import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment{

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootview=inflater.inflate(R.layout.fragment_home, container,false);
		TextView tv = (TextView) rootview.findViewById(R.id.TextView03);
		tv.setEllipsize(TruncateAt.MARQUEE);
        tv.setSelected(true);
        tv.setSingleLine(true);
		return rootview;
	}
	
}
