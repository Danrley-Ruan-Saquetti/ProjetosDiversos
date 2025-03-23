package Components;

import Evidence.Evidence;
import Util.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

public class Daily {

  private final Console dailyConsole = new Console(
      """
          +- Daily
          | E - Evidences
          | ESC - Leave Daily
          +-""",
      new String[] { "E", "ESC" });

  @Getter
  private final Map<Evidence.EVIDENCE_TYPE, Boolean> evidences = new HashMap<>();

  public Daily() {
  }

  public Daily(Evidence.EVIDENCE_TYPE[] evidencesType) {
    for (var type : evidencesType) {
      evidences.put(type, false);
    }
  }

  public void openDaily() {
    do {
      var prompt = this.dailyConsole.read();

      switch (prompt.toUpperCase()) {
        case "E" -> {
          this.openDailyEvidences();
          break;
        }
        case "ESC" -> {
          return;
        }
      }
    } while (true);
  }

  private void openDailyEvidences() {
    do {
      var prompt = this.readPromptEvidences();

      if (prompt.equalsIgnoreCase("ESC")) {
        return;
      }

      var evidenceSelectedIndex = Integer.parseInt(prompt);

      var evidenceSelected = (Evidence.EVIDENCE_TYPE) this.evidences.keySet().toArray()[evidenceSelectedIndex - 1];

      this.toggleEvidence(evidenceSelected);
    } while (true);
  }

  public void toggleEvidence(Evidence.EVIDENCE_TYPE type) {
    setEvidence(type, !evidences.get(type));
  }

  public void setEvidence(Evidence.EVIDENCE_TYPE type, boolean value) {
    if (value && this.getEvidencesSelected().size() >= 3) {
      Console.info("You are only allowed to have 3 pieces of evidence until selected");
      return;
    }

    evidences.put(type, value);
  }

  private String readPromptEvidences() {
    var evidencesText = "+- Evidences\n";
    var enableInputs = new String[this.evidences.size() + 1];

    var index = 1;
    for (var evidence : this.evidences.entrySet()) {
      evidencesText += "| " + index + ". ";

      if (evidence.getValue()) {
        evidencesText += "(X)";
      } else {
        evidencesText += "( )";
      }

      evidencesText += " " + evidence.getKey().getName() + "\n";

      enableInputs[index - 1] = index + "";
      index++;
    }

    evidencesText += "| ESC - Leave Evidences\n+-";
    enableInputs[enableInputs.length - 1] = "ESC";

    return Console.read(evidencesText, enableInputs);
  }

  public List<Evidence.EVIDENCE_TYPE> getEvidencesSelected() {
    var evidencesSelected = new ArrayList<Evidence.EVIDENCE_TYPE>();

    for (var evidence : this.evidences.entrySet()) {
      if (evidence.getValue()) {
        evidencesSelected.add(evidence.getKey());
      }
    }

    return evidencesSelected;
  }
}
