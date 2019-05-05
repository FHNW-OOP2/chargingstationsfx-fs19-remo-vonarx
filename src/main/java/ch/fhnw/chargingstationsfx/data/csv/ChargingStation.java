package ch.fhnw.chargingstationsfx.data.csv;

import ch.fhnw.chargingstationsfx.data.csv.converter.*;
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

		public int getEntityId ()
		{
				return this.entityId.get();
		}

		public void setEntityId ( int entityId ) { this.entityId.set( entityId ); }

		public int getNumberOfChargingPoints ()
		{
				return this.numberOfChargingPoints.get();
		}

		public void setNumberOfChargingPoints ( int numberOfChargingPoints ) { this.numberOfChargingPoints.set( numberOfChargingPoints ); }

		public int getZipCode ()
		{
				return this.zipCode.get();
		}

		public void setZipCode ( int zipCode ) { this.zipCode.set( zipCode ); }

		public float getConnectionPowerKW ()
		{
				return this.connectionPowerKW.get();
		}

		public void setConnectionPowerKW ( float connectionPowerKW )
		{
				this.connectionPowerKW.set( connectionPowerKW );
		}

		public double getLongitude ()
		{
				return this.longitude.get();
		}

		public void setLongitude ( double longitude ) { this.longitude.set( longitude ); }

		public double getLatitude ()
		{
				return this.latitude.get();
		}

		public void setLatitude ( double latitude ) { this.latitude.set( latitude ); }

		public String getOperatingCompany ()
		{
				return this.operatingCompany.get();
		}

		public void setOperatingCompany ( String operatingCompany ) { this.operatingCompany.set( operatingCompany ); }

		public String getAddress ()
		{
				return this.address.get();
		}

		public void setAddress ( String address ) { this.address.set( address ); }

		public String getCity ()
		{
				return this.city.get();
		}

		public void setCity ( String city ) { this.city.set( city ); }

		public String getLoaderType ()
		{
				return this.loaderType.get();
		}

		public void setLoaderType ( String loaderType )
		{
				this.loaderType.set( loaderType );
		}

		public LocalDate getStartupDate ()
		{
				return this.startupDate.get();
		}

		public void setStartupDate ( LocalDate startupDate ) { this.startupDate.set( startupDate ); }

		public String getPlugTypes1 ()
		{
				return this.plugTypes1.get();
		}

		public void setPlugTypes1 ( String plugTypes1 ) { this.plugTypes1.set( plugTypes1 ); }

		public float getPower1KW ()
		{
				return this.power1KW.get();
		}

		public void setPower1KW ( float power1KW ) { this.power1KW.set( power1KW ); }

		public String getPlugTypes2 ()
		{
				return this.plugTypes2.get();
		}

		public void setPlugTypes2 ( String plugTypes2 ) { this.plugTypes2.set( plugTypes2 ); }

		public float getPower2KW ()
		{
				return this.power2KW.get();
		}

		public void setPower2KW ( float power2KW ) { this.power2KW.set( power2KW ); }

		public String getPlugTypes3 ()
		{
				return this.plugTypes3.get();
		}

		public void setPlugTypes3 ( String plugTypes3 ) { this.plugTypes3.set( plugTypes3 ); }

		public float getPower3KW ()
		{
				return this.power3KW.get();
		}

		public void setPower3KW ( float power3KW ) { this.power3KW.set( power3KW ); }

		public String getPlugTypes4 ()
		{
				return this.plugTypes4.get();
		}

		public void setPlugTypes4 ( String plugTypes4 )
		{
				this.plugTypes4.set( plugTypes4 );
		}

		public float getPower4KW ()
		{
				return this.power4KW.get();
		}

		public void setPower4KW ( float power4KW )
		{
				this.power4KW.set( power4KW );
		}
}
