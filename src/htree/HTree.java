package htree;

import javax.swing.JFrame;

public class HTree
{

	public static final int	FRAME_SIZE	= 1020;
	public static final int	BRANCHES	= 5;

	public static void main(String[] args)
	{
		HTree t = new HTree();
		t.init();
	}

	private void init()
	{
		JFrame frame = new JFrame("H Tree");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(HTree.FRAME_SIZE, HTree.FRAME_SIZE);
		frame.setContentPane(new HTreePanel());
		frame.setVisible(true);
	}
}
