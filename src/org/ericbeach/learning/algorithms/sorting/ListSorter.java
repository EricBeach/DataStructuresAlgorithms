package org.ericbeach.learning.algorithms.sorting;

import java.util.List;

/**
 * Interface for all classes that sort a list.
 * @param <T> Generic type.
 */
public interface ListSorter <T> {
  /**
   * Sort a list of objects.
   * @param list List of objects to be sorted.
   * @return Sorted list.
   */
  public List<T> sort(List<T> list);
}
