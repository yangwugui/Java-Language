package ruandao.mypainter;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author  __USER__
 */
public class MyPainter extends javax.swing.JFrame {

	/** Creates new form MyPainter */
	public MyPainter() {
		initComponents();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
	
		jLeftPanel = new javax.swing.JPanel();
		buttonGroup1 = new javax.swing.ButtonGroup();
		jRectButton = new javax.swing.JRadioButton();
		jImageButton = new javax.swing.JRadioButton();
		jColorButton = new javax.swing.JButton();
		jUndoButton = new javax.swing.JButton();
		jRedoButton = new javax.swing.JButton();
		
		jMainPanel = new ruandao.mypainter.Canvas();
	
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u7b80\u5355\u7ed8\u56fe\u7a0b\u5e8f");
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
	
		jMainPanel.setBackground(new java.awt.Color(204, 255, 204));
		getContentPane().add(jMainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 460, 390));
	
		jLeftPanel.setBackground(new java.awt.Color(255, 255, 204));
		jLeftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
	
		buttonGroup1.add(jRectButton);
		jRectButton.setLabel("绘制矩形");
		jRectButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jRectButtonMouseClicked(evt);
			}
		});
		jLeftPanel.add(jRectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));
	
		buttonGroup1.add(jImageButton);
		jImageButton.setLabel("绘制图像");
		jImageButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jImageButtonMouseClicked(evt);
			}
		});
		jLeftPanel.add(jImageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));
	
		jColorButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jColorButtonMouseClicked(evt);
			}
		});
		jLeftPanel.add(jColorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 30));
	
		jUndoButton.setLabel("撤消");
		jUndoButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jUndoButtonMouseClicked(evt);
			}
		});
		jLeftPanel.add(jUndoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 30));
	
		jRedoButton.setLabel("重做");
		jRedoButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jRedoButtonMouseClicked(evt);
			}
		});
		jLeftPanel.add(jRedoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, 30));
	
		getContentPane().add(jLeftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 390));
		this.addComponentListener(new java.awt.event.ComponentAdapter(){
			public void componentResized(java.awt.event.ComponentEvent evt){
				jComponentResized(evt);
			}
		});	
		pack();
	}
	
	protected void jComponentResized(java.awt.event.ComponentEvent evt){
			 	jLeftPanel.setSize(110, getHeight());
				jMainPanel.setSize(getWidth()-110, getHeight());
	}

	protected void jImageButtonMouseClicked(MouseEvent evt) {
		//Color color = javax.swing.JColorChooser.showDialog(this, "Select Color", Color.blue);
		// TODO Auto-generated method stub
		javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
		if( javax.swing.JFileChooser.APPROVE_OPTION==fileChooser.showOpenDialog(this)){
			//jMainPanel.canvasModel.currentImage = getImage(fileChooser.getSelectedFile().getPath());
			jMainPanel.canvasModel.currentImage = Toolkit.getDefaultToolkit().createImage(
					fileChooser.getSelectedFile().getPath()) ;
			jMainPanel.canvasModel.currentMode = "image";
		}
	}

	protected void jRectButtonMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
			jMainPanel.canvasModel.currentMode = "rectangle";
	}

	protected void jColorButtonMouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		Color color = javax.swing.JColorChooser.showDialog(this, "Select Color", Color.blue);
		if ( color!= null ){
			jColorButton.setBackground(color);
			jMainPanel.canvasModel.currentColor = color;
		}
	}

	protected void jUndoButtonMouseClicked(MouseEvent evt) {
        int count = jMainPanel.canvasModel.shapes.size();
		if ( count > 0)
        {
            jMainPanel.canvasModel.undoShapes.add(jMainPanel.canvasModel.shapes.get(count - 1) );
            jMainPanel.canvasModel.shapes.remove(count - 1);
	        jMainPanel.repaint();
        }
	}

	protected void jRedoButtonMouseClicked(MouseEvent evt) {
        int count = jMainPanel.canvasModel.undoShapes.size();
		if ( count > 0)
        {
            jMainPanel.canvasModel.shapes.add(jMainPanel.canvasModel.undoShapes.get(count - 1) );
            jMainPanel.canvasModel.undoShapes.remove(count - 1);
	        jMainPanel.repaint();
        }
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MyPainter().setVisible(true);
			}
		});
	}

	private javax.swing.JPanel jLeftPanel;
	
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JRadioButton jRectButton;
	private javax.swing.JRadioButton jImageButton;
	private javax.swing.JButton jColorButton;
	
	private javax.swing.JButton jUndoButton;
	private javax.swing.JButton jRedoButton;
	
	private ruandao.mypainter.Canvas jMainPanel;
}