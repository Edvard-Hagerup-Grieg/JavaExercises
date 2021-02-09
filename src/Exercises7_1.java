// Коллекция без дубликатов

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

class TestCollection<T> implements Collection<T> {
    private ArrayList<T> items;
    private int size;

    TestCollection() {
        items = new ArrayList<>();
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(T item : items) {
            if(o.equals(item))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }

    @Override
    public Object[] toArray() {
        return items.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(T item) {
        return items.add(item);
    }

    @Override
    public boolean remove(Object o) {
        return items.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        String itemsString = "[";

        for(T item : items)
            itemsString = itemsString + item.toString() + ", ";
        itemsString = itemsString.substring(0, itemsString.length() - 2) + "]";

        return itemsString;
    }
}

public class Exercises7_1 {
    public static <T> Collection<T> removeDuplicate(Collection<T> collection) {
        return new HashSet<T>(collection);
    }

    public static void main(String[] args) {
        TestCollection<Integer> testCollection = new TestCollection<>();

        testCollection.add(1);
        testCollection.add(2);
        testCollection.add(2);
        testCollection.add(3);
        testCollection.add(5);
        testCollection.add(1);

        System.out.println(testCollection);

        System.out.println(removeDuplicate(testCollection));
    }
}
