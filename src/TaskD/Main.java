package TaskD;

/**
 * Author       xinliu
 * Date         5/12/17
 * Time         8:32 AM
 */
public class Main {
    public static void main(String[] args) {
        double f0 = fx(0);
        double f48 = fx(48);
        double h = 0.01;
        double sum = 0.0;
        for (int i = 1; i < 4800; i++) {
            sum += fx(0.01 * i);

        }
        double I = 0.005 * (f0 + 2 * sum + f48);
        System.out.println(I);
    }

    public static double fx(double x) {
        return Math.sqrt(1 + Math.cos(x) * Math.cos(x));
    }


}
