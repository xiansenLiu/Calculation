package TaskA;

/**
 * Author       xinliu
 * Date         5/12/17
 * Time         8:08 AM
 */
public class Main {
    public static void main(String[] args) {
        if (true) {
            calculate1(20);
        } else {
            calculate2(0);
        }
    }


    public static double calculate1(int n) {
        if (n == 0) {
            return 1.2f;
        } else {
            return (-5 * calculate1(n - 1) + 1.0 / n);
        }
    }

    public static double calculate2(int n) {
        if (n == 20) {
            return 7.9975e-003;
        } else {
            return ((1.0 / n - calculate2(n + 1))) / 5;
        }
    }
}
