package Components;

import Item.Item;
import lombok.Getter;

public class Player {

  @Getter
  private Item[] slots;

  @Getter
  private int slotSelectedIndex = 0;

  @Getter
  private int sanity = 100;

  public Player() {
    this.slots = new Item[3];
  }

  public void update(Game game) {
    this.updateItens(game);
  }

  private void updateItens(Game game) {
    for (var item : this.slots) {
      if (item != null) {
        item.update(game);
      }
    }
  }

  public boolean selectSlot(int slotIndex) {
    if (slotIndex < 0 || slotIndex >= this.slots.length) {
      return false;
    }

    this.slotSelectedIndex = slotIndex;

    return true;
  }
  
  public void onItem() {
    this.toggleItem(true);
  }
  
  public void offItem() {
    this.toggleItem(false);
  }
  
  public void toggleItem() {
    var itemSelected = this.getItemSelected();
    
    if (itemSelected != null) {
      itemSelected.setActive(!itemSelected.isActive());
    }
  }
  
  public void toggleItem(boolean value) {
    var itemSelected = this.getItemSelected();
    
    if (itemSelected != null) {
      itemSelected.setActive(value);
    }
  }

  public void increaseSanity(int amount) {
    this.sanity += amount;
  }

  public void decreaseSanity(int amount) {
    this.sanity -= amount;
  }

  @SuppressWarnings("unchecked")
  public <T extends Item> T getItem(int index, Class<T> itemSearch) {
    if (this.slots[index].getClass() != itemSearch) {
      return null;
    }

    return (T) this.slots[index];
  }

  @SuppressWarnings("unchecked")
  public <T extends Item> T getItem(Class<T> itemSearch) {
    for (var item : this.slots) {
      if (item.getClass() == itemSearch) {
        return (T) item;
      }
    }

    return null;
  }

  public Item dropItem() {
    return this.dropItem(this.slotSelectedIndex);
  }

  public boolean collectItem(Item item) {
    if (this.getItemSelected() == null) {
      this.setItem(this.slotSelectedIndex, item);
      return true;
    }

    for (var i = 0; i < this.slots.length; i++) {
      if (this.slots[i] == null) {
        this.setItem(i, item);
        return true;
      }
    }

    return false;
  }

  public void setItem(int index, Item item) {
    this.slots[index] = item;
  }

  private Item dropItem(int index) {
    var item = this.slots[index];
    this.slots[index] = null;

    return item;
  }

  public Item getItem(int index) {
    return this.slots[index];
  }

  public Item getItemSelected() {
    return this.slots[slotSelectedIndex];
  }
}
