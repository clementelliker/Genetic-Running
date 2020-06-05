package Model;

public class Map {
	
	public int mapWidth;
	public int mapHeight;
	public int[] tiles;
	
	public Map(int mW, int mH,int[] tiles) {
		if(tiles.length == mW*mH) {
			this.tiles = tiles;
			this.mapHeight = mH;
			this.mapWidth = mW;
		}else {
			System.out.println("Map cannot be created: dimensions aren't matching");
		}
	}
}
