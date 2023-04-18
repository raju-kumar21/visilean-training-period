package apiforreactapp1;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.containers.MongoDBContainer;

import apiforreactapp1.repo.BookRepo;

public class AbstractContainerBaseTest {

    @Autowired
    BookRepo bookRepo;
    /**
     *
     */
    static final MongoDBContainer MONGO_DB_CONTAINER;

    static{
        MONGO_DB_CONTAINER = new MongoDBContainer("mongo:latest");
         MONGO_DB_CONTAINER.start();
    }
  /**
     * 
     */
   
}
