
import biology.PetriDish;

public class Introduction {

  public static void main(String[] args) {

    PetriDish dish = new PetriDish(4);
    // # of cells in the dish -----^

    dish.printDataBySize();
    // prints data of the cells, sorted by largest to smallest

    System.out.println(dish.getTotalLength());
    // collective length of all the cells

    for (int i = 0; i < 10; i++) {
      // # of sugars ---^^
      dish.feedAndShift();
    }
    System.out.println("---------------AFTER FEEDING--------------------");
    dish.printDataBySize();
    // prints data of the cells, sorted by largest to smallest
  }
}
