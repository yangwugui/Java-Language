package ruandao.collection.library;

public interface BookManager {

	public abstract void guihuan(String name) throws Exception;

	public abstract void borrow(String name) throws Exception;

	public abstract void remove(String name) throws Exception;

	public abstract String list();

	public abstract void add(Book book) throws Exception;

}