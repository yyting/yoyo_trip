package com.example.yoyo_trip;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class MapActivity extends FragmentActivity {
	
	private GoogleMap mMap;
	//private  move;
	final int MARKER_UPDATE_INTERVAL = 1000;
	Handler handler = new Handler();
	
	//���s
	private ImageButton icon;
	private ImageButton pay;
	private ImageButton group;
	private ImageButton plane;
	private ImageButton imageButton1;
	
	Marker marker;
	
	
	
	
	Runnable updateMarker = new Runnable(){
		@Override
		public void run(){
			new AsyncTaskParseJson().execute();
			handler.postDelayed(this, MARKER_UPDATE_INTERVAL);
		}
	};
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
    	StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath().build());

    	
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
	       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	       WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_map);
       
     
        //���s
        icon =((ImageButton)findViewById(R.id.icon));
        pay =((ImageButton)findViewById(R.id.pay));
        group =((ImageButton)findViewById(R.id.group));
        plane =((ImageButton)findViewById(R.id.plane));
     
        
        icon.setOnClickListener(
  				new OnClickListener() {
  				    public void onClick(View arg0) {
  				    	if (pay.getVisibility()==ImageButton.INVISIBLE)
  				      {
  				        pay.setVisibility(View.VISIBLE);
  				    	group.setVisibility(View.VISIBLE);
  				    	plane.setVisibility(View.VISIBLE);
  				      }else{
  				    	pay.setVisibility(View.INVISIBLE);
  				    	group.setVisibility(View.INVISIBLE);
  				    	plane.setVisibility(View.INVISIBLE);
  				      }
  				    	
  				    }});
        
        //�����ȫ��s
        plane.setOnClickListener(new OnClickListener() {
		    public void onClick(View arg0) {

		    	//�D�e�������������
				Intent getmain=new Intent();
				getmain.setClass(MapActivity.this, FragmentTabs.class);
				startActivity(getmain);
				MapActivity.this.finish();
		  
		    }}); 
        
        
        
      //�^�D�e�����s
	       ImageButton imageButton1=(ImageButton)findViewById(R.id.imageButton1);

	       imageButton1.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					
					Intent getmain=new Intent();
					getmain.setClass(MapActivity.this, main.class);
					startActivity(getmain);
					MapActivity.this.finish();
				}
			});
	       
	       //�o���ȫ��s
	       ImageButton imageButton2=(ImageButton)findViewById(R.id.imageButton2);

	       imageButton2.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					
					Intent getmain=new Intent();
					getmain.setClass(MapActivity.this, PayStartActivity.class);
					startActivity(getmain);
					MapActivity.this.finish();
				}
			});
	       
	       //�e�i�a���誺��C��
	       ImageButton imageButton3=(ImageButton)findViewById(R.id.imageButton3);

	       imageButton3.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					
					Intent getmain=new Intent();
					getmain.setClass(MapActivity.this,TaskActivity.class);
					startActivity(getmain);
					MapActivity.this.finish();
				}
			});
        
        
        
        
        
        
        
        
        
        
	//	mMap.addMarker( new MarkerOptions().position( new LatLng(25.047924, 121.517081) ).title("�x�_����") );
        
        mMap = ((SupportMapFragment)
        	     getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        //marker1
        MarkerOptions markerOpt = new MarkerOptions();
        markerOpt.position(new LatLng(25.068088, 121.552696));
        markerOpt.title("�Q�s����");
        //markerOpt.snippet("��1999�~�ʤu�A2004�~12��31�駹�u�ҥΡA�Ӱ�509.2���ءC");
        markerOpt.draggable(false);
        markerOpt.visible(true);
        //markerOpt.anchor(0.5f, 0.5f);//�]���Ϥ��
        markerOpt.icon(BitmapDescriptorFactory.fromResource(R.drawable.airport));

        mMap.addMarker(markerOpt);
        
        //marker2
        MarkerOptions markerOpt2 = new MarkerOptions();
        markerOpt2.position(new LatLng(25.040787, 121.518974));
        markerOpt2.title("�O�j��|");
        //markerOpt2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));//�a�Ъ��C��
        markerOpt2.icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital));

        mMap.addMarker(markerOpt2);
        
        //marker3
        MarkerOptions markerOpt3 = new MarkerOptions();
        markerOpt3.position(new LatLng(25.071701, 121.592440));
        markerOpt3.title("�T�x�`��|");
        //markerOpt2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));//�a�Ъ��C��
        markerOpt3.icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital));

        mMap.addMarker(markerOpt3);
       
        
        setUpMapIfNeeded();
        
        moveMap(new LatLng(25.086774, 121.565490));
        
        mMap.setMyLocationEnabled(true);
       //move.setMyLocationEnabled(new LatLng(25.0419,121.534));
        
        handler.postDelayed(updateMarker, MARKER_UPDATE_INTERVAL);
    }
    
    //���u
    
	/*private void drawPolyline(){
        PolylineOptions polylineOpt = new PolylineOptions();
        polylineOpt.add(new LatLng(25.033611, 121.565000));
        polylineOpt.add(new LatLng(25.032728, 121.565137));
        polylineOpt.add(new LatLng(25.033739, 121.527886));
        polylineOpt.add(new LatLng(25.038716, 121.517758));
        polylineOpt.add(new LatLng(25.045656, 121.519636));
        polylineOpt.add(new LatLng(25.046200, 121.517533));

        polylineOpt.color(Color.BLUE);

        Polyline polyline = mMap.addPolyline(polylineOpt);
        polyline.setWidth(50);
    }*/
    
    
    
    
    
    
    private void moveMap(LatLng place) {
    	CameraPosition cameraPosition =
    			new CameraPosition.Builder().target(place).zoom(13).build();
    	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    @Override
    protected void onDestroy(){
    	handler.removeCallbacks(updateMarker);
    	super.onDestroy();
    }
    
    @Override
    protected void onResume(){
    	super.onResume();
    	setUpMapIfNeeded();
    }
    
    private void setUpMapIfNeeded(){
    	if (mMap == null){
    		mMap = ((SupportMapFragment)
           	     getSupportFragmentManager().findFragmentById(R.id.map)).getMap(); 
    	}
    }
    
    public class AsyncTaskParseJson extends AsyncTask<String, String, String>{
    	String yourJsonStringUrl="";
    	
    	JSONArray dataJsonArr =null;
    	
    	@Override
    	protected String doInBackground(String... argO) {
    		return null;
    	}
    	/*
    	@Override
    	protected void onPostExecute(String strFromDoInBg){
    		try {
    			Parser jParser = new Parser();
    			
    			JSONObject json= jParser.getJSONFromUrl(yourJsonStringUrl);
    			
    			dataJsonArr= json.getJSONArray("retval");
    			
    			for(int i=0;i<dataJsonArr.length();i++){
    				JSONObject c= dataJsonArr.getJSONObject(i);
    				
    				double lat1 = Double.parseDouble(c.getString("lat"));
    				double lng1 = Double.parseDouble(c.getString("lng"));
    				int sbi1 = Integer.parseInt(c.getString("sbi"));
    				int tot1 = Integer.parseInt(c.getString("tot"));
    				
    				mMap.addMarker(new MarkerOptions().title(c.getString("sna")).snippet("�Ѿl�ƶq�G"+sbi1+"��"+","+"�`�ƶq").position(new LatLng(lat1, lng1)));
    			}
    		} catch (JSONException e){
    			e.printStackTrace();
    		}
    	}*/
    }
    

    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}