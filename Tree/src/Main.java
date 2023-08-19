package src;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    AVLTree tree = new AVLTree();
    boolean isOneNode = false;
    boolean choice = true;
    
    while (true) {
      if (!isOneNode) {
        System.out.println("Choose integer/s to insert: ");
      } else {
        System.out.println("Would you like to insert or Delete a node? I/D");      
        String response = sc.nextLine();
        response = response.toLowerCase();  // Fix: Assign the lowercase version to response
        if (response.startsWith("d")) {
          System.out.println("Choose integer/s to delete: ");
          choice = false;
        } else {
          choice = true;
        }
      }      
      String val = sc.nextLine();
      try {
        String[] array = val.split(" ");
        for (String s : array) {
          int key = Integer.parseInt(s);
          chooseMethod(tree, key, choice);
        }
        TreePrinter.print(tree.root);
        isOneNode = true;
      } catch (Exception e) {
        System.out.println("Input invalid, please try again.");
      }
      System.out.println("Would you like to exit: y/n");
      String yesNo = sc.nextLine();
      yesNo = yesNo.toLowerCase();
      if (yesNo.startsWith("y")) {
        break;
      } 
    }
    sc.close();
  }

  private static void chooseMethod(AVLTree tree, int key, boolean option) {
    if (option == true) tree.insert(key); 
    else tree.delete(key);
  }
}
