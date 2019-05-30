package ch.fhnw.chargingstationsfx.presentationmodel;

import ch.fhnw.chargingstationsfx.data.csv.importer.CSVChargingStationImporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ChargingStationsPresentationModelTest
{

		private ChargingStationsPresentationModel csPm;


		@BeforeEach
		public void setUp ()
		{
				Path source = Paths.get( "src", "test", "resources", "data", "CHARGING_STATION.csv" );
				List<ChargingStation> chargingStations = CSVChargingStationImporter.getInstance().parse( source, ';' );
				csPm = new ChargingStationsPresentationModel( chargingStations );
		}


		@Test
		public void testGenerateUniqueEnitityId ()
		{
				//given
				int maxEntityId = csPm.getChargingStations().stream().mapToInt( cs -> cs.entityIdProperty().get() ).max().getAsInt();

				//when
				int generatedUniqueEntity = csPm.generateUniqueEnitityId();

				//then
				assertTrue( generatedUniqueEntity > maxEntityId );

				//when
				csPm.addNewChargingStation();
				int generatedUniqueEntity2 = csPm.generateUniqueEnitityId();

				//then
				assertTrue( generatedUniqueEntity2 > generatedUniqueEntity );

				//when
				csPm.delete( generatedUniqueEntity2 );
				int generatedUniqueEntity3 = csPm.generateUniqueEnitityId();

				//then
				assertTrue( generatedUniqueEntity3 == generatedUniqueEntity2 );
		}

		@Test
		public void testDelete ()
		{
				//given
				int maxEntityId = csPm.getChargingStations().stream().mapToInt( cs -> cs.entityIdProperty().get() ).max().getAsInt();
				int initialSize = csPm.getChargingStations().size();

				//then
				assertTrue( csPm.delete( maxEntityId ) );
				assertTrue( csPm.getChargingStations().size() < initialSize );

				//then
				assertFalse( csPm.delete( maxEntityId ) );
				assertTrue( csPm.getChargingStations().size() == initialSize - 1 );

				//then
				assertFalse( csPm.delete( -1 ) );
				assertTrue( csPm.getChargingStations().size() == initialSize - 1 );

				//given
				List<Integer> allEntities = csPm.getChargingStations().stream().map( cs -> cs.entityIdProperty().get() ).collect( Collectors.toList() );

				//then
				allEntities.forEach( id -> assertTrue( csPm.delete( id ) ) );
				assertTrue( csPm.getChargingStations().size() == 0 );
		}


		@Test
		public void testAddNewChargingStation ()
		{
				//given
				int initialSize = csPm.getChargingStations().size();
				int maxEntityId = csPm.getChargingStations().stream().mapToInt( cs -> cs.entityIdProperty().get() ).max().getAsInt();

				//then

				for( int i = 0; i < 10; i++ )
				{
						assertTrue( csPm.addNewChargingStation() );
				}
				assertTrue( csPm.getChargingStations().size() - initialSize == 10 );
				assertTrue( csPm.generateUniqueEnitityId() > maxEntityId );
		}


		@Test
		public void testGetChargingStation ()
		{
				//given
				int maxEntityId = csPm.getChargingStations().stream().mapToInt( cs -> cs.entityIdProperty().get() ).max().getAsInt();

				//then
				assertTrue( csPm.getChargingStation( maxEntityId ) != null );
				assertTrue( csPm.getChargingStation( maxEntityId + 1 ) == null );
				assertTrue( csPm.getChargingStation( -1 ) == null );
		}


		@Test
		public void testContainsInformation ()
		{
				//given
				String criteria = "bob";
				String wrongCriteria = "bernd";

				String property = "Am Bobersberg";

				assertTrue( csPm.containsInformation( criteria, property ) );
				assertFalse( csPm.containsInformation( wrongCriteria, property ) );
				assertTrue( csPm.containsInformation( "", property ) );
				assertThrows( NullPointerException.class, () -> csPm.containsInformation( null, property ) );
				assertThrows( NullPointerException.class, () -> csPm.containsInformation( criteria, null ) );
				assertThrows( NullPointerException.class, () -> csPm.containsInformation( null, null ) );
		}


		@AfterEach
		public void tearDown ()
		{
				csPm = null;
		}
}