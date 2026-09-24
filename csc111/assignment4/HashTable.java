package assignment4;

public class HashTable<K, V>  {
    private final int DEFAULT_CAPACITY = 10;
    private KeyValueNode<K, V>[] data;
    private Hash<K> hashFunction;

    @SuppressWarnings("unchecked")
    public HashTable(Hash<K> function, int size) {
        if(size <= 0) {
            data = new KeyValueNode[DEFAULT_CAPACITY];
        }
        
        hashFunction = function;
        data = new KeyValueNode[size];
    }

    public V get(K key) {
        int hash = hashFunction.hash(key);
        int index = hash % data.length;
        KeyValueNode<K, V> n = data[index];

        while(n != null) {
            if(n.key.equals(key)) {
                return n.value;
            }
            n = n.next; // i++
        }
        return null;
    }

    public void set(K key, V value) {
        int hash = hashFunction.hash(key);
        int index = hash % data.length;
        KeyValueNode<K, V> targetNode = getKV(key);

        if(targetNode != null) {
            targetNode.value = value;
        } else {
            data[index] = new KeyValueNode<K, V>(key, value, data[index]);
        }
    }

    private KeyValueNode<K, V> getKV(K key) {
        // hash the key, hashFunction(key)
        int hash = hashFunction.hash(key);

        // modulo by data length to convert hash to index
        int index = hash % data.length;

        // linear search of list starting at data[index]
        KeyValueNode<K, V> n = data[index];
        while (n != null) {
            if(n.key.equals(key)) {
                return n;
            }
            n = n.next;
        }
        return null;
    }
}