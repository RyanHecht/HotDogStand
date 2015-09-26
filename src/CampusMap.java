import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;


public class CampusMap implements TileBasedMap {
	public static int[][] map = new int[98][151];
	public CampusMap() {
		BufferedReader br=null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\Ryan\\Desktop\\map.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		for(int row=0;row<98;row++) {
			String line=null;
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			for(int col=0;col<151;col++) {
				map[row][col] = Integer.parseInt(line.substring(col, col+1));
			}
		}
	}
	@Override
	public boolean blocked(PathFindingContext arg0, int x, int y) {
		return map[y][x] == 0;
	}

	@Override
	public float getCost(PathFindingContext arg0, int arg1, int arg2) {
		return 1.0f;
	}

	@Override
	public int getHeightInTiles() {
		return map.length;
	}

	@Override
	public int getWidthInTiles() {
		return map[0].length;
	}

	@Override
	public void pathFinderVisited(int arg0, int arg1) {		
	}

}
