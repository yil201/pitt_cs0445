package cs445.a1;

/**
 * A test of the constructors and methods getSize, isEmpty, isFull, add, doubleCapacity,
 * remove, clear, contains, toArray, get as defined in the class Set.
 */
public class SetExamples {
    public static void main(String[] args){
        Set<String> aSet, bSet, cSet;
        String[] arr = new String[100];
        int a, b, c;
        boolean d, e;

        aSet = new Set<>();
        a = aSet.getSize();
        b = aSet.getCapacity();
        System.out.println(a);
        System.out.println(b);
        for(Object str : aSet.toArray()) System.out.println(str);
        System.out.println();

        aSet = new Set<>(3);
        a = aSet.getSize();
        b = aSet.getCapacity();
        System.out.println(a);
        System.out.println(b);
        for(Object str : aSet.toArray()) System.out.println(str);
        System.out.println();

        arr = new String[] {"a", "b", null, null, "b", null, "c", "a", "d"};
        aSet = new Set<>(arr);
        for(Object str : aSet.toArray()) System.out.println(str);
        System.out.println();

        d = aSet.isEmpty();
        e = aSet.isFull();
        System.out.println(d);
        System.out.println(e);
        System.out.println();

        aSet.doubleCapacity();
        System.out.println(aSet.getCapacity());
        System.out.println();

        aSet.remove("a");
        for(Object str : aSet.toArray()) System.out.println(str);
        System.out.println();

        try{
            aSet.add("e");
        } catch (SetFullException z) {
            z.printStackTrace();
        }
        for(Object str : aSet.toArray()) System.out.println(str);
        System.out.println();

        d = aSet.contains("f");
        e = aSet.contains("b");
        System.out.println(d);
        System.out.println(e);
        System.out.println();

        aSet.clear();
        for(Object str : aSet.toArray()) System.out.println(str);
        System.out.println();

        c = aSet.getCapacity();
        System.out.println(c);
    }
}
