package assignment4;

@FunctionalInterface
public interface Hash<K> {
    int hash(K key);
}
