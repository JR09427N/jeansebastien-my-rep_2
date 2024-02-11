/*************************************************************************
 *
 *  Pace University
 *  Spring 2023
 *  Algorithms and Computing Theory
 *
 *  Course: CS 242
 *  Team members: Jean-Sebastien Rateau
 *  Collaborators: NONE
 *
 *  Assignment: 4
 *  Problem: 
 *  Description: evaluate experimentally the performance of an efficient
implementation of DFS.
 *
 *  Input: 
 *  Output: 
 *
 *  Visible data fields:
 *  
 *
 *  Visible methods:
 *  randomNum, DFS, DFS_Visit
 *
 *
 *   Remarks
 *   
 *   |____________|    |E| = |V| - 1   |   |E| = (|V| - 1)^3/2   |   |E| = (|V| - 1)^2   | 
 *   | |V| = 10   |			221,600	   |		275,900			 |		386,200			 |
 *   | |V| = 100  |			338,700    |		825,700          |		2,362,500		 |
 *   | |V| = 1000 |			1,320,300  |		11,221,600       |		74,830,300		 |
 *   
 *   The choice of data structure used to implement the graph affected the running time expected from my algorithm. Because linked list operations such as get() and add(), which are used in my main and DFS methods, have to traverse through the linked list or create new nodes, it resulted in a higher running time. The structure of the graph also plays a role in the run time because of the order in which the nodes are visited. If the graph has a deep structure like a tree for example, it may take longer to complete because the DFS has to recursively traverse the the deep tree and then backtrack. These factors made the runnning time differ significantly from the expected O(|V| + |E|). The approximate formula for the asymptotic time of DFS is T(n) = c1*v+(E - c2)
 *
 *
 *************************************************************************/
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// prompt user for # of nodes
		System.out.print("V:  ");
		int v = scan.nextInt();
		System.out.println("");
		
		// prompt user for # of edges
		System.out.print("E:  ");
		int e = scan.nextInt();
		System.out.println("");
		
		
		// create and fill parent graph with ints [0 to v-1]
		ArrayList<Integer> A = new ArrayList<>();
		for(int i = 0; i < v; i++) {
			A.add(i);
		}
		
		
		// create adjacency list choosing edges at random
		ArrayList<LinkedList<Integer>> B = new ArrayList<>();
		
		// fill B with inked lists
		for(int i = 0; i < v; i++) {
			B.add(new LinkedList<Integer>());
		}
		
		
		// connect p node to u node
		for(int i = 0; i < e; i++) {
			int u = randomNum(0, v);
			int p = randomNum(0, v);
			while(u == p || B.get(u).contains(p)) {
				u = randomNum(0, v);
				p = randomNum(0, v);
			}
			B.get(u).add(p);
		}
		
		
		for (int i = 0; i < B.size(); i++) {
            LinkedList<Integer> list = B.get(i);
            for (int j = 0; j < list.size(); j++) {
                Integer element = list.get(j);
                System.out.print("-->" + element);
            }
            System.out.println();
        }
		
		System.out.println("B size:  " + B.size());
		System.out.println("******************************************");
		
		System.out.println("t = " + DepthFirstSearch.DFS(B));
	}
	
	
	
	static int randomNum(int min, int max) {
		int n = (int)((Math.random() * max - min) + min);
		
		return n;
	}
	
	
	

}
