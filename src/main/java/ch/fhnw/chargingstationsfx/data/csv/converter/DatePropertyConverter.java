package ch.fhnw.chargingstationsfx.data.csv.converter;

import ch.fhnw.chargingstationsfx.util.DateUtil;
import com.opencsv.bean.AbstractBeanField;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

import static ch.fhnw.chargingstationsfx.ChargingStationsApp.DATE_FORMAT;

public class DatePropertyConverter extends AbstractBeanField<LocalDate>
{

		@Override
		public Object convert ( String value )
		{
				return new SimpleObjectProperty<>( DateUtil.fromString( value, DATE_FORMAT ) );
		}

		@Override
		protected String convertToWrite ( Object value )
		{
				return DateUtil.toString( (LocalDate) value, DATE_FORMAT );
		}
}
