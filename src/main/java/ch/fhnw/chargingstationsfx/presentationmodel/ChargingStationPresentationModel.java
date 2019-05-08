package ch.fhnw.chargingstationsfx.presentationmodel;

import ch.fhnw.chargingstationsfx.ChargingStationsApp;
import ch.fhnw.chargingstationsfx.data.csv.ChargingStation;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ChargingStationPresentationModel
{
		private static Logger logger = LogManager.getLogger( ChargingStationsApp.class );

		private final StringProperty applicationTitle = new SimpleStringProperty( "ChargingStationsFX" );
		private final StringProperty greeting = new SimpleStringProperty( "Hello World!" );
		private final ObservableList<ChargingStation> chargingStations = FXCollections.observableArrayList();


		public ChargingStationPresentationModel ( List<ChargingStation> chargingStations )
		{
				this.chargingStations.addAll( chargingStations );
		}

		// all getters and setters
		public String getApplicationTitle ()
		{
				return applicationTitle.get();
		}
		public void setApplicationTitle ( String applicationTitle )
		{
				this.applicationTitle.set( applicationTitle );
		}
		public StringProperty applicationTitleProperty ()
		{
				return applicationTitle;
		}

		public ObservableList<ChargingStation> getChargingStations ()
		{
				return chargingStations;
		}
}
