package ruandao.mypainter;

import java.awt.Graphics;

public abstract class Shape {
	public Shape( int left, int top, int width, int height)
	{
	    this.left = left;
	    this.top = top;
	    this.width = width;
	    this.height = height;
	}
	public int left;
	public int top;
	public int width;
	public int height;
	abstract public void draw(Graphics graphics);
}



