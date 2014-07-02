package ruandao.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList implements List  {

	MyItem head;
	
	private int amount;
	
	public MyList(){
		this.head = null;
		this.amount = 0;
	}
	
	@Override
	public boolean add(Object element) {
		add( this.amount, element);
		return true;
	}

	@Override
	public void add(int index, Object element) {
		if( element == null ){
			throw new NullPointerException();
		}
		if( index < 0 || index > size() ){
			throw new IndexOutOfBoundsException();
		}
		
		MyItem newItem = new MyItem(element);
		
		int i = 0;
		MyItem prev = null;
		MyItem item = this.head;
		while( i < index ){
			prev = item;
			item = item.next; 
			i++;
		}
		if( prev == null ){
			this.head = newItem;
		}
		else{
			prev.next = newItem;
		}
		newItem.next = item;
		this.amount ++;
	}

	@Override
	public void clear() {
		this.amount = 0;
		this.head = null;
	}

	@Override
	public boolean contains(Object element) {
		return indexOf(element) == -1 ? false : true ;
	}

	@Override
	public Object get(int index) {
		if( index < 0 || index >= size() ){
			throw new IndexOutOfBoundsException();
		}

		int i = 0;
		MyItem item = this.head;
		while( i < index ){
			item = item.next; 
			i++;
		}
		return item.element;
	}

	@Override
	public int indexOf(Object element) {
		if( element == null ){
			throw new NullPointerException();
		}
		int index = -1;
		MyItem item = this.head;
		while( item != null ){
			index ++;
			if( item.element.equals(element) ) break;
			item = item.next; 
		}
		return index;
	}

	@Override
	public boolean isEmpty() {
		return this.amount == 0 ? true : false;
	}

	@Override
	public Iterator iterator() {
		return new MyIterator(this.head);
	}

	@Override
	public boolean remove(Object element) {
		if( element == null ){
			throw new NullPointerException();
		}
		MyItem prev = null;
		MyItem item = this.head;
		while( item != null ){
			if( item.element.equals(element) ){
				if( prev == null ){
					this.head = item.next;
				}
				else{
					prev.next = item.next;
				}
				return true;
			}
			prev = item;
			item = item.next; 
		}
		return false;
	}

	@Override
	public Object remove(int index) {
		if( index < 0 || index >= size() ){
			throw new IndexOutOfBoundsException();
		}
		
		int i = 0;
		MyItem prev = null;
		MyItem item = this.head;
		while( i < index ){
			prev = item;
			item = item.next; 
			i++;
		}
		if( prev == null ){
			this.head = item.next;
		}
		else{
			prev.next = item.next;
		}
		this.amount --;
		return item;
	}

	@Override
	public Object set(int index, Object element) {
		if( index < 0 || index >= size() ){
			throw new IndexOutOfBoundsException();
		}
		
		if( element == null ){
			throw new NullPointerException();
		}

		int i = 0;
		MyItem item = this.head;
		while( i < index ){
			item = item.next; 
			i++;
		}
		Object old = item.element;
		item.element = element;
		return old;
	}

	@Override
	public int size() {
		return this.amount;
	}
	
	/* 下述接口方法在MyList中没有实现  */

	@Override
	public boolean addAll(Collection arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int arg0, Collection arg1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int lastIndexOf(Object arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator listIterator(int arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List subList(int arg0, int arg1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		throw new UnsupportedOperationException();
	}

}
