package ch.fhnw.chargingstationsfx.data.csv.importer;

import ch.fhnw.chargingstationsfx.data.csv.ChargingStation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestCSVChargingStationImporter
{
		private CSVChargingStationImporter importer;
		private Path source;

		@BeforeEach
		public void setUp ()
		{
				this.importer = new CSVChargingStationImporter();
				this.source = Paths.get("src", "test", "resources", "data", "CHARGING_STATION.csv");
		}

		public void checkSource ()
		{
				if( !Files.exists(this.source) )
				{
						fail("Mandatory source file not existing.");
				}
		}

		@Test
		public void parseItems ()
		{
				//given
				checkSource();

				//when
				assertEquals(0, this.importer.parse(this.source, '.').size());
				assertEquals(0, this.importer.parse(this.source, ' ').size());
				assertEquals(0, this.importer.parse(null, ';').size());
				assertEquals(0, this.importer.parse(null, ' ').size());
				assertEquals(6954, this.importer.parse(this.source, ';').size());
		}

		@Test
		public void parseAndValidateChargingStation ()
		{
				//given
				checkSource();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");

				//then
				List<ChargingStation> chargingStations = this.importer.parse(this.source, ';');

				//when
				chargingStations.forEach(station -> assertNotNull(station.getEntityId()));
				chargingStations.forEach(station -> assertNotNull(station.getOperatingCompany()));
				chargingStations.forEach(station -> assertNotNull(station.getAddress()));
				chargingStations.forEach(station -> assertDoesNotThrow(() -> formatter.parse(station.getStartupDate().toString())));
		}


		@AfterEach
		public void tearDown ()
		{
				this.importer = null;
				this.source = null;
		}
}