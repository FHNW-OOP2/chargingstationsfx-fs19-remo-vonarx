package ch.fhnw.chargingstationsfx.view.split.tableview;

import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStation;
import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationsPresentationModel;
import ch.fhnw.chargingstationsfx.view.ViewMixin;
import ch.fhnw.chargingstationsfx.view.split.tableview.cell.LocalDateTableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDate;
import java.util.Arrays;

public class CsTablePane extends StackPane implements ViewMixin
{
		private ChargingStationsPresentationModel csPM;

		private TableView<ChargingStation> tableView;

		private TableColumn<ChargingStation, Number> tcEntityId;
		private TableColumn<ChargingStation, LocalDate> tcStartupDate;
		private TableColumn<ChargingStation, String> tcAddress;
		private TableColumn<ChargingStation, String> tcZip;
		private TableColumn<ChargingStation, String> tcCity;
		private TableColumn<ChargingStation, Number> tcChargingPoints;
		private TableColumn<ChargingStation, String> tcOperatingCompany;

		public CsTablePane ( ChargingStationsPresentationModel csPM )
		{
				this.csPM = csPM;
				init();
		}

		@Override
		public void initializeControls ()
		{
				tableView = new TableView<>( csPM.getChargingStations() );

				tcEntityId = new TableColumn<>( "Entity Id" );
				tcStartupDate = new TableColumn<>( "Startup date" );
				tcAddress = new TableColumn<>( "Street" );
				tcZip = new TableColumn<>( "ZIP" );
				tcCity = new TableColumn<>( "City" );
				tcChargingPoints = new TableColumn<>( "Charging points" );
				tcOperatingCompany = new TableColumn<>( "Operating company" );

				tcEntityId.setCellValueFactory( c -> c.getValue().entityIdProperty() );
				tcStartupDate.setCellValueFactory( c -> c.getValue().startupDateProperty() );
				tcAddress.setCellValueFactory( c -> c.getValue().addressProperty() );
				tcZip.setCellValueFactory( c -> c.getValue().zipCodeProperty() );
				tcCity.setCellValueFactory( c -> c.getValue().cityProperty() );
				tcChargingPoints.setCellValueFactory( c -> c.getValue().chargingPointsProperty() );
				tcOperatingCompany.setCellValueFactory( c -> c.getValue().operatingCompanyProperty() );

				//Making them editable :)
				tcStartupDate.setCellFactory( c -> new LocalDateTableCell( tcStartupDate ) );
				tcAddress.setCellFactory( TextFieldTableCell.forTableColumn() );
				tcZip.setCellFactory( TextFieldTableCell.forTableColumn() );
				tcCity.setCellFactory( TextFieldTableCell.forTableColumn() );
				tcChargingPoints.setCellFactory( TextFieldTableCell.forTableColumn( new NumberStringConverter() ) );
				tcOperatingCompany.setCellFactory( TextFieldTableCell.forTableColumn() );

				tableView.setEditable( true );
		}

		@Override
		public void layoutControls ()
		{
				tableView.getColumns().addAll( Arrays.asList( tcEntityId, tcChargingPoints, tcAddress, tcZip, tcCity, tcStartupDate, tcOperatingCompany ) );
				getChildren().add( tableView );
		}


		@Override
		public void setupEventHandlers ()
		{
				tableView.setOnMouseClicked( event ->
				{
						ChargingStation selectedChargingStation = tableView.getSelectionModel().getSelectedItem();
						if( selectedChargingStation != null )
						{
								csPM.setSelectedEntityId( selectedChargingStation.entityIdProperty().get() );
						}
				} );
		}
}