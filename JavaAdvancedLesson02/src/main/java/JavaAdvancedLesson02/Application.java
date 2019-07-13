package JavaAdvancedLesson02;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		/*
		 * Using AuthorDao
		 */

		List<Author> listOfAuthors = new ArrayList<>();
		listOfAuthors.add(new Author("Igor", "Іванишин", "iwanyshyn@gmail.com", "Івано-Франківськ",
				Date.valueOf(Date.valueOf("2014-10-19").toLocalDate().plusDays(1))));
		listOfAuthors.add(new Author("Христина", "Іванишин", "iwanyshyn_kristina@gmail.com", "Івано-Франківськ",
				Date.valueOf(Date.valueOf("2015-10-19").toLocalDate().plusDays(1))));
		listOfAuthors.add(new Author("Ігор", "Іванишин", "iwanyshyn_igor@gmail.com", "Івано-Франківськ",
				Date.valueOf(Date.valueOf("2016-10-19").toLocalDate().plusDays(1))));
		listOfAuthors.add(new Author("Анастасія", "Іванишин", "iwanyshyn_anastasia@gmail.com", "Івано-Франківськ",
				Date.valueOf(Date.valueOf("2017-10-19").toLocalDate().plusDays(1))));

		AuthorDao authorDao = new AuthorDao(ConnectionUtils.openConnection());

		// READ ALL
		List<Author> resultedList = authorDao.readAll();
		resultedList.stream().forEach(System.out::println);
		System.out.println();

//		// CREATE
//		listOfAuthors.stream().forEach(author -> {
//			try {
//				authorDao.insert(author);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		});
//		authorDao.readAll().stream().forEach(System.out::println);
//		System.out.println();

		// READ BY ID
		int idForReading = 13;
		Optional<Author> findAnyAuthor = resultedList.stream().filter(x -> x.getId() == idForReading).findAny();
		if (findAnyAuthor.isPresent()) {
			System.out.println(authorDao.read(idForReading) + "\n");
		} else {
			System.out.println("Table aythor hasn't element with id " + idForReading + "!\n");
		}

		// UPDATE BY ID
		int idForUpdating = 12;
		findAnyAuthor = resultedList.stream().filter(x -> x.getId() == idForUpdating).findAny();
		if (findAnyAuthor.isPresent()) {
			Author authorUpdate = authorDao.read(idForUpdating);
			authorUpdate.setBirthday(Date.valueOf(Date.valueOf("1978-06-10").toLocalDate().plusDays(1)));
			authorDao.update(authorUpdate);
			System.out.println(authorDao.read(idForUpdating) + "\n");
		} else {
			System.out.println("Table aythor hasn't element with id " + idForUpdating + "!\n");
		}

		// DELETE BY ID
		int idForDeleting = 14;
		findAnyAuthor = resultedList.stream().filter(x -> x.getId() == idForDeleting).findAny();
		if (findAnyAuthor.isPresent()) {
			authorDao.delete(idForDeleting);
			authorDao.readAll().stream().forEach(System.out::println);
			System.out.println();
		} else {
			System.out.println("Table aythor hasn't element with id " + idForDeleting + "!\n");
		}
		
		/*
		 * Using BookDao
		 */

		List<Book> listOfBook = new ArrayList<>();
		listOfBook.add(new Book("Воно", "Опис книги 'Воно'", 120.50, "1", 4));
		listOfBook.add(new Book("Під куполом", "Опис книги 'Під куполом'", 100, "2", 4));
		listOfBook.add(new Book("11-22-63", "Опис книги '11-22-63'", 150.99, "3", 4));
		
		BookDao bookDao = new BookDao(ConnectionUtils.openConnection());

		// READ ALL
		List<Book> resultedBookList = bookDao.readAll();
		resultedBookList.stream().forEach(System.out::println);
		System.out.println();

