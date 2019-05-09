package ch.fhnw.chargingstationsfx.view;

import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationPresentationModel;
import ch.fhnw.chargingstationsfx.view.menu.CsMenubar;
import ch.fhnw.chargingstationsfx.view.split.CsSplitPane;
import javafx.scene.layout.BorderPane;

public class RootPanel extends BorderPane implements ViewMixin
{
		private final ChargingStationPresentationModel csPM;
		private CsSplitPane splitpane;
		private CsMenubar menubar;

		public RootPanel ( ChargingStationPresentationModel csPM )
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
				menubar = new CsMenubar();
				splitpane = new CsSplitPane( csPM );
		}

		@Override
		public void layoutControls ()
		{
				menubar.getStyleClass().add( "cs-menubar" );
				splitpane.getStyleClass().add( "cs-splitpane" );

				this.setTop( menubar );
				this.setCenter( splitpane );
		}
}
