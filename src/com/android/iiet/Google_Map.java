package com.android.iiet;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Google_Map extends Activity {
	private GoogleMap googleMap;
	double latitude=22.403136;
	double longitude=72.776949;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_google_map);
		ActionBar a=getActionBar();
		ColorDrawable c=new ColorDrawable(Color.parseColor("#D82B25"));
		a.setBackgroundDrawable(c);
		a.setDisplayHomeAsUpEnabled(true);
		setTitle("Google Map");
		try {
			// Loading map
			initilizeMap();

		} catch (Exception e) {
			e.printStackTrace();
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
	/**
	 * function to load map. If map is not created it will create it for you
	 * */
	private void initilizeMap() {
		if (googleMap == null) {
			googleMap = ((MapFragment) getFragmentManager().findFragmentById(
					R.id.map)).getMap();
			MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Ipcowala Institute of Engineering and Technology ");
			googleMap.addMarker(marker);
			marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
			 
			googleMap.getUiSettings().setZoomGesturesEnabled(true);
			googleMap.getUiSettings().setCompassEnabled(true);
			CameraPosition cameraPosition = new CameraPosition.Builder().target(
	                new LatLng(22.403136, 72.776949)).zoom(15).build();
	 
	googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
			// adding marker
			googleMap.addMarker(marker);
			// check if map is created successfully or not
			if (googleMap == null) {
				Toast.makeText(getApplicationContext(),
						"Sorry! unable to create maps", Toast.LENGTH_SHORT)
						.show();
			}
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		initilizeMap();
	}
}


