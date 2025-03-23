package Components;

import java.util.ArrayList;
import java.util.List;

public class HouseBuilder {

  public static House createHouse() {
    List<Room> rooms = new ArrayList<>();
    
    rooms.add(new Room("Quarto 1"));
    rooms.add(new Room("Quarto 2"));
    rooms.add(new Room("Quarto 3"));
    rooms.add(new Room("Corredor"));

    return new House("Base", rooms);
  }
}
