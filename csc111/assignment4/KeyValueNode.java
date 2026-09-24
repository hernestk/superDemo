package assignment4;

public class KeyValueNode<K, V> {
    K key;
    V value;
    KeyValueNode <K, V> next;

    public KeyValueNode(K key, V value, KeyValueNode<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
