package apiforreactapp1.repo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.assertions.Assertions;

import apiforreactapp1.AbstractContainerBaseTest;
import apiforreactapp1.model.Book;
import apiforreactapp1.repo.BookRepo;

@DataMongoTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@RunWith(SpringRunner.class)
public class BookRepoTest extends AbstractContainerBaseTest {

    @Autowired
    private BookRepo bookRepo;

    // JUnit for save Book Operation - BDD style

    @Test
    public void givenBookObject_whenSave_thenReturnSaveBooks() {

        // given - setup or precondition

        Book book = new Book(2, "java", "raju", "https//raju.com", "34324", "english", "4555");

        Book saveBooks = bookRepo.save(book);
        // then - verify outputt

        Assertions.assertNotNull(saveBooks);
        Assertions.assertNotNull(saveBooks.getS_no());
        System.out.println("I am running.... Repo   :👍" + Assertions.assertNotNull(saveBooks.getS_no()));

    }

    @Test
    public void givenBookId_whenfindById_thenReturnSaveBooks() {

        // given - setup or precondition

        Book book = new Book(3, "java", "raju", "https//raju.com", "34324", "english", "4555");

        Book saveBooks = bookRepo.save(book);
        // then - verify outputt
        Book saveBook = bookRepo.findById(saveBooks.getS_no()).get();
        Assertions.assertNotNull(saveBook);
        Assertions.assertNotNull(saveBook);
        System.out.println("I am running.... Repo   :👍" + Assertions.assertNotNull(saveBook));

    }

    @AfterEach
    public void tearDown() {
        System.out.println("Tearing Down...");
        bookRepo.deleteAll();
    }

    @Before
    public void setUp() {
        System.out.println("SetUp......");
        bookRepo.deleteAll();
    }

}