//		// CREATE
//		listOfBook.stream().forEach(book -> {
//			try {
//				bookDao.insert(book);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		});
//		bookDao.readAll().stream().forEach(System.out::println);
//		System.out.println();

		// READ BY ID
		int idForBookReading = 5;
		Optional<Book> findAnyBook = resultedBookList.stream().filter(x -> x.getId() == idForBookReading).findAny();
		if (findAnyBook.isPresent()) {
			System.out.println(bookDao.read(idForBookReading) + "\n");
		} else {
			System.out.println("Table book hasn't element with id " + idForBookReading + "!\n");
		}

		// UPDATE BY ID
		int idForBookUpdating = 9;
		findAnyBook = resultedBookList.stream().filter(x -> x.getId() == idForBookUpdating).findAny();
		if (findAnyBook.isPresent()) {
			Book bookUpdate = bookDao.read(idForBookUpdating);
			bookUpdate.setPrice(250.00);
			bookDao.update(bookUpdate);
			System.out.println(bookDao.read(idForBookUpdating) + "\n");
		} else {
			System.out.println("Table book hasn't element with id " + idForBookUpdating + "!\n");
		}

		// DELETE BY ID
		int idForBookDeleting = 8;
		findAnyBook = resultedBookList.stream().filter(x -> x.getId() == idForBookDeleting).findAny();
		if (findAnyBook.isPresent()) {
			bookDao.delete(idForBookDeleting);
			bookDao.readAll().stream().forEach(System.out::println);
			System.out.println();
		} else {
			System.out.println("Table book hasn't element with id " + idForBookDeleting + "!\n");
		}
		
		/*
		 * Using BookAuthorDao
		 */
		
		BookAuthorDao bookAuthorDao = new BookAuthorDao(ConnectionUtils.openConnection());

		// READ ALL
		List<BookAuthor> resultedBookAuthorList = bookAuthorDao.readAll();
		resultedBookAuthorList.stream().forEach(System.out::println);
		System.out.println();
		
		/*
		 * Using GenreOfBookDao
		 */

		List<GenreOfBook> genreOfBookList = new ArrayList<>();
		genreOfBookList.add(new GenreOfBook("Вигадка"));
		
		GenreOfBookDao genreOfBookDao = new GenreOfBookDao(ConnectionUtils.openConnection());

		// READ ALL
		List<GenreOfBook> resultedGenreOfBookList = genreOfBookDao.readAll();
		resultedGenreOfBookList.stream().forEach(System.out::println);
		System.out.println();

//		// CREATE
//		genreOfBookList.stream().forEach(book -> {
//			try {
//				genreOfBookDao.insert(book);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		});
//		genreOfBookDao.readAll().stream().forEach(System.out::println);
//		System.out.println();

		// READ BY ID
		int idForGenreOfBookReading = 12;
		Optional<GenreOfBook> findAnyGenreOfBook = resultedGenreOfBookList.stream().filter(x -> x.getId() == idForGenreOfBookReading).findAny();
		if (findAnyGenreOfBook.isPresent()) {
			System.out.println(genreOfBookDao.read(idForGenreOfBookReading) + "\n");
		} else {
			System.out.println("Table genre_of_book hasn't element with id " + idForGenreOfBookReading + "!\n");
		}

		// UPDATE BY ID
		int idForGenreOfBookUpdating = 9;
		findAnyGenreOfBook = resultedGenreOfBookList.stream().filter(x -> x.getId() == idForGenreOfBookUpdating).findAny();
		if (findAnyGenreOfBook.isPresent()) {
			GenreOfBook genreOfBookUpdate = genreOfBookDao.read(idForGenreOfBookUpdating);
			genreOfBookUpdate.setName("Наукова фантастика");
			genreOfBookDao.update(genreOfBookUpdate);
			System.out.println(genreOfBookDao.read(idForGenreOfBookUpdating) + "\n");
		} else {
			System.out.println("Table genre_of_book hasn't element with id " + idForGenreOfBookUpdating + "!\n");
		}

		// DELETE BY ID
		int idForGenreOfBookDeleting = 9;
		findAnyGenreOfBook = resultedGenreOfBookList.stream().filter(x -> x.getId() == idForGenreOfBookDeleting).findAny();
		if (findAnyGenreOfBook.isPresent()) {
			genreOfBookDao.delete(idForGenreOfBookDeleting);
			genreOfBookDao.readAll().stream().forEach(System.out::println);
			System.out.println();
		} else {
			System.out.println("Table genre_of_book hasn't element with id " + idForGenreOfBookDeleting + "!\n");
		}
	}
}
