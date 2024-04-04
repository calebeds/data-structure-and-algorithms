package calebeoliveira.me.algorithms.recursion;

public class ReverseAString {
    public static String reverseAStringIterative(String string) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString.append(string.charAt(i));
        }

        return reversedString.toString();
    }

    public static String reverseAStringRecursive(String string) {
        if(string.isEmpty()) {
            return "";
        }

        return reverseAStringRecursive(string.substring(1)) + string.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverseAStringIterative("CALEBE"));
        System.out.println(reverseAStringRecursive("CALEBE"));
    }
}
