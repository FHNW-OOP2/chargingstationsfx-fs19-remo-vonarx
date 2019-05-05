package ch.fhnw.chargingstationsfx.data.interfaces.exporter;


import ch.fhnw.chargingstationsfx.data.csv.ChargingStation;

import java.nio.file.Path;
import java.util.List;

public interface IChargingStationExporter
{
		boolean export ( Path destination, List<ChargingStation> data, char delimiter );
}
