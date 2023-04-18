package apiforreactapp.repo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import apiforreactapp.model.Visilean;

@Repository
public interface VisileanRepo extends Neo4jRepository<Visilean, Long> {

}
