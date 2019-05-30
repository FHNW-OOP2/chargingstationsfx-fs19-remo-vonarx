package ch.fhnw.chargingstationsfx.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

public class DateUtilTest
{


		@Test
		public void testToString ()
		{
				//given
				String dateFormat = "dd.MM.yy";
				LocalDate now = LocalDate.now();

				//when
				String date = DateUtil.toString( now, dateFormat );

				//then
				assertDoesNotThrow( () -> LocalDate.parse( date, DateTimeFormatter.ofPattern( dateFormat ) ) );
				assertEquals( "", DateUtil.toString( null, null ) );
				assertEquals( "", DateUtil.toString( null, "" ) );
				assertEquals( "", DateUtil.toString( now, "" ) );
		}


		@Test
		public void testFromString ()
		{
				//given
				String dateFormat = "dd.MM.yy";
				String date = "25.08.17";

				//when
				LocalDate parsedDate = DateUtil.fromString( date, dateFormat );

				//then
				assertThrows( DateTimeParseException.class, () -> DateUtil.fromString( date, "" ) );
				assertDoesNotThrow( () -> DateTimeFormatter.ofPattern( dateFormat ).format( parsedDate ) );
				assertEquals( null, DateUtil.fromString( null, null ) );
				assertEquals( null, DateUtil.fromString( "", null ) );
		}
}
