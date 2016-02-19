package com.jahepi.pathfinding;
import java.util.ArrayList;
import java.util.Iterator;


public class Node {

	private ArrayList<Node> siblings;
	private int x, y;
	private double value;
	private Node prev;
	private int g, f;
	private double h;
	
	public Node() {
		siblings = new ArrayList<Node>();
		g = 1;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void addSibling(Node e) {
		siblings.add(e);
	}
	
	public Iterator<Node> getSiblingsIterator() {
		return siblings.iterator();
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public int getG() {
		return g;
	}
	
	public void setH(Node node) {
		h = Math.abs(x - node.getX()) + Math.abs(y - node.getY());
		h += Math.random();
	}
	
	public void setF(Node node) {
		f = g + Math.abs(x - node.getX()) + Math.abs(y - node.getY());
	}

	public double getH() {
		return h;
	}

	public int getF() {
		return f;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public String toString() {
		return "x: " + x + " y: " + y;
	}
}
