package com.example.yoyo_trip;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.example.yoyo_trip.Fragment2;
import com.example.yoyo_trip.Fragment3;
import com.example.yoyo_trip.TabManager;

public class FragmentTabs extends FragmentActivity{
    private TabHost mTabHost;
    private com.example.yoyo_trip.TabManager mTabManager;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        
        
        setContentView(R.layout.fragment_tabs);
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        mTabManager = new com.example.yoyo_trip.TabManager(this, mTabHost, R.id.realtabcontent);
        mTabHost.setCurrentTab(0);
        
        
        /*mTabManager.addTab(
            mTabHost.newTabSpec("Fragment1").setIndicator("�o��"),
            Fragment1.class, null);
        */
        mTabManager.addTab(
            mTabHost.newTabSpec("Fragment2").setIndicator("�q�q�ڦb��?"),
            com.example.yoyo_trip.Fragment2.class, null);
        mTabManager.addTab(
            mTabHost.newTabSpec("Fragment3").setIndicator("�x�W���Ѥ�"),
            com.example.yoyo_trip.Fragment3.class, null);

        
        
        DisplayMetrics dm = new DisplayMetrics();   
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
           
           
        TabWidget tabWidget = mTabHost.getTabWidget();
        int count = tabWidget.getChildCount();
        if (count >= 2) {   
            for (int i = 0; i < count; i++) {   
                tabWidget.getChildTabViewAt(i)
                      .setMinimumWidth((screenWidth)/2);
            }   
        }
        
        
        
        
        
    }
}

