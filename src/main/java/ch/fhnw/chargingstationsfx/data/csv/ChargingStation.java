package ch.fhnw.chargingstationsfx.data.csv;

import ch.fhnw.chargingstationsfx.data.csv.converter.DatePropertyConverter;
import ch.fhnw.chargingstationsfx.data.csv.converter.DoublePropertyConverter;
import ch.fhnw.chargingstationsfx.data.csv.converter.IntegerPropertyConverter;
import ch.fhnw.chargingstationsfx.data.csv.converter.StringPropertyConverter;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;
import javafx.beans.property.*;

import java.time.LocalDate;

public class ChargingStation
{
		@CsvCustomBindByName(column = "ENTITY_ID", converter = IntegerPropertyConverter.class)
		private SimpleIntegerProperty entityId;

		@CsvCustomBindByName(column = "OPERATING_COMPANY", converter = StringPropertyConverter.class)
		private SimpleStringProperty operatingCompany;

		@CsvCustomBindByName(column = "ADDRESS", converter = StringPropertyConverter.class)
		private SimpleStringProperty address;

		@CsvCustomBindByName(column = "ZIP_CODE", converter = StringPropertyConverter.class)
		private SimpleStringProperty zipCode;

		@CsvCustomBindByName(column = "CITY", converter = StringPropertyConverter.class)
		private SimpleStringProperty city;

		@CsvCustomBindByName(column = "LONGITUDE", converter = DoublePropertyConverter.class)
		private SimpleDoubleProperty longitude;

		@CsvCustomBindByName(column = "LATITUDE", converter = DoublePropertyConverter.class)
		private SimpleDoubleProperty latitude;

		@CsvCustomBindByName(column = "LOADER_TYPE", converter = StringPropertyConverter.class)
		private SimpleStringProperty loaderType;

		@CsvCustomBindByName(column = "START_UP_DATE", converter = DatePropertyConverter.class)
		@CsvDate("dd.MM.yy")
		private SimpleObjectProperty<LocalDate> startupDate;

		@CsvCustomBindByName(column = "NUMBER_OF_CHARGING_POINTS", converter = IntegerPropertyConverter.class)
		private SimpleIntegerProperty chargingPoints;

		@CsvCustomBindByName(column = "CONNECTION_POWER_KW", converter = DoublePropertyConverter.class)
		private SimpleDoubleProperty connectionPowerKW;

		@CsvCustomBindByName(column = "PLUG_TYPES_1", converter = StringPropertyConverter.class)
		private SimpleStringProperty plugTypes1;

		@CsvCustomBindByName(column = "POWER_1_KW", converter = DoublePropertyConverter.class)
		private SimpleDoubleProperty power1KW;

		@CsvCustomBindByName(column = "PLUG_TYPES_2", converter = StringPropertyConverter.class)
		private SimpleStringProperty plugTypes2;

		@CsvCustomBindByName(column = "POWER_2_KW", converter = DoublePropertyConverter.class)
		private SimpleDoubleProperty power2KW;

		@CsvCustomBindByName(column = "PLUG_TYPES_3", converter = StringPropertyConverter.class)
		private SimpleStringProperty plugTypes3;

		@CsvCustomBindByName(column = "POWER_3_KW", converter = DoublePropertyConverter.class)
		private SimpleDoubleProperty power3KW;

		@CsvCustomBindByName(column = "PLUG_TYPES_4", converter = StringPropertyConverter.class)
		private SimpleStringProperty plugTypes4;

		@CsvCustomBindByName(column = "POWER_4_KW", converter = DoublePropertyConverter.class)
		private SimpleDoubleProperty power4KW;

		public ChargingStation ()
		{
				entityId = new SimpleIntegerProperty();
				chargingPoints = new SimpleIntegerProperty();
				connectionPowerKW = new SimpleDoubleProperty();
				longitude = new SimpleDoubleProperty();
				latitude = new SimpleDoubleProperty();
				operatingCompany = new SimpleStringProperty();
				address = new SimpleStringProperty();
				zipCode = new SimpleStringProperty();
				city = new SimpleStringProperty();
				loaderType = new SimpleStringProperty();
				startupDate = new SimpleObjectProperty<LocalDate>();
				plugTypes1 = new SimpleStringProperty();
				power1KW = new SimpleDoubleProperty();
				plugTypes2 = new SimpleStringProperty();
				power2KW = new SimpleDoubleProperty();
				plugTypes3 = new SimpleStringProperty();
				power3KW = new SimpleDoubleProperty();
				plugTypes4 = new SimpleStringProperty();
				power4KW = new SimpleDoubleProperty();
		}

		public IntegerProperty getEntityId () { return entityId; }
		public IntegerProperty getChargingPoints ()
		{
				return chargingPoints;
		}
		public StringProperty getZipCode ()
		{
				return zipCode;
		}
		public DoubleProperty getConnectionPowerKW ()
		{
				return connectionPowerKW;
		}
		public DoubleProperty getLongitude ()
		{
				return longitude;
		}
		public DoubleProperty getLatitude ()
		{
				return latitude;
		}
		public StringProperty getOperatingCompany ()
		{
				return operatingCompany;
		}
		public StringProperty getAddress ()
		{
				return address;
		}
		public StringProperty getCity ()
		{
				return city;
		}
		public StringProperty getLoaderType ()
		{
				return loaderType;
		}
		public ObjectProperty<LocalDate> getStartupDate ()
		{
				return startupDate;
		}
		public StringProperty getPlugTypes1 ()
		{
				return plugTypes1;
		}
		public DoubleProperty getPower1KW ()
		{
				return power1KW;
		}
		public StringProperty getPlugTypes2 ()
		{
				return plugTypes2;
		}
		public DoubleProperty getPower2KW ()
		{
				return power2KW;
		}
		public StringProperty getPlugTypes3 ()
		{
				return plugTypes3;
		}
		public DoubleProperty getPower3KW ()
		{
				return power3KW;
		}
		public StringProperty getPlugTypes4 ()
		{
				return plugTypes4;
		}
		public DoubleProperty getPower4KW ()
		{
				return power4KW;
		}
}
