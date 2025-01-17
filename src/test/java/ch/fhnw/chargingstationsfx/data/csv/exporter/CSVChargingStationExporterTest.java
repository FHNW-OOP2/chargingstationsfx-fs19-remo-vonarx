package ch.fhnw.chargingstationsfx.data.csv.exporter;

import ch.fhnw.chargingstationsfx.data.csv.importer.CSVChargingStationImporter;
import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStation;
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

public class CSVChargingStationExporterTest
{
		private Path source;
		private Path destination;
		private Path backup;
		private CSVChargingStationExporter exporter;
		private CSVChargingStationImporter importer;
		private List<ChargingStation> chargingStations;

		@BeforeEach
		public void setUp ()
		{
				importer = CSVChargingStationImporter.getInstance();
				exporter = CSVChargingStationExporter.getInstance();

				source = Paths.get( "src", "test", "resources", "data", "CHARGING_STATION.csv" );
				destination = Paths.get( "src", "test", "resources", "data", "CHARGING_STATION_out.csv" );
				backup = Paths.get( "src", "test", "resources", "data", "bak", "CHARGING_STATION_out.csv" );
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
				//then
				assertFalse( exporter.export( destination, backup, null, ';' ) );
				assertFalse( Files.exists( destination ) );
				assertFalse( exporter.export( null, null, null, ';' ) );
				assertFalse( Files.exists( destination ) );
				assertFalse( exporter.export( destination, backup, Collections.emptyList(), ';' ) );
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
				exporter.export( destination, backup, chargingStations, ';' );
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
						Files.deleteIfExists( backup );

						destination = null;
						backup = null;

				}
				catch ( IOException e )
				{
						fail( e.getMessage() );
				}
		}
}