package org.ericbeach.learning.algorithms.sorting;

import java.util.List;

/**
 * Performs insertion sort on a list.
 * 
 * Insertion sort is a simple sorting algorithm that builds the final sorted array one item at
 * a time. Insertion sort iterates, consuming and sorting one input element each repetition,
 * thereby growing a sorted output list. On a single repetition, insertion sort removes one
 * element from the input data, which is unsorted, finds the location it belongs to within the
 * sorted list, and inserts it there. It repeats until no input elements remain.
 * 
 * In other words, the algorithm consists of inserting one element at a time into the previously
 * sorted part of the array, moving higher ranked elements up as necessary. To start off, the
 * first (or smallest, or any arbitrary) element of the unsorted array is considered to be the
 * sorted part.
 * 
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
    // The first element starts sorted (it may move later).
    // Iterate one by one up the list.
    for (int sortedIndex = 1; sortedIndex < list.size(); sortedIndex++) {
      innerIndex = sortedIndex;
      // At each phase as we move up the list, take the next unsorted element (one to the right
      // of the sorted list boundary) and with that unsorted element, move down the list,
      // swapping the element as it goes until that element is in the proper sorted position.
      while (innerIndex > 0 && list.get(innerIndex - 1).compareTo(list.get(innerIndex)) > 0) {
        listSorterHelper.swap(list, innerIndex, innerIndex - 1);
        innerIndex--;
      }
    }
    return list;
  }
}
