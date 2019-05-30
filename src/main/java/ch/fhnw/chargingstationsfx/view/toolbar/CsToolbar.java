package ch.fhnw.chargingstationsfx.view.toolbar;

import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationsPresentationModel;
import ch.fhnw.chargingstationsfx.view.ViewMixin;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import static javafx.scene.control.Alert.AlertType.CONFIRMATION;
import static javafx.scene.control.ButtonType.CANCEL;
import static javafx.scene.control.ButtonType.YES;

public class CsToolbar extends HBox implements ViewMixin
{
		private ChargingStationsPresentationModel csPM;
		private Button btnSave;
		private Button btnNew;
		private Button btnDelete;
		private TextField txtfSearch;

		public CsToolbar ( ChargingStationsPresentationModel csPM )
		{
				this.csPM = csPM;
				init();
		}

		@Override
		public void initializeControls ()
		{
				btnSave = new Button( "Save" );
				btnNew = new Button( "New" );
				btnDelete = new Button( "Delete" );
				txtfSearch = new TextField();
				txtfSearch.setPromptText( "Type search text here" );
		}
		@Override
		public void layoutControls ()
		{
				btnSave.getStyleClass().add( "btn-save" );
				btnNew.getStyleClass().add( "btn-new" );
				btnDelete.getStyleClass().add( "btn-delete" );
				txtfSearch.getStyleClass().add( "txtf-search" );

				getChildren().addAll( btnSave, btnNew, btnDelete, txtfSearch );
		}

		@Override
		public void setupBindings ()
		{
				btnDelete.disableProperty().bind( csPM.selectedEntityId().lessThan( 1 ) );
		}

		@Override
		public void setupEventHandlers ()
		{
				btnNew.setOnAction( event -> csPM.addNewChargingStation() );
				btnSave.setOnAction( event -> csPM.save() );
				txtfSearch.setOnKeyTyped( event -> csPM.filter( txtfSearch.getText() ) );

				btnDelete.setOnAction( event ->
								{
										int entityId = csPM.selectedEntityId().get();

										Alert alert = new Alert( CONFIRMATION, "You're about to delete entity " + entityId + "! Are you sure?", YES, CANCEL );
										if( alert.showAndWait().get() == YES )
										{
												csPM.delete( entityId );
										}
								}
				);
		}
}