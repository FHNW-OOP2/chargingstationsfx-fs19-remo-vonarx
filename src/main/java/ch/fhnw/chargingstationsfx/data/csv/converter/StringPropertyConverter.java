package ch.fhnw.chargingstationsfx.data.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import javafx.beans.property.SimpleStringProperty;

public class StringPropertyConverter extends AbstractBeanField<String>
{
		@Override
		public Object convert ( String value )
		{
				return new SimpleStringProperty( value );
		}
}
