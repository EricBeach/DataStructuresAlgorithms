package org.ericbeach.learning.algorithms.sorting;

/**
 * Tests the sorting functionality of the selection sort implementation.
 */
public class SelectionsortListSorterTest extends AbstractListSorterTest {
  @Override
  protected <T extends Comparable<? super T>> ListSorter<T> createListSorter() {
    return new SelectionsortListSorter<T>();
  }
}
