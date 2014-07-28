package ruandao.thread;

public class MyThread extends Thread {
	private int count = 0;
	public void run(){
		while(count < 10 ){
			count++;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Count is: " + this.count );
		}
		count = 0;
	}
	
	static public void main(String[] arg){
		MyThread t1 = new MyThread();
		t1.run();
		MyThread t2 = new MyThread();
		t2.run();
		
		System.out.println("====== thread start ========");
		t1.start();
		t2.start();
	}
}
