package src;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    AVLTree tree = new AVLTree();
    
    while (true) {
      System.out.println("Choose an integer/s to insert: ");
      String val = sc.nextLine();
      try {
        String[] array = val.split(" ");
        for (String s : array) {
            int key = Integer.parseInt(s);
            tree.insert(key);
        }
        TreePrinter.print(tree.root);
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

}
