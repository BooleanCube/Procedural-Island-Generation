import java.io.*;
import java.util.*;

public class Main {
	
	private static Node[][] map;
	private static ArrayDeque<Integer> current = new ArrayDeque<>();

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
		int offsetX = (int)map.length*0.1;
		int offsetY = (int)map[0].length*0.1;
		int radiusX = (int)map.length*0.9;
		int radiusY = (int)map[0].length*0.9;
		
		addStartNodes(offsetX, radiusX, offsetY, radiusY);

		//O(1)
		while(!current.isEmpty()) {
			for(int i=0; i<current.size(); i++) {
				Node n = current.removeFirst();
				n.value = 1;
				int xOff = (int)Math.random(2);
				int yOff = (int)Math.random(2);
				map[n.x][n.y] = n;
				int x = map.length, y = map[0].length;
				if(n.x/2 == x/2 && n.y/2 == y/2) continue;
				if(n.x/2 <= x/2 && n.y/2 <= y/2) current.addLast(map[n.x+xOff][n.y+offSet]);
				else if(n.x/2 <= x/2 && n.y/2 >= y/2) current.addLast(map[n.x+xOff][n.y-offSet]);
				else if(n.x/2 >= x/2 && n.y/2 >= y/2) current.addLast(map[n.x-xOff][n.y-offSet]);
				else if(n.x/2 >= x/2 && n.y/2 <= y/2) current.addLast(map[n.x-xOff][n.y+offSet]);
				else continue;
			}
		}

		printMap();
	}

	static void addStartNodes(int ox, int rx, int oy, int ry) {
		current.addLast(new Node(0, ox, (int)(Math.random()*(ry+1))+oy));
		current.addLast(new Node(0, rx, (int)(Math.random()*(ry+1))+oy));
		current.addLast(new Node(0, oy, (int)(Math.random()*(rx+1))+ox));
		current.addLast(new Node(0, ry, (int)(Math.random()*(rx+1))+ox));
	}

	static void printMap() {
		for(int[] a : map) {
			for(int b : a) System.out.print(b + " ");
			System.out.println();
		}
	}

}

class Node {
	public int value;
	public int x, y;
	public Node(int v, int x, int y) { 
		this.value=v;
		this.x=x;
		this.y=y;
	}
}
