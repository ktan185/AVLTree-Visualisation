package AVL;

public class Main {

  public static void main(String[] args) {

    AVLTree tree = new AVLTree();
    tree.root = tree.insert(tree.root, 3);
    tree.root = tree.insert(tree.root, 2);
    tree.root = tree.insert(tree.root, 1);
    tree.root = tree.insert(tree.root, 7);
    tree.root = tree.insert(tree.root, 0);
    tree.root = tree.insert(tree.root, 5);
    tree.root = tree.insert(tree.root, 8);
    tree.root = tree.insert(tree.root, 4);
    tree.root = tree.insert(tree.root, 6);
    tree.root = tree.insert(tree.root, 9);
    TreePrinter.print(tree.root);

  }

}
