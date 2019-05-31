package ch.fhnw.chargingstationsfx.view.map;

import ch.fhnw.chargingstationsfx.view.ViewMixin;
import com.gluonhq.charm.down.ServiceFactory;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.StorageService;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Point2D;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.util.Optional;

/**
 * @author Dieter Holz
 */
public class GeoPositionView extends StackPane implements ViewMixin
{
		private static final StorageService STORAGE_SERVICE = new StorageService()
		{
				@Override
				public Optional<File> getPrivateStorage ()
				{
						// user home app config location (linux: /home/[yourname]/.gluonmaps)
						return Optional.of( new File( System.getProperty( "user.home" ) ) );
				}

				@Override
				public Optional<File> getPublicStorage ( String subdirectory )
				{
						// this should work on desktop systems because home path is public
						return getPrivateStorage();
				}

				@Override
				public boolean isExternalStorageWritable ()
				{
						//noinspection ConstantConditions
						return getPrivateStorage().get().canWrite();
				}

				@Override
				public boolean isExternalStorageReadable ()
				{
						//noinspection ConstantConditions
						return getPrivateStorage().get().canRead();
				}


		};
		// define service factory for desktop
		private static final ServiceFactory<StorageService> SERVICE_FACTORY = new ServiceFactory<>()
		{

				@Override
				public Class<StorageService> getServiceType ()
				{
						return StorageService.class;
				}

				@Override
				public Optional<StorageService> getInstance ()
				{
						return Optional.of( STORAGE_SERVICE );
				}

		};

		static
		{
				// register service
				Services.registerServiceFactory( SERVICE_FACTORY );
		}

		private final DoubleProperty longitude = new SimpleDoubleProperty();
		private final DoubleProperty latitude = new SimpleDoubleProperty();
		private MapView mapView;
		private PointOfInterestLayer poiLayer;
		private PointOfInterest poi;
		private ChangeListener<Number> positionListener;

		public GeoPositionView ()
		{
				init();
		}

		@Override
		public void initializeSelf ()
		{
				setPrefSize( 250, 250 );
				getStyleClass().add( "geo-position-view" );
		}

		@Override
		public void initializeControls ()
		{
				poiLayer = new PointOfInterestLayer();

				poi = new PointOfInterest();
				poiLayer.addPoint( poi );

				mapView = new MapView();
				mapView.setZoom( 15 );
				mapView.addLayer( poiLayer );
		}

		@Override
		public void layoutControls ()
		{
				getChildren().add( mapView );
		}

		@Override
		public void setupEventHandlers ()
		{
				poi.setOnMouseDragged( event ->
				{
						Point2D point2D = poi.localToParent( event.getX(), event.getY() );
						MapPoint mapPosition = mapView.getMapPosition( point2D.getX(), point2D.getY() );

						poi.getPosition().update( mapPosition.getLatitude(), mapPosition.getLongitude() );

						poiLayer.markDirty();
						event.consume();
				} );

				poi.setOnMouseReleased( event ->
				{
						latitude.removeListener( positionListener );
						longitude.removeListener( positionListener );

						setLatitude( poi.getPosition().getLatitude() );
						setLongitude( poi.getPosition().getLongitude() );

						latitude.addListener( positionListener );
						longitude.addListener( positionListener );
				} );
		}

		@Override
		public void setupValueChangedListeners ()
		{
				positionListener = ( observable, oldValue, newValue ) ->
				{
						poi.getPosition().update( getLatitude(), getLongitude() );
						mapView.setCenter( poi.getPosition() );
				};

				latitude.addListener( positionListener );
				longitude.addListener( positionListener );
		}

		public double getLongitude ()
		{
				return longitude.get();
		}
		public void setLongitude ( double longitude )
		{
				this.longitude.set( longitude );
		}
		public DoubleProperty longitudeProperty ()
		{
				return longitude;
		}
		public double getLatitude ()
		{
				return latitude.get();
		}
		public void setLatitude ( double latitude )
		{
				this.latitude.set( latitude );
		}
		public DoubleProperty latitudeProperty ()
		{
				return latitude;
		}
}