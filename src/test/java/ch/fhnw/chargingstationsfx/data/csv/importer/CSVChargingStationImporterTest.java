package ch.fhnw.chargingstationsfx.data.csv.importer;

import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVChargingStationImporterTest
{
		private CSVChargingStationImporter importer;
		private Path source;

		@BeforeEach
		public void setUp ()
		{
				importer = new CSVChargingStationImporter();
				source = Paths.get( "src", "test", "resources", "data", "CHARGING_STATION.csv" );
		}

		public void checkSource ()
		{
				if( !Files.exists( this.source ) )
				{
						fail( "Mandatory source file not existing." );
				}
		}

		public long countLinesFromSource ( Path source )
		{
				try
				{
						return Files.lines( source ).count();
				}
				catch ( Exception e )
				{
						fail( e.getMessage() );
				}
				return 0;
		}

		@Test
		public void parseItems ()
		{
				//given
				checkSource();

				//when
				assertEquals( 0, importer.parse( source, '.' ).size() );
				assertEquals( 0, importer.parse( source, ' ' ).size() );
				assertEquals( 0, importer.parse( null, ';' ).size() );
				assertEquals( 0, importer.parse( null, ' ' ).size() );
				assertEquals( countLinesFromSource( source ) - 1, importer.parse( source, ';' ).size() );
		}

		@Test
		public void parseAndValidateChargingStation ()
		{
				//given
				checkSource();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-mm-dd" );

				//then
				List<ChargingStation> chargingStations = importer.parse( source, ';' );

				//when
				chargingStations.forEach( station -> assertNotNull( station.entityIdProperty().get() ) );
				chargingStations.forEach( station -> assertNotNull( station.operatingCompanyProperty().get() ) );
				chargingStations.forEach( station -> assertNotNull( station.addressProperty().get() ) );
				chargingStations.forEach( station -> assertDoesNotThrow( () -> formatter.parse( station.startupDateProperty().get().toString() ) ) );
		}


		@AfterEach
		public void tearDown ()
		{
				importer = null;
				source = null;
		}
}