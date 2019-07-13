package JavaAdvancedLesson02;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreOfBookMapper {
	public static GenreOfBook map(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String name = resultSet.getString("name");
	
		return new GenreOfBook(id, name);
	}
}
