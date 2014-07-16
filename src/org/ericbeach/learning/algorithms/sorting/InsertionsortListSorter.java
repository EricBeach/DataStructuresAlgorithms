package org.ericbeach.learning.algorithms.sorting;

import java.util.List;

/**
 * Performs insertion sort on a list.
 * @param <T> Generic type.
 */
public class InsertionsortListSorter <T extends Comparable<? super T>> implements ListSorter<T> {
  private final ListSorterHelper<T> listSorterHelper;
  
  public InsertionsortListSorter() {
    listSorterHelper = new ListSorterHelper<T>();
  }
  
  @Override
  public List<T> sort(List<T> list) {
    int innerIndex;
    for (int sortedIndex = 1; sortedIndex < list.size(); sortedIndex++) {
      innerIndex = sortedIndex;
      while (innerIndex > 0 && list.get(innerIndex - 1).compareTo(list.get(innerIndex)) > 0) {
        listSorterHelper.swap(list, innerIndex, innerIndex - 1);
        innerIndex--;
      }
    }
    return list;
  }
}
