package org.ericbeach.learning.algorithms.sorting;

/**
 * Tests the sorting functionality of the heap sort implementation.
 */
public class HeapSortListSorterTest extends AbstractListSorterTest {
  @Override
  protected <T extends Comparable<? super T>> ListSorter<T> createListSorter() {
    return new HeapSortListSorter<T>();
  }
}
