package org.ericbeach.learning.algorithms.sorting;

import java.util.List;

/**
 * Performs selection sort on a list.
 * 
 * The algorithm divides the input list into two parts: the sublist of items already sorted,
 * which is built up from left to right at the front (left) of the list, and the sublist of items
 * remaining to be sorted that occupy the rest of the list. Initially, the sorted sublist is
 * empty and the unsorted sublist is the entire input list. The algorithm proceeds by finding the
 * smallest (or largest, depending on sorting order) element in the unsorted sublist, exchanging
 * it with the leftmost unsorted element (thereby putting it in sorted order as the leftmost
 * unsorted element would be at the boundary of the sorted list and the next sorted item would be
 * placed in between the sorted list and the unsorted list), and moving the sublist boundaries
 * one element to the right.
 * 
 * The algorithm to sort is in this order:
 * 1. Get a list of unsorted numbers
 * 2. Set a marker for the unsorted section at the front of the list (i.e., marker is a divider
 * between the sorted section of the list and the unsorted section)
 * 3. Repeat steps 4 - 6 until one number remains in the unsorted section
 * 4. Compare all unsorted numbers in order to select the smallest number in the unsorted
 * section of the list
 * 5. Swap this number (i.e., the smallest number in the unsorted list) with the first number in
 * the unsorted section (i.e., swap with the location that will become the next number in the
 * sorted list)
 * 6. Advance the marker that divides the unsorted and sorted section to the right one position
 * 7. Stop
 * 
 * @param <T> Generic type.
 */
public class SelectionsortListSorter <T extends Comparable<? super T>> implements ListSorter<T> {
  private final ListSorterHelper<T> helper;

  public SelectionsortListSorter() {
    helper = new ListSorterHelper<T>();
  }

  @Override
  public List<T> sort(List<T> list) {
    // Initially, no elements are sorted.
    int sortedIndex = 0;

    // Keep sorting an element each iteration until the entire list is sorted.
    while (sortedIndex < list.size()) {
      // The left-most (or lowest) unsorted element is at the boundary of the sorted index.
      int smallestUnsortedIndex = sortedIndex;
      // Iterate from the first unsorted element (the boundary of the sorted index) all the way
      // to the end of the list, checking one element at a time for the smallest element
      // among the unsorted list. This element, will be swapped into its final sorted position.
      for (int nextIndexToCheck = sortedIndex;
          nextIndexToCheck < list.size();
          nextIndexToCheck++) {
        // Keep looking for the smallest unsorted element.
        if (list.get(smallestUnsortedIndex).
                compareTo(list.get(nextIndexToCheck)) > 0) {
          smallestUnsortedIndex = nextIndexToCheck;
        }
      }
      // Swap the smallest unsorted element into place and increment the boundary of the
      // sorted portion of the list by one.
      helper.swap(list, sortedIndex, smallestUnsortedIndex);
      sortedIndex++;
    }
    return list;
  }
}
