package Specter;

import Evidence.*;

public class MareSpecter extends Specter {

  public MareSpecter() {
    super(
        "Mare",
        new Evidence[] {
          new NegativeTemperatureEvidence(),
          new OrbEvidence(),
          new SpiritBoxEvidence(),
        }
    );
  }
}
