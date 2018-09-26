package cs445.a1;

/**
 * A test of the methods, addItem, removeItem, modifyQuantity, printAll,
 * as defined in the class Groceries.
 */
public class GroceriesExamples {
    public static void main(String[] args){
        /*
        Expected output:
        "Groceries:

        "
         */
        Groceries aGroceries = new Groceries();
        aGroceries.printAll();
        System.out.println();

        /*
        Expected output:
        "Groceries:
         882 Apple(s)
         5 Banana(s)
        "
         */
        aGroceries.addItem(new GroceryItem("Apple(s)", 1));
        aGroceries.addItem(new GroceryItem("Banana(s)", 5));
        aGroceries.addItem(new GroceryItem("Apple(s)", 881));
        aGroceries.printAll();
        System.out.println();

        /*
        Expected output:
        "Groceries:
         882 Apple(s)
         2 Banana(s)
        "
         */
        aGroceries.removeItem(new GroceryItem("Banana(s)", 3));
        aGroceries.printAll();
        System.out.println();

        /*
        Expected output:
        "Groceries:
         882 Apple(s)
         2333 Banana(s)
         2
        "
         */
        int a = aGroceries.modifyQuantity(new GroceryItem("Banana(s)", 2333));
        aGroceries.printAll();
        System.out.println(a);
        System.out.println();

        /*
        Expected output:
        "Groceries:
         882 Apple(s)
         2333 Banana(s)
         -1
        "
         */
        a = aGroceries.modifyQuantity(new GroceryItem("Pear(s)", 9));
        aGroceries.printAll();
        System.out.println(a);
        System.out.println();

        /*
        Expected output:
        "Groceries:
         882 Apple(s)
         2333 Banana(s)
        "
         */
        aGroceries.removeItem(new GroceryItem("Dr. Garrison", 445));
        aGroceries.printAll();
        System.out.println();
    }
}
