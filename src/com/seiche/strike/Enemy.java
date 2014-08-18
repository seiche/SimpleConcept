package com.seiche.strike;

import java.util.Random;

public class Enemy {
	
	private int x;
	private int y;
	private Random shootChance;
	private int cell;

	public Enemy(int xInit){
		y = - 32;
		shootChance = new Random();
		x = shootChance.nextInt(xInit);
		cell = shootChance.nextInt(2);
	}
	
	public void move(){
		y += 3;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean shoot(){
		return shootChance.nextInt(500) > 495;
	}
	
	public int getCell(){
		cell++;
		if(cell > 2)
			cell = 0;
		
		return cell;
	}
	
	public void remove(){
		y = 700;
	}
}
