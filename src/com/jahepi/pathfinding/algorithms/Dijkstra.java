package com.jahepi.pathfinding.algorithms;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.jahepi.pathfinding.Node;
import com.jahepi.pathfinding.NodeMap;

public class Dijkstra extends Pathfinding {

	public Dijkstra(NodeMap map) {
		super(map);
	}

	@Override
	public void run(Node start, Node end) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new DijkstraComparator());
		Queue<Node> cameFrom = new LinkedList<Node>();
		
		frontier.add(start);
		double newCost = 0;
		outer: while (!frontier.isEmpty()) {
			Node node = frontier.remove();
			Iterator<Node> siblings = node.getSiblingsIterator();
			while (siblings.hasNext()) {
				Node sibling = siblings.next();
				newCost = node.getValue() + sibling.getValue();
				if (!cameFrom.contains(sibling) || newCost < sibling.getValue()) {
					sibling.setValue(newCost);
					frontier.add(sibling);
					cameFrom.add(sibling);
					sibling.setPrev(node);
					if (node == end) break outer;
				}
			}
		}
		
		boolean done = false;
		Node next = end;
		while (!done) {
			path.add(next);
			if (next == start) {
				done = true;
				continue;
			}
			next = next.getPrev();
		}	
		printTable();
	}
	
	class DijkstraComparator implements Comparator<Node> {

		@Override
		public int compare(Node n1, Node n2) {
			if (n1.getValue() > n2.getValue()) {
				return 1;
			} else if (n1.getValue() < n2.getValue()) {
				return -1;
			}
			return 0;
		}	
	}
}