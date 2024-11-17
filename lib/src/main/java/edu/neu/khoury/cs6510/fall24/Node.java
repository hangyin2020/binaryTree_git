package edu.neu.khoury.cs6510.fall24;

import java.util.Arrays;

final class Node implements BinaryTree {

  private Integer value;
  private BinaryTree left;
  private BinaryTree right;


  public Node(Integer value) {
    this(value, BinaryTree.MT, BinaryTree.MT);
  }

  public Node(Integer value, BinaryTree left, BinaryTree right) {
    if (value == null) {
      throw new IllegalArgumentException("Cannot pass null for BinaryTree node's value");
    }
    if (left == null) {
      throw new IllegalArgumentException("Cannot pass null for BinaryTree node's left child");
    }
    if (right == null) {
      throw new IllegalArgumentException("Cannot pass null for BinaryTree node's right child");
    }
    this.value = value;
    this.left = left;
    this.right = right;
  }

  @Override
  public boolean isBst() {
    return isBstHelper(this, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBstHelper(BinaryTree current, int minValue, int maxValue) {
    if ((current.value() < minValue) || (current.value() > maxValue)) {
      return false;
    }

    return (current.left().isMt() ? true : isBstHelper(current.left(), minValue, current.value()))
        && (current.right().isMt() ? true
            : isBstHelper(current.right(), current.value(), maxValue));
  }

  @Override
  public Integer maxDepth() {
    Integer leftDepth = this.left.maxDepth();
    Integer rightDepth = this.right.maxDepth();
    return Integer.max(leftDepth, rightDepth) + 1;
  }

  @Override
  public Integer highestValue() {
    int leftMax = this.left.isMt() ? Integer.MIN_VALUE : this.left.highestValue();
    int rightMax = this.right.isMt() ? Integer.MIN_VALUE : this.right.highestValue();

    return vmax(this.value, leftMax, rightMax);
  }

  private Integer vmax(Integer... ints) {
    return Arrays.stream(ints).reduce(Integer.MIN_VALUE, Integer::max);
  }

  @Override
  public String toString() {
    return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    result = prime * result + ((left == null) ? 0 : left.hashCode());
    result = prime * result + ((right == null) ? 0 : right.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Node other = (Node) obj;
    if (value == null) {
      if (other.value != null) {
        return false;
      }
    } else if (!value.equals(other.value)) {
      return false;
    }
    if (left == null) {
      if (other.left != null) {
        return false;
      }
    } else if (!left.equals(other.left)) {
      return false;
    }
    if (right == null) {
      if (other.right != null) {
        return false;
      }
    } else if (!right.equals(other.right)) {
      return false;
    }
    return true;
  }

  @Override
  public boolean isMt() {
    return false;
  }

  @Override
  public BinaryTree left() {
    return this.left;
  }

  @Override
  public BinaryTree right() {
    return this.right;
  }

  @Override
  public Integer value() {
    return this.value;
  }
}
