package com.seiche.strike;

public class Explosion {

	private int x;
	private int y;
	private int cell = 0;
	
	public Explosion (int xInit, int yInit){
		x = xInit;
		y = yInit;
	}
	
	public int getCell(){
		return cell;
	}
	
	public void nextCell(){
		cell++;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}
