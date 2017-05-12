package TaskE;


import java.util.ArrayList;
import java.util.List;

/**
 * Author       xinliu
 * Date         5/12/17
 * Time         8:36 AM
 */
public class Main {
    public static void main(String[] args) {
        double tn = 0.01 * 0.0;
        double y10 = 1.0;
        double y20 = Math.exp(1.0);
        List<Double> y1 = new ArrayList<>();
        y1.add(1.0);
        List<Double> y2 = new ArrayList<>();
        y2.add(Math.exp(1.0));
        List<Double> y1Derivate = new ArrayList<>();
        List<Double> y2Derivate = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {

            double tn2 = 0.01 * i;
            double y1derivate = Derivatey1(y1.get(i), y2.get(i), tn2);
            y1Derivate.add(y1derivate);
            double y2derivate = Derivatey2(y1.get(i), y2.get(i), tn2);
            y2Derivate.add(y2derivate);
            double y1nadd1 = y1.get(i) + 0.005 * (y1Derivate.get(i) +
                    Derivatey1(y1.get(i) + 0.01 * y1Derivate.get(i),
                            y2.get(i) + 0.01 * y2Derivate.get(i),
                            0.01 * (i + 1)));
            y1.add(y1nadd1);
            double y2nadd1 = y2.get(i) + 0.005 * (y2Derivate.get(i) +
                    Derivatey2(y1.get(i) + 0.01 * y1Derivate.get(i),
                            y2.get(i) + 0.01 * y2Derivate.get(i),
                            0.01 * (i + 1)));
            y2.add(y2nadd1);
        }
    }

    public static double Derivatey1(double y1t, double y2t, double t) {
        return 2 * t * y1t * Math.log(Math.max(y2t, 1.0e-003));
    }

    public static double Derivatey2(double y1t, double y2t, double t) {
        return -2 * t * y2t * Math.log(Math.max(y1t, 1.0e-003));
    }

    public static double Y1(double t) {
        return Math.exp(Math.sin(t * t));
    }

    public static double Y2(double t) {
        return Math.exp(Math.cos(t * t));
    }

    //    误差
    public void deviation() {
        double tn = 0.01 * 0.0;
        double y10 = 1.0;
        double y20 = Math.exp(1.0);
        List<Double> y1 = new ArrayList<>();
        y1.add(1.0);
        List<Double> y2 = new ArrayList<>();
        y2.add(Math.exp(1.0));
        List<Double> y1Derivate = new ArrayList<>();
        List<Double> y2Derivate = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            double tn2 = 0.01 * i;
            double y1derivate = Derivatey1(y1.get(i), y2.get(i), tn2);
            y1Derivate.add(y1derivate);
            double y2derivate = Derivatey2(y1.get(i), y2.get(i), tn2);
            y2Derivate.add(y2derivate);
            double y1true = Y1(tn2 + 0.01);
            double y1nadd1 = y1.get(i) + 0.005 * (y1Derivate.get(i) + Derivatey1(y1.get(i) + 0.01 * y1Derivate.get(i),
                    y2.get(i) + 0.01 * y2Derivate.get(i), 0.01 * (i + 1)));
            double error1 = Math.abs(y1true - y1nadd1);
            y1.add(y1nadd1);
            double y2true = Y2(tn2 + 0.01);
            double y2nadd1 = y2.get(i) + 0.005 * (y2Derivate.get(i) + Derivatey2(y1.get(i) + 0.01 * y1Derivate.get(i),
                    y2.get(i) + 0.01 * y2Derivate.get(i), 0.01 * (i + 1)));
            double error2 = Math.abs(y2true - y2nadd1);
            y2.add(y2nadd1);
        }
    }


    //    梯形法
    public static void trapezoid() {
        double H = 0.01;
        double EPS = 1.0e-8;
        double y1_last = 1.0;
        double y2_last = Math.E;
        List<Result> results = new ArrayList<>();
        double t = 0;
        while (t <= 10) {
            double y1_0 = y1_last;
            double y2_0 = y2_last;
            int i = 0;

            for (int i1 = 0; i1 < 10000; i1++) {
                double y1_next = y1_last + H * 0.5 * (deriv_1(t, y1_last, y2_last) +
                        deriv_1(t + H, y1_0, y2_0));
                double y2_next = y2_last + H * 0.5 * (deriv_2(t, y2_last, y1_last) +
                        deriv_2(t + H, y2_0, y1_0));
                if (Math.abs(y1_next - y1_0) < EPS && Math.abs(y2_next - y2_0) < EPS) {
                    y1_0 = y1_next;
                    y2_0 = y2_next;
                    break;
                }
                y1_0 = y1_next;
                y2_0 = y2_next;
            }
        }
    }

    public static double deriv_1(double t, double y1_t, double y2_t) {
        return 2 * t * y1_t * Math.log(Math.max(1e-3, y2_t));
    }

    public static double deriv_2(double t, double y1_t, double y2_t) {
        return -2 * t * y2_t * Math.log(Math.max(1e-3, y1_t));
    }
}
