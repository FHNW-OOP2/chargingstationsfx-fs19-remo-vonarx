package ch.fhnw.chargingstationsfx.data.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatePropertyConverter extends AbstractBeanField<LocalDate>
{
		private DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "dd.MM.yy" ).withLocale( Locale.GERMAN );

		@Override
		public Object convert ( String value )
		{
				return new SimpleObjectProperty<>( LocalDate.parse( value, this.formatter ) );
		}

		@Override
		protected String convertToWrite ( Object value )
		{
				SimpleObjectProperty property = ((SimpleObjectProperty) value);
				return LocalDate.parse( property.get().toString() ).toString();
		}
}
