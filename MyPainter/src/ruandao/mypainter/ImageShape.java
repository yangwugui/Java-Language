package ruandao.mypainter;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class ImageShape extends Shape {
	public java.awt.Image image;
	
	public ImageShape(java.awt.Image image, int left, int top, int width, int height){
		super(left,top,width,height);
	    this.image = image;
	}
	@Override
	public void draw(Graphics graphics) {
	    graphics.drawImage( image, this.left, this.top, this.width, this.height,null);
	}
}

