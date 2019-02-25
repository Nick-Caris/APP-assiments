package util;

public class MemoryCell<T>
{

	private T object;

	public MemoryCell(T object)
	{
		this.object = object;
	}

	public T getObject()
	{
		return this.object;
	}
}
