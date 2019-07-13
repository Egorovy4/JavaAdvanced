package JavaAdvancedLesson02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookAuthorDao {
	private static String READ_ALL = "select * from book_author";
	
	private Connection connection;
	private PreparedStatement preparedStatement;

	public BookAuthorDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public List<BookAuthor> readAll() throws SQLException {
		List<BookAuthor> listOfBookAuthors = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			listOfBookAuthors.add(BookAuthorMapper.map(resultSet));
		}
		return listOfBookAuthors;
	}
}
