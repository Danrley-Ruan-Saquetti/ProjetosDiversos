package Specter;

import Components.Game;
import Evidence.Evidence;
import Util.Util;
import lombok.Getter;

public abstract class Specter {

  @Getter
  private final String specterNameType;

  @Getter
  private final String name;

  @Getter
  private final Evidence[] evidences;

  public Specter(String specterNameType, Evidence[] evidences) {
    this.specterNameType = specterNameType;
    this.evidences = evidences;

    this.name = switch (Util.random.nextInt(15)) {
      case 0 -> "Zogoir Vuvon";
      case 1 -> "Nakar Waela";
      case 2 -> "Luhepifa Hoxeo";
      case 3 -> "Kumore Cife";
      case 4 -> "Riuvu Entoa";
      case 5 -> "Gutoce Dyous";
      case 6 -> "Befou Timue";
      case 7 -> "Sebal Xuzil";
      case 8 -> "Hiqua Woavi";
      case 9 -> "Vuxael Sime";
      case 10 -> "Kiblowa Taiwui";
      case 11 -> "Lavyu Xiziflu";
      case 12 -> "Beusr Zimya";
      case 13 -> " Vaoti Cegan";
      case 14 -> "Soibi Isvauba";
      default -> "???";
    };
  }

  public void update(Game game) {
    this.updateItens(game);
  }

  private void updateItens(Game game) {
    for (var evidence : this.evidences) {
      evidence.update(game);
    }
  }

  public boolean hasEvidence(Class<? extends Evidence> evidenceClass) {
    for (var evidence : this.evidences) {
      if (evidence == null)
        continue;

      if (evidence.getClass() == evidenceClass)
        return true;
    }

    return false;
  }
}
