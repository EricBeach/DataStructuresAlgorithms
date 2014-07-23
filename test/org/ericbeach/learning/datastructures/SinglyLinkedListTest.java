package org.ericbeach.learning.datastructures;

import junit.framework.TestCase;

/**
 * Tests for a singly linked list.
 */
public class SinglyLinkedListTest extends TestCase {
  private SinglyLinkedList<String> list;
  private SinglyLinkedListNode<String> node01;
  private SinglyLinkedListNode<String> node02;
  private SinglyLinkedListNode<String> node03;
  private SinglyLinkedListNode<String> node04;
  private SinglyLinkedListNode<String> node05;
  private SinglyLinkedListNode<String> node06;
  private SinglyLinkedListNode<String> node07;
  private SinglyLinkedListNode<String> node08;
  private SinglyLinkedListNode<String> node09;
  private SinglyLinkedListNode<String> node10;
  
  public void setUp() {
    list = new SinglyLinkedList<String>();
    
    node01 = new SinglyLinkedListNode<String>("");
    node02 = new SinglyLinkedListNode<String>("");
    node03 = new SinglyLinkedListNode<String>("");
    node04 = new SinglyLinkedListNode<String>("");
    node05 = new SinglyLinkedListNode<String>("");
    node06 = new SinglyLinkedListNode<String>("");
    node07 = new SinglyLinkedListNode<String>("");
    node08 = new SinglyLinkedListNode<String>("");
    node09 = new SinglyLinkedListNode<String>("");
    node10 = new SinglyLinkedListNode<String>("");
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
  
  public void testappendNode() {    
    list.appendNode(node01);
    list.appendNode(node02);
    list.appendNode(node03);
    list.appendNode(node04);
    list.appendNode(node05);
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
  }
  
  public void testSequentialinsertNode() {
    list.insertNode(0, node01);
    assertEquals(null, node01.getNextNode());
    
    list.insertNode(1, node02);
    assertEquals(node02, node01.getNextNode());
    assertEquals(null, node02.getNextNode());

    list.insertNode(2, node03);
    assertEquals(node03, node02.getNextNode());
    assertEquals(null, node03.getNextNode());
    
    list.insertNode(3, node04);
    assertEquals(node04, node03.getNextNode());
    assertEquals(null, node04.getNextNode());

    list.insertNode(4, node05);
    assertEquals(node05, node04.getNextNode());
    assertEquals(null, node05.getNextNode());
    
    assertEquals(5, list.getSize());
  }
  
  public void testNonSequentialinsertNode() {
    list.appendNode(node01);
    list.appendNode(node02);
    list.appendNode(node03);
    list.appendNode(node04);
    list.appendNode(node05);
    assertEquals(5, list.getSize());
    
    list.insertNode(0, node08);
    // List is 08 -> 01 -> 02 -> 03 -> 04 -> 05
    assertEquals(node01, node08.getNextNode());
    assertEquals(node02, node01.getNextNode());
    assertEquals(6, list.getSize());
    
    list.insertNode(1, node09);
    // List is 08 -> 09 -> 01 -> 02 -> 03 -> 04 -> 05
    assertEquals(node09, node08.getNextNode());
    assertEquals(node01, node09.getNextNode());
    assertEquals(7, list.getSize());
    
    list.insertNode(6, node07);
    // List is 08 -> 09 -> 01 -> 02 -> 03 -> 04 -> 07 -> 05
    assertEquals(node05, node07.getNextNode());
    assertEquals(null, node05.getNextNode());
    assertEquals(8, list.getSize());
  }
  
  public void testDeleteNodeBackToFront() {
    list.appendNode(node01);
    list.appendNode(node02);
    list.appendNode(node03);
    list.appendNode(node04);
    list.appendNode(node05);
    assertEquals(5, list.getSize());
    
    // List is 01 -> 02 -> 03 -> 04 -> 05
    assertEquals(node02, node01.getNextNode());
    
    list.deleteNode(2);
    // List is 01 -> 02 -> 04 -> 05
    assertEquals(node04, node02.getNextNode());
    assertEquals(4, list.getSize());
    
    list.deleteNode(2);
    // List is 01 -> 02 -> 05
    assertEquals(node05, node02.getNextNode());
    assertEquals(3, list.getSize());
        
    list.deleteNode(2);
    // List is 01 -> 02
    assertEquals(null, node02.getNextNode());
    assertEquals(2, list.getSize());
    
    list.deleteNode(1);
    // List is 01 -> 02
    assertEquals(null, node01.getNextNode());
    assertEquals(1, list.getSize());
  }
  
  public void testDeleteNodeFrontToBack() {
    list.appendNode(node01);
    list.appendNode(node02);
    list.appendNode(node03);
    list.appendNode(node04);
    list.appendNode(node05);
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
