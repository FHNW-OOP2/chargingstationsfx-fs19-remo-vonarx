package ch.fhnw.chargingstationsfx.view.event;

import ch.fhnw.chargingstationsfx.data.csv.ChargingStation;
import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationPresentationModel;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class CsTableViewClickEvent implements EventHandler<MouseEvent>
{
		private final ChargingStationPresentationModel csPM;
		public CsTableViewClickEvent ( ChargingStationPresentationModel csPM )
		{
				this.csPM = csPM;
		}

		@Override
		public void handle ( MouseEvent event )
		{
				if( event.getClickCount() == 2 )
				{
						TableView tableView = (TableView) event.getSource();
						ChargingStation chargingStation = (ChargingStation) tableView.getSelectionModel().getSelectedItem();

						csPM.setChargingStation( chargingStation );
				}
		}
}
