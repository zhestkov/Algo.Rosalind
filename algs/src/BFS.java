import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BFS {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  
    private int[] edgeTo;      
    private int[] distTo;     

    
    public BFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++) distTo[v] = INFINITY;
        bfs(G, s);
    }

    
    public BFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++) distTo[v] = INFINITY;
        bfs(G, sources);
    }

    
    private void bfs(Digraph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        marked[s] = true;
        distTo[s] = 0;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    
    private void bfs(Digraph G, Iterable<Integer> sources) {
        Queue<Integer> q = new Queue<Integer>();
        for (int s : sources) {
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);
        }
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    
    public int distTo(int v) {
        return distTo[v];
    }

    
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("inBFS.txt"));
        PrintWriter out = new PrintWriter(new File("outBFS.txt"));
        int V = in.nextInt();
        int E = in.nextInt();
        Digraph G = new Digraph(V+1);
        for (int i = 0; i < E; i++) {
        	int v = in.nextInt();
        	int w = in.nextInt();
        	G.addEdge(v, w);
        }
        int s = 1;
        BFS bfs = new BFS(G, s);

        for (int v = 1; v < G.V(); v++) {
            if (bfs.hasPathTo(v)) 
                out.print(bfs.distTo[v] + " ");
            else
            	out.print(-1 + " ");
        }
        in.close();
        out.close();
         
    }

}
