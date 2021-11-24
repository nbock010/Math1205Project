package biology;

public class Cell {
  private int size; // diameter in micrometers, "um"
  private int sugarsEaten;
  // private int id; // or: create a protected class with a big list of random names or something.
  // idk
  // random thought: dimensions will be in petri dish
  private int leftBoundary;
  public static int DEFAULT_SIZE = 10;

  public Cell() {
    this.size = DEFAULT_SIZE;
    this.sugarsEaten = 0;
    // this.id = 0;
    this.leftBoundary = 0;
  }

  /**
   * The cell consumes a sugar, and grows by 1 um. (This method also acts as a public wrapper for
   * the grow() method).
   */
  public void eat() {
    this.sugarsEaten++;
    this.grow();
  }

  private void grow() {
    this.size++;
  }

  /**
   * Returns the diameter of the cell, in micrometers ('um').
   *
   * @return cell size
   */
  public int getSize() {
    return this.size;
  }

  /**
   * @param n axis point where cell might exist
   * @return true if cell exists at a given point
   */
  public boolean existsAt(int n) {
    return this.leftBoundary <= n && n <= this.getRightBoundary();
  }

  /**
   * Amount of sugars this cell has eaten.
   *
   * @return cell's sugarsEaten value.
   */
  public int getSugarsEaten() {
    return this.sugarsEaten;
  }

  /**
   * Returns the floor value of the Cell.
   *
   * @return
   */
  public int getLeftBoundary() {
    return leftBoundary;
  }

  /** @return cell's ceiling value and location */
  public int getRightBoundary() {
    return this.leftBoundary + this.size - 1; // -1 because the first cell initially starts at 0
  }

  /**
   * @param c other cell
   * @return true if cells have overlapping left and right Boundarys. Can apply to either this cell
   *     or c
   */
  public boolean overlaps(Cell c) {

    return (this.getRightBoundary() >= c.leftBoundary && c.getRightBoundary() >= this.leftBoundary);
  }

  /**
   * Moves a cell to the right 1 um.
   *
   * @apiNote for potential future optimization, add a moveLeft, then adjust all leftBoundary values
   *     to be >0 to prevent rng int issues
   */
  public void moveRightOne() {
    this.leftBoundary++;
  }

  /**
   * Moves a cell to the right n um. (This method is essentially .setLeftBoundary.
   *
   * @param n number of spaces moving right.
   */
  public void moveRight(int n) {
    this.leftBoundary += n;
  }
}
