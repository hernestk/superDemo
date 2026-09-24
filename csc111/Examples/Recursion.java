
public class Recursion {
    public static void main(String[] args) {
        countUpRec(1);
    } 

    public static void countUpIter() {
        for(int i = 1; i <= 10; i++) {
            IO.println(i);
        }
    }

    public static void countUpRec(int start) {
        IO.println(start);

        if(start < 10) {
            countUpRec(start + 1); 
        } else {
            // base case: calls itself
            // do nothing
        }
    }
}
