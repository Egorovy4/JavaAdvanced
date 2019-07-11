package JavaAdvancedLesson01;

import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class ScheduleTest {
	private Seance seance1;
	private Seance seance2;
	private Seance seance3;
	private Schedule schedule;

	@Before
	public void before() {
		seance1 = new Seance(new Movie("Titanic", new Time(1, 50)), new Time(12, 0));
		seance2 = new Seance(new Movie("Terminator", new Time(1, 30)), new Time(15, 0));
		seance3 = new Seance(new Movie("Home alone", new Time(2, 5)), new Time(12, 10));
		schedule = new Schedule();
	}

	@After
	public void after() {
		seance1 = null;
		seance2 = null;
		seance3 = null;
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
	public void addSeanceTest() {
		schedule.addSeance(seance1);
		schedule.addSeance(seance2);
		schedule.addSeance(seance3);

		Set<Seance> actual = schedule.getSeances();

		Set<Seance> expected = new TreeSet<>();
		expected.add(seance1);
		expected.add(seance2);
		expected.add(seance3);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void removeSeanceTest() {
		schedule.addSeance(seance1);
		schedule.addSeance(seance2);
		schedule.addSeance(seance3);

		schedule.removeSeance(seance3);

		Set<Seance> actual = schedule.getSeances();

		Set<Seance> expected = new TreeSet<>();
		expected.add(seance1);
		expected.add(seance2);

		Assert.assertEquals(expected, actual);
	}
}
