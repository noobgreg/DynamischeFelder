import java.util.Arrays;

public class rp_main {

    public static void main(String[] args) {
        Ringpuffer ringpuffer = new Ringpuffer(6);
        System.out.println(Arrays.toString(ringpuffer.array));
        System.out.println(ringpuffer.size());

    }
}
