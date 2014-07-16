package org.ericbeach.learning.algorithms.sorting;

import java.util.List;

/**
 * Performs Quicksort on a List.
 * 
 * 1. Pivot - Pick an element, called a pivot, from the list of items to sort.
 * 2. Partition - Reorder the list so that all elements with values less than the pivot come
 * before the pivot while all elements with values greater than the pivot come after it
 * (equal values can go either way). After this partitioning, the pivot is in its final position.
 * This is called the partition operation.
 * 3. Recursive - Recursively apply the above steps of Pivot and Partition to the sub-list of
 * elements with smaller values and separately the sub-list of elements with greater values.
 * In other words, recursively apply quick sort to each of the two separate partitioned lists
 * created from the just-completed partition step (i.e., call quick sort on the left half of the
 * partitioned list and call quick sort on the right half of the partitioned list). The base case
 * of the recursion are lists of size zero or one, which never need to be sorted.
 * 
 * @param <T> Generic type.
 */
public class QuicksortListSorter <T extends Comparable<? super T>> implements ListSorter<T> {
  private final ListSorterHelper<T> listSorterHelper;
  
  public QuicksortListSorter() {
    listSorterHelper = new ListSorterHelper<T>();
  }
  
  @Override
  public List<T> sort(List<T> list) {
    quickSort(list, 0, list.size() - 1);
    return list;
  }
  
  /**
   * Perform a quick sort on a list.
   * See the class comments for details on how quick sort works.
   * @param list List to be sorted with the quick sort algorithm.
   * @param startIndex Left most boundary of the list.
   * @param endIndex Right most boundary of the list.
   */
  private void quickSort(List<T> list, int startIndex, int endIndex) {
    // BASE CASE: List contains one or fewer elements or the indexes are out of bounds.
    // This indicates that the list is sorted as we have no out of order elements in a zero or one
    // element list.
    if (endIndex <= startIndex || endIndex < 0 || endIndex >= list.size()) {
      return;
    }

    // RECURSIVE CASE: The current list can still be divided (i.e., partitioned) into sublists.
    // Partition the lists into two lists and return the index of the element
    // that served as the pivot (i.e., the element that divided the two lists). The two lists
    // will consist of all elements smaller than the partition (one list) and all elements larger
    // than the partition (second list).
    int partionedIndex = partitionListIntoTwo(list, startIndex, endIndex);

    // With the list sorted into two halves around a pivot index, sort each half individually
    // using quick sort. This is Step 3 described in the class comments.
    quickSort(list, startIndex, partionedIndex - 1);
    quickSort(list, partionedIndex + 1, endIndex);
  }
  
  /**
   * Partition the list, which is bounded by the leftIndex and rightIndex, into two separate lists.
   * The partitioning occurs by swapping elements in the list that are out of order.
   * The first new list is comprised of all the elements smaller than the pivot.
   * The second new list is comprised of all the the elements greater than the pivot.
   * 
   * The method returns the index of the final position of the pivot element. The last step of this
   * method is to ensure that the pivot element ends up in the proper position. This happens by
   * checking if the pivot is out of position with where the right and left index meet.
   * 
   * @param list
   * @param leftIndex
   * @param rightIndex
   * @return
   */
  private int partitionListIntoTwo(List<T> list, int leftIndex, int rightIndex) {
    // Choose the right most position of the list as the pivot. This will
    // remain fixed until the very end when it will be swapped if necessary.
    int initialPivotIndex = rightIndex;

    // As long as the left index pointer does not intersect with the right
    // index pointer, the list is not necessarily partitioned yet. So,
    // keep finding the next element on the right and the next element on the
    // left that are out of place so you can swap them.
    while (leftIndex < rightIndex) {
      //  2, 13, 20, 15, 11
      // As long as the left element is less than the pivot, move the left
      // index forward one and start again. Once you reach a place where
      // the value of the element at the left index is greater than
      // the pivot, the if statement won't evaluate true and we move on
      // to finding the first element on the right side that is out of position.
      if (list.get(leftIndex).compareTo(list.get(initialPivotIndex)) < 0) {
        leftIndex++;
        continue;
      }
      
      // Find the first value on the right that is out of place (i.e., smaller
      // than the pivot value). This is done by looping through the list
      // and decrementing the right index by one for each element on the right
      // that is in proper order (i.e., that is larger than the pivot).
      if (list.get(rightIndex).compareTo(list.get(initialPivotIndex)) >= 0) {
        rightIndex--;
        continue;
      }
      
      // Two elements, both out of position on the opposite side of the pivot
      // are swapped.
      listSorterHelper.swap (list, leftIndex, rightIndex);
      leftIndex++;
    }
    
    // Since we made the pivot index the rightmost element of the list and
    // this pivot stayed in place during the partition, we now need to
    // place this pivot element into its final place. If the pivot element
    // is smaller than the point where the right and left pointer met,
    // then we need to move up the left pointer so that when we swap
    // the pivot element with the left pointer, the order is correct (i.e.,
    // the smaller element--pivot--ends up to the left).
    if (list.get(leftIndex).compareTo(list.get(initialPivotIndex)) < 0) {
      leftIndex++;
    }
    listSorterHelper.swap(list, leftIndex, initialPivotIndex);
    
    return leftIndex;
  }
}
