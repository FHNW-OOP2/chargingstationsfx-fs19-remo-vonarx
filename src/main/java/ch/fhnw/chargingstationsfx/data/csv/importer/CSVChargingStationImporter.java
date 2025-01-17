package ch.fhnw.chargingstationsfx.data.csv.importer;

import ch.fhnw.chargingstationsfx.data.interfaces.importer.IChargingStationImporter;
import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStation;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVChargingStationImporter implements IChargingStationImporter
{
		private static final CSVChargingStationImporter instance = new CSVChargingStationImporter();
		private Logger logger = LogManager.getLogger( CSVChargingStationImporter.class );

		public static CSVChargingStationImporter getInstance () { return instance; }

		@Override
		public List<ChargingStation> parse ( Path source, char delimiter )
		{
				List<ChargingStation> chargingStations = new ArrayList<>();
				try
				{
						logger.info( "parsing now, with source {} and delimiter {}", source.toUri(), delimiter );
						List<ChargingStation> parsedChargingStations = new CsvToBeanBuilder<ChargingStation>( Files.newBufferedReader( source ) )
										.withType( ChargingStation.class ).withSeparator( delimiter ).build().parse();
						chargingStations.addAll( parsedChargingStations );
				}
				catch ( Exception e )
				{
						logger.error( "exception while parsing", e );
				}
				return chargingStations;
		}
}
