package org.ericbeach.learning.algorithms.sorting;

import java.util.List;

/**
 * Performs a heap sort on a list.
 * 
 * The heap sort is performed in place.
 * 
 * Conceptually, the heapsort algorithm can be broken down into two phases: heap and then sort.
 * At a high level, during the heap phase, a heap is built by adding one element at a time from
 * the input list to the heap. With each new element that is added to the heap, we need to check
 * and ensure that adding the new element didn’t break the heap order (i.e., that the new element
 * didn’t cause the heap order to be violated--e.g., that in a max-heap the new element didn’t
 * place a larger value as a child of a smaller value). If adding the new element to the heap
 * caused the heap-order to be violated, then we need to swap the new and out-of-heap-order
 * element with its parent. We continue this process until the heap order is restored, at which
 * time we add a new element to the heap again.
 * 
 * At a high level, during the sort phase, the final sorted list is built by repeating the
 * following until no elements are left in the heap and they are all moved into the final
 * sorted order: (1) move the top element of the heap, which is the largest element, to the end
 * of the array (2) decrement the boundary of the heap by one as the largest element now at the
 * end of the array is no longer in the heap (3) heapfy the heap so that the largest element in
 * the heap, which is the second largest element in the entire array behind the element that was
 * just moved out of the heap into its final position, sits atop the heap.
 * 
 * @param <T> Generic type.
 */
public class HeapSortListSorter <T extends Comparable<? super T>> implements ListSorter<T> {
  private final ListSorterHelper<T> listSorterHelper;

  public HeapSortListSorter() {
    listSorterHelper = new ListSorterHelper<T>();
  }

  @Override
  public List<T> sort(List<T> list) {
    // STEP 1: Max-Heapify the Heap.
    // Put the input list into max-heap order, meaning that for each node all child nodes must
    // be smaller.
    putIntoMaxHeapOrder(list);

    // STEP 2: Sort the Heap.
    // Swap the first and last element of the heap, thereby moving an element into its final
    // sorted position. Decrement the boundary of the heap (as one element left the heap for its
    // final sorted position). Shift down the heap to put the heap back into max-heap order.

    // Entire list is in the heap at this point.
    int endHeapIndex = list.size() - 1;
    while (endHeapIndex > 0) {
      listSorterHelper.swap(list, 0, endHeapIndex);
   
      // With an element moved into final position, its no longer considered part of the heap.
      endHeapIndex--;

      // Put heap back into order.
      shiftDown(list, 0, endHeapIndex);
    }
    return list;
  }
  
  /**
   * Place a list into max-heap order.
   * @param list The list to be max-heapified.
   */
  private void putIntoMaxHeapOrder(List<T> list) {
    // The index of the element to begin shifting up from.
    // We start by placing two elements into the heap (index 1 is 2 elements) and shift up
    // as necessary.
    int startShiftIndex = 1;

    // Begin heapifying the list by shifting up to the root, by starting
    // from the left child of the root (if it exists). After heapifying
    // from element 1, move to the next element if it exists and heapify from
    // there.
    while (startShiftIndex < list.size()) {
      shiftUp(list, startShiftIndex);
      startShiftIndex++;
    }
  }
  
  /**
   * Put a heap or subsection of it into max-heap order by shifting down.
   * @param list The list to be placed in max-heap order.
   * @param startIndex The index of the list to start shifting down from.
   * @param endIndex The index of the list to stop shifting down at.
   */
  private void shiftDown(List<T> list, int startIndex, int endIndex) {
    int currentRootIndex = startIndex;
    int currentChildIndex = 0;
    int toSwapIndex = 0;
    final int doNotSwap = -1;
    
    // As long as there is a child of the element we are currently evaluating,
    // continue shifting down.
    // The child element's index is: (currentRootIndex * 2) + 1 
    while ((currentRootIndex * 2) + 1 <= endIndex) {
      // Start by assuming that you're not going to swap any elements. We need to prove that the
      // element currently being evaluated is smaller than either of its parents.
      toSwapIndex = doNotSwap;

      // Calculate the index of the left child to see whether the current
      // parent index should swap with one of its children.
      currentChildIndex = (currentRootIndex * 2) + 1;
      
      // See if the parent is less than the left child.
      if (list.get(currentRootIndex).compareTo(list.get(currentChildIndex)) < 0) {
        toSwapIndex = currentChildIndex;
      }
      
      // Check whether a right child exists and if it does, whether its bigger than what
      // we previously planned to swap with, the left child, which has
      // already been established to be bigger than the parent.
      if (currentChildIndex + 1 <= endIndex &&
          list.get(toSwapIndex).compareTo(list.get(currentChildIndex + 1)) < 0) {
        toSwapIndex = currentChildIndex + 1;
      }
      
      // Check whether a swap should be performed and if so, perform it.
      // If no swap should be performed, return because we're done.
      if (toSwapIndex != doNotSwap) {
        listSorterHelper.swap(list, toSwapIndex, currentRootIndex);
        currentRootIndex = toSwapIndex;
      } else {
        return;
      }
    }
  }

  /**
   * Put a list in max-heap order by shifting up.
   * @param list The list to place in max-heap order by shifting up.
   * @param startShiftIndex The index of the list to start shifting up from.
   */
  private void shiftUp(List<T> list, int startShiftIndex) {
    // The child index to start shifting up from.
    int childIndex = startShiftIndex;
    
    int parentIndex;

    // As long as the child index is not at the top of the heap, keep
    // working up the tree.
    while (childIndex > 0) {
      parentIndex = (childIndex - 1) / 2;
      
      // If the parent index is less than the child, swap and set the new
      // child index to be the parent index (i.e., the current parent index
      // becomes the new child index).
      // If the parent index is in order, then we are done.
      if (list.get(parentIndex).compareTo(list.get(childIndex)) < 0) {
        listSorterHelper.swap(list, parentIndex, childIndex);
        childIndex = parentIndex;
      } else {
        return;
      }
    }
  }
}
