package calebeoliveira.me.arrays;

//Create a function that reverses a string:
//'Hi My name is Andrei should be:
// 'ierdnA si eman yM iH'
public class ReverseAString {

    public static String reserveAString(String string) {
        if(string == null || string.length() < 2)  {
            return "No string provided";
        }

        char[] arrString = new char[string.length()];

        for (int i = 0; i < string.length(); i++) {
            // tranfer the last char to the beginning
            // transfer the first char to the beginnning
            char firstItem = string.charAt(i);
            char lastItem = string.charAt(arrString.length - (1+i));
            arrString[i] = lastItem;
            arrString[arrString.length - (1+i)] = firstItem;
        }

        return new String(arrString);
    }

    public static String reverseAString2(String string) {
        String result = "";// It's more recommended to use "StringBuilder" object when manipulating strings
        final int length = string.length();
        for (int i = length - 1; i>=0; i--) {
            result += string.charAt(i);
        }
        return result;
    }

    public static String reverseStringWithReelJava(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static String recursiveReversal(String str) {
        if(str.length() == 0) //breakpoint for recursion
            return "";
        return recursiveReversal(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reserveAString("My name is Calebe"));
        System.out.println(reverseAString2("My name is Calebe"));
        System.out.println(reverseStringWithReelJava("My name is Calebe"));
        System.out.println(recursiveReversal("My name is Calebe"));
    }
}
