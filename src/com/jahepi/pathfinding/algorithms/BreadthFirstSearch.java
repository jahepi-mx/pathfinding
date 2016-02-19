package com.jahepi.pathfinding.algorithms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.jahepi.pathfinding.Node;
import com.jahepi.pathfinding.NodeMap;

public class BreadthFirstSearch extends Pathfinding {

	public BreadthFirstSearch(NodeMap map) {
		super(map);
	}

	@Override
	public void run(Node start, Node end) {
		
		Queue<Node> frontier = new LinkedList<Node>();
		Queue<Node> cameFrom = new LinkedList<Node>();
		frontier.add(start);
		
		outer: while (!frontier.isEmpty()) {
			Node node = frontier.remove();
			Iterator<Node> siblings = node.getSiblingsIterator();
			while (siblings.hasNext()) {
				Node sibling = siblings.next();
				if (!cameFrom.contains(sibling)) {
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
}
