package ruandao.oop;

public class Triangle {
	private String symbol;
	private int size;
	private boolean isEmpty;
	
	public Triangle(){
		this("*", 10, false);
	}
	
	public Triangle(String symbol, int size, boolean isEmpty){
		this.symbol = symbol;
		this.size = size;
		this.isEmpty = isEmpty;
	}
	
	public void print(){
		int line = 0;
		
		while(line<this.size){
			int space = 0;
			while( space< this.size - line -1 ){
				System.out.print(" ");
				space ++;
			}
			
			System.out.print(this.symbol);
			
			int empty = 0;
			while(empty<line*2-1){
				if( line<this.size-1 && this.isEmpty ) System.out.print(" ");
				else System.out.print(symbol);
				empty ++;
			} // end of while(empty<line*2-1)
			
			if( line!=0) System.out.print(symbol);
			
			System.out.println();
			line++;   // line = line + 1;  line += 1;
		}  // end of while(line<lines)
		
	}
}
