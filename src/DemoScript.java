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

      System.out.println("Run again?");
      if (!askYesOrNo()) {
        done = true;
      } else {
        System.out.println("Use new values? (Reset cell and sugar counts)");
        if (askYesOrNo()) {
          setCellCount();
          setSugarCount();
        }
      }
    } // end !while
    System.out.println("Bye!");

    PetriDish dish = new PetriDish(askNextInt());
    // number of cells: ----------------^^-----

    // re run?: (y: same values? y/n)(n: bye!)

    scan.close();
  } // end run

  private void predictions() {

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
