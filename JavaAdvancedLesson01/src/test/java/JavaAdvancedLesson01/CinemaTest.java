package JavaAdvancedLesson01;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class CinemaTest {
	private Movie movie1;
	private Movie movie2;
	private Movie movie3;

	private Seance seance1;
	private Seance seance2;
	private Seance seance3;

	private Cinema cinema;

	private static void сinemaComparison(Map<Days, Schedule> actual, Map<Days, Schedule> expected) {
		if (actual.size() == expected.size()) {
			Iterator<Entry<Days, Schedule>> actualIterator = actual.entrySet().iterator();
			Iterator<Entry<Days, Schedule>> expectedIterator = expected.entrySet().iterator();
			while (actualIterator.hasNext() && expectedIterator.hasNext()) {
				Entry<Days, Schedule> actualNext = actualIterator.next();
				Entry<Days, Schedule> expectedNext = expectedIterator.next();

				if (actualNext.getValue().getSeances().size() == expectedNext.getValue().getSeances().size()) {
					if (actualNext.getKey().equals(expectedNext.getKey())) {
						Iterator<Seance> actualValueIterator = actualNext.getValue().getSeances().iterator();
						Iterator<Seance> expectedValueIterator = expectedNext.getValue().getSeances().iterator();

						while (actualValueIterator.hasNext() && expectedValueIterator.hasNext()) {
							Seance actualSeance = actualValueIterator.next();
							Seance expectedSeance = expectedValueIterator.next();
							if (!actualSeance.equals(expectedSeance)) {
								fail("Different seances !");
							}
						}
					} else {
						fail("Different days !");
					}
				} else {
					fail("Quantity of seances is not correct !");
				}
			}
		} else {
			fail("Quantity of days is not correct !");
		}
	}

	@Before
	public void before() {
		movie1 = new Movie("Titanic", new Time(2, 5));
		movie2 = new Movie("Avatar", new Time(2, 40));
		movie3 = new Movie("Green Book", new Time(2, 30));

		seance1 = new Seance(movie1, new Time(12, 0));
		seance2 = new Seance(movie2, new Time(15, 0));
		seance3 = new Seance(movie3, new Time(21, 0));

		cinema = new Cinema(new Time(8, 0), new Time(23, 30));
	}

	@After
	public void after() {
		movie1 = null;
		movie2 = null;
		movie3 = null;

		seance1 = null;
		seance2 = null;
		seance3 = null;

		cinema = null;
	}

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED --> " + description.getClassName() + " " + description.getMethodName());
		};

		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED --> " + description.getClassName() + " " + description.getMethodName());
		};
	};

	@Test
	public void addMovieTest() {
		cinema.addMovie(movie1);
		cinema.addMovie(movie2);
		cinema.addMovie(movie3);
		ArrayList<Movie> actual = cinema.getMoviesLibrary();

		ArrayList<Movie> expected = new ArrayList<>();
		expected.add(movie1);
		expected.add(movie2);
		expected.add(movie3);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void addSeanceTest() {
		cinema.addSeance(seance1, Days.MONDAY.toString());
		cinema.addSeance(seance2, Days.FRIDAY.toString());
		cinema.addSeance(seance3, Days.SATURDAY.toString());
		Map<Days, Schedule> actual = cinema.getSchedules();

		Map<Days, Schedule> expected = new TreeMap<>();
		expected.put(Days.MONDAY, new Schedule());
		expected.put(Days.FRIDAY, new Schedule());
		expected.put(Days.SATURDAY, new Schedule());
		expected.get(Days.MONDAY).addSeance(seance1);
		expected.get(Days.FRIDAY).addSeance(seance2);
		expected.get(Days.SATURDAY).addSeance(seance3);

		CinemaTest.сinemaComparison(actual, expected);
	}

	@Test
	public void removeMovieTest() {
		cinema.addMovie(movie1);
		cinema.addMovie(movie2);
		cinema.addMovie(movie3);
		cinema.removeMovie(movie3);
		ArrayList<Movie> actual = cinema.getMoviesLibrary();

		ArrayList<Movie> expected = new ArrayList<>();
		expected.add(movie1);
		expected.add(movie2);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void removeSeanceTest() {
		cinema.addSeance(seance1, Days.MONDAY.toString());
		cinema.addSeance(seance2, Days.FRIDAY.toString());
		cinema.addSeance(seance3, Days.SATURDAY.toString());
		cinema.removeSeance(seance3, Days.SATURDAY.toString());
		Map<Days, Schedule> actual = cinema.getSchedules();

		Map<Days, Schedule> expected = new TreeMap<>();
		expected.put(Days.MONDAY, new Schedule());
		expected.put(Days.FRIDAY, new Schedule());
		expected.put(Days.SATURDAY, new Schedule());
		expected.get(Days.MONDAY).addSeance(seance1);
		expected.get(Days.FRIDAY).addSeance(seance2);

		CinemaTest.сinemaComparison(actual, expected);
	}
}
