package ruandao.bookstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderManager {
	
	// 
	HashMap<String,Order> allOrders;
	
	public OrderManager(){
		allOrders = new HashMap<String,Order>();
	}
	
	public void select(String code, String isbn){
		
	}
	
	public void setAmount(String code, String isbn, int amount){
		
	}
	
	public void deselect(String code, String isbn){
		
	}
	
	public boolean isExist(String code, String isbn){
		return false;
	}
	
	public Order fetchOrder(String code){
		return allOrders.get(code);
	}
	
	// �Զ����ɶ����š�
	public Order createOrder(String account){
		Order order = new Order();
		return order;
	}
}
