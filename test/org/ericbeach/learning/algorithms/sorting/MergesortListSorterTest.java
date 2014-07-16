package org.ericbeach.learning.algorithms.sorting;

import org.ericbeach.learning.algorithms.sorting.ListSorter;
import org.ericbeach.learning.algorithms.sorting.MergesortListSorter;

/**
 * Tests the sorting functionality of the Mergesort implementation.
 */
public class MergesortListSorterTest extends AbstractListSorterTest {
  @Override
  protected <T extends Comparable<? super T>> ListSorter<T> createListSorter() {
    return new MergesortListSorter<T>();
  }
}
