package com.seiche.strike;

public class EnemyBullet {

	private double x;
	private double y;
	private double dx = 0;
	private double dy = 0;
	
	public EnemyBullet(int xInit, int yInit, int angle){
		x = (double)xInit;
		y = (double)yInit;
		
		switch (angle){
		case -1:
			dx = -1;
			dy = 3.5;
			break;
		case 0:
			dx = 0;
			dy = 4;
			break;
		case 1:
			dx = 1;
			dy = 3.5;
			break;
		}
	}
	
	public void move(){
		x += dx;
		y += dy;
	}
	
	public int getX(){
		return (int)x;
	}
	
	public int getY(){
		return (int)y;
	}
	
	public void remove(){
		y = 720;
	}
}
