package Components;

import lombok.Getter;

public class Room {

  @Getter
  private String name;
  
  public Room(String name) {
    this.name = name;
  }
}
