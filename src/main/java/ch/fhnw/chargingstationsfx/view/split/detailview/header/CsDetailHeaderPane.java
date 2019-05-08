package ch.fhnw.chargingstationsfx.view.split.detailview.header;

import ch.fhnw.chargingstationsfx.view.ViewMixin;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static javafx.scene.layout.Priority.ALWAYS;
import static javafx.scene.layout.Priority.NEVER;

public class CsDetailHeaderPane extends GridPane implements ViewMixin
{
		private Label lblType;
		private Label lblAddress;
		private Label lblZip;
		private Label lblPlace;
		private Label lblChargingPoints;
		private Label lblPowerKWConnectionPowerKW;
		private Label lblMaps;

		public CsDetailHeaderPane ()
		{
				init();
		}

		@Override
		public void initializeControls ()
		{
				lblType = new Label( "Schnellladeeinrichtung" );
				lblAddress = new Label( "Lennénstrasse 1" );
				lblZip = new Label( "1069" );
				lblPlace = new Label( "Dresden" );
				lblChargingPoints = new Label( "2 Ladepunkte" );
				lblPowerKWConnectionPowerKW = new Label( "93.0 kW" );
				lblMaps = new Label( "Maps here" );
		}
		@Override
		public void layoutControls ()
		{
				this.getStyleClass().add( "cs-detailheaderpane" );

				ColumnConstraints ccg = new ColumnConstraints();
				ccg.setHgrow( ALWAYS );

				ColumnConstraints ccn = new ColumnConstraints();
				ccg.setHgrow( NEVER );

				RowConstraints rcg = new RowConstraints();
				rcg.setVgrow( ALWAYS );

				RowConstraints rcn = new RowConstraints();
				rcn.setVgrow( NEVER );

				getColumnConstraints().addAll( ccg, ccn, ccg, ccn, ccg );
				getRowConstraints().addAll( rcg, rcn, rcg, rcn, rcg, rcn, rcg, rcn, rcg, rcn );

				this.add( lblType, 0, 0, 5, 1 );
				this.add( lblAddress, 0, 2 );
				this.add( lblZip, 0, 4 );
				this.add( lblPlace, 3, 4 );
				this.add( lblChargingPoints, 0, 6 );
				this.add( lblPowerKWConnectionPowerKW, 0, 8 );

				this.add( lblMaps, 5, 0, 1, 8 );
		}
}
