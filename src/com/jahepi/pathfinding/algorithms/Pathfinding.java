package com.jahepi.pathfinding.algorithms;

import java.util.ArrayList;
import java.util.Iterator;

import com.jahepi.pathfinding.Node;
import com.jahepi.pathfinding.NodeMap;

public abstract class Pathfinding {

	private static final String WALL = "O|";
	private static final String EMPTY = " |";
	private static final String PATH = "x|";
	
	protected ArrayList<Node> path = new ArrayList<Node>();
	protected NodeMap map;
	
	public Pathfinding(NodeMap map) {
		this.map = map;
	}
	
	public abstract void run(Node start, Node end);
	
	protected void printTable() {
		int[][] bitMap = map.bitMap;
		for (int y = 0; y < bitMap.length; y++) {
			for (int x = 0; x < bitMap[0].length; x++) {		
				Node node = map.getNode(x, y);
				if (node.getValue() >= 1) {
					boolean found = false;
					Iterator<Node> pathIterator = path.iterator();
					while (pathIterator.hasNext()) {
						Node p = pathIterator.next();
						if (p == node) {
							System.out.print(PATH);
							found = true;
							break;
						}
					}
					if (!found) System.out.print(EMPTY);
				} else {
					System.out.print(WALL);
				}
			}
			System.out.print("\n");
		}
	}
}
