package com.shivani.packages.Collection;

// https://www.youtube.com/watch?v=VE_AAUxTUCY
import java.util.*;

// public class Main {
//     public static void main(String[] args) {
//         OurGenericList<Integer> list = new OurGenericList<>();
//         list.add(1);
//         list.add(2);
//         list.add(3);

//         // we can't use this
//         // for(int x:list) //Can only iterate over an array or an instance of
//         // java.lang.Iterable
//         // we can't iterate over a list because it's declared as private in
//         // OurGenericList and we can't access it

//         // Iterable gives instance of class that implements iterator interface which has
//         // next and hasnext methods
//         Iterator<Integer> it = list.iterator();
//         while (it.hasNext()) {
//             System.out.println(it.next());// 1 2 3
//         }

//         // a class which implements iterable, we can use foreach loop to traverse that
//         // particular collection or instance of that class
//         for (int x : list) {
//             System.out.println(x); // 1 2 3
//         }

//     }
// }

public class Main {
    public static void main(String[] args) {
        List<Integer> alist = new ArrayList<>();
        alist.add(1);
        alist.add(2);
        alist.add(3);
        alist.add(2);

        System.out.println(alist); // [1, 2, 3,2]

        // make a copy of the alist
        // we can pass any type of collection
        List<Integer> alist2 = new ArrayList<>(alist);
        alist2.add(4);

        System.out.println(alist2); // [1, 2, 3, 2, 4]

        List<Integer> alist3 = new ArrayList<>();
        alist3.add(4);
        alist3.add(5);
        alist3.add(6);

        alist3.addAll(alist);
        System.out.println(alist3); // [4, 5, 6, 1, 2, 3,2]
        System.out.println(alist.indexOf(2));// 1
        // indexOf accepts object, ideally we should pass like alist.indexOf(new
        // Integer("2")) but we don't need to do this as compiler will automatically
        // convert the primitive type to its wrapper class, autoboxing

        System.out.println(alist.lastIndexOf(2));// 3

        // shallow copy
        List<Integer> alist4 = alist2.subList(1, 4);
        System.out.println(alist4); // [2, 3,2]
        alist4.set(0, 100);
        System.out.println(alist4); // [100, 3, 2]
        System.out.println(alist2);// [1, 100, 3, 2, 4]

        List<Integer> lk = new LinkedList<>();
        lk.add(1);
        lk.add(2);
        lk.add(3);
        ListIterator<Integer> iterator = lk.listIterator();
        // next() return the current element and then moves to next position
        System.out.println(iterator.next());// 1
        System.out.println(iterator.next());// 2
        // previous() moves to previous position and then return the element
        System.out.println(iterator.previous());// 2

        // next()-> return items[index++];
        // previous()-> return items[--index];

        // converting an ArrayList<Integer> into an array of Integer and then iterating
        // through the array to print its elements
        // passing array of size 0, a new array will be created whose size will be equal
        // to size of alist
        // if we pass array of size greater than alist size then , extra space will be
        // pointing to null
        Integer[] arr = alist.toArray(new Integer[0]);
        // for-each loop automatically unboxes each Integer into int because of
        // autoboxing/unboxing.
        for (int x : arr)
            System.out.println(x + ",");

        // To implement queue use Linkedlist in java
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        System.out.println(q.peek());// 1
        System.out.println(q.poll());// 1
        System.out.println(q.peek());// 2
        System.out.println(q.isEmpty());// false

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }

        // to implement deque , use arrayDeque in java
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(1);
        dq.offerLast(2);
        System.out.println(dq);// [1,2]
        System.out.println(dq.pollFirst());// 1
        System.out.println(dq.peekFirst());// 2
        System.out.println(dq);// [2]

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(1);
        pq.offer(2);
        pq.offer(0);
        pq.offer(100);

