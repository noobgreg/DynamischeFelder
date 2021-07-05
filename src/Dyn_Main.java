import java.util.Arrays;

public class Dyn_Main {


    public static void main(String[] args) throws Exception {
        DynArray x = new DynArray();
        //System.out.println(x.set(0, 6));
        System.out.println(x.size());
        System.out.println(x.capacity());
        System.out.println(Arrays.toString(x.dyn_array));

        x.addLast(2);
        System.out.println(x.size());
        System.out.println(x.capacity());
        System.out.println(Arrays.toString(x.dyn_array));
        x.addLast(4);
        System.out.println(x.size());
        System.out.println(x.capacity());
        System.out.println(Arrays.toString(x.dyn_array));
        x.addLast("Usel");
        System.out.println(x.size());
        System.out.println(x.capacity());
        System.out.println(Arrays.toString(x.dyn_array));
        //x.addLast(7);
        //x.addLast("erz1");
        //x.addLast("erz2");
        //x.addLast("erz3");
        //x.addLast("erz4");
        //x.addLast("erz5");
        //x.addLast("erz6");
        //x.addFirst("erz7");
        //x.addFirst("erz8");

        System.out.println(Arrays.toString(x.dyn_array));
    }
}
