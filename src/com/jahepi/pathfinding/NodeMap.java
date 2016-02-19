package com.jahepi.pathfinding;
import java.util.ArrayList;
import java.util.Iterator;

public class NodeMap {


	private ArrayList<Node> map;
	
	public int[][] bitMap = {
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
		{1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	};
	
	public NodeMap() {
		map = new ArrayList<Node>();
		build();
	}
	
	private void build() {
		
		for (int x = 0; x < bitMap[0].length; x++) {
			for (int y = 0; y < bitMap.length; y++) {		
				Node node = new Node();
				node.setX(x);
				node.setY(y);
				node.setValue(bitMap[y][x]);
				map.add(node);
			}
		}
		
		Iterator<Node> iterator = map.iterator();
		while (iterator.hasNext()) {
			Node node = iterator.next();
			int x = node.getX();
			int y = node.getY();
			Node up = getNode(x, y - 1);
			if (up != null) {
				if (up.getValue() >= 1) node.addSibling(up);
			}
			Node down = getNode(x, y + 1);
			if (down != null) {
				if (down.getValue() >= 1) node.addSibling(down);
			}
			Node left = getNode(x - 1, y);
			if (left != null) {
				if (left.getValue() >= 1) node.addSibling(left);
			}
			Node right = getNode(x + 1, y);
			if (right != null) {
				if (right.getValue() >= 1) node.addSibling(right);
			}
		}
	}
	
	public Node getNode(int x, int y) {
		Iterator<Node> iterator = map.iterator();
		while (iterator.hasNext()) {
			Node node = iterator.next();
			if (node.getX() == x && node.getY() == y) {
				return node;
			}
		}
		return null;
	}
	
	public Iterator<Node> getIterator() {
		return map.iterator();
	}
}
