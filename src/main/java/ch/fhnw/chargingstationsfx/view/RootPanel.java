package ch.fhnw.chargingstationsfx.view;

import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationsPresentationModel;
import ch.fhnw.chargingstationsfx.view.split.CsSplitPane;
import ch.fhnw.chargingstationsfx.view.toolbar.CsToolbar;
import javafx.scene.layout.BorderPane;

public class RootPanel extends BorderPane implements ViewMixin
{
		private ChargingStationsPresentationModel csPM;
		private CsSplitPane splitpane;
		private CsToolbar toolbar;

		public RootPanel ( ChargingStationsPresentationModel csPM )
		{
				this.csPM = csPM;
				init();
		}

		@Override
		public void initializeSelf ()
		{
				addStylesheetFiles( "style.css" );
		}

		@Override
		public void initializeControls ()
		{
				toolbar = new CsToolbar( csPM );
				splitpane = new CsSplitPane( csPM );
		}

		@Override
		public void layoutControls ()
		{
				toolbar.getStyleClass().add( "cs-toolbar" );
				splitpane.getStyleClass().add( "cs-splitpane" );

				splitpane.prefWidthProperty().bind( this.prefWidthProperty() );
				splitpane.prefWidthProperty().bind( this.prefWidthProperty() );


				this.setTop( toolbar );
				this.setCenter( splitpane );
		}
}