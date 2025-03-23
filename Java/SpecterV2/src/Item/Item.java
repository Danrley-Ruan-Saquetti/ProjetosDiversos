package Item;

import Components.Game;
import lombok.Getter;
import lombok.Setter;

public abstract class Item {

  @Getter
  private final String name;
  
  @Setter
  @Getter
  protected boolean active = false;

  public Item(String name) {
    this.name = name;
  }
  
  public void update(Game game) { }
}
