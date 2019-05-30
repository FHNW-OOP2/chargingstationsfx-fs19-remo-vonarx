package ch.fhnw.chargingstationsfx.data.interfaces.importer;


import ch.fhnw.chargingstationsfx.presentationmodel.ChargingStation;

import java.nio.file.Path;
import java.util.List;

public interface IChargingStationImporter
{
		List<ChargingStation> parse ( Path source, char delimiter );
}
