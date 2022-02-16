import java.io.*;
import java.util.*;

//rivers are not manually generated but they can coincidentally occur
//keeps the shape more circular with a set radius

public class outwardexpansion {
    //statistics
    private static int iterationCounter = 0;
    private static long startTime = 0;

    //constants
    static double treeIso = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int c = n/2;
        double r = (n*0.8)/2.0;
        startTime = System.currentTimeMillis();
        Node[][] map = new Node[n][n];
        double offC = 2.4/n;
        int[] lastTreeX={c,c,c,c}, lastTreeY={c,c,c,c};
        for(int i=0; i<r; i++) {
            for(int j=0; j<r; j++) {
                ++iterationCounter;
                double d = Math.sqrt(Math.pow(i,2) + Math.pow(j,2));
                if(d>=r) continue;
                double off = d*offC;
                double treeP = off;
                if(Math.random()>off) {
                    map[c+i][c+j] = new Node('*');
                    if(Math.random()>treeP && (Math.abs(lastTreeX[0]-(c+i))>treeIso && Math.abs(lastTreeY[0]-(c+j))>treeIso)) {
                        map[c+i][c+j].value = '#';
                        lastTreeX[0] = c+i; lastTreeY[0] = c+j;
                    } 
                }
                if(Math.random()>off) {
                    map[c-i][c+j] = new Node('*');
                    if(Math.random()>treeP && (Math.abs(lastTreeX[1]-(c-i))>treeIso && Math.abs(lastTreeY[1]-(c+j))>treeIso)) {
                        map[c-i][c+j].value = '#';
                        lastTreeX[1] = c-i; lastTreeY[1] = c+j;
                    }
                }
                if(Math.random()>off) {
                    map[c+i][c-j] = new Node('*');
                    if(Math.random()>treeP && (Math.abs(lastTreeX[2]-(c+i))>treeIso && Math.abs(lastTreeY[2]-(c-j))>treeIso)) {
                        map[c+i][c-j].value = '#';
                        lastTreeX[2] = c+i; lastTreeY[2] = c-j;
                    }
                }
                if(Math.random()>off) {
                    map[c-i][c-j] = new Node('*');
                    if(Math.random()>treeP && (Math.abs(lastTreeX[3]-(c-i))>treeIso && Math.abs(lastTreeY[3]-(c-j))>treeIso)) {
                        map[c-i][c-j].value = '#';
                        lastTreeX[3] = c-i; lastTreeY[3] = c-j;
                    } 
                }
            }
        }
        printMap(map);
    }

    //O(n)
    static void printMap(Node[][] map) {
        /*
        * = land
        # = tree
        [space] = water
        */
        double time = (System.currentTimeMillis()-startTime)/1000.0;
        StringBuilder sb = new StringBuilder();
            for(Node[] a : map) {
                for(Node b : a) {
                    if(b != null) sb.append(b.value).append(" ");
                    else sb.append("  ");
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
