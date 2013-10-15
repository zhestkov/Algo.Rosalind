import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class DoubleDegree_Array {
	
	private static class Graph {
		
		private final int V;
		private int E;
		private LinkedList<Integer>[] adj;
		//private Bag<Integer>[] adj;
		public Graph(int V) {
			this.V = V;
			this.E = 0;
			adj = (LinkedList<Integer>[]) new LinkedList[V]; 
			//adj = (Bag<Integer>[]) new Bag[V];
			for (int i = 0; i < V; i++)
				adj[i] = new LinkedList<Integer>();
		}
		public void addEdge(int v, int w) {
			adj[v].add(w);
			adj[w].add(v);
			E++;
		}
		public LinkedList<Integer> adj(int v) {
			return this.adj[v];
		}
		
		
	}
	
	
	public static int degree(Graph G, int v) {
		int cnt = 0;
		for (int w : G.adj(v))
			cnt += G.adj[w].size();
		return cnt;
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("inDDArray.txt"));
		PrintWriter out = new PrintWriter(new File("outDDArray.txt"));
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
