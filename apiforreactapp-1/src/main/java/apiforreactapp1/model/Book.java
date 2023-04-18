package apiforreactapp1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
public class Book {
	
	@Id
	private Integer s_no;
	
	private String title;
	
	private String author;
	
	private String coverPhotoURL;
	
	private String isbnNumber;
	
	private String price;
	
	private String language;

	public Book() {
		super();
	
	}

	public Book(Integer s_no, String title, String author, String coverPhotoURL, String isbnNumber, String price,
			String language) {
		super();
		this.s_no = s_no;
		this.title = title;
		this.author = author;
		this.coverPhotoURL = coverPhotoURL;
		this.isbnNumber = isbnNumber;
		this.price = price;
		this.language = language;
	}

	public Integer getS_no() {
		return s_no;
	}

	public void setS_no(Integer s_no) {
		this.s_no = s_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCoverPhotoURL() {
		return coverPhotoURL;
	}

	public void setCoverPhotoURL(String coverPhotoURL) {
		this.coverPhotoURL = coverPhotoURL;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Book [s_no=" + s_no + ", title=" + title + ", author=" + author + ", coverPhotoURL=" + coverPhotoURL
				+ ", isbnNumber=" + isbnNumber + ", price=" + price + ", language=" + language + "]";
	}
	
	
	
	
	
	

}
