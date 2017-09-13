package test;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;

public class Test {

	public static Polygon pol = null;
	public static Shape player = null;
	
	
	private static List<Shape> polList = null;
	
	
	
	public Test() {
	}
	

	public static void addPol(Shape p) {
		if (polList == null) {
			polList = new ArrayList<Shape>();
		}
		
		polList.add(p);
	}
	
	
	public static List<Shape> getPolList() {
		return polList;
	}
	
	public static void main(String[] args) {
		new Test();
	}
	
}
