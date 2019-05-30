package ch.fhnw.chargingstationsfx.view.split.detailview.header;

import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStation;
import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationsPresentationModel;
import ch.fhnw.chargingstationsfx.view.ViewMixin;
import ch.fhnw.chargingstationsfx.view.map.GeoPositionView;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static javafx.scene.layout.Priority.ALWAYS;
import static javafx.scene.layout.Priority.NEVER;

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
				lblIntro.getStyleClass().add( "lbl-title" );
		}

		@Override
		public void layoutControls ()
		{
				ColumnConstraints ccg = new ColumnConstraints();
				ccg.setHgrow( ALWAYS );

				ColumnConstraints ccn = new ColumnConstraints();
				ccg.setHgrow( NEVER );

				RowConstraints rcg = new RowConstraints();
				rcg.setVgrow( ALWAYS );

				RowConstraints rcn = new RowConstraints();
				rcn.setVgrow( NEVER );

				this.setMaxWidth( Double.MAX_VALUE );

				getColumnConstraints().addAll( ccg, ccg );
				getRowConstraints().addAll( rcg, rcg, rcg, rcg, rcg );

				this.add( lblLoaderType, 1, 1, 5, 5 );
				this.add( lblAddress, 1, 2 );
				this.add( lblZipCity, 1, 3 );
				this.add( lblChargingPoints, 1, 4 );
				this.add( lblPowerKWConnectionPowerKW, 1, 5 );
				this.add( map, 2, 1, 1, 5 );
				this.add( lblIntro, 0, 0, 8, 8 );

				GridPane.setFillWidth( this, true );
				this.setGridLinesVisible( true );
		}

		@Override
		public void setupBindings ()
		{
				getChildren().forEach( e -> e.visibleProperty().bind( csPM.selectedEntityId().greaterThan( 0 ) ) );
				lblIntro.visibleProperty().unbind();
				lblIntro.visibleProperty().bind( csPM.selectedEntityId().lessThan( 0 ) );

				bindValues( csPM.getChargingStationProxy() );
		}


		private void bindValues ( ChargingStation chargingStation )
		{
				lblLoaderType.textProperty().bind( chargingStation.loaderTypeProperty() );
				lblAddress.textProperty().bind( chargingStation.addressProperty() );
				lblZipCity.textProperty().bind( chargingStation.zipCodeProperty().concat( " " ).concat( chargingStation.cityProperty() ) );
				lblChargingPoints.textProperty().bind( chargingStation.chargingPointsProperty().asString().concat( " Ladepunkte" ) );
				lblPowerKWConnectionPowerKW.textProperty().bind( chargingStation.getConnectionPowerKWBinding().asString( "%.2f kW" ) );
				map.latitudeProperty().bindBidirectional( chargingStation.latitudeProperty() );
				map.longitudeProperty().bindBidirectional( chargingStation.longitudeProperty() );
		}
}