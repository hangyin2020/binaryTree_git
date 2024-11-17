package edu.neu.khoury.cs6510.fall24;

/**
 * Represents a BinaryTree (BT) where each node is either empty or contains.
 * 
 * <ol>
 * <li>an Integer value</li>
 * <li>a left sub tree, also a BT</li>
 * <li>a right sub tree, also a BT</li>
 * </ol>
 */
public interface BinaryTree {


  /**
   * Represents the empty Binary Tree.
   */
  public static BinaryTree MT = new MT();

  /**
   * Creates the root node for a binary tree with a value and the left and right sub trees. This
   * method throws {@link IllegalArgumentException} if any of the inputs is <code>null</code>. To
   * create the empty binary tree use {@link MT}.
   *
   * @param value Integer value for the root node. Cannot be <code>null</code>.
   * @param left the value for the left child for the root node.
   * @param right the value for the right child for the root node.
   *
   * @return the root node of the newly created <code>BinaryTree</code>.
   */
  public static BinaryTree make(Integer value, BinaryTree left, BinaryTree right) {
    return new Node(value, left, right);
  }

  /**
   * Checks if this <code>BinaryTree</code> is a binary search tree.
   *
   *
   * @return true if this is a binary search tree, false otherwise.
   */
  boolean isBst();


  /**
   * Returns the maximum depth of this <code>BinaryTree</code>. Maximum depth is the largest number
   * of nodes from the root to a leaf. For the empty binary try the result is <code>0</code>.
   *
   *
   * @return the maximum depth of this tree.
   */
  Integer maxDepth();

  /**
   * Returns the largest integer value stored in this <code>BinaryTree</code>'s nodes. This method
   * throws {@link InvalidBTOperationException} when called on the empty Binary Tree.
   *
   * @return largest integer value stored in this tree.
   */
  Integer highestValue();

  /**
   * Check if this <code>BinaryTree</code> is empty.
   *
   *
   * @return true if this tree is the empty tree, false otherwise.
   */
  boolean isMt();


  /**
   * Returns the left sub tree. Throws {@link InvalidBTOperationException} when called on an empty
   * Binary Tree.
   *
   *
   * @return the left subtree, or throws an exception if this tree is the empty tree.
   */
  BinaryTree left();

  /**
   * Returns the right sub tree. Throws {@link InvalidBTOperationException} when called on an empty
   * Binary Tree.
   *
   *
   * @return the right sub tree, or throws an exception if this tree is the empty tree.
   */
  BinaryTree right();

  /**
   * Returns the value stored at the root node of this tree. Throws
   * {@link InvalidBTOperationException} when called on an empty Binary Tree.
   *
   *
   * @return the value at the root node of this tree, or an exception if this tree is the empty
   *         tree.
   */
  Integer value();
}
