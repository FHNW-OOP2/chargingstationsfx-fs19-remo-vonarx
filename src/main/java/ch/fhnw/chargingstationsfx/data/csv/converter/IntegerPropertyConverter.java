package ch.fhnw.chargingstationsfx.data.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import javafx.beans.property.SimpleIntegerProperty;

public class IntegerPropertyConverter extends AbstractBeanField<Integer>
{
		@Override
		public Object convert ( String value )
		{
				return new SimpleIntegerProperty( Integer.valueOf( value ) );
		}
}
