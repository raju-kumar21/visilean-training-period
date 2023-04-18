package apiforreactapp1.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import apiforreactapp1.model.Visilean;

@Repository
public interface VisileanRepo extends MongoRepository<Visilean, Integer> {

}
