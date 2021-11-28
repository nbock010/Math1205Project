import biology.PetriDish;

/**
 * A quick rough introduction and explanation for how the simulation runs.
 *
 * @author noahb
 */
public class Introduction {

  public static void main(String[] args) {

    PetriDish dish = new PetriDish(4);
    // # of cells in the dish -----^

    dish.printDataBySize();
    // let's see the data of the cells, sorted by largest to smallest
    // it prints the cell's size and how many sugars it has eaten

    System.out.println("Petri dish length: " + dish.getTotalLength());
    // collective length of all the cells

    for (int i = 0; i < 10; i++) {
      // # of sugars ---^^---
      dish.feedAndShift();
      // feeds the cells, and shifts them so they don't overlap
    }
    System.out.println("---------------AFTER FEEDING--------------------");
    dish.printDataBySize();
    // prints data of the cells, sorted by largest to smallest
    System.out.println("Petri dish length: " + dish.getTotalLength());
    // collective length of all the cells
  }
}
