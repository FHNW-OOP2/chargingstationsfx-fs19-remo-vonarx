package ch.fhnw.chargingstationsfx.view.split;

import ch.fhnw.chargingstationsfx.data.csv.ChargingStation;
import ch.fhnw.chargingstationsfx.view.ViewMixin;
import ch.fhnw.chargingstationsfx.view.split.detailview.CsDetailPane;
import ch.fhnw.chargingstationsfx.view.split.tableview.CsTablePane;
import javafx.collections.ObservableList;
import javafx.scene.control.SplitPane;

public class CsSplitPane extends SplitPane implements ViewMixin
{
		private final ObservableList<ChargingStation> chargingStations;
		private CsTablePane tablePane;
		private CsDetailPane detailPane;

		public CsSplitPane ( ObservableList<ChargingStation> chargingStations )
		{
				this.chargingStations = chargingStations;
				init();
		}

		@Override
		public void initializeControls ()
		{
				tablePane = new CsTablePane( chargingStations );
				detailPane = new CsDetailPane();
		}

		@Override
		public void layoutControls ()
		{
				tablePane.getStyleClass().add( "cs-tablepane" );
				detailPane.getStyleClass().add( "cs-detailpane" );

				this.getItems().addAll( tablePane, detailPane );
		}
}