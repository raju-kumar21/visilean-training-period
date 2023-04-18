package apiforreactapp1.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apiforreactapp1.model.Book;
import apiforreactapp1.repo.BookRepo;

@RestController
@RequestMapping("/Book")
@CrossOrigin
public class BookController {
	
	
	@Autowired
	private BookRepo bookRepo;
	
	
	@PostMapping("/saveBook")
	public Book save(@RequestBody Book book)
	{
		Book books=new Book();
		
		
		for(int i=0;i<=5;i++)
		{
			books.setS_no(book.getS_no()+i);
			books.setTitle(book.getTitle());
			books.setAuthor(book.getAuthor());
			books.setCoverPhotoURL(book.getCoverPhotoURL());
			books.setIsbnNumber(book.getIsbnNumber());
			books.setPrice(book.getPrice());
			books.setLanguage(book.getLanguage());
			bookRepo.save(books);
		}
		return book;
	}
	
	
	@GetMapping("/findBook")
	public List<Book>findAll()
	{
		return bookRepo.findAll();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void delete(@PathVariable("id") Integer id)
	{
		 bookRepo.deleteById(id);
	}
	
	
	@GetMapping("/findBookById/{id}")
	public Book findById(@PathVariable("id") Integer id)
	{
		Book book=bookRepo.findById(id).get();
		return book;
	}
	
	
	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book book)
	{
		return bookRepo.save(book);
	}
	
	@GetMapping("/findBook/")
	public Page<Book>findAll(Pageable pageable)
	{
		return bookRepo.findAll(pageable);
	}
	
	@DeleteMapping("/delete")
	public void deleteAll()
	{
		 bookRepo.deleteAll();
	}
	
	@GetMapping("/findBookSort/")
	public Page<Book>findAllSort(int pageNumber,int pageSize,String sortBy,String sortDir)
	{
		return bookRepo.findAll(PageRequest.of(pageNumber, pageSize, sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()));
	}
	
	@GetMapping("/language")
	public Set<String> findAllLanguage()
	{
		return new TreeSet<String>(Arrays.asList("French","Portuguese","English","Russian","Hindi","Arabic","Spanish","Chinese"));
	}
	
	@GetMapping("/findBookSearch/{search}")
	public Page<Book> findAllBook(@PathVariable("search")String search,Pageable pageable )
	{
		return bookRepo.findAllBook( search,pageable);
	}
	
}
