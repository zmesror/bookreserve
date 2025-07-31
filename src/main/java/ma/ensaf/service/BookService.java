package ma.ensaf.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ensaf.model.Book;
import ma.ensaf.repository.BookRepository;

@Service
public class BookService implements IBookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		bookRepository.save(book);
		
	}

	@Override
	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}

	@Override
	public Book findById(int id) {
		return bookRepository.findById(id).orElse(null);
	}

}
