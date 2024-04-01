package calebeoliveira.me.algorithms.recursion;

public class Inception {
    int count = 0;
    public String inception() {
        if(count > 4) {
            return "done!";
        }
        count++;
        return inception();
    }
}
