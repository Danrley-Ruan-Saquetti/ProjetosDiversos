package Specter;

import Evidence.*;

public class PoltergeistSpecter extends Specter {

  public PoltergeistSpecter() {
    super(
        "Poltergeist",
        new Evidence[] {
          new SpiritBoxEvidence(),
          new OrbEvidence(),
          new WriteEvidence(),
        }
    );
  }
}
