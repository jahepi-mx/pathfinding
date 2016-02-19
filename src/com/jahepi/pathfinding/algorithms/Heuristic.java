package com.jahepi.pathfinding.algorithms;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.jahepi.pathfinding.Node;
import com.jahepi.pathfinding.NodeMap;

public class Heuristic extends Pathfinding {

	public Heuristic(NodeMap map) {
		super(map);
	}

	@Override
	public void run(Node start, Node end) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new HeuristicComparator());
		Queue<Node> cameFrom = new LinkedList<Node>();
		
		frontier.add(start);

		outer: while (!frontier.isEmpty()) {
			Node node = frontier.remove();
			Iterator<Node> siblings = node.getSiblingsIterator();
			while (siblings.hasNext()) {
				Node sibling = siblings.next();
				if (!cameFrom.contains(sibling)) {
					sibling.setH(end);
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

	class HeuristicComparator implements Comparator<Node> {

		@Override
		public int compare(Node n1, Node n2) {
			if (n1.getH() > n2.getH()) {
				return 1;
			} else if (n1.getH() < n2.getH()) {
				return -1;
			} else {
				return 0;
			}
		}	
	}
}
