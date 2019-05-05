package ch.fhnw.chargingstationsfx.data.csv.exporter;

import ch.fhnw.chargingstationsfx.data.csv.ChargingStation;
import ch.fhnw.chargingstationsfx.data.interfaces.exporter.IChargingStationExporter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CSVChargingStationExporter implements IChargingStationExporter
{
		private Logger logger = LogManager.getLogger( CSVChargingStationExporter.class );

		@Override
		public boolean export ( Path destination, List<ChargingStation> data, char delimiter )
		{
				if( !(data == null || data.isEmpty()) )
				{
						logger.info( "Trying to write {} chargingstations to destination {} with delimiter {}", data.size(), destination.toUri(), delimiter );

						try ( Writer writer = Files.newBufferedWriter( destination ) )
						{
								StatefulBeanToCsv<ChargingStation> beanToCsv = new StatefulBeanToCsvBuilder( writer )
												.withSeparator( delimiter )
												.build();
								beanToCsv.write( data );
						}
						catch ( Exception e )
						{
								logger.error( "Error while trying to write data to " + destination.toUri(), e );
								return false;
						}
						return true;
				}
				logger.warn( "There's nothing to read and nothing to write to. Check your params!" );

				return false;
		}
}