package ch.fhnw.chargingstationsfx.view.split.detailview.header;

import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStation;
import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationsPresentationModel;
import ch.fhnw.chargingstationsfx.view.ViewMixin;
import ch.fhnw.chargingstationsfx.view.map.GeoPositionView;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static javafx.scene.layout.Priority.*;

public class CsDetailHeaderPane extends GridPane implements ViewMixin
{
		private ChargingStationsPresentationModel csPM;

		private Label lblLoaderType;
		private Label lblAddress;
		private Label lblZipCity;
		private Label lblChargingPoints;
		private Label lblPowerKWConnectionPowerKW;
		private GeoPositionView map;
		private Label lblIntro;

		public CsDetailHeaderPane ( ChargingStationsPresentationModel csPM )
		{
				this.csPM = csPM;
				init();
		}

		@Override
		public void initializeControls ()
		{
				lblLoaderType = new Label();
				lblAddress = new Label();
				lblZipCity = new Label();
				lblChargingPoints = new Label();
				lblPowerKWConnectionPowerKW = new Label();
				map = new GeoPositionView();
				lblIntro = new Label( "Please choose a charging station!" );
		}

		@Override
		public void layoutControls ()
		{
				lblLoaderType.getStyleClass().add( "lbl-loadertype" );
				lblIntro.getStyleClass().add( "lbl-intro" );
				this.getStyleClass().add( "cs-detailheader" );

				ColumnConstraints ccg = new ColumnConstraints();
				ccg.setHgrow( ALWAYS );

				ColumnConstraints ccs = new ColumnConstraints();
				ccg.setHgrow( SOMETIMES );

				ColumnConstraints ccn = new ColumnConstraints();
				ccn.setHgrow( NEVER );

				RowConstraints rcg = new RowConstraints();
				rcg.setVgrow( ALWAYS );

				RowConstraints rcn = new RowConstraints();
				rcn.setVgrow( NEVER );

				getColumnConstraints().addAll( ccg, ccn, ccg );
				getRowConstraints().addAll( rcn, rcn, rcn, rcn, rcn, rcn, rcg );

				this.add( lblLoaderType, 0, 0 );
				this.add( lblAddress, 0, 1 );
				this.add( lblZipCity, 0, 2 );
				this.add( lblChargingPoints, 0, 3 );
				this.add( lblPowerKWConnectionPowerKW, 0, 4 );
				this.add( map, 2, 0, 2, 6 );
				this.add( lblIntro, 0, 0, 3, 6 );
		}

		@Override
		public void setupBindings ()
		{
				getChildren().forEach( e -> e.visibleProperty().bind( csPM.selectedEntityId().greaterThan( 0 ) ) );
				bindValues( csPM.getChargingStationProxy() );
				lblIntro.visibleProperty().bind( csPM.selectedEntityId().lessThan( 0 ) );
		}

		private void bindValues ( ChargingStation chargingStation )
		{
				lblLoaderType.textProperty().bind( chargingStation.loaderTypeProperty() );
				lblAddress.textProperty().bind( chargingStation.addressProperty() );
				lblZipCity.textProperty().bind( chargingStation.zipCodeProperty().concat( " " ).concat( chargingStation.cityProperty() ) );
				lblChargingPoints.textProperty().bind( chargingStation.chargingPointsProperty().asString().concat( " Charging point(s)" ) );
				lblPowerKWConnectionPowerKW.textProperty().bind( chargingStation.getConnectionPowerKWBinding().asString( "%.2f kW" ) );
				map.latitudeProperty().bindBidirectional( chargingStation.latitudeProperty() );
				map.longitudeProperty().bindBidirectional( chargingStation.longitudeProperty() );
		}
}