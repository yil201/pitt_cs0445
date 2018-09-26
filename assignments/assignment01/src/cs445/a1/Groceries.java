package cs445.a1;

public class Groceries implements GroceriesInterface {
    private Set<GroceryItem> groceryBag;

    public Groceries(){
        groceryBag = new Set<>();
    }

    /**
     * Adds item to these groceries. If an item with the same description is
     * already in these groceries, then its quantity is increased by the amount
     * specified. For instance, if 2 bananas are added when 3 bananas are in the
     * groceries, the quantity is increased to 5 bananas. If an item with the
     * same description is not in these groceries, then it is added with the
     * specified quantity.
     *
     * @param item the item to add
     */
    public void addItem(GroceryItem item){

    }

    /**
     * Removes item from these groceries. If an item with the same description
     * is in these groceries, then its quantity is decreased by the amount
     * specified. For instance, if 3 bananas are removed when 10 bananas are in
     * the groceries, the quantity is decreased to 7 bananas. If the specified
     * quantity is greater than or equal to the current quantity, the item is
     * removed entirely. If an item with the same description is not in these
     * groceries, this method does nothing.
     *
     * @param item the item to remove
     */
    public void removeItem(GroceryItem item){
        for(int i = 0; groceryBag.contains(item) && (i < groceryBag.getSize()); i++){
            if(item.getQuantity() >= groceryBag.get(i).getQuantity()) groceryBag.get(i).setQuantity(0);
            else groceryBag.get(i).setQuantity(groceryBag.get(i).getQuantity() - item.getQuantity());
        }
    }

    /**
     * Modifies an item's quantity within these groceries. If an item with the
     * same description is in these groceries, then its quantity is modified to
     * match the amount specified, and the previous quantity is returned. If an
     * item with the same description is not in these groceries, this method
     * makes no changes and returns -1.
     *
     * @param item the item to modify in the set
     * @return  the old quantity, or -1 if the item was not found
     */
    public int modifyQuantity(GroceryItem item){
        int modified = -1;
        for(int i = 0; i < groceryBag.getSize(); i++){
            if(groceryBag.get(i).getDescription().equals(item.getDescription())){
                modified = groceryBag.get(i).getQuantity();
                groceryBag.get(i).setQuantity(modified + item.getQuantity());
            }
        }
        return modified;
    }

    /**
     * Prints all groceries. Includes a header "Groceries:" and prints each item
     * on a separate line.
     */
    public void printAll(){
        System.out.println("Groceries: ");
        for(int i = 0; i < groceryBag.getSize(); i++){
            System.out.println(groceryBag.get(i).toString());
        }
    }
}