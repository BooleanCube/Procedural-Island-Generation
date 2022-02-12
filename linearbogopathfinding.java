import java.io.*;
import java.util.*;

public class linearbogopathfinding {
	
    //generation
	private static Node[][] map;
	private static ArrayDeque<Node> current = new ArrayDeque<>();

    //statistics
    private static int iterationCounter = 0;
    private static long startTime = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//input map sizes:
		int x = Integer.parseInt(bf.readLine());
		int y = Integer.parseInt(bf.readLine());
    
    	if(x < 20 || y < 20) {
        	System.out.println("The map sizes must be larger than a 20x20. Each side must be larger than 20!");
        	return;
    	}

		map = new Node[x][y];
		bogoPathfinding();
	}

	static void bogoPathfinding() {
    	startTime = System.currentTimeMillis();

		//start with 6 nodes
		int offsetX = (int)(map.length*0.1);
		int offsetY = (int)(map[0].length*0.1);
		int radiusX = (int)(map.length*0.9);
		int radiusY = (int)(map[0].length*0.9);
		
		addStartNodes(offsetX, radiusX, offsetY, radiusY);

		//whole nested loop O(n)
		while(!current.isEmpty()) {
        	//O(1) because current.size is constant
			for(int i=0; i<current.size(); i++) {
				++iterationCounter;
				Node n = current.removeFirst();
				if(n.value.equals("*")) continue;
				n.value = "*";
				int xOff = (int)(Math.random()*2);
				int yOff = (int)(Math.random()*2);
				map[n.x][n.y] = n;
				int x = map.length, y = map[0].length;
				if(n.x == x/2 && n.y == y/2) continue;
				if(n.x <= x/2 && n.y <= y/2) current.addLast(new Node("-", n.x+xOff, n.y+yOff));
				else if(n.x <= x/2 && n.y >= y/2) current.addLast(new Node("-", n.x+xOff, n.y-yOff));
				else if(n.x >= x/2 && n.y >= y/2) current.addLast(new Node("-", n.x-xOff, n.y-yOff));
				else if(n.x >= x/2 && n.y <= y/2) current.addLast(new Node("-", n.x-xOff, n.y+yOff));
				else continue;
			}
		}

		printMap();
	}

    //O(n)
	static void addStartNodes(int ox, int rx, int oy, int ry) {
    	int varianceX = ox/2, varianceY = oy/2;
		for(int i=ox; i<=rx; i++) {
      		current.addLast(new Node("-", i, oy+(int)(Math.random()*(varianceY*2+1)-varianceY)));
      		current.addLast(new Node("-", i, ry+(int)(Math.random()*(varianceY*2+1)-varianceY)));
      		++iterationCounter;
    	}
    	for(int i=oy; i<=ry; i++) {
      		current.addLast(new Node("-", ox+(int)(Math.random()*(varianceX*2+1)-varianceX), i));
      		current.addLast(new Node("-", rx+(int)(Math.random()*(varianceX*2+1)-varianceX), i));
     		++iterationCounter;
    	}
	}

    //O(1)
	static void printMap() {
    	double time = (System.currentTimeMillis()-startTime)/1000.0;
    	StringBuilder sb = new StringBuilder();
		for(Node[] a : map) {
			for(Node b : a) {
        		if(b != null) sb.append(b.value);
        		else sb.append("-");
      		}
			sb.append("\n");
		}
    	System.out.println(sb.toString());
    	System.out.println("Iteration Count: " + iterationCounter + " iterations");
    	System.out.println("Runtime: " + time + " seconds");
	}

}

class Node {
	public String value;
	public int x, y;
	public Node(String v, int x, int y) { 
		this.value=v;
		this.x=x;
		this.y=y;
	}
}
