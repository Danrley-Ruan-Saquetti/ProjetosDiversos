package Specter;

import Evidence.*;

public class ShadeSpecter extends Specter {

  public ShadeSpecter() {
    super(
        "Banshee",
        new Evidence[] {
          new EMF5Evidence(),
          new WriteEvidence(),
          new OrbEvidence(),
        }
    );
  }
}
