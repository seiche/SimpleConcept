package com.seiche.strike;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Surface extends SurfaceView implements Runnable{
	
	SurfaceHolder holder;
	Thread thread = null;
	boolean isRunning = false;
	GameObject game;
	
	public Surface(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		game = new GameObject(this);
		holder = getHolder();
		thread = new Thread(this);		
		isRunning = true;
		thread.start();
	}

	
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning){
			
			if(!holder.getSurface().isValid())
				continue;
			
			Canvas canvas = holder.lockCanvas();
			game.draw(canvas, canvas.getWidth(), canvas.getHeight());
			holder.unlockCanvasAndPost(canvas);
		}
	}

	

	

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		super.onTouchEvent(event);
		
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			game.player.setShoot(true);
		break;
			
		case MotionEvent.ACTION_MOVE:
			game.player.setDisplace((int)event.getX(),(int)event.getY()-80);
		break;
		
		case MotionEvent.ACTION_UP:
			game.player.setImobile();
			game.player.setShoot(false);
		break;
		
		}
		
		return true;
	}

	public void pause(){
		isRunning = false;
		while(true){
			try{
				thread.join();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			break;
		}
		thread = null;
	}
	
	public void resume(){
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
}
