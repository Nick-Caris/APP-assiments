package trees;

public class BinarySearchTreeNode<T extends Comparable<T>>
{

	private T						object;
	private BinarySearchTreeNode<T>	left;
	private BinarySearchTreeNode<T>	right;

	public BinarySearchTreeNode()
	{}

	public BinarySearchTreeNode(T object)
	{
		this.object = object;
	}

	public void add(T object)
	{
		if (this.object == null)
		{
			this.object = object;
			return;
		}
		int compare = this.object.compareTo(object);
		if (compare == 0) { throw new IllegalStateException("This implementation of binary search tree does not allow duplicate values"); }
		if (compare > 0)
		{
			if (this.left == null)
			{
				this.left = new BinarySearchTreeNode<T>(object);
			} else
			{
				this.left.add(object);
			}
		} else
		{
			if (this.right == null)
			{
				this.right = new BinarySearchTreeNode<T>(object);
			} else
			{
				this.right.add(object);
			}
		}
	}

	/**
	 * @param object
	 * @return null if not found
	 */
	public T find(T object)
	{
		int compare = this.object.compareTo(object);
		if (compare == 0) { return object; }
		if (compare < 0)
		{
			return this.left == null ? null : this.left.find(object);
		} else
		{
			return this.right == null ? null : this.right.find(object);
		}
	}

	public T max()
	{
		return this.right == null ? this.object : this.right.min();
	}

	public T min()
	{
		return this.left == null ? this.object : this.left.min();
	}

	public void print()
	{
		System.out.println("Current: " + this.object);
		if (this.left != null)
		{
			System.out.println("  Left: " + this.left.object);
			this.left.print();
		}
		if (this.right != null)
		{
			System.out.println("  Right: " + this.right.object);
			this.right.print();
		}
	}
}
