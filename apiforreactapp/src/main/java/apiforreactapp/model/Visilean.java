package apiforreactapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node(labels = "ReactAPI")
public class Visilean {
	
	@Id
	 private Long id;
	 
	 private String team;
	 
	 private String location;

	public Visilean() {
		super();
		
	}

	public Visilean(Long id, String team, String location) {
		super();
		this.id = id;
		this.team = team;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Visilean [id=" + id + ", team=" + team + ", location=" + location + "]";
	}

	
	 
	 
	 
	 
}
