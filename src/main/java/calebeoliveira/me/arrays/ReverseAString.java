package calebeoliveira.me.arrays;

//Create a function that reverses a string:
//'Hi My name is Andrei should be:
// 'ierdnA si eman yM iH'
public class ReverseAString {

    public static String reserveAString(String string) {
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

    public static void main(String[] args) {
        System.out.println(reserveAString("My name is Calebe"));
    }
}
