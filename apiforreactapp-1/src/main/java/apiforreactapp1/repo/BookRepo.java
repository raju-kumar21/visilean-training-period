package apiforreactapp1.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import apiforreactapp1.model.Book;

public interface BookRepo extends MongoRepository<Book, Integer>{

	// @Query("From Book b WHERE b.title=:searchText OR b.author:searchText OR b.language=:searchText ORDER BY b.price DESC")
	// Page<Book> findAllBook(@Param("searchText") String searchText,Pageable pageable);
	
	
	@Query("{'$or': [ { 'title': { '$regex': ?0 } }, { 'author': { '$regex': ?0 } }, { 'language': { '$regex': ?0 } } ] }")
	Page<Book> findAllBook(String search, Pageable pageable);

	
	// List<Book> saveAllBooks(List<Book> books);

	
	
}
