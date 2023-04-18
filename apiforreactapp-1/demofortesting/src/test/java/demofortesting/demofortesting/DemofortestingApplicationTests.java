package demofortesting.demofortesting;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.hibernate.engine.jdbc.env.spi.SQLStateType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import demofortesting.demofortesting.model.Visilean;
import demofortesting.demofortesting.repo.VisileanRepoTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemofortestingApplicationTests {

	private static final String  sql_query = "INSERT INTO VISILEAN(id,team,location) VALUES(1,'Developer','India')";

	@LocalServerPort
	private int port;

	private String baseUrl = "http://localhost";

	private static RestTemplate restTemplate;

	@Autowired
	private VisileanRepoTest visileanRepoTest;

	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}

	@BeforeEach
	public void setUp() {
		baseUrl = baseUrl.concat(":").concat(port + "").concat("/test");
	}

	@Test
	public void testAddVisileanTeam() {
		Visilean team = new Visilean(9, "Wordpress developer", "India");
		Visilean response = restTemplate.postForObject(baseUrl + "/save", team, Visilean.class);

		assertEquals("Wordpress developer", response.getTeam());
		assertEquals(1, visileanRepoTest.findAll().size());
		System.out.println("Test case Pass: 🙂");

	}

	/**
	 * 
	 */
	@Test
	@Sql(statements =sql_query,executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM VISILEAN WHERE  team='Developer'",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testGetVisilean()
	{
		List<Visilean> visilean = restTemplate.getForObject(baseUrl+"/get",List.class);
		assertEquals(1, visilean.size());
		assertEquals(1,visileanRepoTest.findAll().size());
		System.out.println("Test case Pass: 🙂");
	
	}

	@Test
	@Sql(statements =sql_query,executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM VISILEAN WHERE  team='Developer'",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testFindVisileanTeamById()
	{
		Visilean visilean = restTemplate.getForObject(baseUrl+"/getById/{id}",Visilean.class,1);

		assertAll(
		//    ()->assertNull(visilean),
		   ()->assertEquals(1,visilean.getId()), ()->assertEquals("India",visilean.getLocation())
		);
	}



	
	@Test
	@Sql(statements ="INSERT INTO VISILEAN(id,team,location) VALUES(2,'Testing','UK')",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM VISILEAN WHERE  team='Developer'",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testUpdateVisilean()
	{

		Visilean visilean=new Visilean(2,"Testing","India");
		restTemplate.put(baseUrl+"/updateById/{id}", visilean, 2);
		Visilean visileanFromDB=visileanRepoTest.findById(2).get();

		assertAll(
		//    ()->assertNull(visilean),
		   ()->assertEquals("India",visileanFromDB.getLocation())
		);
	
	
	}

}
