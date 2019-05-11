package ch.fhnw.chargingstationsfx.view.split.tableview;

import ch.fhnw.chargingstationsfx.data.csv.ChargingStation;
import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationPresentationModel;
import ch.fhnw.chargingstationsfx.view.ViewMixin;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;

import java.time.LocalDate;
import java.util.Arrays;

public class CsTablePane extends StackPane implements ViewMixin
{
		private ChargingStationPresentationModel csPM;
		private TableView<ChargingStation> tableView;

		private TableColumn<ChargingStation, String> tcAddress;
		private TableColumn<ChargingStation, String> tcZip;
		private TableColumn<ChargingStation, String> tcCity;
		private TableColumn<ChargingStation, Number> tcChargingPoints;
		private TableColumn<ChargingStation, Number> tcConnectionPowerKW;
		private TableColumn<ChargingStation, Number> tcEntityId;
		private TableColumn<ChargingStation, String> tcOperatingCompany;
		private TableColumn<ChargingStation, Number> tcLongitude;
		private TableColumn<ChargingStation, Number> tcLatitude;
		private TableColumn<ChargingStation, LocalDate> tcStartupDate;
		private TableColumn<ChargingStation, String> tcLoaderType;
		private TableColumn<ChargingStation, Number> tcPower1KW;
		private TableColumn<ChargingStation, Number> tcPower2KW;
		private TableColumn<ChargingStation, Number> tcPower3KW;
		private TableColumn<ChargingStation, Number> tcPower4KW;
		private TableColumn<ChargingStation, String> tcPlugTypes1;
		private TableColumn<ChargingStation, String> tcPlugTypes2;
		private TableColumn<ChargingStation, String> tcPlugTypes3;
		private TableColumn<ChargingStation, String> tcPlugTypes4;

		public CsTablePane ( ChargingStationPresentationModel csPM )
		{
				this.csPM = csPM;
				init();
		}

		@Override
		public void initializeControls ()
		{
				tableView = new TableView<>( csPM.getChargingStations() );

				tcAddress = new TableColumn<>( "Strasse" );
				tcZip = new TableColumn<>( "PLZ" );
				tcCity = new TableColumn<>( "Ort" );
				tcChargingPoints = new TableColumn<>( "Anzahl Ladepunkte" );
				tcConnectionPowerKW = new TableColumn<>( "Anschlussleistung" );
				tcEntityId = new TableColumn<>( "Entitäts-ID" );
				tcOperatingCompany = new TableColumn<>( "Betreiber" );
				tcLongitude = new TableColumn<>( "Längengrad" );
				tcLatitude = new TableColumn<>( "Breitengrad" );
				tcStartupDate = new TableColumn<>( "Inbetriebnahme" );
				tcLoaderType = new TableColumn<>( "Ladungstyp" );
				tcPower1KW = new TableColumn<>( "Leistung Anschluss 1 [kW]" );
				tcPower2KW = new TableColumn<>( "Leistung Anschluss 2 [kW]" );
				tcPower3KW = new TableColumn<>( "Leistung Anschluss 3 [kW]" );
				tcPower4KW = new TableColumn<>( "Leistung Anschluss 4 [kW]" );
				tcPlugTypes1 = new TableColumn<>( "Anschlusstyp 1" );
				tcPlugTypes2 = new TableColumn<>( "Anschlusstyp 2" );
				tcPlugTypes3 = new TableColumn<>( "Anschlusstyp 3" );
				tcPlugTypes4 = new TableColumn<>( "Anschlusstyp 4" );

				tcAddress.setCellValueFactory( c -> c.getValue().getAddress() );
				tcZip.setCellValueFactory( c -> c.getValue().getZipCode() );
				tcCity.setCellValueFactory( c -> c.getValue().getCity() );
				tcChargingPoints.setCellValueFactory( c -> c.getValue().getChargingPoints() );
				tcConnectionPowerKW.setCellValueFactory( c -> c.getValue().getConnectionPowerKW() );
				tcEntityId.setCellValueFactory( c -> c.getValue().getEntityId() );
				tcOperatingCompany.setCellValueFactory( c -> c.getValue().getOperatingCompany() );
				tcLongitude.setCellValueFactory( c -> c.getValue().getLongitude() );
				tcLatitude.setCellValueFactory( c -> c.getValue().getLatitude() );
				tcStartupDate.setCellValueFactory( c -> c.getValue().getStartupDate() );
				tcLoaderType.setCellValueFactory( c -> c.getValue().getLoaderType() );
				tcPower1KW.setCellValueFactory( c -> c.getValue().getPower1KW() );
				tcPower2KW.setCellValueFactory( c -> c.getValue().getPower2KW() );
				tcPower3KW.setCellValueFactory( c -> c.getValue().getPower3KW() );
				tcPower4KW.setCellValueFactory( c -> c.getValue().getPower4KW() );
				tcPlugTypes1.setCellValueFactory( c -> c.getValue().getPlugTypes1() );
				tcPlugTypes2.setCellValueFactory( c -> c.getValue().getPlugTypes2() );
				tcPlugTypes3.setCellValueFactory( c -> c.getValue().getPlugTypes3() );
				tcPlugTypes4.setCellValueFactory( c -> c.getValue().getPlugTypes4() );
		}

		@Override
		public void layoutControls ()
		{
				tableView.getStyleClass().add( "cs-tableView" );

				getChildren().add( tableView );
				tableView.getColumns().addAll( Arrays.asList(
								tcAddress, tcZip, tcCity, tcChargingPoints,
								tcConnectionPowerKW, tcEntityId, tcOperatingCompany,
								tcLongitude, tcLatitude, tcStartupDate, tcLoaderType,
								tcPlugTypes1, tcPower1KW, tcPlugTypes2, tcPower2KW,
								tcPlugTypes3, tcPower3KW, tcPlugTypes4, tcPower4KW )
				);
		}

		@Override
		public void setupEventHandlers ()
		{
				tableView.setOnMouseClicked( event ->
				{
						if( event.getClickCount() == 2 )
						{
								ChargingStation chargingStation = tableView.getSelectionModel().getSelectedItem();
								csPM.setChargingStation( chargingStation );
						}
				} );
		}
}
