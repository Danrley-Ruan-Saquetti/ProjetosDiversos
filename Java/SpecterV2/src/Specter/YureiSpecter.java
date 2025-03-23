package Specter;

import Evidence.*;

public class YureiSpecter extends Specter {

  public YureiSpecter() {
    super(
        "Phantom",
        new Evidence[] {
          new NegativeTemperatureEvidence(),
          new OrbEvidence(),
          new WriteEvidence(),
        }
    );
  }
}
