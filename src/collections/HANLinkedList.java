package collections;

import java.util.Iterator;

public class HANLinkedList<T> extends HANCollection<T>
{

	public static class Node<T>
	{

		public Node<T>	next;
		public T		value;

		public Node(Node<T> next, T value)
		{
			this.next = next;
			this.value = value;
		}

		public Node<T> getNext()
		{
			return this.next;
		}

		public T getValue()
		{
			return this.value;
		}

		public void insertNode(T value)
		{
			this.next = new Node<T>(this.next, value);
		}

		public void removeNextNode()
		{
			this.next = this.next.getNext();
		}
	}

	protected Node<T>	header;
	protected int		size;

	public void addFirst(T value)
	{
		this.header = this.header == null ? new Node<T>(null, value) : new Node<T>(this.header, value);
		this.size++;
	}

	public void delete(int index)
	{
		if (index == 0)
		{
			this.header = this.header.getNext();
			return;
		}
		this.getNode(index - 1).removeNextNode();
		this.size--;
	}

	public T get(int index)
	{
		return this.getNode(index).getValue();
	}

	public int getSize()
	{
		Node<T> node = this.header;
		if (node == null) { return 0; }
		int i = 1;
		while ((node = node.getNext()) != null)
		{
			i++;
		}
		return i;
	}

	public void insert(int index, T value)
	{
		if (index == 0)
		{
			this.header = new Node<T>(this.header == null ? null : this.header.getNext(), value);
			return;
		}
		this.getNode(index - 1).insertNode(value);
		this.size++;
	}

	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{

			private Node<T> node;

			@Override
			public boolean hasNext()
			{
				if (this.node == null)
				{
					this.node = HANLinkedList.this.header;
				}
				return this.node == null ? false : this.node.next != null;
			}

			@Override
			public T next()
			{
				if (this.node == null)
				{
					this.node = HANLinkedList.this.header;
					if (this.node == null) { throw new IndexOutOfBoundsException(); }
				} else
				{
					if (this.node.next == null) { throw new IndexOutOfBoundsException(); }
					this.node = this.node.next;
				}
				return this.node.value;
			}
		};
	}

	public void removeFirst()
	{
		this.header = this.header == null ? null : this.header.getNext();
		this.size--;
	}

	private Node<T> getNode(int index)
	{
		Node<T> node = this.header;
		for (int i = 1; i < index; i++)
		{
			node = node.getNext();
		}
		return node;
	}
}
