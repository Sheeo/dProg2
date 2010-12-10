import java.util.*;

public class MultiSet<E> extends AbstractCollection<E> {
	private HashMap<E, Integer> elems;
	private int elementCount;

	public MultiSet() {
		elems = new HashMap<E, Integer>();
		elementCount = 0;
	}

	public MultiSet(Collection<E> c) {
		this();
		addAll(c);
	}

	@Override
	public boolean add(E e) {
		Integer i = elems.get(e);
		if (i == null) i = 1;
		else i = i + 1;
		elems.put(e, i);
		++elementCount;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		Integer i = elems.get(o);
		if (i == null || i <= 0) return false;
		if (i == 1) {
			elems.remove(o);
		} else {
			elems.put((E) o, i-1);
		}
		--elementCount;
		return true;
	}

	@Override
	public int size() {
		return elementCount;
	}

	@Override
	public Iterator<E> iterator() {
		return new MultiIterator();
	}
	
	@Override
	public int hashCode() {
		return elems.hashCode();
	}
	
	@Override
	public String toString() {
		return elems.toString();
	}

	@Override
	public boolean equals(Object other) {
		if (other.getClass() != this.getClass()) return false;
		return equalsMultiSet((MultiSet<?>) other);
	}
	
	private <F> boolean equalsMultiSet(MultiSet<F> other) {
		if (this == other) return true;
		return this.elems.equals(other.elems);
	}

	private class MultiIterator implements Iterator<E> {
		private Set<E> elemKeys;
		private E currentKey;
		private int currentKeyCount;
		private Iterator<E> keyIt;
		private int nextIdx;
		private boolean removed;

		public MultiIterator() {
			elemKeys = elems.keySet();
			keyIt = elemKeys.iterator();
			nextIdx = 0;
			removed = true; // disallow remove() until next() has been called
		}

		@Override
		public E next() {
			if (currentKey != null && currentKeyCount > nextIdx) {
				++nextIdx;
			} else {
				currentKey = keyIt.next();
				currentKeyCount = elems.get(currentKey);
				nextIdx = 1;
			}
			removed = false;
			return currentKey;
		}

		@Override
		public boolean hasNext() {
			if (currentKey != null && currentKeyCount > nextIdx) {
				return true;
			} else {
				return keyIt.hasNext();
			}
		}

		@Override
		public void remove() {
			if (removed) throw new IllegalStateException("remove() called several times in a row");
			removed = true;
			elems.put(currentKey, --currentKeyCount);
			--nextIdx;
		}
	}
}
