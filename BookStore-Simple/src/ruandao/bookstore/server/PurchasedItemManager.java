package ruandao.bookstore.server;

import java.util.HashMap;
import ruandao.bookstore.Book;
import ruandao.bookstore.PurchasedItem;

public class PurchasedItemManager {
	
	// 
	HashMap<String,PurchasedItem> allItems;
	
	public PurchasedItemManager(){
		allItems = new HashMap<String,PurchasedItem>();
	}
	
	public void select(Book book){
		PurchasedItem item = allItems.get(book.getISBN());
		if( item == null ){
			item = new PurchasedItem();
			item.setIsbn(book.getISBN());
			item.setQuantity(0);
			item.setUnitPrice(book.getPrice());
			allItems.put(book.getISBN(), item);
		}
		int amount = item.getQuantity() + 1;
		item.setQuantity(amount);
	}
	
	public void setAmount(Book book, int amount){
		if( amount <=0 ){
			allItems.remove(book.getISBN());
		}
		PurchasedItem item = allItems.get(book.getISBN());
		if( item == null ){
			item = new PurchasedItem();
			item.setIsbn(book.getISBN());
			item.setQuantity(0);
			item.setUnitPrice(book.getPrice());
			allItems.put(book.getISBN(), item);
		}
		item.setQuantity(amount);
	}

	public HashMap<String,PurchasedItem> getAllItems() {
		return allItems;
	}
	
}
