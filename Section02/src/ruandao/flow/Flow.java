package ruandao.flow;

public class Flow {

	public static void main(String[] args) {
		// 1. 一个一个句子顺序执行
		// 2. 阻塞：前一个句子没有执行完成，下一个不会执行。
		//    用os的cpu管理机制，可以把需要长时间执行因而会阻塞流程的代码，分解成同时执行的流程。
		System.out.println("1. Hello, Java!");
		System.out.println("2. Hello, Java!");
		System.out.println("3. Hello, Java!");
		System.out.println(" game is over!");
	}

}
