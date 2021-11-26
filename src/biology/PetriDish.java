package biology;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

/**
 * A magical science petri dish that grows infinitely as its cells do, such that the cells will
 * always have space between them. Don't question it-- it's science, ok?
 *
 * @author noahb
 */
public class PetriDish {
  // initial: 0-
  private TreeMap<Integer, Cell> cells;
  private int totalLength;
  private Random rng;
  private int cellCount;

  private static Comparator<Cell> cellSorter = (Cell c1, Cell c2) -> c2.getSize() - c1.getSize();

  /** @param c number of cells to put in the petri dish */
  public PetriDish(int c) {
    this.cells = new TreeMap<>();
    this.cellCount = c;
    this.totalLength = c * Cell.DEFAULT_SIZE;
    rng = new Random();

    initialize();
  }

  /** CREATION/BASIC METHODS----------------------------- */

  /** Inserts and places cells into the treemap */
  private void initialize() {
    for (int i = 0; i < this.cellCount; i++) {
      cells.put(i, new Cell());
      cells.get(i).moveRight(i * Cell.DEFAULT_SIZE);
    }
  }

  public Cell getCell(int index) {
    return cells.get(index);
  }

  public int cellCount() {
    return this.cellCount;
  }

  public int getTotalLength() {
    return this.totalLength;
  }

  /*-------------INTERACTIONS--------------*/

  /** gives a random cell one sugar. increases the total length of the dish. */
  public void feedAndShift() {
    int sugarDrop = rng.nextInt(this.totalLength);
    boolean fed = false;
    for (Entry<Integer, Cell> e : cells.entrySet()) {

      if (e.getValue().existsAt(sugarDrop) && !fed) {
        this.feed(e.getKey());
        fed = true;
        // shift the rest
      } else if (fed) {
        e.getValue().moveRightOne();
      }
    } // end for
  }

  private void feed(int index) {
    this.getCell(index).eat();
    this.totalLength++;
  }

  public ArrayList<Cell> sortedList() {
    ArrayList<Cell> tempCells = new ArrayList<Cell>(cells.values());
    tempCells.sort(cellSorter);

    return tempCells;
  }

  public void printDataBySize() {
    ArrayList<Cell> tempCells = sortedList();

    System.out.println();
    ;
    for (Cell c : tempCells) {
      System.out.println("Cell " + tempCells.indexOf(c) + ": ");

      System.out.println("  Size: " + c.getSize() + "um");
      System.out.println("  Sugars eaten: " + c.getSugarsEaten());
      // System.out.println();
    }
  }
}
