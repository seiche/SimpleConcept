package com.seiche.strike;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Player {
	
	//Player Parameters
	
	//Movement and position
	private int x = 100;
	private int y = 100;
	private int dx = 0;
	private int dy = 0;
	private boolean firstRun = true;
	
	//Animation
	private Bitmap myShip[] = new Bitmap[3];
	private int cell = 0;
	
	//Shooting variables
	private boolean shoot = false;
	private int canShoot = 50;
	private Bitmap bulletImg;
	private ArrayList<PlayerBullet> bulletArray;
	
	//Constructor takes in the view as a condition to allocate resources
	public Player(Surface v){
		myShip[0] = BitmapFactory.decodeResource(v.getResources(), R.drawable.plane01);
		myShip[1] = BitmapFactory.decodeResource(v.getResources(), R.drawable.plane02);
		myShip[2] = BitmapFactory.decodeResource(v.getResources(), R.drawable.plane03);
		
		bulletImg = BitmapFactory.decodeResource(v.getResources(), R.drawable.bullet);
		bulletArray = new ArrayList<PlayerBullet>();
	}
	
	
	//Moves and draws the player bitmap
	public void draw(Canvas c, int w, int h){
		if(firstRun){
			x = w/2;
			y = h/2;
			firstRun = false;
		}
		
		x += dx;
		y += dy;
		
		if(y < 0)
			y = 0;
		
		cell++;
		if(cell > 2)
			cell = 0;
		c.drawBitmap(myShip[cell], x-32, y-32, null);
		
		shoot(c);
	}
	
	public void shoot(Canvas c){
		canShoot++;
		if(shoot && canShoot > 5){
			canShoot = 0;
			
			bulletArray.add(new PlayerBullet(x, y-20));
		}
		
		for(int i = 0; i < bulletArray.size(); i++){
			bulletArray.get(i).move();
			int yTemp = bulletArray.get(i).getY();
			c.drawBitmap(bulletImg, bulletArray.get(i).getX()-16, yTemp, null);
			
			if(yTemp < -16)
				bulletArray.remove(i);
		}
	}
	
	
	//Sets the movement variables depending on the input of the touch screen x and y
	//values by dividing the displacement by the hypotenuse of the resulting triangle
	public void setDisplace(int xInput, int yInput){
		int hypo = (int)Math.sqrt(xInput*xInput + yInput*yInput);
		hypo = hypo/50;
		
		dx = (int)(xInput - x)/hypo;
		dy = (int)(yInput - y)/hypo;
	}
	
	//Sets the plane to shooting state or not depending on ACTION_DOWN or ACTION_UP state
	public void setShoot(boolean set){
		shoot = set;
	}
	
	//Returns the movement vector to zero on ACTION_UP
	public void setImobile(){
		dx = 0;
		dy = 0;
	}
	
	public ArrayList<PlayerBullet> getArray(){
		return bulletArray;
	}
	
	public void removeBullet(int index){
		bulletArray.get(index).remove();
	}
}
