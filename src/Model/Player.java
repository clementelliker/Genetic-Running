package Model;

import java.awt.event.KeyEvent;
import java.lang.Math;

public class Player {
	
	public Game game;
	public int hitBoxRay;
	public double xpos;
	public double ypos;
	public double angle;	
	public double speed = 0.7;
	public double sensibility = 0.02;
	public double[][] wallDists;
	
	public Player(int x, int y, int hBR, int angle) {
		this.xpos = x;
		this.ypos = y;	
		this.hitBoxRay = hBR;
		this.angle = angle;
		this.wallDists = new double[5][3];
	}
	
	public void linkGame(Game g) {
		this.game = g;
	}
	
	public void udpatePlayer() {
		this.xpos += Math.cos(this.angle)*speed;
		this.ypos += Math.sin(this.angle)*speed;
		//System.out.println(this.playerTilesPos());
	}

	public void qPressed() {
		this.angle -= this.sensibility;
	}
	
	public void dPressed() {
		this.angle += this.sensibility;
	}
	
	public int playerTilesPos() {
		return this.game.map.mapHeight*(int)(this.ypos*this.game.map.mapHeight/this.game.window.wdHeight) + (int)(this.xpos*this.game.map.mapWidth/this.game.window.wdWidth);
	}
	
	public boolean hittingWall() {
		int currentTile = this.playerTilesPos();
		if(this.game.map.tiles[currentTile] == 1) {
			return true; 
		}else {
			if(this.tilePos(currentTile) == "top left") {
				//System.out.println("top left");
				return this.hittingRightWall(currentTile) || this.hittingBottomWall(currentTile) || this.hittingBottomRightWall(currentTile)
						|| this.xpos - this.hitBoxRay < 0 || this.ypos - this.hitBoxRay < 0;
				
			}else if(this.tilePos(currentTile) == "top right") {
				//System.out.println("top right");
				return this.hittingLeftWall(currentTile) || this.hittingBottomWall(currentTile) || this.hittingBottomLeftWall(currentTile)
						|| this.xpos + this.hitBoxRay > this.game.window.wdWidth || this.ypos - this.hitBoxRay < 0;
						
			}else if(this.tilePos(currentTile) == "bottom left") {
				//System.out.println("bottom left");
				return this.hittingTopWall(currentTile) || this.hittingRightWall(currentTile) || this.hittingTopRightWall(currentTile)
						|| this.xpos - this.hitBoxRay < 0 || this.ypos + this.hitBoxRay > this.game.window.wdHeight;
						
			}else if(this.tilePos(currentTile) == "bottom right") {
				//System.out.println("bottom right");
				return this.hittingTopWall(currentTile) || this.hittingLeftWall(currentTile) || this.hittingTopLeftWall(currentTile)
						|| this.xpos + this.hitBoxRay > this.game.window.wdWidth || this.ypos + this.hitBoxRay > this.game.window.wdHeight;
						
			}else if(this.tilePos(currentTile) == "top") {
				//System.out.println("top");
				return this.hittingLeftWall(currentTile) || this.hittingBottomLeftWall(currentTile) || this.hittingBottomWall(currentTile)
						|| this.hittingBottomRightWall(currentTile) || this.hittingRightWall(currentTile) || this.ypos - this.hitBoxRay < 0;
				
			}else if(this.tilePos(currentTile) == "left") {
				//System.out.println("left");
				return this.hittingTopWall(currentTile) || this.hittingTopRightWall(currentTile) || this.hittingRightWall(currentTile)
						|| this.hittingBottomRightWall(currentTile) || this.hittingBottomWall(currentTile) || this.xpos - this.hitBoxRay < 0;
				
			}else if(this.tilePos(currentTile) == "bottom") {
				//System.out.println("bottom");
				return this.hittingLeftWall(currentTile) || this.hittingTopLeftWall(currentTile) || this.hittingTopWall(currentTile)
						|| this.hittingTopRightWall(currentTile) || this.hittingRightWall(currentTile) || this.ypos + this.hitBoxRay > this.game.window.wdHeight;
				
			}else if(this.tilePos(currentTile) == "right") {
				//System.out.println("right");
				return this.hittingTopLeftWall(currentTile) || this.hittingLeftWall(currentTile) || this.hittingTopWall(currentTile)
						|| this.hittingBottomLeftWall(currentTile) || this.hittingBottomWall(currentTile) || this.xpos + this.hitBoxRay > this.game.window.wdWidth;
				
			}else if(this.tilePos(currentTile) == "center"){
				//System.out.println("center");
				return this.hittingBottomLeftWall(currentTile) || this.hittingBottomRightWall(currentTile) || this.hittingBottomWall(currentTile)
						|| this.hittingLeftWall(currentTile) || this.hittingRightWall(currentTile) || this.hittingTopLeftWall(currentTile)
						|| this.hittingTopRightWall(currentTile) || this.hittingTopWall(currentTile);
			}
			return false;
		}
	}
	
	public String tilePos(int tile) {
		if(tile == 0) return "top left";
		if(tile == this.game.map.mapWidth-1) return "top right";
		if(tile == this.game.map.mapWidth*this.game.map.mapHeight - this.game.map.mapWidth) return "bottom left";
		if(tile == this.game.map.mapWidth*this.game.map.mapHeight-1) return "bottom right";
		if(tile%this.game.map.mapWidth == 0) return "left";
		if(tile%this.game.map.mapWidth == this.game.map.mapWidth-1) return "right";
		if(tile < this.game.map.mapWidth) return "top";
		if(tile > this.game.map.mapWidth*this.game.map.mapHeight - this.game.map.mapWidth-1) return "bottom";
		return "center";
	}
	
