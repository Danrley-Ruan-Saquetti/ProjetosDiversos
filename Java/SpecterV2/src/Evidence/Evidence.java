package Evidence;

import Components.Game;
import lombok.Getter;

public abstract class Evidence {

  public static enum EVIDENCE_TYPE {
    EMF5Evidence("EMF5"),
    NegativeTemperatureEvidence("Negative Temperature"),
    OrbEvidence("Orbs"),
    SpiritBoxEvidence("Spirit Box"),
    WriteEvidence("Write");

    @Getter
    String name;

    EVIDENCE_TYPE(String name) {
      this.name = name;
    }
  }

  @Getter
  private String name;
  @Getter
  private final EVIDENCE_TYPE type;

  public Evidence(String name, EVIDENCE_TYPE type) {
    this.name = name;
    this.type = type;
  }

  public void update(Game game) {
  }
}
