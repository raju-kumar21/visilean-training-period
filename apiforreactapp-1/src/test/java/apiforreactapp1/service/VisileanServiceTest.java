package apiforreactapp1.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import apiforreactapp1.repo.VisileanRepo;

@ExtendWith(MockitoExtension.class)
public class VisileanServiceTest {

   @Mock 
    private VisileanRepo visileanRepo;

    private VisileanService visileanService;


    @BeforeEach
    public void setUp()
    {
        this.visileanService=new VisileanService(this.visileanRepo);
    }



    @Test
    void testDelete() {

    }

    @Test
    void testGet() {
            visileanService.get();
            verify(visileanRepo).findAll();
            System.out.println("Service test running all fine ");
    }

    @Test
    void testGet2() {

    }

    @Test
    void testSave() {

    }

    @Test
    void testUpdate() {

    }
}
