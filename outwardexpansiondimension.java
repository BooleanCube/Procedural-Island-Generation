import java.io.*;
import java.util.*;

//there are no rivers in this proc gen method.

public class outwardexpansion {
    //statistics
    private static int iterationCounter = 0;
    private static long startTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bf.readLine()), y = Integer.parseInt(bf.readLine());
        int cx = x/2, cy = y/2;
        double rx = (x*0.8)/2.0;
        double ry = (y*0.8)/2.0;
        startTime = System.currentTimeMillis();
        Node[][] map = new Node[x][y];
        for(int i=0; i<rx; i++) {
            for(int j=0; j<ry; j++) {
                ++iterationCounter;
                if(Math.random()>0.19) map[cx+i][cy+j] = new Node('*');
                if(Math.random()>0.19) map[cx-i][cy+j] = new Node('*');
                if(Math.random()>0.19) map[cx+i][cy-j] = new Node('*');
                if(Math.random()>0.19) map[cx-i][cy-j] = new Node('*');
            }
        }
        printMap(map);
    }

    //O(n)
    static void printMap(Node[][] map) {
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
    public char value;
    public Node(char v) { value = v; }
}
