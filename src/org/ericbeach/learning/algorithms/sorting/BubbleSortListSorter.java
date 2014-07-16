package org.ericbeach.learning.algorithms.sorting;

import java.util.List;

/**
 * Performs BubbleSort on a List.
 * @param <T> Generic type.
 */
public class BubbleSortListSorter <T extends Comparable<? super T>> implements ListSorter<T> {
  private final ListSorterHelper<T> listSorterHelper;
  
  public BubbleSortListSorter() {
    listSorterHelper = new ListSorterHelper<T>();
  }
  
  @Override
  public List<T> sort(List<T> list) {
    for (int outer = 1; outer < list.size(); outer++) {
      for (int left = 0; left < (list.size() - outer); left++) {
        int right = left + 1;
        if (list.get(left).compareTo(list.get(right)) > 0) {
          listSorterHelper.swap(list, left, right);
        }
      }
    }
    return list;
  }
}
