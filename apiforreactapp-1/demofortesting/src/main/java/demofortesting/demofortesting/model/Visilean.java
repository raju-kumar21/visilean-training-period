package demofortesting.demofortesting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


// @Document(collection = "ReactAPI")
@Entity
@Table(name="VISILEAN")
public class Visilean {
	
	@javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 private String team;
	 
	 private String location;

	public Visilean() {
		super();
		
	}

	public Visilean(Integer id, String team, String location) {
		super();
		this.id = id;
		this.team = team;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
