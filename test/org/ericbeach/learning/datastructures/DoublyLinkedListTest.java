package org.ericbeach.learning.datastructures;

import junit.framework.TestCase;

/**
 * Tests for a doubly linked list.
 */
public class DoublyLinkedListTest extends TestCase {
  private DoublyLinkedList<String> list;
  private DoublyLinkedListNode<String> node01;
  private DoublyLinkedListNode<String> node02;
  private DoublyLinkedListNode<String> node03;
  private DoublyLinkedListNode<String> node04;
  private DoublyLinkedListNode<String> node05;
  private DoublyLinkedListNode<String> node06;
  private DoublyLinkedListNode<String> node07;
  private DoublyLinkedListNode<String> node08;
  private DoublyLinkedListNode<String> node09;
  private DoublyLinkedListNode<String> node10;
  
  public void setUp() {
    list = new DoublyLinkedList<String>();
    
    node01 = new DoublyLinkedListNode<String>("");
    node02 = new DoublyLinkedListNode<String>("");
    node03 = new DoublyLinkedListNode<String>("");
    node04 = new DoublyLinkedListNode<String>("");
    node05 = new DoublyLinkedListNode<String>("");
    node06 = new DoublyLinkedListNode<String>("");
    node07 = new DoublyLinkedListNode<String>("");
    node08 = new DoublyLinkedListNode<String>("");
    node09 = new DoublyLinkedListNode<String>("");
    node10 = new DoublyLinkedListNode<String>("");
  }
  
  public void tearDown() {
    list = null;
    
    node01 = null;
    node02 = null;
    node03 = null;
    node04 = null;
    node05 = null;
    node06 = null;
    node07 = null;
    node08 = null;
    node09 = null;
    node10 = null;
  }
  
  private void populateFirstFiveNodes(DoublyLinkedList<String> list) {
    list.appendNode(node01);
    list.appendNode(node02);
    list.appendNode(node03);
    list.appendNode(node04);
    list.appendNode(node05);
  }
  
  public void testappendNode() {
    populateFirstFiveNodes(list);

    list.appendNode(node06);
    list.appendNode(node07);
    list.appendNode(node08);
    list.appendNode(node09);
    list.appendNode(node10);
    assertEquals(10, list.getSize());
    
    assertEquals(node02, node01.getNextNode());
    assertEquals(node03, node02.getNextNode());
    assertEquals(node04, node03.getNextNode());
    assertEquals(node05, node04.getNextNode());
    assertEquals(node06, node05.getNextNode());
    assertEquals(node07, node06.getNextNode());
    assertEquals(node08, node07.getNextNode());
    assertEquals(node09, node08.getNextNode());
    assertEquals(node10, node09.getNextNode());
    assertEquals(null, node10.getNextNode());

    assertEquals(null, node01.getPreviousNode());
    assertEquals(node01, node02.getPreviousNode());
    assertEquals(node02, node03.getPreviousNode());
    assertEquals(node03, node04.getPreviousNode());
    assertEquals(node04, node05.getPreviousNode());
    assertEquals(node05, node06.getPreviousNode());
    assertEquals(node06, node07.getPreviousNode());
    assertEquals(node07, node08.getPreviousNode());
    assertEquals(node08, node09.getPreviousNode());
    assertEquals(node09, node10.getPreviousNode());
  }
  
  public void testSequentialinsertNode() {
    list.insertNode(0, node01);
    assertEquals(null, node01.getNextNode());
    assertEquals(null, node01.getPreviousNode());
    
    list.insertNode(1, node02);
    assertEquals(node02, node01.getNextNode());
    assertEquals(null, node01.getPreviousNode());
    assertEquals(null, node02.getNextNode());
    assertEquals(node01, node02.getPreviousNode());

    list.insertNode(2, node03);
    assertEquals(node03, node02.getNextNode());
    assertEquals(node01, node02.getPreviousNode());
    assertEquals(null, node03.getNextNode());
    assertEquals(node02, node03.getPreviousNode());
    
    list.insertNode(3, node04);
    assertEquals(node04, node03.getNextNode());
    assertEquals(node02, node03.getPreviousNode());
    assertEquals(null, node04.getNextNode());
    assertEquals(node03, node04.getPreviousNode());

    list.insertNode(4, node05);
    assertEquals(node05, node04.getNextNode());
    assertEquals(node03, node04.getPreviousNode());
    assertEquals(null, node05.getNextNode());
    assertEquals(node04, node05.getPreviousNode());
    
    assertEquals(5, list.getSize());
  }
  
