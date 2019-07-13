package JavaAdvancedLesson02;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper {
	public static Author map(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String firstName = resultSet.getString("first_name");
		String lastName = resultSet.getString("last_name");
		String email = resultSet.getString("email");
		String address = resultSet.getString("address");
		Date date = resultSet.getDate("birthday");
		
		return new Author(id, firstName, lastName, email, address, date);
	}
}
