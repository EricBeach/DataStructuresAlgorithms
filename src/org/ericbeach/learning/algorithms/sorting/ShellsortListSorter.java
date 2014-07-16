package org.ericbeach.learning.algorithms.sorting;

import java.util.List;

/**
 * Performs shell sort on a list.
 * @param <T> Generic type.
 */
public class ShellsortListSorter <T extends Comparable<? super T>> implements ListSorter<T> {
  private final ListSorterHelper<T> listSorterHelper;

  public ShellsortListSorter() {
    listSorterHelper = new ListSorterHelper<T>();
  }
  
  @Override
  public List<T> sort(List<T> list) {
    /**
     * Computes the h-value for sublists and delegates sorting each subsequent
     * sublist.
     */
    for (int hIncrement = list.size() / 2; hIncrement > 0; hIncrement /= 2) {
      hSort(list, hIncrement);
    }
    return list;
  }
  
  /**
   * @param list The list to be sorted.
   * @param hIncrement The current h-value for the overall list (i.e., the
   *     increment that delimets the sublists)
   */
  private void hSort(List<T> list, int hIncrement) {  
    for (int startPos = 0; startPos < hIncrement; startPos++) {
      insertionSort(list, startPos, hIncrement);
    }
  }
  
  /**
   * Perform insertion sort on the h-incremented sublist.
   * @param list The entire list, including the sublist to be sorted. In each
   *     invocation of this method, only a sublist gets sorted.
   * @param startPos The position of the first element in the sublist to be
   *     sorted.
   * @param sublistOffset The h-increment or sublist offset (i.e., how many
   *     positions to jump in the master list in order to get to the next
   *     element in the sublist).
   */
  private void insertionSort(List<T> list, int startPos, int sublistOffset) {
    for (int nextUnsortedPos = startPos + sublistOffset;
        nextUnsortedPos < list.size();
        nextUnsortedPos += sublistOffset) {
      
      for (int nextPosToCheck = nextUnsortedPos;
          nextPosToCheck > startPos;
           nextPosToCheck -= sublistOffset) {
        if (list.get(nextPosToCheck).compareTo(
                list.get(nextPosToCheck - sublistOffset)) < 0) {
          listSorterHelper.swap(list, nextPosToCheck, nextPosToCheck - sublistOffset);
        }
      }
    }
  }
}
