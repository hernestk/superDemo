public class Hash {
    public static void main(String[] args) {
        System.out.println("");
    }

    public static int hashString(String str, int len) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i);
        }
        return sum % len;
    }
}
