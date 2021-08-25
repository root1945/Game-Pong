package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	public boolean right, left;
	public int x,y;
	
	public int width, height;
	
	Player(int x, int y){
		this.x = x;
		this.y = y;
		width = 40;
		height = 10;
	}
	
	public void tick() {
		if(right) {
			x++;
		}
		if(left) {
			x--;
		}
		
		if (x + width > Game.WIDTH) {
			x = Game.WIDTH - width;
		}
		else if(x < 0) {
			x = 0;
		}
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}
	
}
