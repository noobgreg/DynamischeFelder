import java.util.Arrays;

public class rp_main {

    public static void main(String[] args) {


        Ringpuffer rp = new Ringpuffer(8);
        System.out.println(rp.first);
        System.out.println(rp.array.length);


        System.out.println(Arrays.toString(rp.array));
        rp.addFirst(2);
        System.out.println(Arrays.toString(rp.array));
        rp.addFirst(4);
        System.out.println(Arrays.toString(rp.array));
        rp.addFirst(6);
        System.out.println(Arrays.toString(rp.array));


























        /** Beispiel aus dem Skript
        Ringpuffer rp = new Ringpuffer(8);

        System.out.println(Arrays.toString(rp.array));
        System.out.println(rp.size());
        //System.out.println(rp.set(1, "Usel"));
        rp.addLast(6);
        System.out.println(Arrays.toString(rp.array));
        rp.addLast(3);
        System.out.println(Arrays.toString(rp.array));
        rp.addLast(5);
        System.out.println(Arrays.toString(rp.array));
        rp.addLast(8);
        System.out.println(Arrays.toString(rp.array));
        System.out.println("=============================================");
        rp.removeFirst();
        System.out.println(Arrays.toString(rp.array));
        rp.removeFirst();
        System.out.println(Arrays.toString(rp.array));
        System.out.println(rp.first);
        System.out.println("=============================================");
        rp.addLast(10);
        System.out.println(Arrays.toString(rp.array));
        rp.addLast(13);
        System.out.println(Arrays.toString(rp.array));
        rp.addLast(15);
        System.out.println(Arrays.toString(rp.array));
        rp.addLast(18);
        System.out.println(Arrays.toString(rp.array));
        rp.addLast(21);
        System.out.println(Arrays.toString(rp.array));
        rp.addLast(11);
        System.out.println(Arrays.toString(rp.array));
        System.out.println("==============================================");
        rp.removeFirst();
        System.out.println(Arrays.toString(rp.array));
        System.out.println(rp.first);
        rp.addLast(42);
        System.out.println(Arrays.toString(rp.array));
        System.out.println("======================================");
        //rp.addLast(0);
        //System.out.println(Arrays.toString(rp.array));
        */

    }
}
