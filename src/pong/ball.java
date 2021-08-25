package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class ball {

	public double x, y;
	public int width, height;
	
	public double dx, dy;
	public double speed = 1.3;
	
	public ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 4;
		this.height = 4;
		
		this.dx = new Random().nextGaussian();
		this.dy = new Random().nextGaussian();
	}
	
	public void tick() {
		
		 if (x + (dx * speed) + width >= Game.WIDTH) {
			 dx *= -1;
		 }else if(x + (dx * speed) < 0) {
			 dx *= -1;
		 }
		 
		 //Pontua��o
		 if(y >= Game.HEIGHT) {
			 //Ponto do Inimigo
			 System.out.println("Ponto do Inimigo");
			 new Game();
			 return;
		 }else if(y < 0){
			 //Ponto do Jogador.
			 System.out.println("Ponto do Player");
			 new Game();
			 return;
		 }
		 
		Rectangle bounds = new Rectangle((int) (x + (dx * speed)), (int) (y + (dy * speed)), width, height);
		
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);
		
		if(bounds.intersects(boundsPlayer)) {
			dy *= -1;
		}else if (bounds.intersects(boundsEnemy)) {
			dy *= -1;
		}
		
		x += dx * speed;
		y += dy * speed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, width, height);
	}
	
}
