package ch.fhnw.chargingstationsfx.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil
{

		public static String toString ( LocalDate date, String format )
		{
				if( date != null )
				{
						return DateTimeFormatter.ofPattern( format ).format( date );
				}
				else
				{
						return "";
				}
		}


		public static LocalDate fromString ( String date, String format )
		{
				if( date != null && !date.isEmpty() )
				{
						return LocalDate.parse( date, DateTimeFormatter.ofPattern( format ) );
				}
				else
				{
						return null;
				}
		}
}
