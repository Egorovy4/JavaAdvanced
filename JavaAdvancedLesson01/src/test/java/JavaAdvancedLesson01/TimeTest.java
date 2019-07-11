package JavaAdvancedLesson01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class TimeTest {

	private Time time1;
	private Time time2;
	private Time time3;

	@Before
	public void before() {
		time1 = new Time(1, 35);
		time2 = new Time(49, 129);
		time3 = new Time(-12, 58);
	}

	@After
	public void after() {
		time1 = null;
		time2 = null;
		time3 = null;
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
	public void timeSettingsTest() {
		Time.timeSettings(time1);

		int actualHour = time1.getHour();
		int actualMinute = time1.getMinute();

		int expectedHour = 1;
		int expectedMinute = 35;

		Assert.assertEquals(expectedHour, actualHour);
		Assert.assertEquals(expectedMinute, actualMinute);
	}

	@Test
	public void timeSettingsTestBigValues() {
		Time.timeSettings(time2);

		int actualHour = time2.getHour();
		int actualMinute = time2.getMinute();

		int expectedHour = 3;
		int expectedMinute = 9;

		Assert.assertEquals(expectedHour, actualHour);
		Assert.assertEquals(expectedMinute, actualMinute);
	}

	@Test(expected = IllegalArgumentException.class)
	public void timeSettingsTestAreValuesPositive() {
		Time.timeSettings(time3);
	}
}
