package ch.fhnw.chargingstationsfx.data.csv.exporter;

import ch.fhnw.chargingstationsfx.data.csv.ChargingStation;
import ch.fhnw.chargingstationsfx.data.csv.importer.CSVChargingStationImporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestCSVChargingStationExporter
{
		private Path source;
		private Path destination;
		private CSVChargingStationExporter exporter;
		private CSVChargingStationImporter importer;
		private List<ChargingStation> chargingStations;

		@BeforeEach
		public void setUp ()
		{
				importer = new CSVChargingStationImporter();
				exporter = new CSVChargingStationExporter();

				source = Paths.get( "src", "test", "resources", "data", "CHARGING_STATION.csv" );
				destination = Paths.get( "src", "test", "resources", "data", "CHARGING_STATION_out.csv" );
		}

		public void checkSource ()
		{
				if( !Files.exists( source ) )
				{
						fail( "Mandatory source file not existing." );
				}
		}

		@Test
		public void testExport ()
		{
				//when
				assertFalse( exporter.export( destination, null, ';' ) );
				assertFalse( Files.exists( destination ) );
				assertFalse( exporter.export( null, null, ';' ) );
				assertFalse( Files.exists( destination ) );
				assertFalse( exporter.export( destination, Collections.emptyList(), ';' ) );
				assertFalse( Files.exists( destination ) );
		}

		@Test
		public void testExportAndValidateAgainstImport ()
		{
				//given
				checkSource();
				chargingStations = importer.parse( source, ';' );
				int exportSize = chargingStations.size();

				//when
				exporter.export( destination, chargingStations, ';' );
				//then
				assertTrue( Files.exists( destination ) );
				//when
				chargingStations = importer.parse( destination, ';' );
				//then
				assertEquals( exportSize, chargingStations.size() );
		}

		@AfterEach
		public void tearDown ()
		{
				importer = null;
				exporter = null;
				source = null;
				chargingStations = null;
		}

		@AfterEach
		public void deleteDestinationFile ()
		{
				try
				{
						Files.deleteIfExists( destination );
						destination = null;

				}
				catch ( IOException e )
				{
						e.printStackTrace();
				}
		}
}
