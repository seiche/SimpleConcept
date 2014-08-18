package com.seiche.strike;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class GameObject {
	Background background;
	Player player;
	
	ArrayList<Enemy> enemy;
	Bitmap[] enemyImg = new Bitmap[3];
	
	ArrayList<EnemyBullet> bulletArray;
	Bitmap enemyBulletImg;
	
	ArrayList<Explosion> explodeArray;
	Bitmap[] explosion = new Bitmap[6];
	
	public GameObject(Surface v){
		background = new Background(v);
		player = new Player(v);
		enemy = new ArrayList<Enemy>();
		bulletArray = new ArrayList<EnemyBullet>();
		explodeArray = new ArrayList<Explosion>();
		
		enemyImg[0] = BitmapFactory.decodeResource(v.getResources(), R.drawable.enemy01);
		enemyImg[1] = BitmapFactory.decodeResource(v.getResources(), R.drawable.enemy02);
		enemyImg[2] = BitmapFactory.decodeResource(v.getResources(), R.drawable.enemy03);
		enemyBulletImg = BitmapFactory.decodeResource(v.getResources(), R.drawable.bullet1);
		
		explosion[0] = BitmapFactory.decodeResource(v.getResources(), R.drawable.explosion01);
		explosion[1] = BitmapFactory.decodeResource(v.getResources(), R.drawable.explosion02);
		explosion[2] = BitmapFactory.decodeResource(v.getResources(), R.drawable.explosion03);
		explosion[3] = BitmapFactory.decodeResource(v.getResources(), R.drawable.explosion04);
		explosion[4] = BitmapFactory.decodeResource(v.getResources(), R.drawable.explosion05);
		explosion[5] = BitmapFactory.decodeResource(v.getResources(), R.drawable.explosion06);
	}
	
	
	public void draw(Canvas canvas, int width, int height){
		background.draw(canvas, width, height);
		player.draw(canvas, width, height);
		
		manageEnemy(canvas, width, height);
	}
	
	
	public void manageEnemy(Canvas c, int width, int height){
		if(Math.random() > .94)
			enemy.add(new Enemy(width));
		
		for(int i = 0; i < enemy.size(); i++){
			enemy.get(i).move();
			c.drawBitmap(enemyImg[enemy.get(i).getCell()], enemy.get(i).getX()-16, enemy.get(i).getY()-16, null);
			
			if(enemy.get(i).shoot()){
				bulletArray.add(new EnemyBullet(enemy.get(i).getX(),enemy.get(i).getY()+16,-1));
				bulletArray.add(new EnemyBullet(enemy.get(i).getX(),enemy.get(i).getY()+16,0));
				bulletArray.add(new EnemyBullet(enemy.get(i).getX(),enemy.get(i).getY()+16,1));
			}
			
			if(enemy.get(i).getY()-16 > height)
				enemy.remove(i);
		}
		
		for(int i = 0; i < bulletArray.size(); i++){
			bulletArray.get(i).move();
			c.drawBitmap(enemyBulletImg, bulletArray.get(i).getX()-16, bulletArray.get(i).getY()-16, null);
			
			if(bulletArray.get(i).getY() > height)
				bulletArray.remove(i);
		}
		
		collision();
		
		for(int i = 0; i < explodeArray.size(); i++){

			if(explodeArray.get(i).getCell() > 5)
				explodeArray.remove(i);
		}
		
		for(int i = 0; i < explodeArray.size(); i++){
			c.drawBitmap(explosion[explodeArray.get(i).getCell()], explodeArray.get(i).getX() - 16, explodeArray.get(i).getY()-16, null);
			explodeArray.get(i).nextCell();
		}
	}
	
	public void collision(){
		ArrayList<PlayerBullet> temp = player.getArray();
		
		for(int i = 0; i < temp.size(); i++){
			for(int k = 0; k < enemy.size(); k++){
				int xDect = temp.get(i).getX() - enemy.get(k).getX();
				int yDect = temp.get(i).getY() - enemy.get(k).getY();
				xDect = xDect*xDect;
				yDect = yDect*yDect;
				
				if(xDect + yDect < 200){
					explodeArray.add(new Explosion(enemy.get(k).getX(), enemy.get(k).getY()));
					player.removeBullet(i);
					enemy.get(k).remove();
				}
			}
		}
		
	}
	
	
}

