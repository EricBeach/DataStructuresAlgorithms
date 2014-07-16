package org.ericbeach.learning.datastructures;

import org.ericbeach.learning.datastructures.BinarySearchTreeNode;

import junit.framework.TestCase;

/**
 * Test the binary search tree node.
 */
public class BinarySearchTreeNodeTest extends TestCase {
  BinarySearchTreeNode<String> nodeL = null;
  BinarySearchTreeNode<String> nodeG = null;
  BinarySearchTreeNode<String> nodeA = null;
  BinarySearchTreeNode<String> nodeE = null;
  BinarySearchTreeNode<String> nodeI = null;
  BinarySearchTreeNode<String> nodeK = null;
  BinarySearchTreeNode<String> nodeQ = null;
  BinarySearchTreeNode<String> nodeO = null;
  BinarySearchTreeNode<String> nodeT = null;
  BinarySearchTreeNode<String> nodeW = null;
  
  protected void setUp() {
    nodeL = new BinarySearchTreeNode<String>("L");
    nodeG = new BinarySearchTreeNode<String>("G");
    nodeA = new BinarySearchTreeNode<String>("A");
    nodeE = new BinarySearchTreeNode<String>("E");
    nodeI = new BinarySearchTreeNode<String>("I");
    nodeK = new BinarySearchTreeNode<String>("K");
    nodeQ = new BinarySearchTreeNode<String>("Q");
    nodeO = new BinarySearchTreeNode<String>("O");
    nodeT = new BinarySearchTreeNode<String>("T");
    nodeW = new BinarySearchTreeNode<String>("W");

    // Set the root node.
    nodeL.setLeftChild(nodeG);
    
    // Set the left half of the tree.
    nodeG.setParent(nodeL);
    nodeG.setLeftChild(nodeA);
    nodeA.setParent(nodeG);
    nodeA.setRightChild(nodeE);
    nodeE.setParent(nodeA);
    nodeG.setRightChild(nodeI);
    nodeI.setParent(nodeG);
    nodeI.setRightChild(nodeK);
    nodeK.setParent(nodeI);
    
    // Set the right half of the tree.
    nodeQ.setParent(nodeL);
    nodeL.setRightChild(nodeQ);
    nodeO.setParent(nodeQ);
    nodeQ.setLeftChild(nodeO);
    nodeQ.setRightChild(nodeT);
    nodeT.setParent(nodeQ);
    nodeT.setRightChild(nodeW);
    nodeW.setParent(nodeT);
  }
  
  protected void tearDown() {
    nodeL = null;
    nodeG = null;
    nodeA = null;
    nodeE = null;
    nodeI = null;
    nodeK = null;
    nodeQ = null;
    nodeO = null;
    nodeT = null;
    nodeW = null;
  }
  
  public void testCanGetValueFromBinarySearchTreeNode() {
    assertEquals("L", nodeL.getValue());
    assertEquals("G", nodeG.getValue());
    assertEquals("A", nodeA.getValue());
  }

  public void testGetMaximumNode() {
    assertEquals(nodeW, nodeL.getMaximumNode());
    assertEquals(nodeK, nodeG.getMaximumNode());
    assertEquals(nodeE, nodeE.getMaximumNode());
    assertEquals(nodeW, nodeQ.getMaximumNode());
    assertEquals(nodeO, nodeO.getMaximumNode());
    assertEquals(nodeW, nodeW.getMaximumNode());
  }

  public void testGetMinimumOfBinarySearchTree() {
    assertEquals(nodeA, nodeL.getMinimumNode());
    assertEquals(nodeA, nodeG.getMinimumNode());
    assertEquals(nodeE, nodeE.getMinimumNode());
    assertEquals(nodeO, nodeQ.getMinimumNode());
    assertEquals(nodeO, nodeO.getMinimumNode());
    assertEquals(nodeW, nodeW.getMinimumNode());
  }
  
  public void testGetPredecessorNodeInBinarySearchTree() {
    assertEquals(nodeK, nodeL.getPredecessorNode());
    assertEquals(nodeO, nodeQ.getPredecessorNode());
    assertEquals(nodeE, nodeG.getPredecessorNode());
    assertEquals(nodeI, nodeK.getPredecessorNode());

    assertEquals(nodeQ, nodeT.getPredecessorNode());
    assertEquals(nodeL, nodeO.getPredecessorNode());
    assertEquals(nodeA, nodeE.getPredecessorNode());
    assertEquals(null, nodeA.getPredecessorNode());
  }

  public void testGetSuccessorNodeInBinarySearchTree() {
    assertEquals(nodeO, nodeL.getSuccessorNode());
    assertEquals(nodeT, nodeQ.getSuccessorNode());
    assertEquals(nodeI, nodeG.getSuccessorNode());
    assertEquals(nodeL, nodeK.getSuccessorNode());

    assertEquals(nodeW, nodeT.getSuccessorNode());
    assertEquals(nodeQ, nodeO.getSuccessorNode());
    assertEquals(nodeG, nodeE.getSuccessorNode());
    assertEquals(null, nodeW.getSuccessorNode());
  }
}
