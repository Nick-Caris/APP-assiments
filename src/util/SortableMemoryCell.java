package util;

public class SortableMemoryCell<T> extends MemoryCell<T> implements Comparable<SortableMemoryCell<T>>
{

	private int value;

	public SortableMemoryCell(int value, T object)
	{
		super(object);
		this.value = value;
	}

	@Override
	public int compareTo(SortableMemoryCell<T> o)
	{
		return Integer.compare(this.value, o.value);
	}
}
