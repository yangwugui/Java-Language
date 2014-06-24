package ruandao.mypainter;

import java.awt.Color;
import java.awt.Graphics;

public class RectangleShape extends Shape {

    public float borderWidth;
    public Color borderColor ;

    public RectangleShape(Color borderColor, float borderWidth, int left, int top, int width, int height){
    	super(left, top, width,height);
        this.borderWidth = borderWidth;
        this.borderColor = borderColor;
    }
    
    @Override 
    public void draw(Graphics graphics)
    {
        graphics.setColor(borderColor);
        graphics.drawRect(this.left,this.top,this.width,this.height);
    }
}
