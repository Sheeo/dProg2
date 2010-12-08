import java.util.*;

public class MultiSet<E> extends AbstractCollection<E>
{
	private HashMap<E, Integer> elems;
	private int elementCount;

	public MultiSet()
  {
		elems = new HashMap<E, Integer>();
		elementCount = 0;
	}

	public MultiSet(Collection<E> collection)
	{
		elems = new HashMap<E, Integer>();
		addAll(collection);
	}

  public boolean add(E e)
  {
    Integer i = elems.get(e);
    if (i == null) i = 1;
    else i = i + 1;
    elems.put(e, i);
    ++elementCount;
    return true;
  }

  @Override
	public boolean remove(Object e)
  {
    E element = (E)e;
		Integer i = elems.get(element);
    if(i == 1 || i == null)
      elems.remove(element);
    else
      --i;
    elems.put(element, i);
    --elementCount;
    return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) throws RuntimeException
	{
		for(E elem : collection)
		{
			add(elem);
		}
		return true;
	}

	public int size()
  {
		return elementCount;
	}

	public Iterator<E> iterator()
  {
		return new MultiIterator();
	}
	
	@Override
	public int hashCode()
  {
		return elems.hashCode();
	}
	
	@Override
	public String toString()
  {
		return elems.toString();
	}

	@Override
	public boolean equals(Object other)
  {
		if (other.getClass() != this.getClass()) return false;
		return equalsMultiSet((MultiSet<?>) other);
	}
	
  private <F> boolean equalsMultiSet(MultiSet<F> other)
  {
		if (this == other) return true;
		return this.elems.equals(other.elems);
	}

	private class MultiIterator implements Iterator<E>
  {
		private Set<E> elemKeys;
		private E currentKey;
		private int currentKeyCount;
		private Iterator<E> keyIt;
		private int nextIdx;

		public MultiIterator()
    {
			elemKeys = elems.keySet();
			keyIt = elemKeys.iterator();
			nextIdx = 0;
		}

		public E next()
    {
			if (currentKey != null && currentKeyCount > nextIdx) {
				++nextIdx;
			} else {
				currentKey = keyIt.next();
				currentKeyCount = elems.get(currentKey);
				nextIdx = 1;
			}
			return currentKey;
		}

		public boolean hasNext()
    {
			if (currentKey != null && currentKeyCount > nextIdx) {
				return true;
			} else {
				return keyIt.hasNext();
			}
		}

		public void remove()
    {
      throw new UnsupportedOperationException();
		}
	}
}
