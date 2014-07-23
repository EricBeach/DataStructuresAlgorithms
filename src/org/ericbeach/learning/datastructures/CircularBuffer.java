package org.ericbeach.learning.datastructures;

/**
 * A simple implementation of a circular buffer (i.e., a ring buffer) backed by an array. A ring
 * buffer is a fixed-size FIFO queue.
 * 
 * This simple implementation drops new elements if the ring buffer is full. The implementation
 * works by utilizing two index pointers that track: (a) where to place the next element that is
 * added (b) where to remove the next element.
 * 
 * @param <T> Generic type.
 */
public class CircularBuffer <T>{
  private final T[] elements;

  /**
   * Store an index that tracks where to make the next write into the array buffer.
   */
  private int writeIndex = 0;

  /**
   * Store a count that tracks the number of unread elements, which is essentially used to
   * compute the read-index.
   */
  private int unconsumedElements = 0;

  @SuppressWarnings("unchecked")
  public CircularBuffer(int circularBufferSize) {
    elements = (T[]) new Object[circularBufferSize];
  }

  /**
   * Add an element to the circular buffer. If the circular buffer is full, then do not
   * add a new element to the buffer.
   * @param newElement The new element to be added to the circular buffer.
   */
  public void add(T newElement) {
    // Check whether the buffer is full. If so, do not add the new element.
    if (unconsumedElements == getMaxCapacity()) {
      // Buffer is full.
      return;
    }
    // Add the new element to the current write index.
    elements[writeIndex] = newElement;

    // Determine the new write index.
    writeIndex = (writeIndex + 1) % getMaxCapacity();

    // Increment the count of elements available for consumption.
    unconsumedElements++;
  }

  /**
   * Return the maximum capacity of the circular buffer.
   * @return Maximum capacity of circular buffer.
   */
  public int getMaxCapacity() {
    return elements.length;
  }

  /**
   * Peek at the element that is next in line to be consumed.
   * The next element to be consumed will be the first element that was placed in the buffer.
   * @return Next element to be removed.
   */
  public T peek() {
    if (unconsumedElements == 0) {
      return null;
    }

    // Compute the index to write the next element into.
    int nextElemIndex = (writeIndex + (getMaxCapacity() - unconsumedElements)) % getMaxCapacity();
    return elements[nextElemIndex];
  }

  /**
   * Remove the next element in the circular buffer. This will be the first element placed in the
   * circular buffer.
   * @return The next element in the circular buffer, which will just be removed.
   */
  public T remove() {
    T result = peek();
    unconsumedElements--;
    return result;
  }

  /**
   * Return the current size of the circular buffer, which is the number of elements in the
   * circular buffer at the moment.
   * @return Current number of elements in the circular buffer.
   */
  public int getCurrentSize() {
    return unconsumedElements;
  }
}
