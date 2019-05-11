package ch.fhnw.chargingstationsfx.view.split.detailview.editor;

import ch.fhnw.chargingstationsfx.view.ViewMixin;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static javafx.scene.layout.Priority.ALWAYS;
import static javafx.scene.layout.Priority.NEVER;

public class CsEditorPane extends GridPane implements ViewMixin
{
		private Label lblAddress;
		private Label lblZip;
		private Label lblCity;
		private Label lblChargingPoints;
		private Label lblConnectionPowerKW;
		private Label lblEntityId;
		private Label lblOperatingCompany;
		private Label lblLongitude;
		private Label lblLatitude;
		private Label lblStartupDate;
		private Label lblLoaderType;
		private Label lblPower1KW;
		private Label lblPower2KW;
		private Label lblPower3KW;
		private Label lblPower4KW;
		private Label lblPlugTypes1;
		private Label lblPlugTypes2;
		private Label lblPlugTypes3;
		private Label lblPlugTypes4;

		private TextField txtfAddress;
		private TextField txtfZip;
		private TextField txtfCity;
		private TextField txtfChargingPoints;
		private TextField txtfConnectionPowerKW;
		private TextField txtfEntityId;
		private TextField txtfOperatingCompany;
		private TextField txtfLongitude;
		private TextField txtfLatitude;
		private TextField txtfStartupDate;
		private TextField txtfLoaderType;
		private TextField txtfPower1KW;
		private TextField txtfPower2KW;
		private TextField txtfPower3KW;
		private TextField txtfPower4KW;
		private TextField txtfPlugTypes1;
		private TextField txtfPlugTypes2;
		private TextField txtfPlugTypes3;
		private TextField txtfPlugTypes4;

		public CsEditorPane ()
		{
				init();
		}

		@Override
		public void initializeControls ()
		{
				lblEntityId = new Label( "Entitäts-Nummer" );
				lblAddress = new Label( "Strasse" );
				lblZip = new Label( "PLZ" );
				lblCity = new Label( "Ort" );
				lblChargingPoints = new Label( "Anzahl Ladepunkte" );
				lblConnectionPowerKW = new Label( "Anschlussleistung" );
				lblEntityId = new Label( "Entitäts-ID" );
				lblOperatingCompany = new Label( "Betreiber" );
				lblLongitude = new Label( "Längengrad" );
				lblLatitude = new Label( "Breitengrad" );
				lblStartupDate = new Label( "Inbetriebnahme" );
				lblLoaderType = new Label( "Ladungstyp" );
				lblPower1KW = new Label( "Leistung Anschluss 1 [kW]" );
				lblPower2KW = new Label( "Leistung Anschluss 2 [kW]" );
				lblPower3KW = new Label( "Leistung Anschluss 3 [kW]" );
				lblPower4KW = new Label( "Leistung Anschluss 4 [kW]" );
				lblPlugTypes1 = new Label( "Anschlusstyp 1" );
				lblPlugTypes2 = new Label( "Anschlusstyp 2" );
				lblPlugTypes3 = new Label( "Anschlusstyp 3" );
				lblPlugTypes4 = new Label( "Anschlusstyp 4" );

				txtfEntityId = new TextField( "Entität" );
				txtfAddress = new TextField( "Strasse" );
				txtfZip = new TextField( "PLZ" );
				txtfCity = new TextField( "Ort" );
				txtfChargingPoints = new TextField( "Anzahl Ladepunkte" );
				txtfConnectionPowerKW = new TextField( "Anschlussleistung" );
				txtfEntityId = new TextField( "Entitäts-ID" );
				txtfOperatingCompany = new TextField( "Betreiber" );
				txtfLongitude = new TextField( "Längengrad" );
				txtfLatitude = new TextField( "Breitengrad" );
				txtfStartupDate = new TextField( "Inbetriebnahme" );
				txtfLoaderType = new TextField( "Ladungstyp" );
				txtfPower1KW = new TextField( "Leistung Anschluss 1 [kW]" );
				txtfPower2KW = new TextField( "Leistung Anschluss 2 [kW]" );
				txtfPower3KW = new TextField( "Leistung Anschluss 3 [kW]" );
				txtfPower4KW = new TextField( "Leistung Anschluss 4 [kW]" );
				txtfPlugTypes1 = new TextField( "Anschlusstyp 1" );
				txtfPlugTypes2 = new TextField( "Anschlusstyp 2" );
				txtfPlugTypes3 = new TextField( "Anschlusstyp 3" );
				txtfPlugTypes4 = new TextField( "Anschlusstyp 4" );
		}

		@Override
		public void layoutControls ()
		{
				this.getStyleClass().add( "cs-editorpane" );

				ColumnConstraints ccg = new ColumnConstraints();
				ccg.setHgrow( ALWAYS );

				ColumnConstraints ccn = new ColumnConstraints();
				ccg.setHgrow( NEVER );

				RowConstraints rcg = new RowConstraints();
				rcg.setVgrow( ALWAYS );

				RowConstraints rcn = new RowConstraints();
				rcn.setVgrow( NEVER );

				getColumnConstraints().addAll( ccg, ccg, ccn, ccg, ccg );
				getRowConstraints().addAll( rcg, rcn, rcg, rcn, rcg, rcn, rcg, rcn, rcg, rcn, rcg, rcn, rcg, rcn, rcg, rcn, rcg, rcn );

				this.add( lblOperatingCompany, 0, 0 );
				this.add( txtfOperatingCompany, 2, 0 );
				this.add( lblEntityId, 2, 0 );
				this.add( txtfEntityId, 4, 0 );

				this.add( lblAddress, 0, 2 );
				this.add( txtfAddress, 2, 2, 7, 1 );

				this.add( lblZip, 0, 4 );
				this.add( txtfZip, 2, 4 );
				this.add( lblCity, 4, 4 );
				this.add( txtfCity, 6, 4 );

				this.add( lblLongitude, 0, 6 );
				this.add( txtfLongitude, 2, 6 );
				this.add( lblLatitude, 4, 6 );
				this.add( txtfLatitude, 6, 6 );

				this.add( lblStartupDate, 0, 8 );
				this.add( txtfStartupDate, 2, 8 );
				this.add( lblLoaderType, 4, 8 );
				this.add( txtfLoaderType, 6, 8 );

				this.add( lblChargingPoints, 0, 10 );
				this.add( txtfChargingPoints, 2, 10 );
				this.add( lblConnectionPowerKW, 4, 10 );
				this.add( txtfConnectionPowerKW, 6, 10 );

				this.add( lblPlugTypes1, 0, 12 );
				this.add( txtfPlugTypes1, 2, 12 );
				this.add( lblPower1KW, 4, 12 );
				this.add( txtfPower1KW, 6, 12 );

				this.add( lblPlugTypes2, 0, 14 );
				this.add( txtfPlugTypes2, 2, 14 );
				this.add( lblPower2KW, 4, 14 );
				this.add( txtfPower2KW, 6, 14 );

				this.add( lblPlugTypes3, 0, 16 );
				this.add( txtfPlugTypes3, 2, 16 );
				this.add( lblPower3KW, 4, 16 );
				this.add( txtfPower3KW, 6, 16 );

				this.add( lblPlugTypes4, 0, 18 );
				this.add( txtfPlugTypes4, 2, 18 );
				this.add( lblPower4KW, 4, 18 );
				this.add( txtfPower4KW, 6, 18 );
		}
}