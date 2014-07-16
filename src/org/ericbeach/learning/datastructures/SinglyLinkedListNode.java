package org.ericbeach.learning.datastructures;

/**
 * A singly linked list node.
 * @param <T> Generic type of data to store in node.
 */
public class SinglyLinkedListNode<T extends Comparable<? super T>> {
  private T value;
  private SinglyLinkedListNode<T> nextNode;
  
  /**
   * Create a singly linked list node.
   * @param val The value to be stored in the linked list node.
   */
  public SinglyLinkedListNode(T val) {
    value = val;
  }
 
  /**
   * Return the linked list node value. 
   * @return The value in the node.
   */
  public T getValue() {
    return value;
  }

  /**
   * Get the next singly linked list node.
   * @return The next node in the singly linked list.
   */
  public SinglyLinkedListNode<T> getNextNode() {
    return nextNode;
  }
  
  /**
   * Set the next node in the linked list.
   * @param next Next node in the linked list.
   */
  public void setNextNode(SinglyLinkedListNode<T> next) {
    nextNode = next;
  }
}
