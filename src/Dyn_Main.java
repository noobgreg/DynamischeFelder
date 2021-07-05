import java.util.Arrays;

public class Dyn_Main {


    public static void main(String[] args) throws Exception {
        DynArray x = new DynArray();
        //System.out.println(x.set(0, 6));
        System.out.println(x.size());
        System.out.println(x.capacity());
        x.addFirst(2);
        System.out.println(x.size());
        System.out.println(x.capacity());
        x.addFirst(4);
        System.out.println(x.size());
        System.out.println(x.capacity());
        x.addFirst("Usel");
        System.out.println(x.size());
        System.out.println(x.capacity());
        x.addFirst(7);
        //x.addFirst("erz");

        System.out.println(Arrays.toString(x.dyn_array));
    }
}
