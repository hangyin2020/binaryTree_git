package edu.neu.khoury.cs6510.fall24;

final class MT implements BinaryTree {

  @Override
  public boolean isBst() {
    return true;
  }

  @Override
  public Integer maxDepth() {
    return 0;
  }

  @Override
  public Integer highestValue() {
    throw new InvalidBTOperationException("Cannot call highestValue() on an empty tree");
  }

  @Override
  public String toString() {
    return "MT []";
  }

  @Override
  public boolean isMt() {
    return true;
  }

  @Override
  public BinaryTree left() {
    throw new InvalidBTOperationException("Cannot call left() on an empty tree");
  }

  @Override
  public BinaryTree right() {
    throw new InvalidBTOperationException("Cannot call right() on an empty tree");
  }

  @Override
  public Integer value() {
    throw new InvalidBTOperationException("Cannot call value() on an empty tree");
  }


}
