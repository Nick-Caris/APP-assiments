package collections;

import java.util.Iterator;

public abstract class HANCollection<T>
{

	public abstract Iterator<T> iterator();

	@Override
	public String toString()
	{
		Iterator<T> it = this.iterator();
		int index = 0;
		StringBuilder str = new StringBuilder();
		while (it.hasNext())
		{
			str.append(index);
			str.append(":");
			str.append(it.next().toString());
			if (it.hasNext())
			{
				str.append(Character.LINE_SEPARATOR);
			}
		}
		return str.toString();
	}
}
