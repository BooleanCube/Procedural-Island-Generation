public class adjacencynoise {

    // island map
    static final char[][] island = new char[4000][4000];
    
    // statistics calculation
    static int iterationCounter = 0;
    static long startTime = 0L;

    // constants
    static final int size = 4000;
    static final int center = 2000;
    static final int radius = 1400;
    static final double variation = 0.65d;

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                ++iterationCounter;
                double pValue = Math.random();
                if(Math.sqrt(Math.pow(i-center, 2) + Math.pow(j-center, 2)) > radius) pValue -= variation;
                if(pValue >= 0.3d) island[i][j] = '*';
                else island[i][j] = ' ';
            }
        }
        printMap();
    }

    static void printMap() {
        double time = (System.currentTimeMillis() - startTime)/1000d;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) 
                sb.append(island[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString()+"\n");
        System.out.println("Iteration Counter: " + iterationCounter + "\nRuntime: " + String.format("%.8f", time) + " seconds");
    }
}
