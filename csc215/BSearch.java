public class BSearch {
    public static void main(String[] args) {
        System.out.println("BINARY SEARCH TEST PROGRAM: ");

        long [] bigArray = new long[2_147_483_99];

        System.out.println("Array Size: " + bigArray.length);
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = i;
        }

        binarySearch(bigArray, 1500);
        binarySearch(bigArray, 33);
        binarySearch(bigArray, 99999);
        binarySearch(bigArray, 1_000_000_00);
        binarySearch(bigArray, 2_000_000_00);
        binarySearch(bigArray, 2_147_483_60);
        binarySearch(bigArray, 2_147_000_00);
    }

    public static void binarySearch(long[] array, int target) {
        int searches = 0;
        int low = 0;
        int high = array.length;
        int mid = (low + high) / 2;

        while(low <= high) {
            if(target == array[mid]) {
                System.out.println("Found target: " + array[mid]);
                break;
            }

            if(target < array[mid]) {
                high = mid;
                mid = (low + high) / 2;
            } else {
                low = mid;
                mid = (low + high) / 2;
            }
        }
        System.out.println("Number not found");
    }
}