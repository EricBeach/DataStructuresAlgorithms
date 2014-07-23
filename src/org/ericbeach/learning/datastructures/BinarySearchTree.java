package org.ericbeach.learning.datastructures;

/**
 * A binary search tree.
 * @param <T> Generic type.
 */
public class BinarySearchTree <T extends Comparable<? super T>> {
  private BinarySearchTreeNode<T> rootNode;

  /**
   * Perform a binary search for a node using the binary search tree.
   * @param targetVal
   */
  public BinarySearchTreeNode<T> search(T targetVal) {
    return performBinarySearch(targetVal, rootNode);
  }

  /**
   * Perform the binary search recursively.
   * 
   * The algorithm is roughly as follows:
   * 1. Begin at the root node (i.e., the top of the tree -- this node has
   * no parents).
   * 2. If the current node, Node C, is null (i.e., there is no node), Node X
   * was not found and the search is finished. If there is a Node C, proceed.
   * (During the first step of the algorithm, the current node is set to
   * the root node).
   * 3. Compare the value of Node X to the value of the current node, Node C.
   * 3.A -- If Node X == Node C, you found the value and the binary search is
   * finished.
   * 3.B -- If Node X < Node C, move to the left child by setting the current
   * node to be evaluated, Node C, to the left child. Move to step 2.
   * 3.C. -- If Node X > Node C, move to the right child by setting the current
   * node to be evaluated, Node C, to the right child. Move to step 2.
   * 
   * @param targetValue The value to be searched for.
   * @param currentRootNode The current root node. This is set recursively as
   *     you move down the tree where each child is its own sub tree.
   * @return The node with the value being searched for or null if not found.
   */
  private BinarySearchTreeNode<T> performBinarySearch(T targetValue,
                                                      BinarySearchTreeNode<T> currentRootNode) {
    // BASE CASE
    if (currentRootNode == null) {
      return null;
    }

    // RECURSIVE CASE
    if (currentRootNode.getValue().compareTo(targetValue) == 0) {
      return currentRootNode;
    } else if (currentRootNode.getValue().compareTo(targetValue) > 0) {
      return performBinarySearch(targetValue, currentRootNode.getLeftChild());
    } else if (currentRootNode.getValue().compareTo(targetValue) < 0) {
      return performBinarySearch(targetValue, currentRootNode.getRightChild());
    }
    return null;
  }

  /**
   * The size of the BST, calculated as the number of nodes including this one.
   * @param node The root node of the tree whose size needs to be computed.
   * @return The size of the binary search tree.
   */
  public int size(BinarySearchTreeNode<T> node) {
    if (node == null) {
      return 0;
    }
    // Compute the size of the BST by adding the current node (1) and then recursively
    // computing the size of the left and right child.
    return 1 + size(node.getLeftChild()) + size(node.getRightChild());
  }

  /**
   * Insert a value into the BST.
   * @param val The value to be inserted into the BST.
   */
  public void insert(T val) {
    insert(new BinarySearchTreeNode<T>(val));
  }

  /**
   * Insert a node into the BST.
   * @param newNode The node to be inserted into the BST.
   */
  public void insert(BinarySearchTreeNode<T> newNode) {
    BinarySearchTreeNode<T> parentNode = null;
    BinarySearchTreeNode<T> nextNodePos = rootNode;

    // Traverse down the tree to find the position where the next node
    // should exist, which is where we will insert it.
    while (nextNodePos != null) {
      parentNode = nextNodePos;
      if (nextNodePos.getValue().compareTo(newNode.getValue()) == 0) {
        // Attempting to insert duplicate value, so drop it. This BST cannot handle duplicates.
        return;
      } else if (nextNodePos.getValue().compareTo(newNode.getValue()) > 0) {
        nextNodePos = nextNodePos.getLeftChild();
      } else if (nextNodePos.getValue().compareTo(newNode.getValue()) < 0) {
        nextNodePos = nextNodePos.getRightChild();
      }
    }

    newNode.setParent(parentNode);

    if (parentNode == null) {
      rootNode = newNode;
    } else  if (parentNode.getValue().compareTo(newNode.getValue()) > 0) {
      parentNode.setLeftChild(newNode);
    } else if (parentNode.getValue().compareTo(newNode.getValue()) < 0) {
      parentNode.setRightChild(newNode);
    }
  }

  /**
   * Delete a value from the BST.
   * @param value The value of the node to be deleted from the BST.
   */
  public void deleteNode(T value) {
    BinarySearchTreeNode<T> nodeToDelete = search(value);

    /**
     * Case 0: Attempting to delete a node that does not exist.
     */
    if (nodeToDelete == null) {
      return;
    }

    /**
     * Case 1: Node to be deleted has zero children, so just delete.
     */
    if (nodeToDelete.getNumChildren() == 0) {
      // Delete the node and re-wire the parent.
      // Ensure that we delete the proper child from the deleted node's parent.
      if (nodeToDelete.getParent().getLeftChild() != null &&
          nodeToDelete.getParent().getLeftChild().getValue() == value) {
        // Node to delete is a left-child.
        nodeToDelete.getParent().setLeftChild(null);
      } else {
        // Node to delete is a right-child.
        nodeToDelete.getParent().setRightChild(null);
      }
    }

    /**
     * Case 2: Node to be deleted has one child.
     */
    if (nodeToDelete.getNumChildren() == 1) {
      BinarySearchTreeNode<T> newChild;
      // Re-write the deleted child's parent to be the deleted node's parent.
      if (nodeToDelete.getLeftChild() != null) {
        newChild = nodeToDelete.getLeftChild();
      } else {
        newChild = nodeToDelete.getRightChild();        
      }
      newChild.setParent(nodeToDelete.getParent());

      // Delete the node.
      if (nodeToDelete.getParent().getLeftChild() != null &&
          nodeToDelete.getParent().getLeftChild().getValue() == value) {
        // Node to delete is a left-child.
        nodeToDelete.getParent().setLeftChild(newChild);
      } else {
        // Node to delete is a right-child.
        nodeToDelete.getParent().setRightChild(newChild);
      }
    }

    /**
     * Case 3: Node to be deleted has two children.
     */
    if (nodeToDelete.getNumChildren() == 2) {
      // Part A: Find the successor of the node you desire to delete.
      BinarySearchTreeNode<T> successor = nodeToDelete.getSuccessorNode();

      // Part B: Swap the to-delete node with the successor node.
      T temp = nodeToDelete.getValue();
      nodeToDelete.setValue(successor.getValue());
      successor.setValue(temp);

      // Part C: Delete to delete node, which has been swapped and is now
      // guaranteed to fall into the case of having zero children or one child.
      // Run delete on successor since successor now holds the value we want
      // to delete.
      deleteNode(successor.getValue());
    }

    nodeToDelete = null;
  }

  /**
   * Delete a specific node from from the BST.
   * @param node The node to be deleted from the BST.
   */
  public void deleteNode(BinarySearchTreeNode<T> node) {
    deleteNode(node.getValue());
  }
}
