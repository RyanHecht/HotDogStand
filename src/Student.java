import java.util.Random;


public class Student {
	Point o;
	Point d;
	Point c;
	
	public Student(Point origin) {
	o=origin;
	c=o;
	int x,y;
	Random r = new Random();
	//this do loop is for given dorm locations
	do {	
	int dorm = r.nextInt(7);
	switch(dorm) {
	case 0:
		d=new Point(0,15);
		break;
	case 1:
		d=new Point(110,15);
		break;
	case 2:
		d=new Point(124,0);
		break;
	case 3:
		d=new Point(141,14);
		break;
	case 4:
		d=new Point(125,30);
		break;
	case 5:
		d=new Point(59,97);
		break;
	case 6:
		d=new Point(0,97);
		break;
	}
	} while(d.equals(o));
	}
	
	//this do loop is for randomized locations
	/*
	do {
	x = r.nextInt(151);
	y = r.nextInt(98);
	d=new Point(x,y);
	} while(Main.map.blocked(null, x, y));
	} 
	*/
	public Point getDest() {
		return d;
	}
	public Point getPos() {
		return c;
	} 


}