package ch.fhnw.chargingstationsfx.view.split.detailview;

import ch.fhnw.chargingstationsfx.view.ViewMixin;
import ch.fhnw.chargingstationsfx.view.split.detailview.editor.CsEditorPane;
import ch.fhnw.chargingstationsfx.view.split.detailview.header.CsDetailHeaderPane;
import javafx.scene.layout.VBox;

import static javafx.scene.layout.Priority.ALWAYS;
import static javafx.scene.layout.Priority.SOMETIMES;

public class CsDetailPane extends VBox implements ViewMixin
{
		private CsEditorPane editorPane;
		private CsDetailHeaderPane detailHeader;

		public CsDetailPane ()
		{
				init();
		}

		@Override
		public void initializeControls ()
		{
				detailHeader = new CsDetailHeaderPane();
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