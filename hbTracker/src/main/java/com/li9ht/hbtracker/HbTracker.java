package com.li9ht.hbtracker;

import com.activeandroid.ActiveAndroid;

public class HbTracker extends com.activeandroid.app.Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		ActiveAndroid.initialize(this);
	}
	@Override
	public void onTerminate() {
		super.onTerminate();
		ActiveAndroid.dispose();
	}
	
}
