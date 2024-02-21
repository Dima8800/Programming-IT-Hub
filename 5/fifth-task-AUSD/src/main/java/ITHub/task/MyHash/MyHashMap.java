package ITHub.task.MyHash;

import java.util.ArrayList;
import java.util.List;


public class MyHashMap<K extends MyHashable, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Entry<K, V>[] table;
    private int size;

    public MyHashMap() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    public void mapKeyVal(K key, V val) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = getIndex(key);
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = val;
                return;
            }
            entry = entry.next;
        }

        Entry<K, V> newEntry = new Entry<>(key, val);
        newEntry.next = table[index];
        table[index] = newEntry;
        size++;

        if (size > table.length * LOAD_FACTOR) {
            resizeTable();
        }
    }

    public V mapKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = getIndex(key);
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }

        return null;
    }

    public void delKey(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = getIndex(key);
        Entry<K, V> entry = table[index];
        Entry<K, V> prevEntry = null;

        while (entry != null) {
            if (entry.key.equals(key)) {
                if (prevEntry == null) {
                    table[index] = entry.next;
                } else {
                    prevEntry.next = entry.next;
                }
                size--;
                return;
            }
            prevEntry = entry;
            entry = entry.next;
        }
    }

    public int size() {
        return size;
    }

    public K[] keys() {
        List<K> keyList = new ArrayList<>();

        for (Entry<K, V> entry : table) {
            while (entry != null) {
                keyList.add(entry.key);
                entry = entry.next;
            }
        }

        @SuppressWarnings("unchecked")
        K[] keys = (K[]) new MyHashable[keyList.size()];
        return keyList.toArray(keys);
    }

    private int getIndex(K key) {
        int hashCode = key.hashMeDaddy();
        return hashCode % table.length;
    }

    private void resizeTable() {
        Entry<K, V>[] oldTable = table;
        int newCapacity = table.length * 2;
        table = new Entry[newCapacity];
        size = 0;

        for (Entry<K, V> entry : oldTable) {
            while (entry != null) {
                mapKeyVal(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
