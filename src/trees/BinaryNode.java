package trees;

public class BinaryNode<T extends Comparable<T>>
{

	T				key;
	BinaryNode<T>	left, right;

	public BinaryNode(T key)
	{
		this.key = key;
	}

	public BinaryNode(T key, BinaryNode<T> left, BinaryNode<T> right)
	{
		this.key = key;
		this.left = left;
		this.right = right;
	}

	public void mirror()
	{
		BinaryNode<T> temp = this.left;
		this.left = this.right;
		this.right = temp;
		if (this.left != null)
		{
			this.left.mirror();
		}
		if (this.right != null)
		{
			this.right.mirror();
		}
	}

	public void print()
	{
		System.out.println("Current: " + this.key);
		if (this.left != null)
		{
			System.out.println("  Left: " + this.left.key);
		}
		if (this.right != null)
		{
			System.out.println("  Right: " + this.right.key);
		}
		if (this.left != null)
		{
			this.left.print();
		}
		if (this.right != null)
		{
			this.right.print();
		}
	}

	public BinaryNode<T> setLeft(T key)
	{
		this.left = new BinaryNode<T>(key);
		return this.left;
	}

	public BinaryNode<T> setRight(T key)
	{
		this.right = new BinaryNode<T>(key);
		return this.right;
	}
}
