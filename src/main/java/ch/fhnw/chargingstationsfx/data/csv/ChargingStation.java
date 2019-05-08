package ch.fhnw.chargingstationsfx.data.csv;

import ch.fhnw.chargingstationsfx.data.csv.converter.*;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;
import javafx.beans.property.*;

import java.time.LocalDate;

public class ChargingStation
{
		@CsvCustomBindByName(column = "ENTITY_ID", converter = IntegerPropertyConverter.class)
		private IntegerProperty entityId;

		@CsvCustomBindByName(column = "OPERATING_COMPANY", converter = StringPropertyConverter.class)
		private SimpleStringProperty operatingCompany;

		@CsvCustomBindByName(column = "ADDRESS", converter = StringPropertyConverter.class)
		private SimpleStringProperty address;

		@CsvCustomBindByName(column = "ZIP_CODE", converter = IntegerPropertyConverter.class)
		private SimpleIntegerProperty zipCode;

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
		private SimpleIntegerProperty numberOfChargingPoints;

		@CsvCustomBindByName(column = "CONNECTION_POWER_KW", converter = FloatPropertyConverter.class)
		private SimpleFloatProperty connectionPowerKW;

		@CsvCustomBindByName(column = "PLUG_TYPES_1", converter = StringPropertyConverter.class)
		private SimpleStringProperty plugTypes1;

		@CsvCustomBindByName(column = "POWER_1_KW", converter = FloatPropertyConverter.class)
		private SimpleFloatProperty power1KW;

		@CsvCustomBindByName(column = "PLUG_TYPES_2", converter = StringPropertyConverter.class)
		private SimpleStringProperty plugTypes2;

		@CsvCustomBindByName(column = "POWER_2_KW", converter = FloatPropertyConverter.class)
		private SimpleFloatProperty power2KW;

		@CsvCustomBindByName(column = "PLUG_TYPES_3", converter = StringPropertyConverter.class)
		private SimpleStringProperty plugTypes3;

		@CsvCustomBindByName(column = "POWER_3_KW", converter = FloatPropertyConverter.class)
		private SimpleFloatProperty power3KW;

		@CsvCustomBindByName(column = "PLUG_TYPES_4", converter = StringPropertyConverter.class)
		private SimpleStringProperty plugTypes4;

		@CsvCustomBindByName(column = "POWER_4_KW", converter = FloatPropertyConverter.class)
		private SimpleFloatProperty power4KW;

		public IntegerProperty getEntityId () { return entityId; }
		public SimpleIntegerProperty getNumberOfChargingPoints ()
		{
				return numberOfChargingPoints;
		}
		public SimpleIntegerProperty getZipCode ()
		{
				return zipCode;
		}
		public SimpleFloatProperty getConnectionPowerKW ()
		{
				return connectionPowerKW;
		}
		public SimpleDoubleProperty getLongitude ()
		{
				return longitude;
		}
		public SimpleDoubleProperty getLatitude ()
		{
				return latitude;
		}
		public SimpleStringProperty getOperatingCompany ()
		{
				return operatingCompany;
		}
		public SimpleStringProperty getAddress ()
		{
				return address;
		}
		public SimpleStringProperty getCity ()
		{
				return city;
		}
		public SimpleStringProperty getLoaderType ()
		{
				return loaderType;
		}
		public SimpleObjectProperty<LocalDate> getStartupDate ()
		{
				return startupDate;
		}
		public SimpleStringProperty getPlugTypes1 ()
		{
				return plugTypes1;
		}
		public SimpleFloatProperty getPower1KW ()
		{
				return power1KW;
		}
		public SimpleStringProperty getPlugTypes2 ()
		{
				return plugTypes2;
		}
		public SimpleFloatProperty getPower2KW ()
		{
				return power2KW;
		}
		public SimpleStringProperty getPlugTypes3 ()
		{
				return plugTypes3;
		}
		public SimpleFloatProperty getPower3KW ()
		{
				return power3KW;
		}
		public SimpleStringProperty getPlugTypes4 ()
		{
				return plugTypes4;
		}
		public SimpleFloatProperty getPower4KW ()
		{
				return power4KW;
		}

}
