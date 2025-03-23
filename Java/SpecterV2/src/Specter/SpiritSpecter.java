package Specter;

import Evidence.*;

public class SpiritSpecter extends Specter {

  public SpiritSpecter() {
    super(
        "Spirit",
        new Evidence[] {
          new EMF5Evidence(),
          new SpiritBoxEvidence(),
          new WriteEvidence(),
        }
    );
  }
}
