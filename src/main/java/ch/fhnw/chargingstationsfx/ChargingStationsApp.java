package ch.fhnw.chargingstationsfx;

import ch.fhnw.chargingstationsfx.data.csv.ChargingStation;
import ch.fhnw.chargingstationsfx.data.csv.importer.CSVChargingStationImporter;
import ch.fhnw.chargingstationsfx.data.interfaces.importer.IChargingStationImporter;
import ch.fhnw.chargingstationsfx.presentationmodel.RootPM;
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
		private static Logger logger = LogManager.getLogger( ChargingStationsApp.class );
		private List<ChargingStation> chargingStations;

		public static void main ( String[] args )
		{
				launch( args );
		}

		@Override
		public void start ( Stage primaryStage )
		{
				RootPM rootPM = new RootPM();
				Parent rootPanel = new RootPanel( rootPM );

				Scene scene = new Scene( rootPanel );

				primaryStage.titleProperty().bind( rootPM.applicationTitleProperty() );
				primaryStage.setScene( scene );

				primaryStage.show();
		}
		@Override
		public void init () throws Exception
		{
				IChargingStationImporter importer = new CSVChargingStationImporter();

				Path source = Paths.get( "src", "main", "resources", "data", "CHARGING_STATION.csv" );
				chargingStations = importer.parse( source, ';' );

				logger.info( "fetched " + chargingStations.size() + " charging stations out of " + source.toUri() );
		}

}
