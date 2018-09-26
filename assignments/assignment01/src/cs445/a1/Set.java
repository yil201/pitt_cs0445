package cs445.a1;

import java.util.Arrays;

/**
 * Dynamic-capacity array-based implementation.
 */
@SuppressWarnings({"JavadocReference", "SpellCheckingInspection", "unchecked"})
public class Set<E> implements cs445.a1.SetInterface<E> {
    private int size, position;
    private E[] contents;
    private static final int DEFAULT_ARRAY_SIZE = 100;

    public Set(){
        this(DEFAULT_ARRAY_SIZE);
    }

    public Set(int capacity){
        size = capacity;
        contents = (E[]) new Object[size];
        position = 0;
    }

    public Set(E[] entries){
        this(entries.length);
        for (E entry : entries) {
            if (entry != null && !this.contains(entry)) {
                contents[position] = entry;
                position++;
            }
        }
    }

    /**
     * Determines the current number of entries in this set.
     *
     * @return  The integer number of entries currently in this set
     */
    public int getSize(){
        return position;
    }

    /**
     * Determines whether this set is empty.
     *
     * @return  true if this set is empty; false if not
     */
    public boolean isEmpty(){
        return position == 0;
    }

    /**
     * Determines whether this set is full.
     *
     * @return  true if this set is full; false if not
     */
    public boolean isFull(){
        return position == this.size;
    }

    /**
     * Adds a new entry to this set, avoiding duplicates.
     *
     * <p> If newEntry is not null, this set does not contain newEntry, and this
     * set has available capacity (if applicable), then add modifies the set so
     * that it contains newEntry. All other entries remain unmodified.
     * Duplicates are determined using the .equals() method.
     *
     * <p> If newEntry is null, then add throws NullPointerException without
     * modifying the set. If this set already contains newEntry, then add
     * returns false without modifying the set. If this set has a capacity
     * limit, and does not have available capacity, then add throws
     * SetFullException without modifying the set. If this set does not have a
     * capacity limit (i.e., if it resizes as needed), then it will never throw
     * SetFullException.
     *
     * @param newEntry  The object to be added as a new entry
     * @return  true if the addition is successful; false if the item already is
     * in this set
     * @throws cs445.a1.SetFullException  If this set has a fixed capacity and does not
     * have the capacity to store an additional entry
     * @throws NullPointerException  If newEntry is null
     */
    public boolean add(E newEntry) throws cs445.a1.SetFullException, NullPointerException{
        boolean add = true;
        if(this.isFull()){
            doubleCapacity();
        }
        // SetFullException will never be thrown due to the dynamic-capacity nature
        if(this.isFull()){
            throw new cs445.a1.SetFullException();
        }
        else if(newEntry == null){
            throw new NullPointerException();
        }
        // check for duplicates
        if(this.contains(newEntry)){
                add = false;
        }
        if(add){
            this.contents[position] = newEntry;
            position ++;
        }
        return add;
    }

    /**
     * Double the capacity of this set.
     */
    public void doubleCapacity(){
        size = 2 * contents.length;
        contents = Arrays.copyOf(contents, 2 * contents.length);
    }

    /**
     * Removes a specific entry from this set, if possible.
     *
     * <p> If this set contains the entry, remove modifies the set so that it no
     * longer contains entry. All other entries remain unmodified. Identifying
     * this entry is accomplished using the .equals() method. The removed entry
     * will be returned.
     *
     * <p> If this set does not contain entry, remove will return null without
     * modifying the set. Because null cannot be added, a return value of null
     * will never indicate a successful removal.
     *
     * <p> If the specified entry is null, then remove throws
     * NullPointerException without modifying the set.
     *
     * @param entry  The entry to be removed
     * @return  The removed entry if removal was successful; null otherwise
     * @throws NullPointerException  If entry is null
     */
    public E remove(E entry) throws NullPointerException{
        E removed = null;
        if(this.isEmpty()){
            throw new NullPointerException();
        }
        if(this.contains(entry)){
            removed = entry;
            for(int i = this.getSize(); i >= 0; i--){
                if(this.contents[i].equals(entry)){
                    this.contents[i] = entry;
                    System.arraycopy(this.contents, i + 1, this.contents, i, this.getSize() - i + 1);
                    position --;
                }
            }
        }
        return removed;
    }

    /**
     * Removes an arbitrary entry from this set, if possible.
     *
     * <p> If this set contains at least one entry, remove will modify the set
     * so that it no longer contains one of its entries. All other entries
     * remain unmodified. The removed entry will be returned.
     *
     * <p> If this set is empty, remove will return null without modifying the
     * set. Because null cannot be added, a return value of null will never
     * indicate a successful removal.
     *
     * @return  The removed entry if the removal was successful; null otherwise
     */
    public E remove(){
        E removed = null;
        if(!this.isEmpty()){
            removed = this.contents[position];
            this.contents[position] = null;
            position --;
        }
        return removed;
    }

    /**
     * Removes all entries from this set.
     *
     * <p> If this set is already empty, clear will not modify the set.
     * Otherwise, the set will be modified so that it contains no entries.
     */
    public void clear(){
        if(!this.isEmpty()){
            for(int i = 0; i < this.getSize(); i++){
                this.contents[i] = null;
            }
        }
    }

    /**
     * Tests whether this set contains a given entry. Equality is determined
     * using the .equals() method.
     *
     * <p> If this set contains entry, then contains returns true. Otherwise
     * (including if this set is empty), contains returns false. If entry is
     * null, then remove throws NullPointerException. The method never modifies
     * this set.
     *
     * @param entry  The entry to locate
     * @return  true if this set contains entry; false if not
     * @throws NullPointerException  If entry is null
     */
    public boolean contains(E entry) throws NullPointerException{
        if(entry == null){
            throw new NullPointerException();
        }
        boolean found = false;
        for(int i = 0; !found && (i < this.getSize()); i++){
            if(entry.equals(this.contents[i])){
                found = true;
            }
        }
        return found;
    }

    /**
     * Retrieves all entries that are in this set.
     *
     * <p> An array is returned that contains a reference to each of the entries
     * in this set. The returned array's length will be equal to the number of
     * elements in this set, and thus the array will contain no null values.
     *
     * <p> If the implementation of set is array-backed, toArray will not return
     * the private backing array. Instead, a new array will be allocated with
     * exactly the appropriate capacity (including an array of size 0, if the
     * set is empty).
     *
     * @return  A newly-allocated array of all the entries in this set
     */
    public Object[] toArray(){
        Object[] array = new Object[this.getSize()];
        System.arraycopy(this.contents, 0, array, 0, this.getSize());
        return array;
    }

}