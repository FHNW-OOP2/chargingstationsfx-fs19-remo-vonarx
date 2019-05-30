package ch.fhnw.chargingstationsfx.view.split.detailview;

import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationsPresentationModel;
import ch.fhnw.chargingstationsfx.view.ViewMixin;
import ch.fhnw.chargingstationsfx.view.split.detailview.editor.CsEditorPane;
import ch.fhnw.chargingstationsfx.view.split.detailview.header.CsDetailHeaderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CsDetailPane extends VBox implements ViewMixin
{
		private ChargingStationsPresentationModel csPM;
		private CsEditorPane editorPane;
		private CsDetailHeaderPane detailHeader;

		public CsDetailPane ( ChargingStationsPresentationModel csPM )
		{
				this.csPM = csPM;
				init();
		}

		@Override
		public void initializeControls ()
		{
				detailHeader = new CsDetailHeaderPane( csPM );
				editorPane = new CsEditorPane( csPM );
		}
		@Override
		public void layoutControls ()
		{
				this.getStyleClass().add( "cs-detailpane" );
				VBox.setVgrow( editorPane, Priority.ALWAYS );
				HBox.setHgrow( detailHeader, Priority.ALWAYS );


				detailHeader.prefWidthProperty().bind( this.widthProperty() );
				editorPane.prefWidthProperty().bind( this.widthProperty() );

				GridPane.setFillWidth( detailHeader, true );
				GridPane.setFillWidth( editorPane, true );

				getChildren().addAll( detailHeader, editorPane );


		}
}