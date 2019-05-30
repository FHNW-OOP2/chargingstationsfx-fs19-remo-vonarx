package ch.fhnw.chargingstationsfx.view.split.detailview.editor;

import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStation;
import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationsPresentationModel;
import ch.fhnw.chargingstationsfx.util.DateUtil;
import ch.fhnw.chargingstationsfx.view.ViewMixin;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ch.fhnw.chargingstationsfx.ChargingStationsApp.DATE_FORMAT;
import static javafx.scene.layout.Priority.ALWAYS;
import static javafx.scene.layout.Priority.NEVER;

public class CsEditorPane extends GridPane implements ViewMixin
{
		private ChargingStationsPresentationModel csPM;
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
		private Spinner<Integer> spinnerChargingPoints;
		private TextField txtfConnectionPowerKW;
		private TextField txtfEntityId;
		private TextField txtfOperatingCompany;
		private TextField txtfLongitude;
		private TextField txtfLatitude;
		private DatePicker dpStartupDate;
		private TextField txtfLoaderType;
		private TextField txtfPower1KW;
		private TextField txtfPower2KW;
		private TextField txtfPower3KW;
		private TextField txtfPower4KW;
		private TextField txtfPlugTypes1;
		private TextField txtfPlugTypes2;
		private TextField txtfPlugTypes3;
		private TextField txtfPlugTypes4;

		private List<TextField> powerFields;
		private List<TextField> plugTypesFields;

		private StringConverter<LocalDate> stringToDateConverter = new StringConverter<>()
		{
				@Override
				public String toString ( LocalDate date )
				{
						return DateUtil.toString( date, DATE_FORMAT );
				}

				@Override
				public LocalDate fromString ( String string )
				{
						return DateUtil.fromString( string, DATE_FORMAT );
				}
		};


		public CsEditorPane ( ChargingStationsPresentationModel csPM )
		{
				this.csPM = csPM;
				init();
		}


