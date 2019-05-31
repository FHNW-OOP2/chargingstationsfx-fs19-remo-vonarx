package ch.fhnw.chargingstationsfx.view;

import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStationsPresentationModel;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class InfoPane extends StackPane implements ViewMixin
{
		private ChargingStationsPresentationModel csPM;
		private Label lblAmountInfo;

		public InfoPane ( ChargingStationsPresentationModel csPM )
		{
				this.csPM = csPM;
				init();
		}

		@Override
		public void initializeControls ()
		{
				lblAmountInfo = new Label();
		}

		@Override
		public void layoutControls ()
		{
				this.getStyleClass().add( "cs-infopane" );
				this.getChildren().add( lblAmountInfo );
		}

		@Override
		public void setupBindings ()
		{
				lblAmountInfo.textProperty().bind( csPM.filteredSizePropertyProperty().asString().concat( "/" ).concat( csPM.allSizePropertyProperty() ) );
		}
}
