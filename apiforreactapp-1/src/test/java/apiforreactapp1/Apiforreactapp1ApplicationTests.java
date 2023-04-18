//package apiforreactapp1;
//
//import static org.junit.Assert.assertThat;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hamcrest.CoreMatchers;
//import org.junit.Before;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.testcontainers.containers.MongoDBContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//import apiforreactapp1.model.Book;
//import apiforreactapp1.repo.BookRepo;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class Apiforreactapp1ApplicationTests extends AbstractContainerBaseTest{
//
//	// @Container
//	// private static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");
//
//	@Autowired
//	private BookRepo bookRepo;
//
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	// given/when/then format -BDD style(behaviour driven development style)
//	@Test
//	public void giveBooks_whenGellAllBooks_thenListOfBooks() throws Exception {
//		System.out.println("I am Running");
//		
//		// given - setup or precondition
//        Book book = new Book(1, "java", "raju", "https//raju.com", "34324", "english", "4555");
//		Book book2 = new Book(2, "java", "raju", "https//raju.com", "34324", "english", "4555");
//		
//		List<Book> books=new ArrayList<>();
//		books.add(book);
//		books.add(book2);
//		bookRepo.saveAll(books);
//		// // when - action
//		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/Book/findBook"));
//	
//		// // then - verify the output
//		response.andExpect(MockMvcResultMatchers.status().isOk());
//		response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(books.size())));
//	}
//
//
//	Calculator c=new Calculator();
//
//
//
//	/**
//	 * 
//	 */
//	@Test
//	void testSum() {
//	int expectedResult=17;
//	int actualResult=c.doSum(12,3, 2);
//	assertThat(actualResult).isEqualTo(expectedResult);
//	}
//
//	@Test
//	void testProduct(){
//		int expectedResult=6;
//		int actualResult=c.doProduct(2,3);
//		assertThat(actualResult).isEqualTo(expectedResult);
//	}
//
//
//
//
//	
//}
