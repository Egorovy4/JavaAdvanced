package JavaAdvancedLesson02;

public class Book {
	private int id;
	private String name;
	private String description;
	private double price;
	private String isbn;
	private int genreOfBookId;
	
	public Book(int id, String name, String description, double price, String isbn, int genreOfBookId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.isbn = isbn;
		this.genreOfBookId = genreOfBookId;
	}
	
	public Book(String name, String description, double price, String isbn, int genreOfBookId) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.isbn = isbn;
		this.genreOfBookId = genreOfBookId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getGenreOfBookId() {
		return genreOfBookId;
	}

	public void setGenreOfBookId(int genreOfBookId) {
		this.genreOfBookId = genreOfBookId;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", isbn="
				+ isbn + ", genreOfBookId=" + genreOfBookId + "]";
	}
}
