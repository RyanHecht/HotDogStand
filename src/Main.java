
import java.util.ArrayList;
import org.newdawn.slick.util.pathfinding.AStarHeuristic;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;


public class Main {
	public static CampusMap map = new CampusMap();
	public static ArrayList<Student> students = new ArrayList<Student>();	
	public static void main(String[] args) {
		new Window();
		
		int[][] heatmap = new int[98][151];
		for(int row=0; row<98; row++) {
			for(int col=0; col<151; col++) {
				heatmap[row][col] = 0;
			}
		}
		System.out.println("Spawning Students...");
		for(int i=0; i<400; i++) {
			students.add(new Student(new Point(0,15)));
		}
		for(int i=0; i<300; i++) {
			students.add(new Student(new Point(110,15)));
		}
		for(int i=0; i<300; i++) {
			students.add(new Student(new Point(124,0)));
		}
		for(int i=0; i<300; i++) {
			students.add(new Student(new Point(141,14)));
		}
		for(int i=0; i<300; i++) {
			students.add(new Student(new Point(125,30)));
		}
		for(int i=0; i<800; i++) {
			students.add(new Student(new Point(59,97)));
		}
		for(int i=0; i<800; i++) {
			students.add(new Student(new Point(0,97)));
		}
		
		System.out.println("Finding paths...");
		AStarPathFinder pathFinder = new AStarPathFinder(map, 9999, false);
		for(Student s : students) {
			Point d = s.getDest();
			Point c = s.getPos();
			Path path = pathFinder.findPath(null, c.getX(), c.getY(), d.getX(), d.getY());
			if(path==null) System.out.println("null path");
			else {
			for(int i=0; i < path.getLength(); i++) {
				heatmap[path.getY(i)][path.getX(i)]++;
			}
			}
		}
		System.out.println("Finding max...");
		int max = Integer.MIN_VALUE;
		int maxrow=0,maxcol=0;
		for(int row=0; row<98; row++) {
			for(int col=0; col<151; col++) {
				if(heatmap[row][col] > max) {
					max=heatmap[row][col];
					maxrow=row;
					maxcol=col;
				}
			}
		}
		System.out.println("The optimal position is X: " + maxcol + " Y: " + maxrow + ". It is traveled through " + max + " times.");
}
}

