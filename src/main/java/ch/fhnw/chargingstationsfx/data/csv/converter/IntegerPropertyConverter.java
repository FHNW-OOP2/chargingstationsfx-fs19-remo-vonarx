package ch.fhnw.chargingstationsfx.data.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import javafx.beans.property.SimpleIntegerProperty;

public class IntegerPropertyConverter extends AbstractBeanField<Integer>
{
		@Override
		public Object convert ( String value ) throws CsvDataTypeMismatchException, CsvConstraintViolationException
		{
				return new SimpleIntegerProperty( Integer.valueOf( value ) );
		}
}
