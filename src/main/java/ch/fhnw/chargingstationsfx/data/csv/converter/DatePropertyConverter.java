package ch.fhnw.chargingstationsfx.data.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatePropertyConverter extends AbstractBeanField<LocalDate>
{
		private DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd.MM.yy" );

		@Override
		public Object convert ( String value ) throws CsvDataTypeMismatchException, CsvConstraintViolationException
		{
				this.formatter = this.formatter.withLocale( Locale.GERMAN );
				return new SimpleObjectProperty( LocalDate.parse( value, this.formatter ) );
		}

		@Override
		protected String convertToWrite ( Object value ) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException
		{
				SimpleObjectProperty property = ((SimpleObjectProperty) value);
				return LocalDate.parse( property.get().toString() ).toString();
		}
}
