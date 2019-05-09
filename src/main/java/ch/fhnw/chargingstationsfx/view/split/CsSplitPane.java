package ch.fhnw.chargingstationsfx.view.split;

import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationPresentationModel;
import ch.fhnw.chargingstationsfx.view.ViewMixin;
import ch.fhnw.chargingstationsfx.view.split.detailview.CsDetailPane;
import ch.fhnw.chargingstationsfx.view.split.tableview.CsTablePane;
import javafx.scene.control.SplitPane;

public class CsSplitPane extends SplitPane implements ViewMixin
{
		private final ChargingStationPresentationModel csPM;
		private CsTablePane tablePane;
		private CsDetailPane detailPane;

		public CsSplitPane ( ChargingStationPresentationModel csPM )
		{
				this.csPM = csPM;
				init();
		}

		@Override
		public void initializeControls ()
		{
				tablePane = new CsTablePane( csPM );
				detailPane = new CsDetailPane( csPM );
		}

		@Override
		public void layoutControls ()
		{
				tablePane.getStyleClass().add( "cs-tablepane" );
				detailPane.getStyleClass().add( "cs-detailpane" );

				this.getItems().addAll( tablePane, detailPane );
		}
}