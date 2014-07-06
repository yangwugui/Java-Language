package ruandao.datetime.bookstore;

public interface BookManager {

	public abstract void init() throws Exception;

	public abstract int guihuan(String person) throws Exception;

	public abstract void borrow(String person, String bookName) throws Exception;

	public abstract void remove(String name) throws Exception;

	public abstract String list();

	public abstract void add(Book book) throws Exception;

}