package Specter;

import Evidence.*;

public class BansheeSpecter extends Specter {

  public BansheeSpecter() {
    super(
        "Banshee",
        new Evidence[] {
          new EMF5Evidence(),
          new NegativeTemperatureEvidence(),
          new OrbEvidence(),
        }
    );
  }
}
