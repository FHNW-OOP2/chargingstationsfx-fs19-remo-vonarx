package ch.fhnw.chargingstationsfx.view.split.detailview;

import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationPresentationModel;
import ch.fhnw.chargingstationsfx.view.ViewMixin;
import ch.fhnw.chargingstationsfx.view.split.detailview.editor.CsEditorPane;
import ch.fhnw.chargingstationsfx.view.split.detailview.header.CsDetailHeaderPane;
import javafx.scene.layout.VBox;

import static javafx.scene.layout.Priority.ALWAYS;
import static javafx.scene.layout.Priority.SOMETIMES;

public class CsDetailPane extends VBox implements ViewMixin
{
		private ChargingStationPresentationModel csPM;
		private CsEditorPane editorPane;
		private CsDetailHeaderPane detailHeader;

		public CsDetailPane ( ChargingStationPresentationModel csPM )
		{
				this.csPM = csPM;
				init();
		}

		@Override
		public void initializeControls ()
		{
				detailHeader = new CsDetailHeaderPane( csPM );
				editorPane = new CsEditorPane();
		}
		@Override
		public void layoutControls ()
		{
				this.getStyleClass().add( "cs-detailpane" );

				VBox.setVgrow( detailHeader, SOMETIMES );
				VBox.setVgrow( editorPane, ALWAYS );

				getChildren().addAll( detailHeader, editorPane );
		}
}
