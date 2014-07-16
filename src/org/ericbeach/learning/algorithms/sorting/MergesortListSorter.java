package org.ericbeach.learning.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Performs Merge sort on a List.
 * 
 * Conceptually, a merge sort works as follows:
 * 1. Divide the unsorted list into n sublists, each containing 1 element (a list of 1
 * element is considered sorted).
 * 2. Repeatedly merge sublists to produce new sublists until there is only 1 sublist
 * remaining. This will be the sorted list.
 * 
 * For example:
 * The divide phase is as follows:
 * [2, 6, 1, 5, 4, 6, 2, 3]
 * [2, 6, 1, 5], [4, 6, 2, 3]
 * [2, 6], [1, 5], [4, 6], [2, 3]
 * [2], [6], [1], [5], [4], [6], [2], [3]
 * 
 * The merge phase is as follows:
 * [2], [6], [1], [5], [4], [6], [2], [3]
 * [2, 6],   [1, 5],   [4, 6],   [2, 3]
 * [1, 2, 5, 6],       [2, 3, 4, 6]
 * [1, 2, 2, 3, 4, 5, 6]
 * @param <T> Generic type.
 */
public class MergesortListSorter <T extends Comparable<? super T>> implements ListSorter<T> {
  
  @Override
  public List<T> sort(List<T> list) { 
    List<T> sorted = mergeSort(list, 0, list.size() - 1);
    return sorted;
  }
  
  /**
   * Sort a list of elements between two indices using the merge sort algorithm.
   * @param list The list of items to be sorted.
   * @param startIndex The first index of the list to be sorted.
   * @param endIndex The last index of the list to be sorted.
   * @return List sorted via the merge sort algorithm.
   */
  private List<T> mergeSort(List<T> list, int startIndex, int endIndex) {
    // BASE CASE: There is only one element in list that is comprised from startIndex to endIndex,
    // which means that this list is sorted. Since the one element list is sorted, we return
    // a list containing only this element.
    if (endIndex == startIndex) {
      List<T> result = new ArrayList<T>();
      result.add(list.get(startIndex));
      return result;
    }

    // RECURSIVE CASE: There is more than one element in the list comprised from startIndex to
    // endIndex, so divide the list in half and call merge sort on each half of the list.
    // In other words, split the current list (formed from startIndex to endIndex) into half,
    // thereby making two lists and sort each of those new lists with merge sort.
    int middleIndex = startIndex + ((endIndex - startIndex) / 2);
    List<T> leftList = mergeSort(list, startIndex, middleIndex);
    List<T> rightList = mergeSort(list, middleIndex + 1, endIndex);

    // Merge the left and right sublist, now sorted by merge sort, to get a larger list. Return
    // that larger list and you're done.
    // This is where the recursive magic happens.
    // The sorted list is the merger of the left and right lists.
    return merge(leftList, rightList);
  }
  
  
  /**
   * Merge two individually sorted lists together in order.
   * A crucial assumption necessary for this method to work is that the supplied left and right
   * lists are in-and-of themselves already sorted. In merge sort, we can assume this as you
   * will never attempt to merge lists that are in-and-of themselves not sorted. The purpose
   * of the merge is to merge two sorted lists.
   * 
   * In other words, take in the following left and right list: 
   * [2, 6],   [1, 5]
   * and return the following merged list:
   * [1, 2, 5, 6]
   * 
   * @param leftList
   * @param rightList
   * @return
   */
  private List<T> merge(List<T> leftList, List<T> rightList) {
    // Create the list that will contain the result (i.e., merge) of the two lists.
    List<T> mergedList = new ArrayList<T>();

    // As long as either the left or the right list has items remaining in it that have not been
    // merged, continue removing the elements in order and building up the merged list.
    while (leftList.size() > 0 || rightList.size() > 0) {
      // Case 1: Both lists have elements remaining.
      if (leftList.size() > 0 && rightList.size() > 0) {
        if (leftList.get(0).compareTo(rightList.get(0)) < 0) {
          // Left list contains next smallest element, so remove it and add it to the merged list.
          mergedList.add(leftList.remove(0));
        } else {
          // Right list contains next smallest element, so remove it and add it to the merged list.
          mergedList.add(rightList.remove(0));
        }
        continue;
      }
      
      // Case 2: Only the left list has elements remaining (we would not get to this point
      // in the code if the rightList.size() > 0), so the next smallest elements must be in the
      // left list.
      if (leftList.size() > 0) {
        // Remove the next element in the left list, which will be the next smallest element, and
        // add it to the merged list.
        mergedList.add(leftList.remove(0));
        continue;
      }
      
      // Case 3: Only the right list has elements remaining
      if (rightList.size() > 0) {
        // Remove the next element in the right list, which will be the next smallest element, and
        // add it to the merged list.
        mergedList.add(rightList.remove(0));
        continue;
      }
    }
    return mergedList;
  }
}
