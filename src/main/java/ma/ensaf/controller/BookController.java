package ma.ensaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ma.ensaf.model.Book;
import ma.ensaf.service.BookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	
	@GetMapping("/available-books")
	public ModelAndView getAllBooks() {
		List<Book> books = bookService.getAllBook();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bookList");
		mv.addObject("books", books);
		return mv;
	}
	
	@GetMapping("/book-register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bookService.save(b);
		return "redirect:available-books";
	}
	
}