        // top 2 elements
        List<Integer> top2 = new ArrayList<>();
        int i = 0;
        while (!pq.isEmpty()) {
            if (i == 2)
                break;
            top2.add(pq.poll());
            i++;
        }
        System.out.println(top2); // [0, 1]
        System.out.println(pq); // [2, 100]

        // get me the top 3 students according to their maths marks *?

        List<StudentMarks> stMarks = new ArrayList<>();
        stMarks.add(new StudentMarks(70, 80));
        stMarks.add(new StudentMarks(38, 10));
        stMarks.add(new StudentMarks(100, 38));
        stMarks.add(new StudentMarks(40, 88));
        stMarks.add(new StudentMarks(97, 19));
        // PriorityQueue<StudentMarks> spq = new PriorityQueue<>(stMarks);

        // // we get a Exception in thread "main" java.lang.ClassCastException: when
        // ever
        // // we use custom class like StudentMarks, hence use comparator or comparable
        // // interface to decide based on what parameter priority queue should maintain
        // // its priority
        // // comparator is used at class level , type of class priority queue is using
        // // StudentMarks
        // // in order to create priority queue of custom time we have to implement
        // // comparable interface in turn we have compare to method

        // List<StudentMarks> top3 = new ArrayList<>();
        // int idx = 0;
        // while (!spq.isEmpty()) {
        // if (idx == 2)
        // break;
        // top3.add(spq.poll());
        // idx++;
        // }
        // System.out.println(top3); // [StudentMarks [maths=100, physics=38],
        // StudentMarks [maths=97, physics=19]]
        // System.out.println(spq); // [StudentMarks [maths=70, physics=80],
        // StudentMarks [maths=40, physics=88],
        // // StudentMarks [maths=38, physics=10]]

        // here natural ordering done in StudentMarks class , and total ordering is done
        // in priorityqueue parameter, hence total ordering will be followe
        // we will mostly use comparator function

        PriorityQueue<StudentMarks> spq = new PriorityQueue<StudentMarks>((s1, s2) -> {
            System.out.println("comparator's compareTo() is called "); // comparator's compareTo() is called
            return s2.getPhysics() - s1.getPhysics();
        });
        for (StudentMarks sm : stMarks)
            spq.add(sm);

        List<StudentMarks> top3 = new ArrayList<>();
        int idx = 0;
        while (!spq.isEmpty()) {
            if (idx == 2)
                break;
            top3.add(spq.poll());
            idx++;
        }
        System.out.println(top3); // [StudentMarks [maths=100, physics=38], StudentMarks [maths=97, physics=19]]
        System.out.println(spq); // [StudentMarks [maths=70, physics=80], StudentMarks [maths=40, physics=88],
                                 // StudentMarks [maths=38, physics=10]]

        // for wrapper classes, if we want to alter compareTo methods of it's comparable
        // interface then we should use comparator
        // what if we want top 2 elements of bottom 2 ?
        // bottom2
        // now it will follow the ordering of MyCustomClassComparator
        // the ordering the class is following is called natural ordering
        // ordering passed as priority queue as comparator is called total ordering
        // total ordering is more preferred than natural ordering
        // if comparator passed to priorityqueue then comparator's compare() is executed
        // if we don't pass comparator to priorityqueue then the class has to implements
        // comparable comparesTo() method is executed otherwise class cast exception is
        // thrown

        // PriorityQueue<Integer> pq1 = new PriorityQueue<>(new MyCustomComparator());

        // pq1.offer(1);
        // pq1.offer(2);
        // pq1.offer(0);
        // pq1.offer(100);

        // List<Integer> bottom2 = new ArrayList<>();
        // int index = 0;
        // while (!pq1.isEmpty()) {
        // if (index == 2)
        // break;
        // bottom2.add(pq1.poll());
        // index++;
        // }
        // System.out.println(bottom2); // [100, 2]
        // System.out.println(pq1); // [1, 0]

