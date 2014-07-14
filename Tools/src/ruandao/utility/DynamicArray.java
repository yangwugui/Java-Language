package ruandao.utility;

import java.util.Arrays;

public class DynamicArray {
	private Object[] innerArray;
	private int capacity;
	// 对于值类型无法确定元素的有效性，所以用size来跟踪事实使用的元素个数
	private int size;  
	private int increment;
	
	public DynamicArray(int capacity, int increment){
		this.innerArray = new Object[capacity];
		this.capacity = capacity;
		this.size = 0;
		this.increment = increment;
	}
	
	public int getIncrement(){
		return this.increment;
	}
	
	public int getSize(){
		return this.size;
	}
	
	// 增加数组的长度，同时克隆已有的数据。
	private void increase(){
		this.capacity += increment;
		this.innerArray = Arrays.copyOf(this.innerArray, this.capacity);
	}
	
	public void insertAt(Object object, int position){
		if( this.size==this.capacity) increase();
		
		if( position>size || position<0) position = size;
		for( int i=size-1; i>=position; i--){
			this.innerArray[i+1] = this.innerArray[i];
		}
		this.innerArray[position] = object;
		this.size ++;
	}
	
	public void append(Object object){
		insertAt(object, -1);
	}
	
	public void removeAt(int position){
		if(position>size-1 || position<0) return;
		
		for(int i=position; i<size-1; i++){
			this.innerArray[i] = this.innerArray[i+1];
		}
		this.innerArray[size-1] = null;
		size --;
	}
	
	public void remove(Object object){
		removeAt(getIndex(object));
	}
	
	public int getIndex(Object object){
		for(int i=0; i<size; i++){
			if(object.equals(this.innerArray[i])) return i;
		}
		return -1;
	}
	
	public Object getObject(int position){
		if(position>size-1 || position<0) return null;
		return this.innerArray[position];
	}
	
	// 如果capacity比size大很多，那么收缩数组所使用的空间。
	public void shrink(){
		int empty = this.capacity - this.size;
		if(empty<this.increment) return;
		
		if( empty > this.increment){
			empty -= (empty % this.increment);
		}
		this.capacity -= empty;
		this.innerArray = Arrays.copyOf(this.innerArray, this.capacity);
	}
}
