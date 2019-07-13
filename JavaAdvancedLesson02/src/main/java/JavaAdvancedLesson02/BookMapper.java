package JavaAdvancedLesson02;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {
	public static Book map(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String name = resultSet.getString("name");
		String description = resultSet.getString("description");
		double price = resultSet.getDouble("price");
		String isbn = resultSet.getString("isbn");
		int genreOfBookId = resultSet.getInt("genre_of_book_id");
		
		return new Book(id, name, description, price, isbn, genreOfBookId);
	}
}
