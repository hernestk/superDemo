public class Bubbles {
    public static void main(String[] args) {
        int[] cats = {3, 2, 5, 1, 7, 8, 11, 3};
        for (int i = 0; i < cats.length; i++) {
            System.out.print(cats[i] + " ");
        }
        System.out.println();

        bubbleSort(cats);

        for (int i = 0; i < cats.length; i++) {
            System.out.print(cats[i] + " ");
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if(array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                } 
            }
        }
    }
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

