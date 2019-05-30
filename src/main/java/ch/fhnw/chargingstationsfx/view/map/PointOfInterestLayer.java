package ch.fhnw.chargingstationsfx.view.map;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;

/**
 * A layer that allows to visualise points of interest.
 */
public class PointOfInterestLayer extends MapLayer
{

		private final ObservableList<PointOfInterest> points = FXCollections.observableArrayList();

		public PointOfInterestLayer ()
		{
		}

		@Override
		public void markDirty ()
		{
				super.markDirty();
		}

		public void addPoint ( PointOfInterest poi )
		{
				points.add( poi );
				this.getChildren().add( poi );
				this.markDirty();
		}

		@Override
		protected void layoutLayer ()
		{
				for( PointOfInterest poi : points )
				{
						MapPoint point = poi.getPosition();
						Point2D mapPoint = baseMap.getMapPoint( point.getLatitude(), point.getLongitude() );
						poi.setVisible( true );
						poi.setTranslateX( mapPoint.getX() );
						poi.setTranslateY( mapPoint.getY() );
				}
		}

}
