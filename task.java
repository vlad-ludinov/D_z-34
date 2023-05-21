import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.Iterator;

/**
 * task
 */
public class task {

    public static void main(String[] args) {
        
        MySet set1 = new MySet();

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        MyTreeSet set2 = new MyTreeSet(comparator);

        for (int i = 0; i < 5; i++) {
            set1.add(new Random().nextInt(10));
            set2.add(new Random().nextInt(10));
        }
        
        Iterator<Integer> iterator1 = set1.iterator();
        Iterator<Integer> iterator2 = set2.iterator();

        System.out.print(iterator1.next());
        while (iterator1.hasNext()) {
            System.out.printf(", %d", iterator1.next());
        }

        System.out.println();
        System.out.print(iterator2.next());
        while (iterator2.hasNext()) {
            System.out.printf(", %d", iterator2.next());
        }
        System.out.println();

    }
}

/**
 * MySet
 */
class MySet {


    private LinkedHashMap<Integer, Object> linkedHashMap = new LinkedHashMap<>();

    static final Object OBJECT = new Object();

    public boolean add(int num) {
        return linkedHashMap.put(num, OBJECT) == null;
    }

    public boolean contains(int num) {
        return linkedHashMap.containsKey(num);
    }

    public Object[] toArray() {
        return linkedHashMap.keySet().toArray();
    }
    
    public Iterator<Integer> iterator() {
        return linkedHashMap.keySet().iterator();
    }

    public Integer getItem(int index) {
        return (Integer) toArray()[index];
    }
}

class MyTreeSet {

    private Comparator<Integer> comparator;

    public MyTreeSet(Comparator<Integer> comp) {
        comparator = comp;
    }

    private TreeMap<Integer, Object> TreeMap = new TreeMap<>(comparator);

    static final Object OBJECT = new Object();

    public boolean add(int num) {
        return TreeMap.put(num, OBJECT) == null;
    }

    public boolean contains(int num) {
        return TreeMap.containsKey(num);
    }

    public Object[] toArray() {
        return  TreeMap.keySet().toArray();
    }
    
    public Iterator<Integer> iterator() {
        return TreeMap.keySet().iterator();
    }

    public Integer getItem(int index) {
        return (Integer) toArray()[index];
    }
}