package Specter;

import Evidence.*;

public class WendigoSpecter extends Specter {

  public WendigoSpecter() {
    super(
        "Wendigo",
        new Evidence[] {
          new NegativeTemperatureEvidence(),
          new SpiritBoxEvidence(),
          new WriteEvidence(),
        }
    );
  }
}
