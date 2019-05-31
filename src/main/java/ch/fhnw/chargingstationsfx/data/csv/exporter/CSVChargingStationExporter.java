package ch.fhnw.chargingstationsfx.data.csv.exporter;

import ch.fhnw.chargingstationsfx.data.interfaces.exporter.IChargingStationExporter;
import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStation;
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
		private static final CSVChargingStationExporter instance = new CSVChargingStationExporter();
		private Logger logger = LogManager.getLogger( CSVChargingStationExporter.class );

		private CSVChargingStationExporter () {}
		public static CSVChargingStationExporter getInstance () { return instance; }

		@Override
		public boolean export ( Path destination, Path backup, List<ChargingStation> data, char delimiter )
		{
				if( !(data == null || data.isEmpty()) )
				{
						logger.info( "Trying to write {} chargingstations to destination {} with delimiter {}", data.size(), destination.toUri(), delimiter );

						try ( Writer writer = Files.newBufferedWriter( destination ) )
						{
								StatefulBeanToCsv<ChargingStation> beanToCsv = new StatefulBeanToCsvBuilder<ChargingStation>( writer )
												.withSeparator( delimiter )
												.withApplyQuotesToAll( false )
												.build();
								beanToCsv.write( data );
								logger.info( "Success saving {} items!", data.size() );
						}
						catch ( Exception e )
						{
								logger.error( "Error while trying to write data to " + destination.toUri(), e );
								Path path = restoreBackup( backup, destination );
								if( path != null )
								{
										logger.info( "Restored backup!" );
								}
								return false;
						}
						return true;
				}
				logger.warn( "There's nothing to read and nothing to write to. Check your params!" );

				return false;
		}

		@Override
		public Path restoreBackup ( Path backup, Path destination )
		{
				try
				{
						logger.info( "Trying to restore backup from {0}", backup.toUri() );
						return Files.copy( backup, destination );
				}
				catch ( Exception e )
				{
						logger.error( "Not being able to restore backup from {0}", backup.toUri(), e );
				}
				return null;
		}
}