package org.ericbeach.learning.algorithms.sorting;

import java.util.List;

/**
 * Helper class to provide common methods for sorting a list.
 * @param <T>
 */
public class ListSorterHelper<T extends Comparable<? super T>> {
  /**
   * Swap two elements in a list.
   * @param list The list from which the two elements will be swapped.
   * @param leftPos The index of the left element to be swapped.
   * @param rightPos The index of the right element to be swapped.
   */
  public void swap(List<T> list, int leftPos, int rightPos) {
    T temp = list.get(leftPos);
    list.set(leftPos, list.get(rightPos));
    list.set(rightPos, temp);
  }
}
