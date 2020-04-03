package Chapter10_11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class PaintFrame extends JFrame{
	//��¼��ͼ����
	private BufferedImage canvas;
	//��¼��һ�����x��λ��
	private int lastX = -1;
	//��¼��һ�����y��λ��
	private int lastY = -1;
	
	public PaintFrame() {
		//���ڴ�С�ı�ʱ��
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				BufferedImage newCanvas = new BufferedImage(getWidth(), getWidth(), BufferedImage.TYPE_INT_RGB);
				if (canvas != null) {
					Graphics g = newCanvas.getGraphics();
					g.drawImage(canvas, 0, 0, null);
				}
				canvas = newCanvas;
			}
		});
		//����ƶ��¼�
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				if (lastX == -1 && lastY == -1) {
					lastX = x;
					lastY = y;
				}else {
					Graphics g = canvas.getGraphics();
					g.setColor(Color.RED);
					g.drawLine(lastX, lastY, x, y);
					lastX = x;
					lastY = y;
					//�ػ津��paint
					repaint();
				}
			}
		});
	}
	//
	@Override
	public void paint(Graphics g) {
		g.drawImage(canvas, 0, 0, null);
	}
	public static void main(String[] args) {
		PaintFrame frame = new PaintFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