		@Override
		public void initializeControls ()
		{
				lblEntityId = new Label( "Entity id" );
				lblAddress = new Label( "Street" );
				lblZip = new Label( "Zip" );
				lblCity = new Label( "City" );
				lblChargingPoints = new Label( "Charging points" );
				lblConnectionPowerKW = new Label( "Connection power [kW]" );
				lblOperatingCompany = new Label( "Operating company" );
				lblLongitude = new Label( "Longitude" );
				lblLatitude = new Label( "Latitude" );
				lblStartupDate = new Label( "Startup date" );
				lblLoaderType = new Label( "Loader type" );
				lblPower1KW = new Label( "Power Plugtype #1" );
				lblPower2KW = new Label( "Power Plugtype #2" );
				lblPower3KW = new Label( "Power Plugtype #3" );
				lblPower4KW = new Label( "Power Plugtype #4" );
				lblPlugTypes1 = new Label( "Plugtype #1" );
				lblPlugTypes2 = new Label( "Plugtype #2" );
				lblPlugTypes3 = new Label( "Plugtype #3" );
				lblPlugTypes4 = new Label( "Plugtype #4" );

				txtfEntityId = new TextField();
				txtfEntityId.setEditable( false );

				txtfAddress = new TextField();
				txtfZip = new TextField();
				txtfCity = new TextField();
				spinnerChargingPoints = new Spinner<>();
				spinnerChargingPoints.setValueFactory( new SpinnerValueFactory.IntegerSpinnerValueFactory( 1, 4, 0 ) );

				txtfConnectionPowerKW = new TextField();
				txtfEntityId = new TextField();
				txtfOperatingCompany = new TextField();
				txtfLongitude = new TextField();
				txtfLatitude = new TextField();

				txtfLoaderType = new TextField();
				txtfPower1KW = new TextField();
				txtfPower2KW = new TextField();
				txtfPower3KW = new TextField();
				txtfPower4KW = new TextField();
				txtfPlugTypes1 = new TextField();
				txtfPlugTypes2 = new TextField();
				txtfPlugTypes3 = new TextField();
				txtfPlugTypes4 = new TextField();

				dpStartupDate = new DatePicker( LocalDate.now() );
				dpStartupDate.setShowWeekNumbers( true );
				dpStartupDate.setConverter( stringToDateConverter );
				dpStartupDate.setPromptText( DATE_FORMAT );

				plugTypesFields = new LinkedList<>();
				powerFields = new LinkedList<>();

				plugTypesFields.add( txtfPlugTypes1 );
				plugTypesFields.add( txtfPlugTypes2 );
				plugTypesFields.add( txtfPlugTypes3 );
				plugTypesFields.add( txtfPlugTypes4 );

				powerFields.add( txtfPower1KW );
				powerFields.add( txtfPower2KW );
				powerFields.add( txtfPower3KW );
				powerFields.add( txtfPower4KW );
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

				getColumnConstraints().addAll( ccn, ccg, ccn, ccg );
				getRowConstraints().addAll( rcg, rcg, rcg, rcg, rcg, rcg, rcg, rcg, rcg, rcg );

				this.setMaxWidth( Double.MAX_VALUE );

				this.add( lblOperatingCompany, 2, 0 );
				this.add( txtfOperatingCompany, 3, 0 );
				this.add( lblEntityId, 0, 0 );
				this.add( txtfEntityId, 1, 0 );

				this.add( lblAddress, 0, 1 );
				this.add( txtfAddress, 1, 1, 7, 1 );

				this.add( lblZip, 0, 2 );
				this.add( txtfZip, 1, 2 );
				this.add( lblCity, 0, 3 );
				this.add( txtfCity, 1, 3 );

				this.add( lblLongitude, 2, 2 );
				this.add( txtfLongitude, 3, 2 );
				this.add( lblLatitude, 2, 3 );
				this.add( txtfLatitude, 3, 3 );

				this.add( lblLoaderType, 0, 4 );
				this.add( txtfLoaderType, 1, 4 );
				this.add( lblStartupDate, 2, 5 );
				this.add( dpStartupDate, 3, 5 );

				this.add( lblChargingPoints, 0, 6 );
				this.add( spinnerChargingPoints, 1, 6 );
				this.add( lblConnectionPowerKW, 2, 6 );
				this.add( txtfConnectionPowerKW, 3, 6 );

				this.add( lblPlugTypes1, 0, 7 );
				this.add( txtfPlugTypes1, 1, 7 );
				this.add( lblPower1KW, 2, 7 );
				this.add( txtfPower1KW, 3, 7 );

				this.add( lblPlugTypes2, 0, 8 );
				this.add( txtfPlugTypes2, 1, 8 );
				this.add( lblPower2KW, 2, 8 );
				this.add( txtfPower2KW, 3, 8 );

				this.add( lblPlugTypes3, 0, 9 );
				this.add( txtfPlugTypes3, 1, 9 );
				this.add( lblPower3KW, 2, 9 );
				this.add( txtfPower3KW, 3, 9 );

				this.add( lblPlugTypes4, 0, 10 );
				this.add( txtfPlugTypes4, 1, 10 );
				this.add( lblPower4KW, 2, 10 );
				this.add( txtfPower4KW, 3, 10 );

				this.txtfEntityId.setEditable( false );
				this.txtfConnectionPowerKW.setEditable( false );

				this.setGridLinesVisible( true );
		}

		@Override
		public void setupBindings ()
		{
				bindValues( csPM.getChargingStationProxy() );

				txtfPlugTypes1.visibleProperty().bindBidirectional( lblPlugTypes1.visibleProperty() );
				txtfPlugTypes2.visibleProperty().bindBidirectional( lblPlugTypes2.visibleProperty() );
				txtfPlugTypes3.visibleProperty().bindBidirectional( lblPlugTypes3.visibleProperty() );
				txtfPlugTypes4.visibleProperty().bindBidirectional( lblPlugTypes4.visibleProperty() );

				txtfPower1KW.visibleProperty().bindBidirectional( lblPower1KW.visibleProperty() );
				txtfPower2KW.visibleProperty().bindBidirectional( lblPower2KW.visibleProperty() );
				txtfPower3KW.visibleProperty().bindBidirectional( lblPower3KW.visibleProperty() );
				txtfPower4KW.visibleProperty().bindBidirectional( lblPower4KW.visibleProperty() );

				this.getChildren().forEach( e -> e.disableProperty().bind( csPM.selectedEntityId().lessThan( 1 ) ) );
		}

