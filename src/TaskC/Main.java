package TaskC;

/**
 * Author       xinliu
 * Date         5/12/17
 * Time         8:20 AM
 */
public class Main {

    public static double y0 = f(1.00);
    public static double x0 = 1.00;
    public static double y1 = f(1.02);
    public static double x1 = 1.02;
    public static double y2 = f(1.04);
    public static double x2 = 1.04;
    public static double y3 = f(1.06);
    public static double x3 = 1.06;
    public static double y4 = f(1.05);
    public static double x4 = 1.05;
    public static double max = 15 * Math.exp(1.0) - 16 * Math.exp(2.0);

    public static void main(String[] args) {
        double trueAnswer = f(1.03);
        if (true) {
            double p3 = P3(1.03);
            double R3 = Math.abs(trueAnswer - p3);
        } else {
            double p4 = P4(1.03);
            double R4 = Math.abs(trueAnswer - p4);

        }
    }


    public static double f(double x) {
        return Math.exp(x) * (3 * x - Math.exp(x));
    }

    public static double P3(double x) {
        double l0 = y0 * (x - x1) * (x - x2) * (x - x3) / (x0 - x1) / (x0 - x2) / (x0 - x3);
        double l1 = y1 * (x - x0) * (x - x2) * (x - x3) / (x1 - x0) / (x1 - x2) / (x1 - x3);
        double l2 = y2 * (x - x0) * (x - x1) * (x - x3) / (x2 - x0) / (x2 - x1) / (x2 - x3);
        double l3 = y3 * (x - x0) * (x - x1) * (x - x2) / (x3 - x0) / (x3 - x1) / (x3 - x2);
        return l0 + l1 + l2 + l3;
    }

    public static double P4(double x) {
        double l0 = y0 * (x - x1) * (x - x2) * (x - x3) * (x - x4) / (x0 - x1) / (x0 - x2) / (x0 - x3) / (x0 - x4);
        double l1 = y1 * (x - x0) * (x - x2) * (x - x3) * (x - x4) / (x1 - x0) / (x1 - x2) / (x1 - x3) / (x1 - x4);
        double l2 = y2 * (x - x0) * (x - x1) * (x - x3) * (x - x4) / (x2 - x0) / (x2 - x1) / (x2 - x3) / (x2 - x4);
        double l3 = y3 * (x - x0) * (x - x1) * (x - x2) * (x - x4) / (x3 - x0) / (x3 - x1) / (x3 - x2) / (x3 - x4);
        double l4 = y4 * (x - x0) * (x - x1) * (x - x2) * (x - x3) / (x4 - x0) / (x4 - x1) / (x4 - x2) / (x4 - x3);
        return l0 + l1 + l2 + l3 + l4;
    }
}
