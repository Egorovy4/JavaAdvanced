package JavaAdvancedLesson02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {
	private static String READ_ALL = "select * from author";
	private static String CREATE = "insert into author(`first_name`, `last_name`, `email`, `address`, `birthday`) values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from author where id = ?";
	private static String UPDATE_BY_ID = "update author set first_name = ?, last_name = ?, email = ?, address = ?, birthday = ? where id = ?";
	private static String DELETE_BY_ID = "delete from author where id = ?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public AuthorDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void insert(Author author) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, author.getFirstName());
		preparedStatement.setString(2, author.getLastName());
		preparedStatement.setString(3, author.getEmail());
		preparedStatement.setString(4, author.getAddress());
		preparedStatement.setDate(5, author.getBirthday());
		preparedStatement.executeUpdate();
	}

	public Author read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		return AuthorMapper.map(resultSet);
	}

	public void update(Author author) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, author.getFirstName());
		preparedStatement.setString(2, author.getLastName());
		preparedStatement.setString(3, author.getEmail());
		preparedStatement.setString(4, author.getAddress());
		preparedStatement.setDate(5, author.getBirthday());
		preparedStatement.setInt(6, author.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<Author> readAll() throws SQLException {
		List<Author> listOfAuthors = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			listOfAuthors.add(AuthorMapper.map(resultSet));
		}
		return listOfAuthors;
	}
}
