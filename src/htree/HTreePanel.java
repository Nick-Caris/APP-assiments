package htree;

import java.awt.Graphics;

import javax.swing.JPanel;

public class HTreePanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void drawTree(Graphics g, int x, int y, double length, int n)
	{
		if (n <= 0) { return; }
		length /= Math.sqrt(2);
		int xA = (int) (n % 2 == 0 ? x - length : x);
		int yA = (int) (n % 2 == 0 ? y : y - length);
		int xB = (int) (n % 2 == 0 ? x + length : x);
		int yB = (int) (n % 2 == 0 ? y : y + length);
		g.drawLine(x, y, xA, yA);
		g.drawLine(x, y, xB, yB);
		this.drawTree(g, xA, yA, length, n - 1);
		this.drawTree(g, xB, yB, length, n - 1);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		int center = HTree.FRAME_SIZE / 2;
		this.drawTree(g, center, center, center / Math.sqrt(2), HTree.BRANCHES);
	}
}
