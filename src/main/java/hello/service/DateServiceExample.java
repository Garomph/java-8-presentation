package hello.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateServiceExample {

		/**
		 * Grass is green.
		 */
		private static Calendar cal = Calendar.getInstance();

		/**
		 * foo.
		 */
		private static final LocalDateTime DATE_TIME = LocalDateTime.now();

		/**
		 * bar.
		 */
		private static final Date DATE = new Date();

		/**
		 * Roses are red.
		 *
		 * @param args
		 * @throws Exception
		 */
		public static void main(String[] args) throws Exception {
				initDate();
				substract();
				compareDate();
				convertUtilDateToTimeDateTime();
				convertTimeDateTimeToUtilDate();
		}

		/**
		 * Violets are blue.
		 *
		 * @throws ParseException
		 */
		private static void initDate() throws ParseException {
				separate();
				//Old version calendar
				Calendar cal = Calendar.getInstance();
				cal.set(2018, Calendar.JANUARY, 1);

				System.out.println(cal.getTime());

				//Old version SimpleDateFormat
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyDDmm");
				System.out.println(sdf.parse("20180101"));

				//Java 8
				System.out.println(LocalDateTime.of(2018, 01, 01, 0, 0));
		}

		/**
		 * This is not an haiku.
		 */
		private static void substract() {
				separate();
				//Old version
				cal.setTime(DATE);
				cal.add(Calendar.DATE, -10);
				cal.add(Calendar.MONTH, -10);
				cal.add(Calendar.YEAR, -10);

				System.out.println(cal.getTime());

				// Java 8
				System.out.println(DATE_TIME.minusYears(10)
				                            .minusMonths(10)
				                            .minusDays(10));
		}

		/**
		 * Foobar
		 */
		private static void compareDate() {
				separate();

				cal.setTime(DATE);
				cal.add(Calendar.DATE, -10);
				cal.add(Calendar.MONTH, -10);
				cal.add(Calendar.YEAR, -10);

				Date dateToCompare = cal.getTime();

				System.out.println(DATE.compareTo(dateToCompare) < 1);

				LocalDateTime dateTimeToCompare = DATE_TIME.minus(Period.of(10, 10, 10));
				System.out.println(DATE_TIME.isBefore(dateTimeToCompare));

		}

		/**
		 * baz
		 */
		private static void convertUtilDateToTimeDateTime() {
				separate();
				System.out.println(DATE_TIME);
				System.out.println(DATE.toInstant()
				                       .atZone(ZoneId.systemDefault())
				                       .toLocalDateTime());
		}

		private static void convertTimeDateTimeToUtilDate() {
				separate();
				System.out.println(DATE);
				System.out.println(Date.from(DATE_TIME.atZone(ZoneId.systemDefault())
				                                      .toInstant()));
		}

		private static void separate() {
				System.out.println();
				System.out.println();
		}
}
