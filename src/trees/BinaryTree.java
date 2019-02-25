package trees;

public class BinaryTree<T extends Comparable<T>> extends BinaryNode<T>
{

	public static void main(String[] args)
	{
		BinaryTree<Integer> tree = new BinaryTree<Integer>(6);
		tree.setLeft(5);
		BinaryNode<Integer> four = tree.setRight(4);
		four.setLeft(2);
		four.setRight(3);
		tree.print();
		System.out.println("\n");
		System.out.println("MIRROR");
		System.out.println("\n");
		tree.mirror();
		tree.print();
		// Reset for subtract
		tree.mirror();
		System.out.println("\n");
		System.out.println("SUBTRACT");
		System.out.println("\n");
		System.out.println(BinaryTree.subtract(tree));
	}

	private static int subtract(BinaryTree<Integer> bt)
	{
		// * 2 because the value is subtracted in the algorithm
		return BinaryTree.subtractNode(bt, bt.key * 2);
	}

	private static int subtractNode(BinaryNode<Integer> node, int value)
	{
		if (node == null) { return value; }
		System.out.println(value + "-" + node.key + " = " + (value - node.key));
		value -= node.key;
		value = BinaryTree.subtractNode(node.left, value);
		value = BinaryTree.subtractNode(node.right, value);
		return value;
	}

	public BinaryTree(T key)
	{
		super(key);
	}
}
