package TaskB;

/**
 * Author       xinliu
 * Date         5/12/17
 * Time         8:16 AM
 */
public class SinFunction implements Function {
    @Override
    public double value(double x) {
        return 0;
    }

    @Override
    public double derivate(double x) {
        return 0;
    }


    public void calculate(double x, double s) {
        double a = x;
        double b = x-value(x)/derivate(x);
        while (Math.abs(a - b) >= s) {
            a = b;
            b=x-value(b)/derivate(b);
        }
    }
}
