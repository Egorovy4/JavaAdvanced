package JavaAdvancedLesson02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreOfBookDao {
	private static String READ_ALL = "select * from genre_of_book order by id asc";
	private static String CREATE = "insert into genre_of_book(`name`) values (?)";
	private static String READ_BY_ID = "select * from genre_of_book where id = ?";
	private static String UPDATE_BY_ID = "update genre_of_book set name = ? where id = ?";
	private static String DELETE_BY_ID = "delete from genre_of_book where id = ?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public GenreOfBookDao(Connection connection) {
		super();
		this.connection = connection;
	}

	public void insert(GenreOfBook genreOfBook) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, genreOfBook.getName());
		preparedStatement.executeUpdate();
	}

	public GenreOfBook read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		return GenreOfBookMapper.map(resultSet);
	}

	public void update(GenreOfBook genreOfBook) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, genreOfBook.getName());	
		preparedStatement.setInt(2, genreOfBook.getId());
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}

	public List<GenreOfBook> readAll() throws SQLException {
		List<GenreOfBook> genresOfBookList = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			genresOfBookList.add(GenreOfBookMapper.map(resultSet));
		}
		return genresOfBookList;
	}
}
