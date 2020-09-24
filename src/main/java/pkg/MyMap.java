package pkg;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MyMap<K, V> implements Map<K, V> {
    private class MyEntry<K, V> implements Entry<K, V> {
        K key;
        V value;

        MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public String toString() {
            return key + "=" + value; // key=value
        }
    }

    private MyEntry[] entries;
    private int indexEntries;
    private int indexAux;

    public MyMap() {
        entries = new MyEntry[3];
    }

    @Override
    public int size() {
        return indexEntries;
    }

    @Override
    public boolean isEmpty() {
        return entries[0] == null;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        for (indexAux = 0; indexAux < entries.length; indexAux++)
            if (entries[indexAux] != null && entries[indexAux].key == key)
                return (V) entries[indexAux].value;
        return null;
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        Objects.requireNonNull(value);

        V oldValue = get(key);
        if (oldValue != null)
            entries[indexAux] = new MyEntry(key, value);
        else
            for (int indexTemp = 0; indexTemp < entries.length; indexTemp++) {
                if (entries[indexTemp] == null) {
                    entries[indexEntries++] = new MyEntry(key, value);
                    break;
                }
            }
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        V oldValue = get(key);
        if (oldValue != null) {
            entries[indexAux] = null;
            --indexEntries;
        }
        return oldValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
