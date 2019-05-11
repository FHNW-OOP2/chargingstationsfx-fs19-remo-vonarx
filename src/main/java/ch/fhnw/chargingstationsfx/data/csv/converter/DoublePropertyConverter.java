package ch.fhnw.chargingstationsfx.data.csv.converter;

import com.opencsv.bean.AbstractBeanField;
import javafx.beans.property.SimpleDoubleProperty;

public class DoublePropertyConverter extends AbstractBeanField<Double>
{
		@Override
		public Object convert ( String value )
		{
				return new SimpleDoubleProperty( Double.valueOf( value ) );
		}
}
