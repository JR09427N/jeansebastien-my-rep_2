import java.util.ArrayList;
import java.util.LinkedList;

public class DepthFirstSearch {
	
	static int time = 0;
	
	public static long DFS(ArrayList<LinkedList<Integer>> G) {
		long startTime = System.nanoTime();
		int[] color = new int[G.size()];
		int[] d = new int[color.length * 2];
		int[] f = new int[d.length];
		int[] p = new int[f.length];
		
		
		for(int i = 0; i < color.length; i++) {
			color[i] = 0;
		}
		
		for(int i = 0; i < color.length; i++) {
			if(color[i] == 0) {
				DFS_Visit(G, i, color, d, f, p);
			}
		}
		
		return System.nanoTime() - startTime;
	}
	
	
	public static void DFS_Visit(ArrayList<LinkedList<Integer>> G, int u, int[] color, int[] d, int[] f, int[] p) {
		time = time + 1;
		d[u] = time;
		color[u] = 1;
		
		LinkedList<Integer> adjList = G.get(u);
		
		for(int v : adjList) {
			if(color[v] == 0) {
				p[v] = u;
				DFS_Visit(G, v, color, d, f, p);
			}
		}
		
		time++;
		f[u] = time;
		color[u] = 2;
		
	}
	
	
	
}
