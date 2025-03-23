package Components;

import Evidence.Evidence;
import Item.*;
import Specter.*;
import Util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;

public class Game {

  private static final List<Class<? extends Specter>> SPECTERS = Arrays.asList(
      BansheeSpecter.class,
      DemonSpecter.class,
      JinnSpecter.class,
      MareSpecter.class,
      OniSpecter.class,
      PhantomSpecter.class,
      PoltergeistSpecter.class,
      RevenantSpecter.class,
      ShadeSpecter.class,
      SpiritSpecter.class,
      WendigoSpecter.class,
      YureiSpecter.class);
  private static final List<Class<? extends Item>> ITENS = Arrays.asList(
      BookItem.class,
      CameraItem.class,
      EMFItem.class,
      GlassesItem.class,
      RadioItem.class,
      ThermometerItem.class);

  @Getter
  private Player player = null;

  @Getter
  private Specter specter = null;

  @Getter
  private Daily daily = null;

  @Getter
  private final List<Item> itens = new ArrayList<>();

  private boolean isRunning = false;

  public void run() {
    this.initComponents();
    this.start();
  }

  private void initComponents() {
    this.specter = Util.newInstance(chooseSpecter());
    this.player = new Player();
    this.daily = new Daily(new Evidence.EVIDENCE_TYPE[]{
      Evidence.EVIDENCE_TYPE.EMF5Evidence,
      Evidence.EVIDENCE_TYPE.NegativeTemperatureEvidence,
      Evidence.EVIDENCE_TYPE.OrbEvidence,
      Evidence.EVIDENCE_TYPE.SpiritBoxEvidence,
      Evidence.EVIDENCE_TYPE.WriteEvidence,});

    this.itens.clear();

    for (var itemClass : ITENS) {
      this.itens.add((Item) Util.newInstance(itemClass));
    }

    this.isRunning = false;
    this.collectItem(this.itens.get(0));
    //this.player.onItem();
  }

  private static Class<? extends Specter> chooseSpecter() {
    if (SPECTERS.isEmpty()) {
      throw new RuntimeException("Without Specter defined");
    }

    return SPECTERS.get(Util.random.nextInt(SPECTERS.size()));
  }

  public void start() {
    this.isRunning = true;

    Console.info("Game Start!");

    while (this.isRunning) {
      this.update();
    }

    Console.info("End Game!");
  }

  public void update() {
    var prompt = this.printAndReadMenuGame();

    switch (prompt.toUpperCase()) {
      case "J" -> {
        Console.info("Enter Daily!");
        this.daily.openDaily();
        Console.info("Leave Daily!");
      }
      case "1", "2", "3" -> {
        this.player.selectSlot(Integer.parseInt(prompt) - 1);
      }
      case "E" -> {
        this.player.toggleItem();
      }
      case "ESC" -> {
        this.isRunning = false;
        return;
      }
    }

    this.specter.update(this);
    this.player.update(this);

    this.validSanityPlayer();
  }

  private String printAndReadMenuGame() {
    var slotsOptions = "";
    var itensPlayer = this.player.getSlots();

    for (var i = 0; i < itensPlayer.length; i++) {
      if (i > 0) {
        slotsOptions += "\n";
      }
      slotsOptions += "| " + (i + 1) + " - ";

      if (itensPlayer[i] != null) {
        slotsOptions += itensPlayer[i].getName();
        if (itensPlayer[i].isActive()) {
          slotsOptions += " [X]";
        } else {
          slotsOptions += " [ ]";
        }
      } else {
        slotsOptions += "(empty)";
      }

      if (this.player.getSlotSelectedIndex() == i) {
        slotsOptions += "\t<-";
      }
    }

    var slotsConsole = STR."""
                          +- Game
                          | E - Enable/Disable Item
                          | J - Daily
                          | ESC - Quit Game
                          +- Slots
                          \{slotsOptions}
                          +-""";

    return Console.read(slotsConsole, new String[]{"ESC", "J", "1", "2", "3", "E"});
  }

  public void validSanityPlayer() {
    if (this.player.getSanity() <= 0) {
      this.isRunning = false;
    }
  }

  private void collectItem(Item item) {
    if (this.player.collectItem(item)) {
      this.itens.remove(item);
    }
  }
}
