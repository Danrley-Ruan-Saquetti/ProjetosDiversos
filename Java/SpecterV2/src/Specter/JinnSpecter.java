package Specter;

import Evidence.*;

public class JinnSpecter extends Specter {

  public JinnSpecter() {
    super(
        "Jinn",
        new Evidence[] {
          new EMF5Evidence(),
          new SpiritBoxEvidence(),
          new OrbEvidence(),
        }
    );
  }
}
