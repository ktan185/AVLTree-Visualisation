package src;

public class AVLTree {

  Node root;

  // Method to insert a key into AVL Tree.
  public void insert(int key) {

    // Get the current root.
    Node root = this.root;
    // Call helper method to update new root.
    this.root = insertHelper(root, key);
  }

  // Method to delete a key from the Tree.
  public void delete(int key) {

    Node root = this.root;
    this.root = deleteHelper(root, key);

  }

  // Helper function to calculate the height of the current node.
  private int height(Node node) {
    if (node == null)
      return 0;
    return node.height;
  }

  // Helper function to calculate the balance factor of the current node.
  private int getBalanceFactor(Node node) {
    if (node == null)
      return 0;
    return height(node.left) - height(node.right);
  }

  // Helper function to determine which height is greater.
  private int max(int a, int b) {
    return (a > b) ? a : b;
  }

  // Helper function to perform Right Rotation on a node.
  private Node rightRotation(Node x) {

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

  // Helper function to perform Left Rotation on a node.
  private Node leftRotation(Node x) {

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

  // Helper function to perform Left Right Rotation on a node.
  private Node leftRightRotation(Node x) {
    // Save the left child of the given node.
    Node y = x.left;
    // Peform a left rotation on node y.
    Node y1 = leftRotation(y);
    // Update the left child of x to y1.
    x.left = y1;
    // Perform right rotation on the given node.
    return rightRotation(x);
  }

  // Helper function to perform Right Left Rotation on a node.
  private Node rightLeftRotation(Node x) {

    // Save the right child of the given node.
    Node y = x.right;
    // Perform a right rotation on node y.
    Node y1 = rightRotation(y);
    // Update the right child of x to y1.
    x.right = y1;
    // Perform left rotation on the given node.
    return leftRotation(x);

  }

  // Helper function to perform insertion Recursively.
  private Node insertHelper(Node root, int key) {

    // Base case.
    if (root == null) {
      return new Node(key);
    }
    if (root.key < key) { // If the key is greater than the current value, recursively go right.
      root.right = insertHelper(root.right,key);
    } else if (root.key > key) { // If the key is less than current value, recursively go left.
      root.left = insertHelper(root.left, key);
    } else {
      return root; // Otherwise, the key already exists in the tree, return (NO DUPLICATES).
    }

    // Update the height of the current node;
    root.height = max(height(root.left), height(root.right)) + 1;

    // Get the balance factor of the current node.
    int bf = getBalanceFactor(root);

    // If the balance factor is greater than 1, and the key to be inserted is less than the key of the left child,
    // Perform Right rotation.
    if (bf > 1 && key < root.left.key) {
      root = rightRotation(root);
    // If the balance factor is less than -1, and the key to be inserted is greater than the key of the right child,
    // Perform Left rotation.
    } else if (bf < -1 && key > root.right.key) {
      root = leftRotation(root);
      // If the balance factor is greater than 1, and the key to be inserted is greater than the key of the left chid,
      // Perform left right rotation.
    } else if (bf > 1 && key > root.left.key) {
      root = leftRightRotation(root);
      // If the balance factor is less than -1, and the key to be inserted is less than the key of the right chid,
      // Perform right left rotation.
    } else if (bf < -1 && key < root.right.key) {
      root = rightLeftRotation(root);
    }
    return root;
  }

  // Helper function to delete a node from the tree recursively.
  private Node deleteHelper(Node root, int key) {

    // Base case. if the node does not exist, return;
    if (root == null) return null;

    // If the current node's key is less than the key to delete,
    // Go right;
    if (root.key < key) { 
      root.right = deleteHelper(root.right, key);
    // If the current node's key is greater than the key to delete,
    // Go left.
    } else if (root.key > key) {
      root.left = deleteHelper(root.left, key);
    } else {
      // if the root has 0 to 1 child:
      if (root.left == null)  {
        return root.left;
      } else if (root.right == null) {
        return root.right;
      }
      // if the root has 2 children:
      // Go to the right child, and find the next biggest element in the tree and replace the node with that node.
      root.key = findMin(root.right);
      // Delete that node.  
      root.right = deleteHelper(root.right, key);
    }

    // Update the height of the current node.
    root.height = max(height(root.left),height(root.right)) + 1;

    // Calculate the balance factor.
    int bf = getBalanceFactor(root);

    // If the balance factor is greater than 1, and the key to be inserted is less than the key of the left child,
    // Perform Right rotation.
    if (bf > 1 && key < root.left.key) {
      root = rightRotation(root);
    // If the balance factor is less than -1, and the key to be inserted is greater than the key of the right child,
    // Perform Left rotation.
    } else if (bf < -1 && key > root.right.key) {
      root = leftRotation(root);
      // If the balance factor is greater than 1, and the key to be inserted is greater than the key of the left chid,
      // Perform left right rotation.
    } else if (bf > 1 && key > root.left.key) {
      root = leftRightRotation(root);
      // If the balance factor is less than -1, and the key to be inserted is less than the key of the right chid,
      // Perform right left rotation.
    } else if (bf < -1 && key < root.right.key) {
      root = rightLeftRotation(root);
    }
    return root;
  }

  // helper function to determine the smallest value in the tree.
  private int findMin(Node node) {

    while (node.left != null) {
      node = node.left;
    }
    return node.key;
  }

}
