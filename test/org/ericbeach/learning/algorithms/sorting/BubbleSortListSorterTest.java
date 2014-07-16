package org.ericbeach.learning.algorithms.sorting;

import org.ericbeach.learning.algorithms.sorting.BubbleSortListSorter;
import org.ericbeach.learning.algorithms.sorting.ListSorter;

/**
 * Tests the sorting functionality of the BubbleSort implementation.
 */
public class BubbleSortListSorterTest extends AbstractListSorterTest {
  @Override
  protected <T extends Comparable<? super T>> ListSorter<T> createListSorter() {
    return new BubbleSortListSorter<T>();
  }
}
