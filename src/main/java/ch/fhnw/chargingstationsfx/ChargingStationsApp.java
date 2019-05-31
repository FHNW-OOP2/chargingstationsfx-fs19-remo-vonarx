package ch.fhnw.chargingstationsfx;

import ch.fhnw.chargingstationsfx.data.csv.importer.CSVChargingStationImporter;
import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStation;
import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationsPresentationModel;
import ch.fhnw.chargingstationsfx.view.RootPanel;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ChargingStationsApp extends Application
{
		public static final Path SOURCE = Paths.get( "src", "main", "resources", "data", "CHARGING_STATION.csv" );
		public static final Path SOURCE_BACKUP = Paths.get( "src", "main", "resources", "data", "bak", "CHARGING_STATION.csv" );

		public static final String DATE_FORMAT = "dd.MM.yy";
		public static final char DEFAULT_DELIMITER = ';';

		private static final Logger logger = LogManager.getLogger( ChargingStationsApp.class );

		private List<ChargingStation> chargingStations;

		public static void main ( String[] args )
		{
				launch( args );
		}

		@Override
		public void init ()
		{
				chargingStations = CSVChargingStationImporter.getInstance().parse( SOURCE, DEFAULT_DELIMITER );
				logger.info( "fetched " + chargingStations.size() + " charging stations out of " + SOURCE.toUri() );
		}

		@Override
		public void start ( Stage primaryStage )
		{
				ChargingStationsPresentationModel csPM = new ChargingStationsPresentationModel( chargingStations );

				Parent rootPanel = new RootPanel( csPM );
				Scene scene = new Scene( rootPanel );

				primaryStage.titleProperty().set( "Charging Station Manager" );
				primaryStage.setScene( scene );

				primaryStage.show();
		}
}