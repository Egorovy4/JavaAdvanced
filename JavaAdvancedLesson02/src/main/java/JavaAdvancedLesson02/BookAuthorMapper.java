package JavaAdvancedLesson02;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookAuthorMapper {
	public static BookAuthor map(ResultSet resultSet) throws SQLException {
		int bookId = resultSet.getInt("book_id");
		int authorId = resultSet.getInt("author_id");
		
		return new BookAuthor(bookId, authorId);
	}
}
