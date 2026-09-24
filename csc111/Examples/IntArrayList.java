public class IntArrayList {
    final int DEFAULT_CAPACITY = 10;
    int[] data;
    int size;

    public IntArrayList() {
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public int get(int index) {
        // throw exception if index is out of bounds
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        return data[index];
    }

    public void insert(int index, int element) {
        // bounds check
        // we allow index == size because inserting at size won't fragment the data
        // sotred in the array
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }
        // ensure data is large enough to hold element
        // shift elements over to make room for the new element
        // store new element at data[index]
        // increase size
    }

    // public boolean remove(int element) {
    //     // find element (indexOf)
    //     // if found, remove at index and return true
    //     // if not found, return false
    // }

    public void removeAt(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        int element = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public void clear() {
        // if our list constains objects and not primitves, null each element
        // set size to 0;
        size = 0;
    }

    private void boundsCheck() {
        
    }

    private void ensureCapacity() {
        if(size == data.length) {
            int[] newData = new int[size * 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    public int capacity() {
        return data.length;
    }
}