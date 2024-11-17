package edu.neu.khoury.cs6510.fall24;

/**
 * Runtime exception thrown when an invalid operation is attempted on a BinaryTree. For example
 * calling <code>value()</code> on an empty binary tree.
 */
public class InvalidBTOperationException extends RuntimeException {

  /**
   * Creates an invalid
   *
   * @param msg the message as a string for this exception.
   */
  public InvalidBTOperationException(String msg) {
    super(msg);
  }

}
