package org.ericbeach.learning.algorithms.sorting;

import org.ericbeach.learning.algorithms.sorting.ListSorter;

import junit.framework.TestCase;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Sets up tests on string and integer lists that can be shared among
 * different types of list sorting algorithms.
 */
public abstract class AbstractListSorterTest extends TestCase {
  private List<Integer> unsortedOneIntegerList;
  private List<Integer> sortedOneIntegerList;

  private List<Integer> unsortedTwoIntegerList;
  private List<Integer> sortedTwoIntegerList;
  
  private List<Integer> unsortedIntegerList;
  private List<Integer> sortedIntegerList;

  private List<Integer> unsortedTinyIntegerList;
  private List<Integer> sortedTinyIntegerList;
  
  private List<String> unsortedStringList;
  private List<String> sortedStringList;

  private List<Timestamp> unsortedTimestampList;
  private List<Timestamp> sortedTimestampList;
  
  protected void setUp() throws Exception {
    unsortedOneIntegerList = new ArrayList<Integer>();
    unsortedOneIntegerList.add(0);
    
    sortedOneIntegerList = new ArrayList<Integer>();
    sortedOneIntegerList.add(0);

    unsortedTwoIntegerList = new ArrayList<Integer>();
    unsortedTwoIntegerList.add(10);
    unsortedTwoIntegerList.add(0);
    
    sortedTwoIntegerList = new ArrayList<Integer>();
    sortedTwoIntegerList.add(0);
    sortedTwoIntegerList.add(10);
    
    unsortedIntegerList = new ArrayList<Integer>();
    unsortedIntegerList.add(100);
    unsortedIntegerList.add(50);
    unsortedIntegerList.add(-120);
    unsortedIntegerList.add(9000);
    unsortedIntegerList.add(14);
    unsortedIntegerList.add(-200);
    unsortedIntegerList.add(60);

    sortedIntegerList = new ArrayList<Integer>();
    sortedIntegerList.add(-200);
    sortedIntegerList.add(-120);
    sortedIntegerList.add(14);
    sortedIntegerList.add(50);
    sortedIntegerList.add(60);
    sortedIntegerList.add(100);
    sortedIntegerList.add(9000);
    
    unsortedTinyIntegerList = new ArrayList<Integer>();
    unsortedTinyIntegerList.add(10);
    unsortedTinyIntegerList.add(0);
    
    sortedTinyIntegerList = new ArrayList<Integer>();
    sortedTinyIntegerList.add(0);
    sortedTinyIntegerList.add(10);
    
    unsortedStringList = new ArrayList<String>();
    unsortedStringList.add("my string");
    unsortedStringList.add("my String");
    unsortedStringList.add("My String");
    unsortedStringList.add("A");
    unsortedStringList.add("A123");
    unsortedStringList.add("123");

    sortedStringList = new ArrayList<String>();
    sortedStringList.add("123");
    sortedStringList.add("A");
    sortedStringList.add("A123");
    sortedStringList.add("My String");
    sortedStringList.add("my String");
    sortedStringList.add("my string");

    unsortedTimestampList = new ArrayList<Timestamp>();
    unsortedTimestampList.add(new Timestamp(1386037882000L));
    unsortedTimestampList.add(new Timestamp(1386037876000L));
    unsortedTimestampList.add(new Timestamp(1386037886000L));
    unsortedTimestampList.add(new Timestamp(1386037881000L));

    sortedTimestampList = new ArrayList<Timestamp>();
    sortedTimestampList.add(new Timestamp(1386037876000L));
    sortedTimestampList.add(new Timestamp(1386037881000L));
    sortedTimestampList.add(new Timestamp(1386037882000L));
    sortedTimestampList.add(new Timestamp(1386037886000L));
  }
  
  protected void tearDown() throws Exception {
    unsortedOneIntegerList = null;
    sortedOneIntegerList = null;

    unsortedTwoIntegerList = null;
    sortedTwoIntegerList = null;
    
    unsortedIntegerList = null;
    sortedIntegerList = null;
    
    unsortedTinyIntegerList = null;
    sortedTinyIntegerList = null;
    
    unsortedStringList = null;
    sortedStringList = null;

    unsortedTimestampList = null;
    sortedTimestampList = null;
  }

  protected abstract <T extends Comparable<? super T>> ListSorter<T>
    createListSorter();

  public void testSortOneInt() {
    ListSorter<Integer> sorter = createListSorter();
    List<Integer> result = sorter.sort(unsortedOneIntegerList);
    
    assertEquals(unsortedOneIntegerList.size(), result.size());

    Iterator<Integer> actual = result.iterator();
    Iterator<Integer> expected = sortedOneIntegerList.iterator();

    while (actual.hasNext() && expected.hasNext()) {
      assertEquals(expected.next(), actual.next());
    }   
  }
  
  public void testSortTwoInts() {
    ListSorter<Integer> sorter = createListSorter();
    List<Integer> result = sorter.sort(unsortedTwoIntegerList);
    
    assertEquals(unsortedTwoIntegerList.size(), result.size());

    Iterator<Integer> actual = result.iterator();
    Iterator<Integer> expected = sortedTwoIntegerList.iterator();

    while (actual.hasNext() && expected.hasNext()) {
      assertEquals(expected.next(), actual.next());
    }   
  }
  
  public void testSortSimpleInts() {
    ListSorter<Integer> sorter = createListSorter();
    List<Integer> result = sorter.sort(unsortedIntegerList);
    
    assertEquals(unsortedIntegerList.size(), result.size());

    Iterator<Integer> actual = result.iterator();
    Iterator<Integer> expected = sortedIntegerList.iterator();

    while (actual.hasNext() && expected.hasNext()) {
      assertEquals(expected.next(), actual.next());
    }   
  }
  
  public void testTinySortedInts() {
    ListSorter<Integer> sorter = createListSorter();
    List<Integer> result = sorter.sort(unsortedTinyIntegerList);
    
    assertEquals(unsortedTinyIntegerList.size(), result.size());

    Iterator<Integer> actual = result.iterator();
    Iterator<Integer> expected = sortedTinyIntegerList.iterator();

    while (actual.hasNext() && expected.hasNext()) {
      assertEquals(expected.next(), actual.next());
    }    
  }
  
  public void testSortSimpleStrings() {
    ListSorter<String> sorter = createListSorter();
    List<String> result = sorter.sort(unsortedStringList);
    
    assertEquals(unsortedStringList.size(), result.size());

    Iterator<String> actual = result.iterator();
    Iterator<String> expected = sortedStringList.iterator();

    while (actual.hasNext() && expected.hasNext()) {
      assertEquals(expected.next(), actual.next());
    }
  }

  public void testSortSimpleLongs() {
    ListSorter<Timestamp> sorter = createListSorter();
    List<Timestamp> result = sorter.sort(unsortedTimestampList);
    
    assertEquals(unsortedTimestampList.size(), result.size());

    Iterator<Timestamp> actual = result.iterator();
    Iterator<Timestamp> expected = sortedTimestampList.iterator();

    while (actual.hasNext() && expected.hasNext()) {
      assertEquals(expected.next(), actual.next());
    }
  }
}