	public boolean hittingTopWall(int tile) {
		int topTile = tile - this.game.map.mapWidth;
		double maxBottom = (((int)topTile/this.game.map.mapHeight) + 1)*this.game.window.wdHeight/this.game.map.mapHeight;					
		return (this.ypos-this.hitBoxRay) < maxBottom && this.game.map.tiles[topTile] == 1;
	}
	
	public boolean hittingBottomWall(int tile) {
		int bottomTile = tile + this.game.map.mapWidth;
		double maxTop = ((int)(bottomTile/this.game.map.mapHeight))*this.game.window.wdHeight/this.game.map.mapHeight;	
		return (this.ypos+this.hitBoxRay) > maxTop && this.game.map.tiles[bottomTile] == 1;
	}
	
	public boolean hittingLeftWall(int tile) {
		int leftTile = tile - 1;
		double maxRight = (leftTile%this.game.map.mapWidth + 1)*this.game.window.wdWidth/this.game.map.mapWidth;
		return this.xpos-this.hitBoxRay < maxRight && this.game.map.tiles[leftTile] == 1;
	}
	
	public boolean hittingRightWall(int tile) {
		int rightTile = tile + 1;
		double maxLeft = rightTile%this.game.map.mapWidth*this.game.window.wdWidth/this.game.map.mapWidth;
		return this.xpos+this.hitBoxRay > maxLeft && this.game.map.tiles[rightTile] == 1;
	}
	
	public boolean hittingTopLeftWall(int tile) {
		int topLeftTile = tile - this.game.map.mapWidth - 1;
		double maxBot = ((int)(topLeftTile/this.game.map.mapHeight + 1))*this.game.window.wdHeight/this.game.map.mapHeight;
		double maxRight = (topLeftTile%this.game.map.mapWidth + 1)*this.game.window.wdWidth/this.game.map.mapWidth;
		return Maths.dist(this.xpos, this.ypos, maxRight, maxBot) < this.hitBoxRay && this.game.map.tiles[topLeftTile] == 1;
	}
	
	public boolean hittingBottomLeftWall(int tile) {
		int bottomLeftTile = tile + this.game.map.mapWidth - 1;
		double maxTop = ((int)(bottomLeftTile/this.game.map.mapHeight))*this.game.window.wdHeight/this.game.map.mapHeight;
		double maxRight = (bottomLeftTile%this.game.map.mapWidth + 1)*this.game.window.wdWidth/this.game.map.mapWidth;
		return Maths.dist(this.xpos, this.ypos, maxRight, maxTop) < this.hitBoxRay && this.game.map.tiles[bottomLeftTile] == 1;
	}
	
	public boolean hittingTopRightWall(int tile) {
		int topRightTile = tile - this.game.map.mapWidth + 1; 
		double maxBot = ((int)(topRightTile/this.game.map.mapHeight + 1))*this.game.window.wdHeight/this.game.map.mapHeight;
		double maxLeft = topRightTile%this.game.map.mapWidth*this.game.window.wdWidth/this.game.map.mapWidth;
		return Maths.dist(this.xpos, this.ypos, maxLeft, maxBot) < this.hitBoxRay && this.game.map.tiles[topRightTile] == 1;
	}
	
	public boolean hittingBottomRightWall(int tile) {
		int bottomRightTile = tile + this.game.map.mapWidth + 1;
		double maxTop = ((int)(bottomRightTile/this.game.map.mapHeight))*this.game.window.wdHeight/this.game.map.mapHeight;
		double maxLeft = bottomRightTile%this.game.map.mapWidth*this.game.window.wdWidth/this.game.map.mapWidth;
		return Maths.dist(this.xpos, this.ypos, maxLeft, maxTop) < this.hitBoxRay && this.game.map.tiles[bottomRightTile] == 1;
	}
	
	public void getWallDist() {		
		this.wallDists[0] = getWallDist(-Math.PI/2);
		this.wallDists[1] = getWallDist(-Math.PI/4);
		this.wallDists[2] = getWallDist(0);
		this.wallDists[3] = getWallDist(Math.PI/4);
		this.wallDists[4] = getWallDist(Math.PI/2);
	}
	
	public double[] getWallDist(double theta) {
		double ret = 0;
		double x = this.xpos;
		double y = this.ypos;
		while(x > 0 && x < this.game.window.wdWidth && y > 0 
				&& y < this.game.window.wdHeight && this.game.map.tiles[getTilesPos(x,y)] != 1) {
			x += Math.cos(this.angle + theta)*this.speed*10;
			y += Math.sin(this.angle + theta)*this.speed*10;
			ret += this.speed*10;
		}
		return new double[] {ret-this.hitBoxRay, x, y};
	}
	
	public int getTilesPos(double x, double y) {
		return this.game.map.mapHeight*(int)(y*this.game.map.mapHeight/this.game.window.wdHeight) + (int)(x*this.game.map.mapWidth/this.game.window.wdWidth);
	}

	public void getInput() {
		// TODO Auto-generated method stub
		
	}

	public boolean lapDone() {
		return this.playerTilesPos() == this.game.map.finishTile;
	}
	
	
}
