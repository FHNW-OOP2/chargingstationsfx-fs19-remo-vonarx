package ch.fhnw.chargingstationsfx.data.interfaces.exporter;


import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStation;

import java.nio.file.Path;
import java.util.List;

public interface IChargingStationExporter
{
		boolean export ( Path destination, Path backup, List<ChargingStation> data, char delimiter );

		Path restoreBackup ( Path backup, Path destination );
}
