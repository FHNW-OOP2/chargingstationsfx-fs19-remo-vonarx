package ch.fhnw.chargingstationsfx.view.map;

import com.gluonhq.charm.down.Platform;
import com.gluonhq.maps.MapPoint;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * @author Dieter Holz
 */
public class PointOfInterest extends Circle
{

		private final MapPoint position = new MapPoint( 0, 0 );

		public PointOfInterest ()
		{
				super( Platform.isDesktop() ? 7 : 12, Color.RED );
				setCursor( Cursor.HAND );
		}

		public MapPoint getPosition ()
		{
				return position;
		}
}
