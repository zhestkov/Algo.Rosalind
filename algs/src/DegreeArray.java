import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Collection;

public class DegreeArray {
	
	private static class Graph {
		
		private final int V;
		private int E;
		private Bag<Integer>[] adj;
		public Graph(int V) {
			this.V = V;
			this.E = 0;
			adj = (Bag<Integer>[]) new Bag[V];
			for (int i = 0; i < V; i++)
				adj[i] = new Bag<Integer>();
		}
		public void addEdge(int v, int w) {
			adj[v].add(w);
			adj[w].add(v);
			E++;
		}
		public Iterable<Integer> adj(int v) {
			return this.adj[v];
		}
	}
	
	public static int degree(Graph G, int v) {
		int cnt = 0;
		for (int w : G.adj(v))
			cnt++;
		return cnt;
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("inDegreeArray.txt"));
		PrintWriter out = new PrintWriter(new File("outDegreeArray.txt"));
		int V = in.nextInt();
		int E = in.nextInt();
		Graph g = new Graph(V);
		for (int i = 0; i < E; i++) {
			int v = in.nextInt()-1;
			int w = in.nextInt()-1;
			g.addEdge(v, w);
		}
		for (int i = 0; i < V; i++)
			out.print(degree(g, i) + " ");
		
		in.close();
		out.close();
	}

}
