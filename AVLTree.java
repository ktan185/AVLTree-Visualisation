package AVL;

public class AVLTree {

  Node root;

  // Helper function to calculate the height of the current node.
  public int height(Node node) {
    if (node == null)
      return 0;
    return node.height;
  }

  // Helper function to calculate the balance factor of the current node.
  public int getBalanceFactor(Node node) {
    if (node == null)
      return 0;
    return height(node.left) - height(node.right);
  }

  public int max(int a, int b) {
    return (a > b) ? a : b;
  }

  public Node rightRotation(Node x) {

    // Save the left child of the given node.
    Node y = x.left;
    // update the left child of the given node to be the right child of its left child.
    x.left = y.right;
    // Make the right child of the left child the current node.
    y.right = x;

    // Update the height of respective nodes.
    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;

    return y;
  }

  public Node leftRotation(Node x) {

    // Save the right child of the given node.
    Node y = x.right;
    // update the right child of the givevn node to be the left child of its right child.
    x.right = y.left;
    // Make the left child of the right child the current node.
    y.left = x;

    // Update the height of respective nodes.
    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;

    return y;
  }

  public Node leftRightRotation(Node x) {
    // Save the left child of the given node.
    Node y = x.left;
    // Peform a left rotation on node y.
    Node y1 = leftRotation(y);
    // Update the left child of x to y1.
    x.left = y1;
    // Perform right rotation on the given node.
    return rightRotation(x);
  }

  public Node rightLeftRotation(Node x) {

    // Save the right child of the given node.
    Node y = x.right;
    // Perform a right rotation on node y.
    Node y1 = rightRotation(y);
    // Update the right child of x to y1.
    x.right = y1;
    // Perform left rotation on the given node.
    return leftRotation(x);

  }

  public Node insert(Node node, int key) {
    return null;
  }

}
