package ch.fhnw.chargingstationsfx.data.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import javafx.beans.property.SimpleStringProperty;

public class StringPropertyConverter<T> extends AbstractBeanField<T>
{
		@Override
		public Object convert ( String value ) throws CsvDataTypeMismatchException, CsvConstraintViolationException
		{
				return new SimpleStringProperty( value );
		}
}
