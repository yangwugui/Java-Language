package ruandao.io.library;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import ruandao.io.*;

public interface BookManager {

	public abstract int guihuan(String person, String bookName) throws Exception;

	public abstract void borrow(String person, String bookName) throws Exception;

	public abstract void remove(String name) throws Exception;

	public abstract String list();

	public abstract void add(Book book);

	public abstract void save(String name) throws Exception;
	
	public abstract void open(String filename) throws Exception;
}