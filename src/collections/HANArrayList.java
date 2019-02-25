package collections;

import java.util.Iterator;

public class HANArrayList<T> extends HANCollection<T>
{

	private T[]	array;
	private int	length;

	public HANArrayList()
	{
		this(10);
	}

	@SuppressWarnings("unchecked")
	public HANArrayList(int initialCapacity)
	{
		this.array = (T[]) new Object[initialCapacity];
		this.length = 1;
	}

	public void add(T value)
	{
		if (this.array.length == this.length)
		{
			this.expand(this.array.length);
		}
		this.array[this.length - 1] = value;
		this.length++;
	}

	public T get(int index)
	{
		return this.array[index];
	}

	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{

			private int index = 0;

			@Override
			public boolean hasNext()
			{
				return HANArrayList.this.array.length > this.index;
			}

			@Override
			public T next()
			{
				T tmp = HANArrayList.this.array[this.index];
				this.index++;
				return tmp;
			}
		};
	}

	public void set(int index, T value)
	{
		this.array[index] = value;
	}

	private void expand(int expansion)
	{
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[this.array.length + expansion];
		for (int i = 0; i < this.array.length; i++)
		{
			array[i] = this.array[i];
		}
		this.array = array;
	}
}
