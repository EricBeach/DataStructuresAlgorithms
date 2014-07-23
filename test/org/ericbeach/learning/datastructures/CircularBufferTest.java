package org.ericbeach.learning.datastructures;

import junit.framework.TestCase;

public class CircularBufferTest extends TestCase {
  private CircularBuffer<Integer> circularBuffer1;
  private CircularBuffer<Integer> circularBuffer2;
  private CircularBuffer<Integer> circularBuffer3;

  public void setUp() {
    circularBuffer1 = new CircularBuffer<Integer>(10);
    circularBuffer1.add(1);
    circularBuffer1.add(2);
    circularBuffer1.add(3);
    circularBuffer1.add(4);

    circularBuffer2 = new CircularBuffer<Integer>(15);
    circularBuffer2.add(10);

    circularBuffer3 = new CircularBuffer<Integer>(2);
    circularBuffer3.add(2);
    circularBuffer3.add(4);
    circularBuffer3.add(6);
  }

  public void tearDown() {
    circularBuffer1 = null;
    circularBuffer2 = null;
    circularBuffer3 = null;
  }

  public void testGetMaxCapacity() {
    assertEquals(10, circularBuffer1.getMaxCapacity());
    assertEquals(15, circularBuffer2.getMaxCapacity());
    assertEquals(2, circularBuffer3.getMaxCapacity());
  }

  public void testGetCurrentSize() {
    assertEquals(4, circularBuffer1.getCurrentSize());
    assertEquals(1, circularBuffer2.getCurrentSize());
    assertEquals(2, circularBuffer3.getCurrentSize());
  }

  public void testPeek() {
    assertEquals(0, circularBuffer1.peek().compareTo(1));
    assertEquals(0, circularBuffer2.peek().compareTo(10));
    assertEquals(0, circularBuffer3.peek().compareTo(2));
  }

  public void testAdd() {
    circularBuffer1.add(5);
    assertEquals(10, circularBuffer1.getMaxCapacity());
    assertEquals(5, circularBuffer1.getCurrentSize());
    assertEquals(0, circularBuffer1.peek().compareTo(1));

    circularBuffer2.add(10);
    assertEquals(15, circularBuffer2.getMaxCapacity());
    assertEquals(2, circularBuffer2.getCurrentSize());
    assertEquals(0, circularBuffer2.peek().compareTo(10));

    circularBuffer3.add(10);
    assertEquals(2, circularBuffer3.getMaxCapacity());
    assertEquals(2, circularBuffer3.getCurrentSize());
    assertEquals(0, circularBuffer3.peek().compareTo(2));
  }

  public void testRemove() {
    assertEquals(0, circularBuffer1.remove().compareTo(1));
    assertEquals(10, circularBuffer1.getMaxCapacity());
    assertEquals(3, circularBuffer1.getCurrentSize());
    assertEquals(0, circularBuffer1.peek().compareTo(2));

    assertEquals(0, circularBuffer2.remove().compareTo(10));
    assertEquals(15, circularBuffer2.getMaxCapacity());
    assertEquals(0, circularBuffer2.getCurrentSize());

    assertEquals(0, circularBuffer3.remove().compareTo(2));
    assertEquals(2, circularBuffer3.getMaxCapacity());
    assertEquals(1, circularBuffer3.getCurrentSize());
  }

  public void testLargeScaleAddAndRemove() {
    assertEquals(0, circularBuffer3.remove().compareTo(2));
    assertEquals(0, circularBuffer3.remove().compareTo(4));
    assertEquals(0, circularBuffer3.getCurrentSize());

    circularBuffer3.add(1);
    assertEquals(1, circularBuffer3.getCurrentSize());
    circularBuffer3.add(2);
    assertEquals(2, circularBuffer3.getCurrentSize());
    circularBuffer3.add(3);
    assertEquals(2, circularBuffer3.getCurrentSize());
    assertEquals(0, circularBuffer3.remove().compareTo(1));
    assertEquals(1, circularBuffer3.getCurrentSize());
    circularBuffer3.add(4);
    assertEquals(2, circularBuffer3.getCurrentSize());
    circularBuffer3.add(5);
    assertEquals(2, circularBuffer3.getCurrentSize());
    assertEquals(0, circularBuffer3.remove().compareTo(2));
  }
}