        // we can also use lambda function instead of passing object of
        // MyNewcutomcomparator
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> b - a);

        pq1.offer(1);
        pq1.offer(2);
        pq1.offer(0);
        pq1.offer(100);

        List<Integer> bottom2 = new ArrayList<>();
        int index = 0;
        while (!pq1.isEmpty()) {
            if (index == 2)
                break;
            bottom2.add(pq1.poll());
            index++;
        }
        System.out.println(bottom2); // [100, 2]
        System.out.println(pq1); // [1, 0]

        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(2);
        System.out.println(set.contains(2)); // true
        System.out.println(set.contains(200)); // false
        System.out.println(set);// [2, 3, 4]

        // we can also create set from arraylist
        Set<Integer> set1 = new HashSet<>(alist);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(2);
        System.out.println(set1); // [1, 2, 3, 4]
        set1.remove(2);
        System.out.println(set1); // [1, 3, 4]
        // set1.clear();
        // System.out.println(set1); // []

        // System.out.println("after retaining");
        // set1.retainAll(set);
        // System.out.println(set1); // [3, 4]
        // System.out.println(set); // [2, 3, 4]

        // System.out.println("after removing all");
        // set1.removeAll(set);
        // System.out.println(set1); // [1]
        // System.out.println(set); // [2, 3, 4]

        System.out.println("after adding all");
        set1.addAll(set);
        System.out.println(set1); // [1, 2, 3, 4]
        System.out.println(set); // [2, 3, 4]

        // hashset doesn't remember the order of the element in which they are inserted
        // but linkedhashset remembers the order in which element is stored

        // Linked hashset extends hashset
        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(2);
        set2.add(0);

        Set<Integer> set3 = new LinkedHashSet<>();
        set3.add(2);
        set3.add(3);
        set3.add(4);
        set3.add(2);
        set3.add(0);

        // insertion order is not maintained
        for (int x : set2)
            System.out.print(x + ","); // 0,2,3,4
        System.out.println();
        // insertion order is maintained
        for (int x : set3)
            System.out.print(x + ","); // 2,3,4,0

        Set<StudentMarks> set4 = new HashSet<>(stMarks);
        System.out.println(set4.contains(new StudentMarks(70, 80))); // false, after implementing hashCode() and
                                                                     // equals() in StudentMarks it returns true

        for (StudentMarks x : set4) {
            System.out.print(x + ","); // StudentMarks [maths=70, physics=80],StudentMarks [maths=40,
            // physics=88],StudentMarks [maths=97, physics=19],StudentMarks [maths=38,
            // physics=10],StudentMarks [maths=100, physics=38],
        }

        // when we insert any element in the hashset a hashcode of that element is
        // generated and mapped to particular bucket
        // whenever we create object , two different hashcode is generated
        // when u use hashset and own custom class , must override equals()
        // and hashCode() of your custom class before using it in a hashSet

        // Set<StudentMarks> treeset = new TreeSet<>();
        // treeset.add(new StudentMarks(70, 80)); // comparable's compareTo () is called
        // treeset.add(new StudentMarks(38, 10)); // comparable's compareTo () is called
        // treeset.add(new StudentMarks(100, 38));// comparable's compareTo () is called
        // treeset.add(new StudentMarks(40, 88));// comparable's compareTo () is called
        // treeset.add(new StudentMarks(97, 19));// comparable's compareTo () is called

        // for (StudentMarks x : treeset)
        // System.out.println(x + ", ");
        // StudentMarks [maths=100, physics=38],
        // StudentMarks [maths=97, physics=19],
        // StudentMarks [maths=70, physics=80],
        // StudentMarks [maths=40, physics=88],
        // StudentMarks [maths=38, physics=10],

        // to sort based on comparator
        Set<StudentMarks> treeset = new TreeSet<>((s1, s2) -> s2.getPhysics() - s1.getPhysics());
        treeset.add(new StudentMarks(70, 80)); // comparable's compareTo () is called
        treeset.add(new StudentMarks(38, 10)); // comparable's compareTo () is called
        treeset.add(new StudentMarks(100, 38));// comparable's compareTo () is called
        treeset.add(new StudentMarks(40, 88));// comparable's compareTo () is called
        treeset.add(new StudentMarks(97, 19));// comparable's compareTo () is called

        for (StudentMarks x : treeset)
            System.out.println(x + ", ");
        // StudentMarks [maths=70, physics=80],
        // StudentMarks [maths=100, physics=38],
        // StudentMarks [maths=97, physics=19],
        // StudentMarks [maths=38, physics=10],

        NavigableSet<Integer> set5 = new TreeSet<>();
        set5.add(8);
        set5.add(3);
        set5.add(1);
        set5.add(0);
        for (int x : set5)
            System.out.print(x + ", ");

        System.out.println();
        System.out.println(set5.floor(2));// 1
        System.out.println(set5.higher(2));// 3
        System.out.println(set5.lower(2)); // 1
        System.out.println(set5.ceiling(2)); // 3

        // Map can't be iterate as it is not part of collection interface, but it can be
        // converted to set and then it can be iterated

        Map<String, Integer> map = new HashMap<>();
        map.put("shivani", 1);
        map.put("riddhi", 2);
        map.put("rahul", 3);
        map.remove("rahul");
        // System.out.println(map.get("dsjk")); // null
        System.out.println(map.getOrDefault("djsk", 0)); // 0
        System.out.println(map.getOrDefault("riddhi", 0)); // 2
        System.out.println(map.containsKey("riddhi")); // true
        System.out.println(map.containsKey("rahul")); // false

        Map<Integer, List<Integer>> adj = new HashMap<>();
        // 1-2
        // 3-5
        // 1-3

        if (adj.get(1) == null)
            adj.put(1, new ArrayList<>());
        adj.get(1).add(2);
        // instead of writing 3 lines of code we can write one line of code to do the
        // same work
        // function we want to execute when key is not present
        adj.computeIfAbsent(2, f -> new ArrayList<>()).add(3);

        // how to traverse a map
        // map is not a iterable, hence need to be converted into set to become iterable
        // 1. use entySet() -> gives a set of entries, and set is iterable
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet)
            System.out.println(entry.getKey() + "=" + entry.getValue());
        // riddhi=2
        // shivani=1

        // 2.use keySet() -> gives set of keys
        Set<String> keySets = map.keySet();
        for (String key : keySets)
            System.out.println(key + "," + map.get(key));
        // riddhi,2
        // shivani,1

        NavigableMap<Integer, String> tmap = new TreeMap<>();
        tmap.put(1, "riddhi");
        tmap.put(2, "raj");
        tmap.put(3, "rahul");
        tmap.put(7, "ram");
        tmap.remove(2);
        Set<Map.Entry<Integer, String>> entrySet1 = tmap.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet1)
            System.out.println(entry.getKey() + "=" + entry.getValue());
        // 1=riddhi
        // 3=rahul
        System.out.println("key " + tmap.ceilingKey(4)); // 7

        NavigableMap<Integer, String> tmap1 = new TreeMap<>((a, b) -> b - a);
        tmap1.put(1, "riddhi");
        tmap1.put(2, "raj");
        tmap1.put(7, "rahul");

        Set<Map.Entry<Integer, String>> entrySet2 = tmap1.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet2)
            System.out.println(entry.getKey() + "=" + entry.getValue());
        // 7=rahul
        // 2=raj
        // 1=riddhi
        System.out.println(tmap1.pollFirstEntry()); // 7=rahul
        // with descending order, the map is traversed from largest to smallest, and 2
        // is the "ceiling" in this context.[7, 2, 1]
        System.out.println("key " + tmap1.ceilingKey(3)); // 2

        Integer arr1[] = new Integer[] { 1, 2, 3, 0, 1, 5, 10, 7 };
        Arrays.sort(arr1);

        List<Integer> lst = Arrays.asList(arr1);
        System.out.println(lst); // [0, 1, 1, 2, 3, 5, 7, 10]

    }
}
