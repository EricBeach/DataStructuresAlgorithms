package org.ericbeach.learning.datastructures;

/**
 * A node that is a part of a binary search tree.
 * @param <T> Generic type.
 */
public class BinarySearchTreeNode <T extends Comparable<? super T>> {
  private T value;
  private BinarySearchTreeNode<T> parent;
  private BinarySearchTreeNode<T> leftChild;
  private BinarySearchTreeNode<T> rightChild;

  /**
   * Construct a binary search tree node to store a value.
   * @param val Value to be stored in the node.
   */
  public BinarySearchTreeNode(T val) {
    value = val;
  }

  /**
   * Return the value stored in the BST node.
   * @return The value stored in the BST node.
   */
  public T getValue() {
    return value;
  }

  /**
   * Set the value to be stored in the BST node.
   * @param val The value to be stored in the BST node.
   */
  public void setValue (T val) {
    value = val;
  }

  /**
   * Return the parent of the BST node.
   * @return The parent of the BST node.
   */
  public BinarySearchTreeNode<T> getParent() {
    return parent;
  }

  /**
   * Set the node's parent node.
   * @param parentNode Node's parent.
   */
  public void setParent(BinarySearchTreeNode<T> parentNode) {
    parent = parentNode;
  }

  /**
   * Return the node's left child.
   * @return Node's left child.
   */
  public BinarySearchTreeNode<T> getLeftChild() {
    return leftChild;
  }

  /**
   * Set the node's left child.
   * @param node Node's left child.
   */
  public void setLeftChild(BinarySearchTreeNode<T> node) {
    leftChild = node;
  }

  /**
   * Return the night child.
   * @return The right child node.
   */
  public BinarySearchTreeNode<T> getRightChild() {
    return rightChild;
  }

  /**
   * Set the right child node.
   * @param node The right node.
   */
  public void setRightChild(BinarySearchTreeNode<T> node) {
    rightChild = node;
  } 

  /**
   * Find and return the minimum node in the BST whose root is this node.
   * @return The minimum node.
   */
  public BinarySearchTreeNode<T> getMinimumNode() {
    BinarySearchTreeNode<T> nextLeft = this;
    while (nextLeft.leftChild != null) {
      nextLeft = nextLeft.leftChild;
    }
    return nextLeft;
  }

  /**
   * Find and return the maximum node in the BST whose root is this node.
   * @return The maximum node.
   */
  public BinarySearchTreeNode<T> getMaximumNode() {
    BinarySearchTreeNode<T> nextRight = this;
    while (nextRight.rightChild != null) {
      nextRight = nextRight.rightChild;
    }
    return nextRight;
  }

  /**
   * Compute and return the predecessor node. The predecessor node is the node
   * whose value is the next smallest than this node.
   * @return The predecessor node.
   */
  public BinarySearchTreeNode<T> getPredecessorNode() {
    /**
     * Case 1: Node has left child
     * If a node X has a left child, then node X's predecessor node is the
     * maximum value of the left child node (i.e., you perform the maximum
     * operation on that left child). The result of performing the maximum
     * operation on the left child could either be the left child itself
     * (if the left child has no right child) or you trace all the way down
     * the right until you reach the leaf node (which would be the maximum).
     */
    if (leftChild != null) {
      return leftChild.getMaximumNode();
    }

    /**
     * Case 2: Node has no left child
     * If a node X has no left child, then node X's predecessor is found by
     * tracing back up the tree until you find a node that is a right child.
     * X's predecessor is the parent of that right child. In other words,
     * if node X has no left child, you trace back up the tree until you have
     * the first opportunity to turn left and X's successor is the first node
     * after turning left as you traverse back up the graph. It is important
     * that X might be the first node that is a right child.
     */
    // Seed the operation by starting with the current node as a parent.
    BinarySearchTreeNode<T> parentNode = this;
    while (parentNode != null) {
      if (parentNode.parent != null &&
          parentNode.parent.rightChild == parentNode) {
        return parentNode.parent;
      }

      // Walk up the tree.
      parentNode = parentNode.parent;
    }
    return null;
  }

  /**
   * Compute and return the predecessor node. The successor node is the node
   * whose value is the next largest than this node.
   * @return The successor node.
   */
  public BinarySearchTreeNode<T> getSuccessorNode() {
    /**
     * Case 1: Node has right child
     * If a node X has a right child, then node X's successor node is the
     * minimum value of the right child node (i.e., you perform the minimum
     * operation on that right child). The result of performing the minimum
     * operation on the right child could either be the right child itself
     * (if the right child has no left child) or you trace all the way down
     * the left until you reach the leaf node (which would be the minimum).
     */
    if (rightChild != null) {
      return rightChild.getMinimumNode();
    }

    /**
     * If a node X has no right child, then node X's successor is found by
     * tracing back up the tree until you find a node that is a left child.
     * X's successor is the parent of that left child's. In other words,
     * if node X has no right child, you trace back up the tree until you
     * have the first opportunity to turn right and X's successor is the
     * first node after turning right as you traverse back up the graph. 
     */
    // Seed the operation by starting with the current node as a parent.
    BinarySearchTreeNode<T> parentNode = this;
    while (parentNode != null) {
      if (parentNode.parent != null &&
          parentNode.parent.leftChild == parentNode) {
        return parentNode.parent;
      }

      // Walk up the tree.
      parentNode = parentNode.parent;
    }
    return null; 
  }

  /**
   * Compute the number of children a node has, not including itself.
   * @return Number of children this BST has.
   */
  public int getNumChildren() {
    int numChildren = 0;
    if (leftChild != null) {
      numChildren++;
    }
    if (rightChild != null) {
      numChildren++;
    }
    return numChildren;
  }
}
