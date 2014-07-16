package org.ericbeach.learning.algorithms.sorting;

import org.ericbeach.learning.algorithms.sorting.ListSorter;
import org.ericbeach.learning.algorithms.sorting.QuicksortListSorter;

/**
 * Tests the sorting functionality of the shell sort implementation.
 */
public class QuicksortListSorterTest extends AbstractListSorterTest {
  @Override
  protected <T extends Comparable<? super T>> ListSorter<T> createListSorter() {
    return new QuicksortListSorter<T>();
  }
}
