package ruandao.datetime.library;

public interface BookManager {

	public abstract int guihuan(String person, String bookName) throws Exception;

	public abstract void borrow(String person, String bookName) throws Exception;

	public abstract void remove(String name) throws Exception;

	public abstract String list();

	public abstract void add(Book book);

}