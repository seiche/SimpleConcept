package com.seiche.strike;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class GameProjectActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Thread thread = new Thread(){
        	
        	public void run(){
        		
        		try{
        			sleep(2000);
        			Intent menu = new Intent("com.seiche.strike.MENU");
        			startActivity(menu);
        			
        		}catch(InterruptedException e){
        			e.printStackTrace();
        		}
        		finally{
        			finish();
        		}
        		
        	}
        };
        
        thread.start();
    }
}