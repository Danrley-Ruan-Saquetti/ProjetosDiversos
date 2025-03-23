package Specter;

import Evidence.*;

public class OniSpecter extends Specter {

  public OniSpecter() {
    super(
        "Banshee",
        new Evidence[] {
          new EMF5Evidence(),
          new SpiritBoxEvidence(),
          new WriteEvidence(),
        }
    );
  }
}
