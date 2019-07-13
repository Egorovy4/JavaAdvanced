package JavaAdvancedLesson02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	private static String READ_ALL = "select * from book";
	private static String CREATE = "insert into book(`name`, `description`, `price`, `isbn`, `genre_of_book_id`) values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from book where id = ?";
	private static String UPDATE_BY_ID = "update book set name = ?, description = ?, price = ?, isbn = ?, genre_of_book_id = ? where id = ?";
	private static String DELETE_BY_ID = "delete from book where id = ?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public BookDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void insert(Book book) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, book.getName());
		preparedStatement.setString(2, book.getDescription());
		preparedStatement.setDouble(3, book.getPrice());
		preparedStatement.setString(4, book.getIsbn());
		preparedStatement.setInt(5, book.getGenreOfBookId());
		preparedStatement.executeUpdate();
	}

	public Book read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		return BookMapper.map(resultSet);
	}

	public void update(Book book) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, book.getName());
		preparedStatement.setString(2, book.getDescription());
		preparedStatement.setDouble(3, book.getPrice());
		preparedStatement.setString(4, book.getIsbn());
		preparedStatement.setInt(5, book.getGenreOfBookId());
		preparedStatement.setInt(6, book.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<Book> readAll() throws SQLException {
		List<Book> listOfBooks = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			listOfBooks.add(BookMapper.map(resultSet));
		}
		return listOfBooks;
	}
}
