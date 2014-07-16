package org.ericbeach.learning.algorithms.sorting;

import java.util.ArrayList;

/**
 * Performs Radix sort on a list of integers.
 */
public class RadixIntegerSorter {
  /**
   * Perform a Radix sort on array of integers.
   * @param list
   * @param maxDigits
   * @return
   */
  public ArrayList<Integer> sortIntegers(ArrayList<Integer> list, int maxDigits) {
    int nextPosToSort = 1;
    final int base = 10;
    int exp = 1;

    // Step 1: Perform the sort operation for each digit.
    while (nextPosToSort <= maxDigits) {
      
      // Step 1.A: Create buckets for each digit.
      ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < base; i++) {
        buckets.add(new ArrayList<Integer>()); 
      }
      
      // Step 1.B: Place each number into the appropriate bucket.
      for (int i = 0; i < list.size(); i++) {
        int elemDestinationBucketIndex = (list.get(i) / exp) % base;
        buckets.get(elemDestinationBucketIndex).add(list.get(i));
      }
      exp *= base;

      // Step 1.C: Unwind the bucketed array.
      int finalListIndex = 0;
      for (int bIndex = 0; bIndex < base; bIndex++) {
        for (int i = 0; i < buckets.get(bIndex).size(); i++, finalListIndex++) {
          list.set(finalListIndex, buckets.get(bIndex).get(i));
        }
      }
      nextPosToSort++;
    }
    return list;
  }
}
