package AVL;

import AVL.TreePrinter.PrintableNode;

public class Node implements PrintableNode {

  int key;
  int height;
  Node left;
  Node right;

  public Node(int key) {
    this.key = key;
    this.height = 1;
  }

  @Override
  public PrintableNode getLeft() {
    return this.left;
  }

  @Override
  public PrintableNode getRight() {
    return this.right;
  }

  @Override
  public String getText() {
    return String.valueOf(key);
  }

}