		@Override
		public void setupValueChangedListeners ()
		{
				spinnerChargingPoints.getEditor().textProperty().addListener( ( observable, oldValue, newValue ) ->
				{
						Integer chargingPoints = Integer.valueOf( newValue );
						changeVisibilityForChargingPoints( powerFields, plugTypesFields, chargingPoints );
						spinnerChargingPoints.getValueFactory().setValue( chargingPoints );

				} );

				//Clearing powerfields when plugtypes are being turned invisible
				Stream.concat( powerFields.stream(), plugTypesFields.stream() ).forEach( e ->
								e.visibleProperty().addListener( ( observable, oldValue, newValue ) -> e.clear() ) );
		}

		private void changeVisibilityForChargingPoints ( List<TextField> chargingPointPowerTextFields, List<TextField> plugTypesTextFields, int chargingPoints )
		{
				IntStream.range( 0, chargingPointPowerTextFields.size() ).forEach( i ->
				{
						chargingPointPowerTextFields.get( i ).visibleProperty().set( i < chargingPoints );
						plugTypesTextFields.get( i ).visibleProperty().set( i < chargingPoints );
				} );
		}


		private void bindValues ( ChargingStation chargingStation )
		{
				txtfEntityId.textProperty().bindBidirectional( chargingStation.entityIdProperty(), new NumberStringConverter( "####" ) );
				txtfAddress.textProperty().bindBidirectional( chargingStation.addressProperty() );
				txtfZip.textProperty().bindBidirectional( chargingStation.zipCodeProperty() );
				txtfCity.textProperty().bindBidirectional( chargingStation.cityProperty() );

				spinnerChargingPoints.getEditor().textProperty().bindBidirectional( chargingStation.chargingPointsProperty(), new NumberStringConverter() );
				dpStartupDate.valueProperty().bindBidirectional( chargingStation.startupDateProperty() );
				txtfLoaderType.textProperty().bindBidirectional( chargingStation.loaderTypeProperty() );

				txtfConnectionPowerKW.textProperty().bind( chargingStation.getConnectionPowerKWBinding().asString( "%.2f" ) );

				txtfOperatingCompany.textProperty().bindBidirectional( chargingStation.operatingCompanyProperty() );

				txtfLongitude.textProperty().bindBidirectional( chargingStation.longitudeProperty(), new NumberStringConverter( "##.#######" ) );
				txtfLatitude.textProperty().bindBidirectional( chargingStation.latitudeProperty(), new NumberStringConverter( "##.#######" ) );

				txtfPower1KW.textProperty().bindBidirectional( chargingStation.power1KwProperty(), new NumberStringConverter() );
				txtfPower2KW.textProperty().bindBidirectional( chargingStation.power2KwProperty(), new NumberStringConverter() );
				txtfPower3KW.textProperty().bindBidirectional( chargingStation.power3KwProperty(), new NumberStringConverter() );
				txtfPower4KW.textProperty().bindBidirectional( chargingStation.power4KwProperty(), new NumberStringConverter() );

				txtfPlugTypes1.textProperty().bindBidirectional( chargingStation.plugTypes1Property() );
				txtfPlugTypes2.textProperty().bindBidirectional( chargingStation.plugTypes2Property() );
				txtfPlugTypes3.textProperty().bindBidirectional( chargingStation.plugTypes3Property() );
				txtfPlugTypes4.textProperty().bindBidirectional( chargingStation.plugTypes4Property() );
		}
}