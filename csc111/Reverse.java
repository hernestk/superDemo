public class Reverse {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(reverse(arg));
        }
    }

    // Problem: Reverse a string by pushing each char onto a stack and then
    // popping each char off the stack.
    public static String reverse(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        String r = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
        }

        while(!stack.isEmpty()) {
            char c = stack.pop();
            r += c;
        }

        return r;
    }
}




