package com.seiche.strike;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
//import android.graphics.RectF;

public class Background {

	Bitmap back;
	int progress;
	
	public Background(Surface v){
		back = BitmapFactory.decodeResource(v.getResources(), R.drawable.map);
		progress = 1600-230;
		
	}
	
	public void draw(Canvas c, int w, int h){
		if(progress > 0)
			progress--;
		Rect source = new Rect(0,progress,400,progress+225);
		Rect dest = new Rect(0,0,w,h);
		c.drawBitmap(back, source, dest, null);
	}
	
	public int getProgress(){
		return progress;
	}
}
