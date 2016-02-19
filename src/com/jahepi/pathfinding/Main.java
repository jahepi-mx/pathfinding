package com.jahepi.pathfinding;

import com.jahepi.pathfinding.algorithms.A;
import com.jahepi.pathfinding.algorithms.BreadthFirstSearch;
import com.jahepi.pathfinding.algorithms.Dijkstra;
import com.jahepi.pathfinding.algorithms.Heuristic;

public class Main {

	public Main() {
	}
	
	public void run() {
		NodeMap map = new NodeMap();
		Node start = map.getNode(0, 12);
		Node end = map.getNode(14, 2);
		
		BreadthFirstSearch bfs = new BreadthFirstSearch(map);
		Dijkstra d = new Dijkstra(map);
		Heuristic h = new Heuristic(map);
		A a = new A(map);
		
		bfs.run(start, end);
		System.out.println("\n");
		d.run(start, end);
		System.out.println("\n");
		h.run(start, end);
		System.out.println("\n");
		a.run(start, end);
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
}
