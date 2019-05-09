package ch.fhnw.chargingstationsfx;

import ch.fhnw.chargingstationsfx.data.csv.ChargingStation;
import ch.fhnw.chargingstationsfx.data.csv.importer.CSVChargingStationImporter;
import ch.fhnw.chargingstationsfx.data.interfaces.importer.IChargingStationImporter;
import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationPresentationModel;
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

		private static Logger logger = LogManager.getLogger( ChargingStationsApp.class );
		private List<ChargingStation> chargingStations;

		public static void main ( String[] args )
		{
				launch( args );
		}

		@Override
		public void start ( Stage primaryStage )
		{
				ChargingStationPresentationModel csPM = new ChargingStationPresentationModel( chargingStations );
				Parent rootPanel = new RootPanel( csPM );

				Scene scene = new Scene( rootPanel );

				primaryStage.titleProperty().bind( csPM.applicationTitleProperty() );
				primaryStage.setScene( scene );

				primaryStage.show();
		}

		@Override
		public void init () throws Exception
		{
				IChargingStationImporter importer = new CSVChargingStationImporter();
				chargingStations = importer.parse( SOURCE, ';' );

				logger.info( "fetched " + chargingStations.size() + " charging stations out of " + SOURCE.toUri() );
		}
}
