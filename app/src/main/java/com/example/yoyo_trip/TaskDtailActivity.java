package com.example.yoyo_trip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class TaskDtailActivity extends Activity{
	
	@Override  
	   public void onCreate(Bundle savedInstanceState) {  
	       super.onCreate(savedInstanceState);
	       requestWindowFeature(Window.FEATURE_NO_TITLE); 
	       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	       WindowManager.LayoutParams.FLAG_FULLSCREEN);
	       setContentView(R.layout.activity_taskdtail);

	       
	       //��^�W�@��
	       ImageButton imageButton1=(ImageButton)findViewById(R.id.imageButton1);

	       imageButton1.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					
					Intent getmain=new Intent();
					getmain.setClass(TaskDtailActivity.this, TaskActivity.class);
					startActivity(getmain);
					TaskDtailActivity.this.finish();
				}
			});
	       
	       
	     //��^�W�@��
	       Button button1=(Button)findViewById(R.id.button1);

	       button1.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					
					Intent getmain=new Intent();
					getmain.setClass(TaskDtailActivity.this, MapActivity.class);
					startActivity(getmain);
					TaskDtailActivity.this.finish();
				}
			});
	       
	}
}
