package JUnitTests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import biology.PetriDish;

/** @author noahb Just put this here to copy/paste and remember formatting for tests */
class PetriDishTests {

  @Test
  @DisplayName("No null cells")
  void no_null_cells() {
    PetriDish pd = new PetriDish(3);
    assertNotNull(pd.getCell(1));
    assertNotNull(pd.getCell(2));
    assertNull(pd.getCell(3));
  }

  @Test
  @DisplayName("cells are indexed")
  void indexed_cells() {
    PetriDish pd = new PetriDish(3);
  }

  @Test
  @DisplayName("Cells don't oerlap upon construction")
  void no_initial_collisions() {
    PetriDish pd = new PetriDish(5);
    boolean result = false;
  }

  @Test
  @DisplayName("feeding increases petri dish size")
  void petri_feed_size() {
    PetriDish pd = new PetriDish(3);
    pd.feedAndShift();
    assertEquals(pd.getTotalLength(), 31);
  }

  @Test
  @DisplayName("Feeding a cell will push all other cells down to avoid collision")
  void petri_moves_after_noms() {
    PetriDish pd = new PetriDish(3);
    pd.feedAndShift();
    pd.feedAndShift();
    assertFalse(pd.getCell(0).overlaps(pd.getCell(1)));
    assertFalse(pd.getCell(1).overlaps(pd.getCell(2)));
    assertFalse(pd.getCell(1).overlaps(pd.getCell(2)));
  }

  @Test
  @DisplayName("printing")
  void print_test() {
    PetriDish pd = new PetriDish(3);
    pd.feedAndShift();
    pd.feedAndShift();
    assertEquals(pd.getTotalLength(), 32);
    pd.printDataBySize();
  }
}
