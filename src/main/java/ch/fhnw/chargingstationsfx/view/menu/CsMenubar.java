package ch.fhnw.chargingstationsfx.view.menu;

import ch.fhnw.chargingstationsfx.view.ViewMixin;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CsMenubar extends HBox implements ViewMixin
{
		private Button btnSave;
		private Button btnNew;
		private Button btnDelete;

		public CsMenubar ()
		{
				init();
		}

		@Override
		public void initializeControls ()
		{
				btnSave = new Button( "Save" );
				btnNew = new Button( "New" );
				btnDelete = new Button( "Delete" );
		}
		@Override
		public void layoutControls ()
		{
				getChildren().addAll( btnSave, btnNew, btnDelete );
		}

		@Override
		public void setupEventHandlers ()
		{
				//
		}
}
