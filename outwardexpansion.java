import java.io.*;
import java.util.*;

//rivers are not manually generated but can occur coincidentally

public class outwardexpansion {
    //statistics
    private static int iterationCounter = 0;
    private static long startTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int c = n/2;
        double r = (n*0.8)/2.0;
        startTime = System.currentTimeMillis();
        Node[][] map = new Node[n][n];
        double offC = 2.4/n;
        for(int i=0; i<r; i++) {
            for(int j=0; j<r; j++) {
                ++iterationCounter;
                double d = Math.sqrt(Math.pow(i,2) + Math.pow(j,2));
                if(d>=r) continue;
                double off = d*offC;
                if(Math.random()>off) map[c+i][c+j] = new Node('*');
                if(Math.random()>off) map[c-i][c+j] = new Node('*');
                if(Math.random()>off) map[c+i][c-j] = new Node('*');
                if(Math.random()>off) map[c-i][c-j] = new Node('*');
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
                    if(b != null) sb.append(b.value).append(" ");
                    else sb.append("- ");
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
