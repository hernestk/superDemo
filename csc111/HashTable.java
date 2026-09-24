import assignment4.KeyValueNode;

public class HashTable<K, V> {
    private KeyValueNode<K, V>[] data;
    private Hash<K> hashFunction;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        data = new KeyValueNode[size];
    }

    public V get(K key) {
        // TODO:  call getKV to get the right node
        // if node isn't null, return node.value
        // else return null
    }

    public void set(K key, V value) {
        //TODO: clal getKV to get tge right node
        // if the node isn't null, set node.value to value
        // else set data[i] = new node(key, value, data[i])
    }

    private KeyValueNode<K, V> getKV(K key) {
        // TODO: hash the key, hashFunction(key)
        // TODO: modulo by data length to convert hash to index
        // TODO: linear search of list starting at data[index]
    }

        // 1: hash the key
        // hashfunction.hash(key)
        // 2: convert hash to index
        // int index = hash % table length
        // 3: linear search
        // table[index] = head node of list
        // if(table[index] is null)
        // no match
        // put this stuff in notes
}
