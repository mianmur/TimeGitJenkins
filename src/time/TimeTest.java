/*
 * Murtaza Mian
 */
package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly", seconds == 18305);
	}

	@Test
	public void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {
			Time.getTotalSeconds("10:00");
		});
	}

	@Test
	public void testGetTotalSecondsBoundary() {
		int seconds = Time.getTotalSeconds("99:99:99");
		assertTrue("The seconds were not calculated properly", seconds == 362439);
	}

	@ParameterizedTest
	@ValueSource(strings = { "00:32:59", "09:45:59", "23:59:59" })
	void testGetSecondsGood(String candidate) {
		int seconds = Time.getSeconds(candidate);
		assertTrue("The minutes were not calculated properly", seconds == 59);
	}

	@Test
	public void testGetSecondsBad() {
		assertThrows(NumberFormatException.class, () -> {
			Time.getTotalSeconds("99:99:999");
		});
	}

	@Test
	public void testGetSecondsBoundary() {
		int seconds = Time.getSeconds("99:99:99");
		assertTrue("The seconds were not calculated properly", seconds == 99);
	}

	@ParameterizedTest
	@ValueSource(strings = { "00:45:00", "09:45:15", "23:45:59" })
	void testGetTotalMinutesGood(String candidate) {
		int minutes = Time.getTotalMinutes(candidate);
		assertTrue("The minutes were not calculated properly", minutes == 45);
	}

	@Test
	public void testGetTotalMinutesBad() {
		assertThrows(NumberFormatException.class, () -> {
			Time.getTotalSeconds("99:999:99");
		});
	}

	@Test
	public void testGetTotalMinutesBoundary() {
		int minutes = Time.getTotalMinutes("99:99:99");
		assertTrue("The minutes were not calculated properly", minutes == 99);
	}

	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15", "05:59:59" })
	void testGetTotalHoursGood(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertTrue("The hours were not calculated properly", hours == 5);
	}

	@Test
	public void testGetTotalHoursBad() {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {
			Time.getTotalSeconds("10:00");
		});
	}

	@Test
	public void testGetTotalHoursBoundary() {
		int hours = Time.getTotalHours("99:99:99");
		assertTrue("The hours were not calculated properly", hours == 99);
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00:05", "05:15:05:05", "05:59:59:05" })
	void testGetMillisecondsGood(String candidate) {
		int milliseconds = Time.getMilliseconds(candidate);
		assertTrue("The milliseconds were not calculated properly", milliseconds == 5);
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "05:00:10:", "05:15:15:3", "05:59:59" })
	void testGetMilliseccondsBad(String candidate) {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {
			Time.getMilliseconds(candidate);
		});
	}
	
	@Test
	void testGetMilliseccondsBoundary() {
		int milliseconds = Time.getMilliseconds("99:99:99:99");
		assertTrue("The milliseconds were not calculated properly", milliseconds == 99);
	}
	
	
}
