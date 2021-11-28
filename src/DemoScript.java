import java.util.Scanner;

import biology.PetriDish;

/** @author noahb */
public class DemoScript {
  private Scanner scan = new Scanner(System.in);
  private PetriDish dish;
  private int sugars;

  public void run() {
    System.out.println("Welcome to Noah B's Math 1205-001 project.");
    System.out.println("------------------------------------------");
    boolean done = false;

    // initialize
    setCellCount();
    setSugarCount();

    // simulation
    while (!done) {

      for (int i = 0; i < sugars; i++) {
        dish.feedAndShift();
      }

      dish.printDataBySize();
      // make calculations
      predictions();

      System.out.println("Run again?");
      if (!askYesOrNo()) { // ends simulation
        scan.close();
        done = true;
      } else { // new simulation
        System.out.println("Use new values? (Reset cell and sugar counts)");
        if (askYesOrNo()) {
          setCellCount();
          setSugarCount();
        } else {
          dish = new PetriDish(dish.cellCount()); // resets
        }
        // else, repeat same cells and sugars
      }
    } // end !while
    System.out.println("Bye!");
    scan.close();
  } // end run

  /**
   * By The end, this will tally how many sugars were eaten and the sum of lengths, each divided by
   * the top 20% of cells.
   *
   * <p>Note: Because of java's dividing algorithm, cellCounts below 5 will return 0 cells.
   */
  private void predictions() {
    System.out.println();
    System.out.println("*------------------------------------*");
    int countTopTwenty = dish.cellCount() / 5;
    // How many cells are in the top 20%
    int topTwentySugars = 0;
    int topTwentyLength = 0;

    // Adds the values of the top 20% of cells' sugars and lengths
    for (int i = 0; i < countTopTwenty; i++) {
      topTwentySugars += dish.sortedList().get(i).getSugarsEaten();
      // adds the sugars eaten
      topTwentyLength += dish.sortedList().get(i).getSize();
      // adds the lengths
    }

    System.out.println("Number of cells in top 20%: ");
    System.out.println("  " + countTopTwenty);

    System.out.println("Number of sugars in the first " + countTopTwenty + " cells: ");
    System.out.println("  " + topTwentySugars + "( out of " + sugars + ")");

    System.out.println("Length of the first " + countTopTwenty + " cells: ");
    System.out.println("  " + topTwentyLength + "( out of " + dish.getTotalLength() + " um)");

    System.out.println("*------------------------------------*");
    // cells / 20
  }

  private void setCellCount() {
    System.out.println("How many cells are we working with?");
    dish = new PetriDish(askNextInt());
  }

  private void setSugarCount() {
    System.out.println("How many sugars are we feeding in?");
    sugars = askNextInt();
  }

  /**
   * Asks user for integer input, and works around invalid inputs
   *
   * @return int provided by user
   */
  private int askNextInt() {
    int out = 0;
    while (!scan.hasNextInt()) {
      System.out.println("Error: enter an integer");
      scan.nextLine();
    }
    out = scan.nextInt();
    scan.nextLine();

    return out;
  }

  /**
   * Okay, I know this might be cringey spaghetti code...I might fix it up later...
   *
   * <p>Asks user for boolean values via "yes" or "no" (case insensitive), and works around invalid
   * inputs.
   *
   * @return true or false based on "yes" or "no as input"
   */
  private boolean askYesOrNo() {
    boolean out = false; // for now;
    boolean done = false;

    while (!done) {
      String check = scan.nextLine();
      if (check.equalsIgnoreCase("yes")) {
        out = true;
        done = true;
      } else if (check.equalsIgnoreCase("no")) {
        out = false;
        done = true;
      } else {
        System.out.println("Error: enter 'yes' or 'no'");
      }
    } // end while
    return out;
  }
}
