package org.ericbeach.learning.datastructures;

/**
 * Implementation of a doubly linked list.
 * @param <T> Generic type.
 */
public class DoublyLinkedList<T extends Comparable<? super T>> {
  private DoublyLinkedListNode<T> startNode;
  private DoublyLinkedListNode<T> endNode;
  private int size = 0;

  /**
   * Insert a node into the doubly linked list at a specific index.
   * @param index The index number to insert the node at. This is the final
   *     index of the new node.
   * @param newNode The new node to insert.
   */
  public void insertNode(int index, DoublyLinkedListNode<T> newNode) {
    //Check for out of bounds insertion.
    if (index > size) {
      return;
    }

    if (size == 0) {
      // Deal with special case of the first node.
      startNode = newNode;
    } else if (index == 0) {
      // Deal with special case of inserting at beginning of list.
      newNode.setNextNode(startNode);
      if (size > 0) {
        newNode.getNextNode().setPreviousNode(newNode);
      }
    } else  {
      // General case of inserting with existing nodes.
      DoublyLinkedListNode<T> currentNode = startNode;
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNextNode(); 
      }

      newNode.setPreviousNode(currentNode);
      newNode.setNextNode(currentNode.getNextNode());
      currentNode.setNextNode(newNode);
      
      if (newNode.getNextNode() != null) {
        newNode.getNextNode().setPreviousNode(newNode);
      }
    }

    // Reset start and end node, if necessary.
    if (index == size) {
      endNode = newNode;
    }
    if (index == 0) {
      startNode = newNode;
    }
    size++;
  }

  /**
   * Append a node to the end of the list.
   * @param newNode Node to be appended.
   */
  public void appendNode(DoublyLinkedListNode<T> newNode) {
    insertNode(size, newNode);
  }

  /**
   * Delete a node at a specific index.
   * @param index The index of the element to be deleted.
   * @return The node that is deleted.
   */
  public DoublyLinkedListNode<T> deleteNode(int index) {
    // Check for out of bounds insertion.
    if (index > size) {
      return null;
    }

    DoublyLinkedListNode<T> deleteNode = null;
    DoublyLinkedListNode<T> newNextNode = null;
    
    // Find the node before the node we want to delete.
    DoublyLinkedListNode<T> current = startNode;
    for (int i = 0; i < index - 1; i++) {
      current = current.getNextNode(); 
    }

    // Deal with special cases.
    if (size == 1) {
      deleteNode = current;
      startNode = null;
      endNode = null;
    } else if (index == 0) {
      deleteNode = current;
      startNode = current.getNextNode();
    } else if (index == size - 1) {
      deleteNode = current.getNextNode();
      current.setNextNode(null);
      endNode = current;
    } else {
      deleteNode = current.getNextNode();
      newNextNode = current.getNextNode().getNextNode();
      newNextNode.setPreviousNode(current);
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
