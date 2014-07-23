package org.ericbeach.learning.algorithms.sorting;

import java.util.List;

/**
 * Performs BubbleSort on a List.
 * Bubble sort is a simple sorting algorithm that works by repeatedly stepping through the list to
 * be sorted, comparing each pair of adjacent items and swapping them if they are in the wrong
 * order. The pass through the list is repeated until no swaps are needed, which indicates that
 * the list is sorted. The algorithm gets its name from the way smaller elements "bubble" to the
 * top of the list. Because it only uses comparisons to operate on elements, it is a comparison
 * sort.
 * 
 * Bubble Sort starts at one side of the data set and iterates its way through the set a total
 * of n-1 times. During each iteration, the pointer is moved slowly from one side of the set to
 * another, comparing two items at each stop and swapping them if they are out of order.
 * 
 * After the first iteration (i.e., doing one run through the list and comparing two items at
 * each point in the list), only one item is sorted. This iteration is repeated except that you
 * ignore the item at the far end, which is properly sorted (i.e., you compare two adjacent items
 * for all slots except the last slot).
 * 
 * @param <T> Generic type.
 */
public class BubbleSortListSorter <T extends Comparable<? super T>> implements ListSorter<T> {
  private final ListSorterHelper<T> listSorterHelper;

  public BubbleSortListSorter() {
    listSorterHelper = new ListSorterHelper<T>();
  }

  @Override
  public List<T> sort(List<T> list) {
    // Iterate over the list, starting from the first element going to the last element.
    for (int outer = 1; outer < list.size(); outer++) {
      // In each iteration, perform another iteration from the very beginning of the list
      // to the point at which the outer loop has placed an element in its final position.
      // At each step, compare whether the element to the right is out of place with the current
      // element and if so, swap.
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
