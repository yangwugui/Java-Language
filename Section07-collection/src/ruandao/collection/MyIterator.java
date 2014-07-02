package ruandao.collection;

import java.util.Iterator;

class MyIterator implements Iterator {
    /**
     * Index of element to be returned by subsequent call to next.
     */
    MyItem cursor;
    
    MyIterator(MyItem head){
    	this.cursor = head;
    }

    public boolean hasNext() {
        return cursor != null;
    }

    public Object next() {
    	Object current = cursor.element;
    	cursor = (MyItem) cursor.next;
    	return current;
    }

    public void remove() {
    	throw new  UnsupportedOperationException();
    }
}