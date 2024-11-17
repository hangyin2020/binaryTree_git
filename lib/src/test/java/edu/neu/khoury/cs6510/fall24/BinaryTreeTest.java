package edu.neu.khoury.cs6510.fall24;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Testing BinaryTrees interface methods.
 */
public class BinaryTreeTest {

  private BinaryTree mt = BinaryTree.MT;

  @Test
  void testHighestValue() {
    assertThrows(InvalidBTOperationException.class, () -> mt.highestValue());
    assertEquals(1, BinaryTree.make(1, mt, mt).highestValue());
    assertEquals(10, BinaryTree.make(1, BinaryTree.make(10, mt, mt), mt).highestValue());
    assertEquals(10, BinaryTree.make(1, mt, BinaryTree.make(10, mt, mt)).highestValue());
    assertEquals(10,
        BinaryTree.make(1, BinaryTree.make(3, mt, mt), BinaryTree.make(10, mt, mt)).highestValue());
    assertEquals(10, BinaryTree.make(10, BinaryTree.make(3, mt, mt), BinaryTree.make(10, mt, mt))
        .highestValue());
    assertEquals(10, BinaryTree.make(10, BinaryTree.make(10, mt, mt), BinaryTree.make(3, mt, mt))
        .highestValue());
  }

  @Test
  void testIsBst() {
    assertTrue(mt.isBst());
    assertTrue(BinaryTree.make(1, mt, mt).isBst());

    assertTrue(BinaryTree.make(2, BinaryTree.make(1, mt, mt), BinaryTree.make(6, mt, mt)).isBst());

    assertFalse(BinaryTree.make(3, BinaryTree.make(1, mt, mt), BinaryTree.make(2, mt, mt)).isBst());


    assertFalse(
        BinaryTree.make(3, BinaryTree.make(10, mt, mt), BinaryTree.make(20, mt, mt)).isBst());

    assertFalse(BinaryTree
        .make(5, BinaryTree.make(3, BinaryTree.make(1, mt, mt), BinaryTree.make(6, mt, mt)),
            BinaryTree.make(10, mt, mt))
        .isBst());

    assertTrue(
        BinaryTree
            .make(10, BinaryTree.make(5, BinaryTree.make(1, mt, mt), BinaryTree.make(6, mt, mt)),
                BinaryTree.make(20, BinaryTree.make(15, mt, mt), BinaryTree.make(30, mt, mt)))
            .isBst());

  }

  @Test
  void testIsMt() {
    assertTrue(mt.isMt());
    assertFalse(BinaryTree.make(1, mt, mt).isMt());
  }

  @Test
  void testMake() {
    BinaryTree leaf = BinaryTree.make(1, mt, mt);
    assertEquals(1, leaf.value());
    assertEquals(mt, leaf.left());
    assertEquals(mt, leaf.right());

    BinaryTree t211 = BinaryTree.make(2, leaf, leaf);
    assertEquals(2, t211.value());
    assertEquals(leaf, t211.left());
    assertEquals(leaf, t211.right());

  }

  @Test
  void testMaxDepth() {
    assertEquals(0, mt.maxDepth());
    assertEquals(1, BinaryTree.make(1, mt, mt).maxDepth());

    BinaryTree line = BinaryTree.make(4, mt,
        BinaryTree.make(3, mt, BinaryTree.make(2, mt, BinaryTree.make(1, mt, mt))));

    assertEquals(4, line.maxDepth());

    BinaryTree isosceles = BinaryTree.make(1, line, line);
    assertEquals(5, isosceles.maxDepth());
  }

  @Test
  void testLeft() {
    assertThrows(InvalidBTOperationException.class, () -> mt.left());
  }


  @Test
  void testRight() {
    assertThrows(InvalidBTOperationException.class, () -> mt.right());
  }

  @Test
  void testValue() {
    assertThrows(InvalidBTOperationException.class, () -> mt.value());
  }

}
