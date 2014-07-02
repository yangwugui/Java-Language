package ruandao.collection;

public class MyListProgram {

	public static void main(String[] args) {
		MyList list = new MyList();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add(2,"two-three");
		
		list.add(0,"zero");
		list.add(5,"befor four");
		list.add(7,"end");
		
		for( Object item : list){
			String str = (String) item;
			System.out.println(str);
		}
		
		list.remove(0);
		list.remove("end");
		list.remove(2);
		
		for( Object item : list){
			String str = (String) item;
			System.out.println(str);
		}
	
	}

}
