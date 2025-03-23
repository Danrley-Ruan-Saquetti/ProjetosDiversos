package Specter;

import Evidence.*;

public class RevenantSpecter extends Specter {

  public RevenantSpecter() {
    super(
        "Demon",
        new Evidence[] {
          new EMF5Evidence(),
          new WriteEvidence(),
          new OrbEvidence(),
        }
    );
  }
}
