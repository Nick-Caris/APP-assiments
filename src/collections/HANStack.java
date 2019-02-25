package collections;

import java.util.Iterator;

public class HANStack<T> extends HANCollection<T>
{

	private HANLinkedList<T> list = new HANLinkedList<>();

	public int getSize()
	{
		return this.list.getSize();
	}

	@Override
	public Iterator<T> iterator()
	{
		return this.list.iterator();
	}

	public void pop()
	{
		this.list.removeFirst();
	}

	public void push(T object)
	{
		this.list.addFirst(object);
	}

	public T top()
	{
		return this.list.get(0);
	}
}
