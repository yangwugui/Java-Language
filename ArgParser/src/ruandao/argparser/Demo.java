package ruandao.argparser;

public class Demo {
	public static void main(String[] args){
		DemoArgParser dap = new DemoArgParser(args);
		if( !dap.parse() ) return;
		
		System.out.println(dap.getTitle());
		
		for( int i=0; i<dap.getRows(); i++){
			for( int j=0; j<dap.getCols(); j++ ){
				System.out.print(dap.getSymbol());
			}
			System.out.println();
		}
	}
}
