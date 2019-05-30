package ch.fhnw.chargingstationsfx.presentationmodel;

import ch.fhnw.chargingstationsfx.data.csv.converter.DatePropertyConverter;
import ch.fhnw.chargingstationsfx.data.csv.converter.DoublePropertyConverter;
import ch.fhnw.chargingstationsfx.data.csv.converter.IntegerPropertyConverter;
import ch.fhnw.chargingstationsfx.data.csv.converter.StringPropertyConverter;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.*;

import java.time.LocalDate;

public class ChargingStation
{
		@CsvCustomBindByName(column = "ENTITY_ID", converter = IntegerPropertyConverter.class)
		private SimpleIntegerProperty entityIdProperty = new SimpleIntegerProperty();

		@CsvCustomBindByName(column = "OPERATING_COMPANY", converter = StringPropertyConverter.class)
		private SimpleStringProperty operatingCompanyProperty = new SimpleStringProperty();

		@CsvCustomBindByName(column = "ADDRESS", converter = StringPropertyConverter.class)
		private SimpleStringProperty addressProperty = new SimpleStringProperty();

		@CsvCustomBindByName(column = "ZIP_CODE", converter = StringPropertyConverter.class)
		private SimpleStringProperty zipCodeProperty = new SimpleStringProperty();

		@CsvCustomBindByName(column = "CITY", converter = StringPropertyConverter.class)
		private SimpleStringProperty cityProperty = new SimpleStringProperty();

		@CsvCustomBindByName(column = "LONGITUDE", converter = DoublePropertyConverter.class)
		private SimpleDoubleProperty longitudeProperty = new SimpleDoubleProperty();

		@CsvCustomBindByName(column = "LATITUDE", converter = DoublePropertyConverter.class)
		private SimpleDoubleProperty latitudeProperty = new SimpleDoubleProperty();

		@CsvCustomBindByName(column = "LOADER_TYPE", converter = StringPropertyConverter.class)
		private SimpleStringProperty loaderTypeProperty = new SimpleStringProperty();

		@CsvCustomBindByName(column = "START_UP_DATE", converter = DatePropertyConverter.class)
		@CsvDate("dd.MM.yy")
		private SimpleObjectProperty<LocalDate> startupDateProperty = new SimpleObjectProperty<>();

		@CsvCustomBindByName(column = "NUMBER_OF_CHARGING_POINTS", converter = IntegerPropertyConverter.class)
		private SimpleIntegerProperty chargingPointsProperty = new SimpleIntegerProperty();

		@CsvCustomBindByName(column = "PLUG_TYPES_1", converter = StringPropertyConverter.class)
		private SimpleStringProperty plugTypes1Property = new SimpleStringProperty();

		@CsvCustomBindByName(column = "POWER_1_KW", converter = DoublePropertyConverter.class)
		private SimpleDoubleProperty power1KwProperty = new SimpleDoubleProperty();

		@CsvCustomBindByName(column = "PLUG_TYPES_2", converter = StringPropertyConverter.class)
		private SimpleStringProperty plugTypes2Property = new SimpleStringProperty();

		@CsvCustomBindByName(column = "POWER_2_KW", converter = DoublePropertyConverter.class)
		private SimpleDoubleProperty power2KwProperty = new SimpleDoubleProperty();

		@CsvCustomBindByName(column = "PLUG_TYPES_3", converter = StringPropertyConverter.class)
		private SimpleStringProperty plugTypes3Property = new SimpleStringProperty();

		@CsvCustomBindByName(column = "POWER_3_KW", converter = DoublePropertyConverter.class)
		private SimpleDoubleProperty power3KwProperty = new SimpleDoubleProperty();

		@CsvCustomBindByName(column = "PLUG_TYPES_4", converter = StringPropertyConverter.class)
		private SimpleStringProperty plugTypes4Property = new SimpleStringProperty();

		@CsvCustomBindByName(column = "POWER_4_KW", converter = DoublePropertyConverter.class)
		private SimpleDoubleProperty power4KwProperty = new SimpleDoubleProperty();

		private DoubleBinding connectionPowerKW = power1KwProperty.add( power2KwProperty ).add( power3KwProperty ).add( power4KwProperty );

		public ChargingStation ( int entityId )
		{
				entityIdProperty.set( entityId );
		}

		public ChargingStation () {}

		public IntegerProperty entityIdProperty () { return entityIdProperty; }
		public SimpleIntegerProperty chargingPointsProperty ()
		{
				return chargingPointsProperty;
		}
		public StringProperty zipCodeProperty () { return zipCodeProperty; }
		public DoubleProperty longitudeProperty ()
		{
				return longitudeProperty;
		}
		public DoubleProperty latitudeProperty ()
		{
				return latitudeProperty;
		}
		public StringProperty operatingCompanyProperty ()
		{
				return operatingCompanyProperty;
		}
		public StringProperty addressProperty ()
		{
				return addressProperty;
		}
		public StringProperty cityProperty ()
		{
				return cityProperty;
		}
		public StringProperty loaderTypeProperty ()
		{
				return loaderTypeProperty;
		}
		public ObjectProperty<LocalDate> startupDateProperty () { return startupDateProperty; }
		public StringProperty plugTypes1Property ()
		{
				return plugTypes1Property;
		}
		public DoubleProperty power1KwProperty ()
		{
				return power1KwProperty;
		}
		public StringProperty plugTypes2Property ()
		{
				return plugTypes2Property;
		}
		public DoubleProperty power2KwProperty ()
		{
				return power2KwProperty;
		}
		public StringProperty plugTypes3Property () { return plugTypes3Property; }
		public DoubleProperty power3KwProperty ()
		{
				return power3KwProperty;
		}
		public StringProperty plugTypes4Property ()
		{
				return plugTypes4Property;
		}
		public DoubleProperty power4KwProperty ()
		{
				return power4KwProperty;
		}
		public DoubleBinding getConnectionPowerKWBinding () { return connectionPowerKW; }

		//Getters are needed for the export, therefore ignore warnings.
		public int getEntityIdProperty () { return entityIdProperty.get(); }
		public String getOperatingCompanyProperty () { return operatingCompanyProperty.get(); }
		public String getAddressProperty () { return addressProperty.get(); }
		public String getZipCodeProperty () { return zipCodeProperty.get(); }
		public String getCityProperty () { return cityProperty.get(); }
		public double getLongitudeProperty () { return longitudeProperty.get(); }
		public double getLatitudeProperty () { return latitudeProperty.get(); }
		public String getLoaderTypeProperty () { return loaderTypeProperty.get(); }
		public LocalDate getStartupDateProperty () { return startupDateProperty.get(); }
		public int getChargingPointsProperty () { return chargingPointsProperty.get(); }
		public double getConnectionPowerKW () { return connectionPowerKW.get(); }
		public String getPlugTypes1Property () { return plugTypes1Property.get(); }
		public double getPower1KwProperty () { return power1KwProperty.get(); }
		public String getPlugTypes2Property () { return plugTypes2Property.get(); }
		public double getPower2KwProperty () { return power2KwProperty.get(); }
		public String getPlugTypes3Property () { return plugTypes3Property.get(); }
		public double getPower3KwProperty () { return power3KwProperty.get(); }
		public String getPlugTypes4Property () { return plugTypes4Property.get(); }
		public double getPower4KwProperty () { return power4KwProperty.get(); }
}