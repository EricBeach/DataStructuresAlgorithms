package org.ericbeach.learning.algorithms.sorting;

import java.util.List;

/**
 * Performs selection sort on a list.
 * @param <T> Generic type.
 */
public class SelectionsortListSorter <T extends Comparable<? super T>> implements ListSorter<T> {
  private final ListSorterHelper<T> helper;
  
  public SelectionsortListSorter() {
    helper = new ListSorterHelper<T>();
  }
  
  @Override
  public List<T> sort(List<T> list) {
    int sortedIndex = 0;
    while (sortedIndex < list.size()) {
      int smallestUnsortedIndex = sortedIndex;
      for (int nextIndexToCheck = sortedIndex;
          nextIndexToCheck < list.size();
          nextIndexToCheck++) {
        if (list.get(smallestUnsortedIndex).
                compareTo(list.get(nextIndexToCheck)) > 0) {
          smallestUnsortedIndex = nextIndexToCheck;
        }
      }
      helper.swap(list, sortedIndex, smallestUnsortedIndex);
      sortedIndex++;
    }
    return list;
  }
}
