package Specter;

import Evidence.*;

public class DemonSpecter extends Specter {

  public DemonSpecter() {
    super(
        "Demon",
        new Evidence[] {
          new NegativeTemperatureEvidence(),
          new SpiritBoxEvidence(),
          new WriteEvidence(),
        }
    );
  }
}
