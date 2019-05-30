package ch.fhnw.chargingstationsfx.presentationmodel;

import ch.fhnw.chargingstationsfx.ChargingStationsApp;
import ch.fhnw.chargingstationsfx.data.csv.exporter.CSVChargingStationExporter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Predicate;

import static ch.fhnw.chargingstationsfx.ChargingStationsApp.*;

public class ChargingStationsPresentationModel
{
		private static Logger logger = LogManager.getLogger( ChargingStationsApp.class );

		private final IntegerProperty selectedEntityId = new SimpleIntegerProperty( -1 );
		private ObservableList<ChargingStation> allChargingStations = FXCollections.observableArrayList();
		private FilteredList<ChargingStation> filteredChargingStations;
		private ChargingStation proxy = new ChargingStation( -1 );

		public ChargingStationsPresentationModel ( List<ChargingStation> chargingStations )
		{
				allChargingStations.addAll( chargingStations );
				filteredChargingStations = new FilteredList<>( allChargingStations );

				selectedEntityId.addListener( ( observable, oldValue, newValue ) ->
								{
										ChargingStation oldChargingStation = getChargingStation( oldValue.intValue() );
										ChargingStation newChargingStation = getChargingStation( newValue.intValue() );

										if( oldChargingStation != null )
										{
												proxy.entityIdProperty().unbindBidirectional( oldChargingStation.entityIdProperty() );
												proxy.addressProperty().unbindBidirectional( oldChargingStation.addressProperty() );
												proxy.cityProperty().unbindBidirectional( oldChargingStation.cityProperty() );
												proxy.zipCodeProperty().unbindBidirectional( oldChargingStation.zipCodeProperty() );
												proxy.operatingCompanyProperty().unbindBidirectional( oldChargingStation.operatingCompanyProperty() );
												proxy.longitudeProperty().unbindBidirectional( oldChargingStation.longitudeProperty() );
												proxy.latitudeProperty().unbindBidirectional( oldChargingStation.latitudeProperty() );
												proxy.startupDateProperty().unbindBidirectional( oldChargingStation.startupDateProperty() );
												proxy.loaderTypeProperty().unbindBidirectional( oldChargingStation.loaderTypeProperty() );
												proxy.chargingPointsProperty().unbindBidirectional( oldChargingStation.chargingPointsProperty() );
												proxy.power1KwProperty().unbindBidirectional( oldChargingStation.power1KwProperty() );
												proxy.power2KwProperty().unbindBidirectional( oldChargingStation.power2KwProperty() );
												proxy.power3KwProperty().unbindBidirectional( oldChargingStation.power3KwProperty() );
												proxy.power4KwProperty().unbindBidirectional( oldChargingStation.power4KwProperty() );
												proxy.plugTypes1Property().unbindBidirectional( oldChargingStation.plugTypes1Property() );
												proxy.plugTypes2Property().unbindBidirectional( oldChargingStation.plugTypes2Property() );
												proxy.plugTypes3Property().unbindBidirectional( oldChargingStation.plugTypes3Property() );
												proxy.plugTypes4Property().unbindBidirectional( oldChargingStation.plugTypes4Property() );
										}

										if( newChargingStation != null )
										{
												proxy.entityIdProperty().bindBidirectional( newChargingStation.entityIdProperty() );
												proxy.addressProperty().bindBidirectional( newChargingStation.addressProperty() );
												proxy.cityProperty().bindBidirectional( newChargingStation.cityProperty() );
												proxy.zipCodeProperty().bindBidirectional( newChargingStation.zipCodeProperty() );
												proxy.operatingCompanyProperty().bindBidirectional( newChargingStation.operatingCompanyProperty() );
												proxy.longitudeProperty().bindBidirectional( newChargingStation.longitudeProperty() );
												proxy.latitudeProperty().bindBidirectional( newChargingStation.latitudeProperty() );
												proxy.startupDateProperty().bindBidirectional( newChargingStation.startupDateProperty() );
												proxy.loaderTypeProperty().bindBidirectional( newChargingStation.loaderTypeProperty() );
												proxy.chargingPointsProperty().bindBidirectional( newChargingStation.chargingPointsProperty() );
												proxy.power1KwProperty().bindBidirectional( newChargingStation.power1KwProperty() );
												proxy.power2KwProperty().bindBidirectional( newChargingStation.power2KwProperty() );
												proxy.power3KwProperty().bindBidirectional( newChargingStation.power3KwProperty() );
												proxy.power4KwProperty().bindBidirectional( newChargingStation.power4KwProperty() );
												proxy.plugTypes1Property().bindBidirectional( newChargingStation.plugTypes1Property() );
												proxy.plugTypes2Property().bindBidirectional( newChargingStation.plugTypes2Property() );
												proxy.plugTypes3Property().bindBidirectional( newChargingStation.plugTypes3Property() );
												proxy.plugTypes4Property().bindBidirectional( newChargingStation.plugTypes4Property() );
										}
								}
				);
		}

		public ObservableList<ChargingStation> getChargingStations ()
		{
				return filteredChargingStations;
		}

		public ChargingStation getChargingStationProxy ()
		{
				return proxy;
		}

		public ChargingStation getChargingStation ( int entityId ) { return allChargingStations.stream().filter( cs -> cs.entityIdProperty().get() == entityId ).findFirst().orElse( null ); }

		public IntegerProperty selectedEntityId () { return selectedEntityId; }

		public void setSelectedEntityId ( int entityId ) { selectedEntityId.set( entityId ); }

		public int generateUniqueEnitityId () { return allChargingStations.stream().mapToInt( cs -> cs.entityIdProperty().get() ).max().getAsInt() + 1; }

		public boolean save ()
		{
				logger.info( "Saving all current charging station..." );
				return CSVChargingStationExporter.getInstance().export( SOURCE, SOURCE_BACKUP, allChargingStations, DEFAULT_DELIMITER );
		}

		public boolean delete ( int entityId )
		{
				logger.info( "Trying to delete charging station with id: {0} ", entityId );
				return allChargingStations.removeIf( cs -> cs.entityIdProperty().get() == entityId );
		}

		public boolean addNewChargingStation ()
		{
				int entityId = generateUniqueEnitityId();
				logger.info( "Adding new charging station with id: {0} ", entityId );
				return allChargingStations.add( new ChargingStation( entityId ) );
		}

		public void filter ( String criteria )
		{
				if( !criteria.isEmpty() )
				{
						Predicate<ChargingStation> addressPredicate = chargingStation -> containsInformation( criteria, chargingStation.addressProperty().getValueSafe() );
						Predicate<ChargingStation> cityPredicate = chargingStation -> containsInformation( criteria, chargingStation.cityProperty().getValueSafe() );
						Predicate<ChargingStation> zipPredicate = chargingStation -> containsInformation( criteria, chargingStation.zipCodeProperty().getValueSafe() );
						Predicate<ChargingStation> operatorPredicate = chargingStation -> containsInformation( criteria, chargingStation.operatingCompanyProperty().getValueSafe() );
						Predicate<ChargingStation> chargingPointsPredicate = chargingStation -> containsInformation( criteria, chargingStation.chargingPointsProperty().asString().getValueSafe() );

						filteredChargingStations.setPredicate( addressPredicate.or( cityPredicate ).or( operatorPredicate ).or( zipPredicate ).or( chargingPointsPredicate ) );
				}
				else
				{
						logger.debug( "No criteria found, resetting predicates" );
						filteredChargingStations.setPredicate( null );
				}
		}

		public boolean containsInformation ( String criteria, String property )
		{
				return property.toLowerCase().contains( criteria );
		}
}