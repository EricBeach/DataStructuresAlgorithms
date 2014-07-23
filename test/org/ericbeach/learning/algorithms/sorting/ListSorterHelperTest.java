package org.ericbeach.learning.algorithms.sorting;

import junit.framework.TestCase;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests the list sorter helper to make sure it swaps elements properly.
 */
public class ListSorterHelperTest extends TestCase {
  public void testSwapStrings() {
    List<String> stringList = new ArrayList<String>();
    stringList.add("my string");
    stringList.add("my String");
    stringList.add("My String");
    stringList.add("A");
    stringList.add("A123");
    stringList.add("123");

    ListSorterHelper<String> helper = new ListSorterHelper<String>();
    assertEquals("my string", stringList.get(0));
    helper.swap(stringList, 0, 1);
    assertEquals("my String", stringList.get(0));
    
    assertEquals("My String", stringList.get(2));
    helper.swap(stringList, 2, 3);
    assertEquals("A", stringList.get(2));

    assertEquals("A123", stringList.get(4));
    helper.swap(stringList, 4, 5);
    assertEquals("123", stringList.get(4));
  }

  public void testSwapLongs() {
    ListSorterHelper<Timestamp> helper = new ListSorterHelper<Timestamp>();

    List<Timestamp> timestampList = new ArrayList<Timestamp>();
    timestampList.add(new Timestamp(1386037882000L));
    timestampList.add(new Timestamp(1386037876000L));
    timestampList.add(new Timestamp(1386037886000L));
    timestampList.add(new Timestamp(1386037881000L));

    assertEquals(new Timestamp(1386037882000L), timestampList.get(0));
    helper.swap(timestampList, 0, 1);
    assertEquals(new Timestamp(1386037876000L), timestampList.get(0));
    
    assertEquals(new Timestamp(1386037886000L), timestampList.get(2));
    helper.swap(timestampList, 2, 3);
    assertEquals(new Timestamp(1386037881000L), timestampList.get(2));
  }
}
