package com.example.yoyo_trip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.yoyo_trip.FragmentTabs;

public class Login3Activity extends Activity {
	private Button sign_in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login3);
		
		sign_in=((Button)findViewById(R.id.next));
		
		sign_in.setOnClickListener(new OnClickListener() {
				    public void onClick(View arg0) {


				    	//�n�J�������D�e��
						Intent getmain=new Intent();
						getmain.setClass(Login3Activity.this, main.class);
						startActivity(getmain);
						Login3Activity.this.finish();
				  
				    }}); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login3, menu);
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