  public void testNonSequentialinsertNode() {
    populateFirstFiveNodes(list);
    assertEquals(5, list.getSize());
    
    list.insertNode(0, node08);
    // List is 08 -> 01 -> 02 -> 03 -> 04 -> 05
    assertEquals(node01, node08.getNextNode());
    assertEquals(null, node08.getPreviousNode());
    assertEquals(node02, node01.getNextNode());
    assertEquals(node08, node01.getPreviousNode());
    assertEquals(node01, node02.getPreviousNode());
    assertEquals(6, list.getSize());
    
    list.insertNode(1, node09);
    // List is 08 -> 09 -> 01 -> 02 -> 03 -> 04 -> 05
    assertEquals(node09, node08.getNextNode());
    assertEquals(null, node08.getPreviousNode());
    assertEquals(node01, node09.getNextNode());
    assertEquals(node08, node09.getPreviousNode());
    assertEquals(node09, node01.getPreviousNode());
    assertEquals(7, list.getSize());
    
    list.insertNode(6, node07);
    // List is 08 -> 09 -> 01 -> 02 -> 03 -> 04 -> 07 -> 05
    assertEquals(node05, node07.getNextNode());
    assertEquals(node04, node07.getPreviousNode());
    assertEquals(node03, node04.getPreviousNode());
    assertEquals(node07, node05.getPreviousNode());
    assertEquals(null, node05.getNextNode());
    assertEquals(8, list.getSize());
  }
  
  public void testDeleteNodeBackToFront() {
    populateFirstFiveNodes(list);
    assertEquals(5, list.getSize());
    
    // List is 01 -> 02 -> 03 -> 04 -> 05
    assertEquals(node02, node01.getNextNode());
    assertEquals(null, node01.getPreviousNode());
    assertEquals(node01, node02.getPreviousNode());
    assertEquals(node02, node03.getPreviousNode());
    assertEquals(node03, node02.getNextNode());
    
    list.deleteNode(2);
    // List is 01 -> 02 -> 04 -> 05
    assertEquals(node04, node02.getNextNode());
    assertEquals(node02, node01.getNextNode());
    assertEquals(node01, node02.getPreviousNode());
    assertEquals(node02, node04.getPreviousNode());
    assertEquals(4, list.getSize());
    
    list.deleteNode(2);
    // List is 01 -> 02 -> 05
    assertEquals(node05, node02.getNextNode());
    assertEquals(node01, node02.getPreviousNode());
    assertEquals(node02, node05.getPreviousNode());
    assertEquals(3, list.getSize());
        
    list.deleteNode(1);
    // List is 01 -> 05
    assertEquals(node01, node05.getPreviousNode());
    assertEquals(null, node05.getNextNode());
    assertEquals(2, list.getSize());
    
    list.deleteNode(1);
    // List is 01
    assertEquals(null, node01.getNextNode());
    assertEquals(null, node01.getPreviousNode());
    assertEquals(1, list.getSize());
  }
  
  public void testDeleteNodeFrontToBack() {
    populateFirstFiveNodes(list);
    assertEquals(5, list.getSize());
    
    // List is 01 -> 02 -> 03 -> 04 -> 05
    assertEquals(node02, node01.getNextNode());

    list.deleteNode(0);
    // List is 02 -> 03 -> 04 -> 05
    assertEquals(node03, node02.getNextNode());
    assertEquals(4, list.getSize());
    
    list.deleteNode(0);
    // List is 03 -> 04 -> 05
    assertEquals(node04, node03.getNextNode());
    assertEquals(3, list.getSize());
    
    list.deleteNode(0);
    // List is 04 -> 05
    assertEquals(node05, node04.getNextNode());
    assertEquals(2, list.getSize());

    list.deleteNode(0);
    // List is 05
    assertEquals(null, node05.getNextNode());
    assertEquals(1, list.getSize());
  }
}
