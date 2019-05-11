package ch.fhnw.chargingstationsfx.presentationmodel;

import ch.fhnw.chargingstationsfx.data.csv.ChargingStation;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ChargingStationPresentationModel
{
		//private static Logger logger = LogManager.getLogger( ChargingStationsApp.class );

		private final StringProperty applicationTitle = new SimpleStringProperty( "ChargingStationsFX" );
		//private final StringProperty greeting = new SimpleStringProperty( "Hello World!" );
		private ObservableList<ChargingStation> chargingStations = FXCollections.observableArrayList();

		private ObjectProperty<ChargingStation> chargingStationProperty = new SimpleObjectProperty<>();

		public ChargingStationPresentationModel ( List<ChargingStation> chargingStations )
		{
				this.chargingStations.addAll( chargingStations );
				this.setChargingStation( new ChargingStation() );
		}

		/*public String getApplicationTitle ()
		{
				return applicationTitle.get();
		}*/

		/*public void setApplicationTitle ( String applicationTitle )
		{
				this.applicationTitle.set( applicationTitle );
		}*/

		public StringProperty applicationTitleProperty ()
		{
				return applicationTitle;
		}

		public ObservableList<ChargingStation> getChargingStations ()
		{
				return chargingStations;
		}

		public Property<ChargingStation> chargingStationProperty ()
		{
				return chargingStationProperty;
		}

		public void setChargingStation ( ChargingStation chargingStation )
		{
				if( chargingStation != null )
				{
						chargingStationProperty.setValue( chargingStation );
				}
		}
}
