package com.seiche.strike;

public class PlayerBullet {

	private int x;
	private int y;
	
	public PlayerBullet(int xInit, int yInit){
		x = xInit;
		y = yInit;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void move(){
		y -= 4;
	}
	
	public void remove(){
		y = -100;
	}
	
}
