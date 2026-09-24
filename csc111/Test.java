public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
    }

    public static int binarySearch(int[] array, int target) {
        int min = 0;
        int max = array.length - 1;
        int mid = (min + max) / 2;

        boolean findingNum = true;
        while(findingNum) {
            if(array[mid] == target) {
                findingNum = false;
                return target;
            }
        }
        return 0;
    }
}
