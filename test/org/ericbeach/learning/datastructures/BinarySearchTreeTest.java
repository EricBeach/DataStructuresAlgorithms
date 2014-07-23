package org.ericbeach.learning.datastructures;

import junit.framework.TestCase;

/**
 * Test the binary search tree.
 */
public class BinarySearchTreeTest extends TestCase {
  BinarySearchTreeNode<String> sL = null;
  BinarySearchTreeNode<String> sG = null;
  BinarySearchTreeNode<String> sA = null;
  BinarySearchTreeNode<String> sE = null;
  BinarySearchTreeNode<String> sI = null;
  BinarySearchTreeNode<String> sK = null;
  BinarySearchTreeNode<String> sQ = null;
  BinarySearchTreeNode<String> sO = null;
  BinarySearchTreeNode<String> sT = null;
  BinarySearchTreeNode<String> sW = null;
  
  BinarySearchTree<String> bst = null;
  
  protected void setUp() {
    sL = new BinarySearchTreeNode<String>("L");
    sG = new BinarySearchTreeNode<String>("G");
    sA = new BinarySearchTreeNode<String>("A");
    sE = new BinarySearchTreeNode<String>("E");
    sI = new BinarySearchTreeNode<String>("I");
    sK = new BinarySearchTreeNode<String>("K");
    sQ = new BinarySearchTreeNode<String>("Q");
    sO = new BinarySearchTreeNode<String>("O");
    sT = new BinarySearchTreeNode<String>("T");
    sW = new BinarySearchTreeNode<String>("W");
    
    bst = new BinarySearchTree<String>();
  }
  
  protected void manuallySetupTree() {
    // Set the root node. 
    bst.insert(sL);
    
    // Set the left half of the tree.
    sL.setLeftChild(sG);
    sG.setParent(sL);
    sG.setLeftChild(sA);
    sA.setParent(sG);
    sA.setRightChild(sE);
    sE.setParent(sA);
    sG.setRightChild(sI);
    sI.setParent(sG);
    sI.setRightChild(sK);
    sK.setParent(sI);
    
    // Set the right half of the tree.
    sQ.setParent(sL);
    sL.setRightChild(sQ);
    sO.setParent(sQ);
    sQ.setLeftChild(sO);
    sQ.setRightChild(sT);
    sT.setParent(sQ);
    sT.setRightChild(sW);
    sW.setParent(sT);
  }
  
  protected void tearDown() {
    sL = null;
    sG = null;
    sA = null;
    sE = null;
    sI = null;
    sK = null;
    sQ = null;
    sO = null;
    sT = null;
    sW = null;
  }
  
  public void testSize() {
    manuallySetupTree();
 
    assertEquals(10, bst.size(sL));
    assertEquals(2, bst.size(sI));
    assertEquals(1, bst.size(sW));
  }
  
  public void testSearch() {
    manuallySetupTree();

    assertEquals(null, bst.search("N/A"));
    assertEquals(sL, bst.search("L"));
    assertEquals(sG, bst.search("G"));
    assertEquals(sA, bst.search("A"));
    assertEquals(sE, bst.search("E"));
    assertEquals(sI, bst.search("I"));
    assertEquals(sK, bst.search("K"));
    assertEquals(sQ, bst.search("Q"));
    assertEquals(sO, bst.search("O"));
    assertEquals(sT, bst.search("T"));
    assertEquals(sW, bst.search("W"));
  }

  public void testInsert() {
    bst.insert(sL);
    
    bst.insert(sL);
    bst.insert(sG);
    bst.insert(sA);
    bst.insert(sE);
    bst.insert(sI);
    bst.insert(sK);
    bst.insert(sQ);
    bst.insert(sO);
    bst.insert(sT);
    bst.insert(sW);
    
    assertEquals(sG, sL.getLeftChild());
    assertEquals(sQ, sL.getRightChild());
    assertEquals(sA, sG.getLeftChild());
    assertEquals(sI, sG.getRightChild());
    assertEquals(null, sI.getLeftChild());
    assertEquals(sK, sI.getRightChild());
    assertEquals(null, sA.getLeftChild());
    assertEquals(sE, sA.getRightChild());
  }
  
  public void testDeleteNodeOneByOne() {
    manuallySetupTree();
    
    assertEquals(sW, bst.search("W"));
    bst.deleteNode("W");
    assertEquals(null, bst.search("W"));
    
    tearDown();
    setUp();
    manuallySetupTree();
    
    assertEquals(sO, bst.search("O"));
    bst.deleteNode("O");
    assertEquals(null, bst.search("O"));
    
    tearDown();
    setUp();
    manuallySetupTree();
    
    assertEquals(sA, bst.search("A"));
    bst.deleteNode("A");
    assertEquals(null, bst.search("A"));    

    tearDown();
    setUp();
    manuallySetupTree();
    
    assertEquals(sL, bst.search("L"));
    bst.deleteNode("L");
    assertEquals(null, bst.search("L"));
  }
  
  public void testDeleteNodeSuccession() {
    manuallySetupTree();
   
    assertEquals(sL, bst.search("L"));
    assertEquals(sG, bst.search("G"));
    assertEquals(sQ, bst.search("Q"));
    assertEquals(sO, bst.search("O"));
    assertEquals(sT, bst.search("T"));
    assertEquals(sW, bst.search("W"));
    assertEquals(sK, bst.search("K"));
    assertEquals(sE, bst.search("E"));
  
    bst.deleteNode("L");
    assertEquals(null, bst.search("L"));
    bst.deleteNode("G");
    assertEquals(null, bst.search("G"));
    bst.deleteNode("Q");
    assertEquals(null, bst.search("Q"));
    bst.deleteNode("O");
    assertEquals(null, bst.search("O"));
    bst.deleteNode("T");
    assertEquals(null, bst.search("T"));
    bst.deleteNode("W");
    assertEquals(null, bst.search("W"));
    bst.deleteNode("K");
    assertEquals(null, bst.search("K"));
    bst.deleteNode("E");
    assertEquals(null, bst.search("E"));
  }
}
