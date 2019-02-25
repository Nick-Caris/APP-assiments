package trees;

class FirstChildNextSiblingTree<T>
{

	private T								object;
	private FirstChildNextSiblingTree<T>	child;
	private FirstChildNextSiblingTree<T>	sibling;

	public FirstChildNextSiblingTree(T object)
	{
		this.object = object;
	}

	public FirstChildNextSiblingTree(T object, FirstChildNextSiblingTree<T> child, FirstChildNextSiblingTree<T> sibling)
	{
		this.object = object;
		this.child = child;
		this.sibling = sibling;
	}

	/**
	 * Adds a child at the beginning of the linked list.
	 * 
	 * @param child
	 */
	public void addChild(FirstChildNextSiblingTree<T> child)
	{
		child.child = child;
		this.child = child;
	}

	/**
	 * Adds a sibling at the beginning of the linked list.
	 * 
	 * @param sibling
	 */
	public void addSibling(FirstChildNextSiblingTree<T> sibling)
	{
		sibling.sibling = this.sibling;
		this.sibling = sibling;
	}

	public FirstChildNextSiblingTree<T> getFirstChild()
	{
		return this.child;
	}

	public FirstChildNextSiblingTree<T> getNextSibling()
	{
		return this.sibling;
	}

	public T getObject()
	{
		return this.object;
	}
}
