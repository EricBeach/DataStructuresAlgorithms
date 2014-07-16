package org.ericbeach.learning.datastructures;

/**
 * A doubly linked list node.
 * @param <T> Generic type of data to store in node.
 */
public class DoublyLinkedListNode<T extends Comparable<? super T>> {
  private T value;
  private DoublyLinkedListNode<T> previousNode;
  private DoublyLinkedListNode<T> nextNode;
  
  /**
   * Create a doubly linked list node.
   * @param val The value to be stored in the linked list node.
   */
  public DoublyLinkedListNode(T value) {
    this.value = value;
  }
 
  /**
   * Return the linked list node value. 
   * @return The value in the node.
   */
  public T getValue() {
    return value;
  }

  /**
   * Get the next doubly linked list node.
   * @return The next node in the doubly linked list.
   */
  public DoublyLinkedListNode<T> getNextNode() {
    return nextNode;
  }
  
  /**
   * Set the next node in the linked list.
   * @param next Next node in the linked list.
   */
  public void setNextNode(DoublyLinkedListNode<T> nextNode) {
    this.nextNode = nextNode;
  }
  
  /**
   * Get the previous doubly linked list node.
   * @return The previous node in the doubly linked list.
   */
  public DoublyLinkedListNode<T> getPreviousNode() {
    return previousNode;
  }
  
  /**
   * Set the previous node in the linked list.
   * @param previous Previous node in the linked list.
   */
  public void setPreviousNode(DoublyLinkedListNode<T> previousNode) {
    this.previousNode = previousNode;
  }
}
