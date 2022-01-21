import java.io.*;
import java.util.*;

public class Main {
	
	private static Node[][] map;
	private static ArrayDeque<Node> current = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//input map sizes:
		int x = Integer.parseInt(bf.readLine());
		int y = Integer.parseInt(bf.readLine());

		map = new Node[x][y];
		bogoPathfinding();
	}

	static void bogoPathfinding() {
		//start with 6 nodes
		int offsetX = (int)(map.length*0.1);
		int offsetY = (int)(map[0].length*0.1);
		int radiusX = (int)(map.length*0.9);
		int radiusY = (int)(map[0].length*0.9);
		
		addStartNodes(offsetX, radiusX, offsetY, radiusY);

		//O(1)
		while(!current.isEmpty()) {
			for(int i=0; i<current.size(); i++) {
				Node n = current.removeFirst();
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

	static void addStartNodes(int ox, int rx, int oy, int ry) {
		int[] options = {ox, rx, oy, ry};
		int sn = (int)(((map.length+map[0].length)/2)*2.5);
		System.out.println(sn);
		for(int i=0; i<sn; i++) {
			int idx = (int)(Math.random()*4);
			if(idx < 2) current.addLast(new Node("-", options[idx], (int)(Math.random()*(ry-oy+1))+oy));
			else current.addLast(new Node("-", (int)(Math.random()*(rx-ox+1))+ox, options[idx]));
		}
	}

	static void printMap() {
		for(Node[] a : map) {
			for(Node b : a) System.out.print(b != null ? b.value : "-");
			System.out.println();
		}
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
