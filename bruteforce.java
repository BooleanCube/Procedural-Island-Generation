import java.io.*;
import java.util.*;

//there are no rivers in this proc gen method.

public class bruteforce {
    //statistics
    private static int iterationCounter = 0;
    private static long startTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        double r = 5.71428571429d;
        startTime = System.currentTimeMillis();
        Node[][] map = new Node[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                ++iterationCounter;
                map[i][j] = new Node('-');
                if (j>(n/2)-(n/r/2) && j < (n/2)+(n/r/2) && (i > (n/2)-(n/r/2) && i < (n/2)+(n/r/2))) {
                    int rand1 = (int)(Math.random()*100)+1;
                    int dist = (Math.abs(j-n/2)+Math.abs(i-n/2))/2;
                    if (rand1 >= 10+dist) map[i][j].value = '*';
                }
                else if (j > (n/2)-(n/4/2) && j < (n/2)+(n/4/2) && (i > (n/2)-(n/4/2) && i < (n/2)+(n/4/2))) {
                    int rand1 = (int)(Math.random()*100)+1;
                    if (rand1 > 65) map[i][j].value = '*';
                }
            }
        }
        printMap(map);
    }

    //O(1)
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
