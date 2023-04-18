package demofortesting.demofortesting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import demofortesting.demofortesting.model.Visilean;



// @Repository
// public interface VisileanRepo extends MongoRepository<Visilean, Integer> {

// }


@Repository
public interface VisileanRepo extends JpaRepository<Visilean, Integer> {

}
