package Components;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class House {

  @Getter
  private final List<Room> rooms;
  
  @Getter
  private final String name;
  
  private int roomHasPlayerIndex;

  public House() {
    this.name = "";
    this.rooms = new ArrayList<>();
    this.roomHasPlayerIndex = 0;
  }
  
  public House(String name, List<Room> rooms) {
    this.name = name;
    this.rooms = rooms;
  }
  
  public void setRoomHasPlayer(int roomHasPlayerIndex) {
    this.roomHasPlayerIndex = roomHasPlayerIndex;
  }
  
  public Room getRoomHasPlayer() {
    return this.rooms.get(this.roomHasPlayerIndex);
  }
}