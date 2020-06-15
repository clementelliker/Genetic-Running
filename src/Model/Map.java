package Model;

public class Map {
	
	public int mapWidth;
	public int mapHeight;
	public int[] tiles;
	public int startTile;
	public int finishTile;
	public int startAngle;
	
	public Map(int mW, int mH,int[] tiles, int sT, int fT, int sA) {
		if(tiles.length == mW*mH) {
			this.tiles = tiles;
			this.mapHeight = mH;
			this.mapWidth = mW;
			this.startTile = sT;
			this.finishTile = fT;
			this.startAngle = sA;
		}else {
			System.out.println("Map cannot be created: dimensions aren't matching");
		}
	}
}
