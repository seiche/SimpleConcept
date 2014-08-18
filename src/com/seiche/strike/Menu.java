package com.seiche.strike;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Menu extends Activity {

	private Button about;
	private Button start;
	private Button config;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		// Initialize buttons
		start = (Button) findViewById(R.id.start_button);
		config = (Button) findViewById(R.id.config_button);
		about = (Button) findViewById(R.id.credit_button);

		start.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
				startActivity(new Intent("com.seiche.strike.GAMEACTIVITY"));
				}finally{
					finish();
				}
			}
		});

		config.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		about.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog about_me = new AlertDialog.Builder(Menu.this)
						.create();
				about_me.setTitle("About");
				about_me.setMessage("This program was written for practice by Benjamin Collins a student at Jyousai University. All graphics in this game have been downloaded off of the internet and belong to their respectie owners.");
				about_me.setButton("Okay",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								dialog.dismiss();
							}

						});

				about_me.show();
			}
		});

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
