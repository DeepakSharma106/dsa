package core;


import java.util.HashMap;

class Entry<K,V> {
    K key;
    V value;
    Entry<K,V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }
}

class CustomHashMap<K,V> {
    private Entry<K,V>[] table;

    public CustomHashMap(){
        table = new Entry[10];
    }

    public CustomHashMap(int size) {
        table = new Entry[size];
    }

    public void put(K key, V value) {
        // get the bucket location
        int bucketLocation = key.hashCode() % table.length;
        Entry<K,V> newEntry = new Entry<>(key, value);
        // check if already entry exist at the given bucket location or not
        Entry<K,V> existingEntry = table[bucketLocation];
        if(existingEntry == null) {
            table[bucketLocation] = newEntry;
        } else {
            // already some entry exist
            Entry<K,V> current = existingEntry;
            Entry<K,V> previous = null;
            while(current != null) {
                // if key matches, then simply replace the value and come out of the loop
                if(current.getKey().equals(key)) {
                    current.setValue(value);
                    break;
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
            // reached at the end of the linked list
            if(previous != null)
                previous.setNext(newEntry);
        }
    }

    public V get(K key) {
        int bucketLocation = key.hashCode() % table.length;
        Entry<K,V> entry = table[bucketLocation];
        while(entry != null) {
            if(entry.getKey().equals(key)) {
                return entry.getValue();
            } else {
                entry = entry.getNext();
            }
        }
        return null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < table.length; i++) {
            Entry<K,V> entry = table[i];
            while(entry != null) {
                sb.append(entry.getKey()+"-"+entry.getValue()+", ");
                entry = entry.getNext();
            }
        }
        sb.replace(sb.length()-2, sb.length(),"");
        return sb.toString();
    }
}

public class CustomHashMapTest {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(1);
        map.put("A",11);
        map.put("B",21);
        map.put("A",51);
        map.put("D",23);
        map.put("C",67);

        System.out.println(map);
        System.out.println(map.get("Z"));
    }
}
