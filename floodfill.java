import java.io.*;
import java.util.*;

public class floodfill {
    
    //statistics
    static int iterationCounter = 0;
    static long startTime = 0;

    //map
    static Node[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        map = new Node[n][n];
        startTime = System.currentTimeMillis();
        int c = n/2;
        map[c][c] = new Node('z',c,c);
        fillIsland(c, c, map[c][c], 2.4/n, n*0.4);
        printMap();
    }

    static void fillIsland(int x, int y, Node center, double offC, double radius) {
        if(map[x][y] == null || map[x][y].value == 'z') map[x][y] = new Node(' ', x, y);
        else return;
        double d = Math.sqrt(Math.pow(x-center.x, 2) + Math.pow(y-center.y, 2));
        if(d>radius) return;
        iterationCounter++;
        double off = d*offC;
        if(Math.random() > off) map[x][y].value = '*';
        fillIsland(x+1, y, center, offC, radius);
        fillIsland(x-1, y, center, offC, radius);
        fillIsland(x, y+1, center, offC, radius);
        fillIsland(x, y-1, center, offC, radius);
    }

    static void printMap() {
        double time = (System.currentTimeMillis()-startTime)/1000d;
        StringBuilder sb = new StringBuilder();
        for(Node[] l : map) {
            for(Node n : l) {
                if(n != null) sb.append(n.value).append(' ');
                else sb.append("  ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
        System.out.println("Iteration Counter: " + iterationCounter + "\nRuntime: " + time + " seconds");
    }

}

class Node {
    public int x, y;
    public char value = 'z';
    public Node(char v, int x, int y) {
        value = v;
        this.x = x;
        this.y = y;
    }
}
