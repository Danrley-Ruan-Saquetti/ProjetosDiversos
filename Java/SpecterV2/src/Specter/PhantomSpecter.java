package Specter;

import Evidence.*;

public class PhantomSpecter extends Specter {

  public PhantomSpecter() {
    super(
        "Phantom",
        new Evidence[] {
          new EMF5Evidence(),
          new NegativeTemperatureEvidence(),
          new OrbEvidence(),
        }
    );
  }
}
