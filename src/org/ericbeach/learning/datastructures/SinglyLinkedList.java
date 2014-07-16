package org.ericbeach.learning.datastructures;

/**
 * Implementation of a singly linked list.
 * @param <T> Generic type.
 */
public class SinglyLinkedList<T extends Comparable<? super T>> {
  private SinglyLinkedListNode<T> start;
  private SinglyLinkedListNode<T> end;
  private int size = 0;
 
  /**
   * Insert a node into the singly linked list at a specific index.
   * @param index The index number to insert the node at. This is the final
   *     index of the new node.
   * @param newNode The new node to insert.
   */
  public void insertNode(int index, SinglyLinkedListNode<T> newNode) {
    // Check for out of bounds insertion.
    if (index > size) {
      return;
    }
    
    if (size == 0) {
      // Deal with special case of the first node.
      start = newNode;
    } else if (index == 0) {
      // Deal with special case of inserting at beginning of list.
      newNode.setNextNode(start);
    } else  {
      // General case of inserting with existing nodes.
      SinglyLinkedListNode<T> current = start;
      for (int i = 0; i < index - 1; i++) {
        current = current.getNextNode(); 
      }
      
      newNode.setNextNode(current.getNextNode());
      current.setNextNode(newNode);  
    }
    
    // Reset start and end node, if necessary
    if (index == size) {
      end = newNode;
    }
    if (index == 0) {
      start = newNode;
    }
    size++;
  }
  
  /**
   * Append a node to the end of the list.
   * @param newNode Node to be appended.
   */
  public void appendNode(SinglyLinkedListNode<T> newNode) {
    insertNode(size, newNode);
  }
  
  /**
   * Delete a node at a specific index.
   * @param index The index of the element to be deleted.
   * @return The node that is deleted.
   */
  public SinglyLinkedListNode<T> deleteNode(int index) {
    // Check for out of bounds insertion.
    if (index > size) {
      return null;
    }
    
    SinglyLinkedListNode<T> deleteNode = null;
    SinglyLinkedListNode<T> newNextNode = null;
    
    // Find the node before the node we want to delete.
    SinglyLinkedListNode<T> current = start;
    for (int i = 0; i < index - 1; i++) {
      current = current.getNextNode(); 
    }
    
    // Deal with special cases.
    if (size == 1) {
      deleteNode = current;
    } else if (index == 0) {
      deleteNode = current;
    } else if (index == size) {
      deleteNode = current.getNextNode();
    } else {
      deleteNode = current.getNextNode();
      newNextNode = current.getNextNode().getNextNode();
      current.setNextNode(newNextNode); 
    }
    
    size--;
    return deleteNode;
  }
  
  /**
   * Return the size of the list.
   * @return The size of the linked list.
   */
  public int getSize() {
    return size;
  }
}
