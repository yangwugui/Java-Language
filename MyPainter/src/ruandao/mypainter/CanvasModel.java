package ruandao.mypainter;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class CanvasModel {
	public String currentMode = "rectangle";
    public Shape currentShape;
    public java.awt.Color currentColor = java.awt.Color.blue;
    public int currentWidth = 2;
    public java.awt.Image currentImage;
    
    public int x0;
    public int y0;
    public boolean isDrawing = false;

    public List<Shape> shapes = new ArrayList<Shape>();
    public List<Shape> undoShapes = new ArrayList<Shape>();
}
