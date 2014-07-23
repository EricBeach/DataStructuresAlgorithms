package org.ericbeach.learning.algorithms.sorting;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Tests the sorting functionality of the BubbleSort implementation.
 */
public class RadixIntegerSorterTest extends TestCase {
  private ArrayList<Integer> unsortedIntegers;
  private ArrayList<Integer> sortedIntegers;
  private RadixIntegerSorter sorter;

  protected void setUp() {
    unsortedIntegers = new ArrayList<Integer>();
    unsortedIntegers.add(10);
    unsortedIntegers.add(1);
    unsortedIntegers.add(100);
    unsortedIntegers.add(50);
    unsortedIntegers.add(2000);

    sortedIntegers = new ArrayList<Integer>();
    sortedIntegers.add(1);
    sortedIntegers.add(10);
    sortedIntegers.add(50);
    sortedIntegers.add(100);
    sortedIntegers.add(2000);

    sorter = new RadixIntegerSorter();
  }

  protected void tearDown() {
    unsortedIntegers = null;
    sortedIntegers = null;
    sorter = null;
  }

  public void testCanIntegersBeSortedCorrectly() {
    ArrayList<Integer> sorted = sorter.sortIntegers(unsortedIntegers, 4);

    if (sorted.size() != sortedIntegers.size()) {
      fail("Size of sorted array is wrong");
    }

    for (int i = 0; i < sorted.size(); i++) {
      assertEquals(sortedIntegers.get(i), sorted.get(i));
    }
  }
}
