// CSC111L - Lab 9
// Hernest Koroli
package lab9;

public class MyArrayList {
    private String [] data;
    private int size;
    private final int DEFAULT_SIZE = 10;

    public MyArrayList() {
    	data = new String[DEFAULT_SIZE];
        size = 0;
    }

    private void resize() {
        String[] newData = new String[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    
    public void add(String value) {
        // if the variable size is equal to the array's length, 
    	//		then call the resize method
        if(size() == data.length) {
            resize();
        }
        value = data[size];
        
        size++;
    }

    public void insertAtFront(String value) {
        //TODO if the variable size is equal to the array's length, 
    	//		then call the resize method
        if(size() == data.length) {
            resize();
        }
        //TODO  shift elements one position to the right starting from the end
    	//	I used a for loop and set data at location i, equal to data at location i-1
        for (int i = 1; i < data.length; i++) {
            data[i] = data[i - 1];
        }

    	// add value to the front of the array
        data[0] = value;
        
        size++;
    }
    
    public String get(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public int size() {
        return size;
    }
}
