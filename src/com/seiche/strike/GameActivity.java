package com.seiche.strike;

import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity{
	Surface view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		view = new Surface(this);
		setContentView(view);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		view.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		view.resume();
	}

	/**
	 * @param args
	 */
	

}
