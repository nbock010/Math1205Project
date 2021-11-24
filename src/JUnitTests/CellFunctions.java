package JUnitTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import biology.Cell;

class CellFunctions {

  @DisplayName("Creation test")
  @Test
  void cellConstruct() {
    Cell alpha = new Cell();
    assertEquals(alpha.getSize(), Cell.DEFAULT_SIZE);
    assertEquals(alpha.getLeftBoundary(), 0);
    assertEquals(alpha.getRightBoundary(), 9);
  }

  @DisplayName("Size tests")
  @Test
  void size_tests() {
    Cell alpha = new Cell();
    alpha.eat();
    assertTrue(alpha.getSugarsEaten() == 1);
    assertTrue(alpha.getSize() == 11);
    assertTrue(alpha.existsAt(0));
    assertTrue(alpha.existsAt(9));
    assertEquals(alpha.getRightBoundary(), 10);
  }

  @Test
  @DisplayName("cells can shift")
  void cells_reBoundary_test() {
    Cell alpha = new Cell();
    assertEquals(alpha.getLeftBoundary(), 0);
    assertEquals(alpha.getRightBoundary(), 9);
    alpha.moveRightOne();
    assertEquals(alpha.getLeftBoundary(), 1);
    assertEquals(alpha.getRightBoundary(), 10);
  }

  @Test
  @DisplayName("cells can overlap")
  void cells_can_snuggle() {
    Cell alpha = new Cell();
    Cell bravo = new Cell();
    assertTrue(alpha.overlaps(bravo));
  }

  @Test
  @DisplayName("cells can be pushed over until they have space")
  void cells_go_bump() {
    Cell alpha = new Cell();
    Cell bravo = new Cell();
    bravo.moveRight(alpha.getSize());
    assertEquals(bravo.getLeftBoundary(), 10);
    assertFalse(alpha.overlaps(bravo));
    assertFalse(bravo.overlaps(alpha));
    assertFalse(alpha.existsAt(10));
    assertTrue(bravo.existsAt(10));
  }

  @Test
  @DisplayName("triple cell overlap test")
  void three_cells_test() {
    Cell alpha = new Cell();
    Cell bravo = new Cell();
    Cell charlie = new Cell();
    assertTrue(alpha.overlaps(bravo) && bravo.overlaps(charlie) && charlie.overlaps(alpha));

    bravo.moveRight(alpha.getSize());
    assertEquals(bravo.getLeftBoundary(), 10);
    charlie.moveRight(alpha.getSize() + bravo.getSize());

    assertFalse(alpha.overlaps(bravo) && bravo.overlaps(charlie) && charlie.overlaps(alpha));
    assertEquals(charlie.getLeftBoundary(), 20);
  }
}
