package ma.ensaf.service;


import java.util.List;

import ma.ensaf.model.Book;

public interface IBookService {
	
	public void save(Book book);
	public List<Book> getAllBook();
	public Book getBookById(int id);
	public void deleteById(int id);
	public Book findById(int id);

}
